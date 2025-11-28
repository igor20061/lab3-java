package ru.lyaginskov.bird;

public class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public void sing() {
        System.out.println("Птица поет");
    }

    public String getName() {
        return name;
    }
}
