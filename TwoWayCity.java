package ru.lyaginskov.city;

public class TwoWayCity extends City {

    public TwoWayCity(String name) {
        super(name);
    }

    public TwoWayCity(String name, City[] connectedCities, int[] costs) {
        super(name, connectedCities, costs);
        // При создании через этот конструктор тоже нужно обеспечить двусторонность
        if (connectedCities != null && costs != null) {
            for (int i = 0; i < connectedCities.length; i++) {
                addTwoWayPath(connectedCities[i], costs[i]);
            }
        }
    }

    // Метод для добавления двусторонней дороги
    public void addTwoWayPath(City otherCity, int cost) {
        if (otherCity == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }

        if (otherCity == this) {
            throw new IllegalArgumentException("Нельзя добавить связь города с самим собой");
        }

        // Добавляем дорогу от этого города к другому
        super.addPath(otherCity, cost);

        // Добавляем обратную дорогу от другого города к этому
        // Проверяем, есть ли уже такая связь у другого города
        boolean hasReversePath = false;
        City[] otherConnections = otherCity.getConnectedCities();
        for (City connected : otherConnections) {
            if (connected == this) {
                hasReversePath = true;
                break;
            }
        }

        // Если обратной дороги нет - добавляем её
        if (!hasReversePath) {
            otherCity.addPath(this, cost);
        }
    }

    // Переопределяем метод добавления пути, чтобы сделать его двусторонним
    @Override
    public void addPath(City city, int cost) {
        addTwoWayPath(city, cost);
    }
}
