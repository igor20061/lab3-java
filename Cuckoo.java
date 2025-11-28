package ru.lyaginskov.bird;

import java.util.Random;

public class Cuckoo extends Bird {
    private Random random;

    public Cuckoo() {
        super("Кукушка");
        this.random = new Random();
    }

    @Override
    public void sing() {
        int count = random.nextInt(10) + 1; // от 1 до 10
        for (int i = 0; i < count; i++) {
            System.out.print("ку-ку");
            if (i < count - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
