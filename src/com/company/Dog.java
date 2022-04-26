package com.company;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, int weight, String breed) {
        super(name, age, weight); //fixme можно передать меньше свойств?
        this.breed = breed;
    }
}
