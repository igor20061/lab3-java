package ru.lyaginskov.city;

public class City {
    private String name;
    private City[] connectedCities; // массив связанных городов
    private int[] costs;             // массив стоимостей поездок

    // Конструктор 1 — только название
    public City(String name) {
        this.name = name;
        this.connectedCities = new City[0];
        this.costs = new int[0];
    }

    // Конструктор 2 — название + связанные города и их стоимости
    public City(String name, City[] connectedCities, int[] costs) {
        this.name = name;
        // если передано null — создаём пустые массивы, чтобы не было ошибок
        if (connectedCities == null || costs == null) {
            this.connectedCities = new City[0];
            this.costs = new int[0];
        } else {
            // Проверяем уникальность городов и создаём копии массивов
            this.connectedCities = new City[connectedCities.length];
            this.costs = new int[costs.length];

            for (int i = 0; i < connectedCities.length; i++) {
                // Проверяем, нет ли уже связи с этим городом
                if (findCityIndex(connectedCities[i]) != -1) {
                    throw new IllegalArgumentException("Город " + connectedCities[i].name +
                            " уже связан с городом " + name);
                }
                this.connectedCities[i] = connectedCities[i];
                this.costs[i] = costs[i];
            }
        }
    }

    // Метод для добавления пути к новому городу
    public void addPath(City city, int cost) {
        // Проверяем, что город не null
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }

        // Проверяем, что не пытаемся добавить связь с самим собой
        if (city == this) {
            throw new IllegalArgumentException("Нельзя добавить связь города с самим собой");
        }

        // Проверяем, нет ли уже связи с этим городом
        if (findCityIndex(city) != -1) {
            throw new IllegalArgumentException("Город " + city.name + " уже связан с городом " + name);
        }

        int newSize = connectedCities.length + 1;

        City[] newCities = new City[newSize];
        int[] newCosts = new int[newSize];

        // копируем старые данные
        for (int i = 0; i < connectedCities.length; i++) {
            newCities[i] = connectedCities[i];
            newCosts[i] = costs[i];
        }

        // добавляем новый путь
        newCities[newSize - 1] = city;
        newCosts[newSize - 1] = cost;

        connectedCities = newCities;
        costs = newCosts;
    }

    // Метод для удаления дороги к городу
    public void removePath(City city) {
        int index = findCityIndex(city);
        if (index == -1) {
            throw new IllegalArgumentException("Город " + city.name + " не связан с городом " + name);
        }

        int newSize = connectedCities.length - 1;
        City[] newCities = new City[newSize];
        int[] newCosts = new int[newSize];

        // копируем все элементы кроме удаляемого
        for (int i = 0, j = 0; i < connectedCities.length; i++) {
            if (i != index) {
                newCities[j] = connectedCities[i];
                newCosts[j] = costs[i];
                j++;
            }
        }

        connectedCities = newCities;
        costs = newCosts;
    }

    // Вспомогательный метод для поиска индекса города в массиве connectedCities
    private int findCityIndex(City city) {
        for (int i = 0; i < connectedCities.length; i++) {
            if (connectedCities[i] == city) {
                return i;
            }
        }
        return -1;
    }

    // Геттер для имени города
    public String getName() {
        return name;
    }

    // Геттер для связанных городов (возвращаем копию для защиты от внешних изменений)
    public City[] getConnectedCities() {
        return connectedCities.clone();
    }

    // Геттер для стоимостей (возвращаем копию для защиты от внешних изменений)
    public int[] getCosts() {
        return costs.clone();
    }

    @Override
    public String toString() {
        String result = "Город " + name + " связан с: ";
        if (connectedCities.length == 0) {
            result += "нет путей";
        } else {
            for (int i = 0; i < connectedCities.length; i++) {
                result += connectedCities[i].name + ":" + costs[i] + " ";
            }
        }
        return result;
    }
}