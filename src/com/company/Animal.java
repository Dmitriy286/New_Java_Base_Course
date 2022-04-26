package com.company;

public class Animal {
    public String name;
    public int age;
    public int weight;
    private int height;
    private int legNumber;

    public void sayHello() {
        System.out.println("Hi, I'm animal. My name is " + this.name + ", I'm " + this.age + " years old, " + "my weight is " + this.weight);
    }

//    public Animal() {
//        age = 0;
//        name = "Any animal";
//        weight = 0;
//    }

    public Animal(String name, int age, int weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public Animal(int age, int weight, int condition) {
        switch (condition) {
            case 1: {};
            case 2: {};
        }
        this.age = age;
        this.weight = weight;
        this.name = "Poka net";
    }

    public String getName() { // getter, метод, возвращающий поле или свойство класса
        return this.name;
    }

    public void setName(String name) { // setter, меняет поля
        this.name = name;
    }

    public void increaseAge(int raise) { // это уже не сеттер
        this.age += raise;
    }

}
