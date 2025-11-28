package ru.lyaginskov.bird;

import java.util.Random;

public class Parrot extends Bird {
    private String text;
    private Random random;

    public Parrot(String text) {
        super("Попугай");
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст для попугая не может быть пустым");
        }
        this.text = text.trim();
        this.random = new Random();
    }

    @Override
    public void sing() {
        int n = random.nextInt(text.length()) + 1; // от 1 до длины текста
        String song = text.substring(0, n);
        System.out.println(song);
    }

    public String getText() {
        return text;
    }
}
