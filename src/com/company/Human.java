package com.company;

public class Human {
    String name;
    int age;
    int weight;

    public Human (String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void greetings() {
        System.out.println("Hi, I'm " + this.name + "!");
    }

    @Override
    public String toString() {
        return "Hi, I'm " + this.name + "!";
    }
}
