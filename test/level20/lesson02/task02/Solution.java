package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\gesse_000\\Desktop\\test.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\gesse_000\\Desktop\\test.txt");
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Gleb");
            user1.setLastName("Egumenov");
            user1.setBirthDate(dateFormat.parse("29.02.1988"));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            User user2 = new User();
            user2.setFirstName("Olya");
            user2.setLastName("Gudova");
            user2.setBirthDate(dateFormat.parse("12.08.1985"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);


        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUserPresent = users != null ? "yes" : "no";
            printWriter.println(isUserPresent);
            if (users != null) {
                for (User user : this.users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(dateFormat.format(user.getBirthDate()));
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry());
                }

            }
            printWriter.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String isUserPresent = reader.readLine();
                if (isUserPresent.equals("yes")) {
                    while (reader.ready()) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(dateFormat.parse(reader.readLine()));
                    String male = reader.readLine();
                    if (male.equals("true")) {
                        user.setMale(true);
                    } else {
                        user.setMale(false);
                    }
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    users.add(user);
                }
            }
            reader.close();
        }
    }
}
