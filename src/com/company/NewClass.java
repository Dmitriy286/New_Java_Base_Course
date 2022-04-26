package com.company;

public class NewClass {
    public static void main(String[] args) {
        Animal afrodita = new Animal("Afrodita", 1, 10); //конструктор класса
        Animal hermes = new Animal("Hermes", 2, 20);

        afrodita.sayHello();
        hermes.sayHello();
        System.out.println(afrodita.getName());
        afrodita.setName("Pochti Hermes");
        System.out.println(afrodita.getName());
        afrodita.sayHello();
        Dog dog = new Dog("Bob", 3, 12, "some breed");

    }


}
