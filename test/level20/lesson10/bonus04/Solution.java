package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements Cloneable, Serializable{
    @Override
    public Solution clone() throws CloneNotSupportedException
    {
        Solution clone = (Solution) super.clone();

        clone.allNodes = new LinkedList<>(allNodes);

        return clone;
    }

    @Override
    public void clear()
    {
        Node first = allNodes.getFirst();
        allNodes = new LinkedList<>();
        allNodes.add(first);
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
        System.out.println(list.size());
        for (String s :list)
        {
            System.out.print(s + " ");
        }
        System.out.println();

        //Testing iterator
//        Iterator<String> iterator = list.iterator();
//        for (int i = 0; i < 3; i++)
//        {
//            iterator.next();
//        }
//        iterator.remove();
//        for (String s :list)
//        {
//            System.out.print(s + " ");
//        }
//        System.out.println();

        for (int i = 16; i < 25; i++)
        {
            ((Solution) list).add(""+i);
            System.out.printf("p:%s, e:%d\n", ((Solution) list).getParent(""+i), i);
        }
        System.out.println();

        list.remove("16");
        list.remove("23");

        ((Solution) list).add("25");
        ((Solution) list).add("26");

        for (String s: list)
        {
            System.out.printf("p:%s, e:%s\n", ((Solution) list).getParent(s),s );
        }
        System.out.println();

        System.out.println("TESTING CLONE");
        Solution clone = ((Solution) list).clone();

        System.out.println("OR:");
        for (String s :list)
        {
            System.out.print(s + " ");
        }
        System.out.println();


        System.out.println("Cl:");
        for (String s :clone)
        {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("Change clone and list");
        clone.remove("1");
        list.remove("2");

        System.out.println("OR:");
        for (String s :list)
        {
            System.out.print(s + " ");
        }
        System.out.println();


        System.out.println("Cl:");
        for (String s :clone)
        {
            System.out.print(s + " ");
        }
        System.out.println("\n"+ clone.size());

        ((Solution)list).clear();
        System.out.println("clear list:");
        for (String s :list)
        {
            System.out.print(s + " ");
        }
        System.out.println("\n"+ list.size());
    }

    @Override
    public boolean add(String s)
    {
        int i;
        Node p = allNodes.getLast().p;
        if (p == null){
            i = 0;
        }else {
            i = allNodes.indexOf(p);
        }
        for (; i < allNodes.size(); i++)
        {
            Node curN = allNodes.get(i);
            Node[] chs = curN.chs;
            for (int j = 0; j < chs.length; j++)
            {
                if (chs[j] == null){
                    Node newN = new Node(s, curN);
                    chs[j] = newN;
                    allNodes.add(newN);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Iterator<String>()
        {
            int cursor;
            @Override
            public void remove()
            {
                if (cursor == 0){
                    throw new IllegalStateException();
                }
                Solution.this.remove(allNodes.get(cursor).item);
            }

            @Override
            public boolean hasNext()
            {
                return cursor<size();
            }

            @Override
            public String next()
            {
                cursor++;
                return allNodes.get(cursor).item;
            }
        };
    }

    @Override
    public boolean remove(Object o)
    {
        String str = (String) o;
        for (int i = 1; i < allNodes.size(); i++)
        {
            Node curN = allNodes.get(i);
            if (str.equals(curN.item)){
                allNodes.remove(curN);

                Node[] chs = curN.chs;
                for (int j = 0; j < chs.length; j++)
                {
                    if (chs[j] != null){
                        remove(chs[j].item);
                        chs[j] = null;
                    }
                }
                Node[] pChs = curN.p.chs;
                for (int j = 0; j < pChs.length; j++)
                {
                    if (pChs[j] == curN){
                        pChs[j] = null;
                        break;
                    }
                }

            }
        }

        return true;
    }

    public Solution()
    {
        allNodes.add(new Node(null,null));
    }

    LinkedList<Node> allNodes = new LinkedList<>();

    private static class Node implements Serializable {
        String item;
        Node p;

        Node[] chs = new Node[2];

        public Node(String item, Node p)
        {
            this.item = item;
            this.p = p;
        }
    }

    public String getParent(String value) {
        //have to be implemented
        for (int i = 1; i < allNodes.size(); i++)
        {
            Node curNode = allNodes.get(i);
            if (value.equals(curNode.item)){
                return curNode.p.item;
            }
        }
        return null;
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        return allNodes.size()-1;
    }
}
