package com.javarush.test.level15.lesson12.home05;

/**
 * Created by gesse_000 on 18.10.2015.
 */
public class SubSolution extends Solution {
    public SubSolution() {
    }

    public SubSolution(int i) {
        super(i);
    }

    public SubSolution(int i, String s) {
        super(i, s);
    }

    protected SubSolution(int i, String s, boolean b) {
        super(i, s, b);
    }

    protected SubSolution(String s, boolean b) {
        super(s, b);
    }

    protected SubSolution(int i, boolean b) {
        super(i, b);
    }

    private SubSolution(String s){
    }

    private SubSolution(String s, int i){
    }

    private SubSolution(boolean b){
        }

    SubSolution(Object o) {
        super(o);
    }

    SubSolution(Object o, int c) {
        super(o, c);
    }

    SubSolution(int c, Object o) {
        super(c, o);
    }


}
