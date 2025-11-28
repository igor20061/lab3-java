package ru.lyaginskov.main;

import ru.lyaginskov.bird.*;
import ru.lyaginskov.city.*;
import ru.lyaginskov.point.*;

public class main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ВСЕХ КЛАССОВ ===\n");

        // Задание 1.10 - Города с односторонними дорогами
        System.out.println("1. ДЕМОНСТРАЦИЯ ГОРОДОВ (ЗАДАНИЕ 1.10)");
        System.out.println("========================================");

        // Создаем города
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");

        // Добавляем дороги согласно схеме (односторонние)
        cityA.addPath(cityB, 1);
        cityA.addPath(cityC, 2);
        cityB.addPath(cityA, 1);
        cityB.addPath(cityD, 3);
        cityB.addPath(cityC, 4);
        cityC.addPath(cityA, 2);
        cityD.addPath(cityB, 3);
        cityD.addPath(cityE, 5);
        cityE.addPath(cityD, 5);
        cityE.addPath(cityC, 6);

        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);

        // Пытаемся добавить дублирующую дорогу
        try {
            cityA.addPath(cityB, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении дублирующей дороги: " + e.getMessage());
        }

        // Удаляем дорогу
        cityB.removePath(cityC);
        System.out.println("\nПосле удаления дороги B->C:");
        System.out.println(cityB);

        // Восстанавливаем дорогу для дальнейших демонстраций
        cityB.addPath(cityC, 4);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Задание 2.5 - Маршруты между городами
        System.out.println("2. ДЕМОНСТРАЦИЯ МАРШРУТОВ (ЗАДАНИЕ 2.5)");
        System.out.println("========================================");

        // Создаем маршруты согласно графу
        Route routeAE = new Route(cityA, cityE);
        System.out.println("Маршрут из A в E: " + routeAE);

        Route routeCA = new Route(cityC, cityA);
        System.out.println("Маршрут из C в A: " + routeCA);

        Route routeEC = new Route(cityE, cityC);
        System.out.println("Маршрут из E в C: " + routeEC);

        // Изменяем конечную точку маршрута
        routeAE.setEnd(cityD);
        System.out.println("Маршрут из A в D: " + routeAE);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Задание 3.3 - Города с двусторонними дорогами
        System.out.println("3. ДЕМОНСТРАЦИЯ ДВУСТОРОННИХ ГОРОДОВ (ЗАДАНИЕ 3.3)");
        System.out.println("==================================================");

        // Создаем двусторонние города
        TwoWayCity twoWayA = new TwoWayCity("A");
        TwoWayCity twoWayB = new TwoWayCity("B");
        TwoWayCity twoWayC = new TwoWayCity("C");
        TwoWayCity twoWayD = new TwoWayCity("D");
        TwoWayCity twoWayE = new TwoWayCity("E");

        // Создаем связи согласно графу (все дороги двусторонние)
        System.out.println("Создание двусторонних связей:");

        // A <-> B
        twoWayA.addTwoWayPath(twoWayB, 1);
        System.out.println("Добавлена дорога A <-> B (1)");

        // A <-> C
        twoWayA.addTwoWayPath(twoWayC, 2);
        System.out.println("Добавлена дорога A <-> C (2)");

        // B <-> C
        twoWayB.addTwoWayPath(twoWayC, 4);
        System.out.println("Добавлена дорога B <-> C (4)");

        // B <-> D
        twoWayB.addTwoWayPath(twoWayD, 3);
        System.out.println("Добавлена дорога B <-> D (3)");

        // D <-> E
        twoWayD.addTwoWayPath(twoWayE, 5);
        System.out.println("Добавлена дорога D <-> E (5)");

        // E <-> C
        twoWayE.addTwoWayPath(twoWayC, 6);
        System.out.println("Добавлена дорога E <-> C (6)");

        System.out.println("\nРезультат двусторонних связей:");
        System.out.println(twoWayA);
        System.out.println(twoWayB);
        System.out.println(twoWayC);
        System.out.println(twoWayD);
        System.out.println(twoWayE);

        // Демонстрация маршрутов в двусторонней сети
        System.out.println("\nМаршруты в двусторонней сети:");
        Route twoWayRouteAE = new Route(twoWayA, twoWayE);
        System.out.println("Маршрут из A в E: " + twoWayRouteAE);

        Route twoWayRouteCA = new Route(twoWayC, twoWayA);
        System.out.println("Маршрут из C в A: " + twoWayRouteCA);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Задание 3.5 - Трехмерные точки
        System.out.println("4. ДЕМОНСТРАЦИЯ ТРЕХМЕРНЫХ ТОЧЕК (ЗАДАНИЕ 3.5)");
        System.out.println("==============================================");

        Point point2D = new Point(1.0, 2.0);
        Point3D point3D = new Point3D(1.0, 2.0, 3.0);
        Point3D point3D_2 = new Point3D(4.5, 6.7, 8.9);

        System.out.println("2D точка: " + point2D.Coordinates());
        System.out.println("3D точка 1: " + point3D.Coordinates());
        System.out.println("3D точка 2: " + point3D_2.Coordinates());

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Задание 4.3 - Птицы
        System.out.println("5. ДЕМОНСТРАЦИЯ ПТИЦ (ЗАДАНИЕ 4.3)");
        System.out.println("===================================");

        Bird[] birds = new Bird[3];
        birds[0] = new Sparrow();
        birds[1] = new Cuckoo();
        birds[2] = new Parrot("Привет, я попугай и умею говорить длинные фразы!");

        System.out.println("Демонстрация пения птиц:");
        for (int i = 0; i < birds.length; i++) {
            System.out.print((i + 1) + ". " + birds[i].getName() + " поет: ");
            birds[i].sing();
        }

        // Демонстрация нескольких пений кукушки и попугая (случайный характер)
        System.out.println("\nДополнительные демонстрации (случайный характер):");
        for (int i = 0; i < 2; i++) {
            System.out.print("Кукушка поет: ");
            birds[1].sing();
            System.out.print("Попугай поет: ");
            birds[2].sing();
        }

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Задание 5.9 - Граф городов (комбинированный по новому графу)
        System.out.println("6. ДЕМОНСТРАЦИЯ КОМБИНИРОВАННОГО ГРАФА (ЗАДАНИЕ 5.9)");
        System.out.println("===================================================");

// Создаем смешанный граф согласно новому графу:
// A соединен с B и C (двусторонние)
// B соединен с A, D и C (A - двусторонняя, D - двусторонняя, C - односторонняя B→C)
// C соединен с A (двусторонняя)
// D соединен с B и E (двусторонние)
// E соединен с D и C (D - двусторонняя, C - односторонняя E→C)

// Для правильной реализации используем:
// - TwoWayCity для городов, где нужны двусторонние связи
// - Обычные City для городов, где нужны односторонние связи

// Города, которые участвуют в двусторонних связях
        TwoWayCity cityA_mixed = new TwoWayCity("A");
        TwoWayCity cityB_mixed = new TwoWayCity("B");
        TwoWayCity cityD_mixed = new TwoWayCity("D");
        TwoWayCity cityE_mixed = new TwoWayCity("E");

// Город C - обычный, так как к нему ведут односторонние связи
        City cityC_mixed = new City("C");

        System.out.println("Создание комбинированного графа:");
        System.out.println("(Только пути B→C и E→C односторонние, остальные двусторонние)");

// ДВУСТОРОННИЕ СВЯЗИ (используем addTwoWayPath):

// A <-> B
        cityA_mixed.addTwoWayPath(cityB_mixed, 1);
        System.out.println("Добавлена дорога A <-> B (1)");

// A <-> C (двусторонняя)
        cityA_mixed.addTwoWayPath(cityC_mixed, 2);
        System.out.println("Добавлена дорога A <-> C (2)");

// B <-> D
        cityB_mixed.addTwoWayPath(cityD_mixed, 3);
        System.out.println("Добавлена дорога B <-> D (3)");

// D <-> E
        cityD_mixed.addTwoWayPath(cityE_mixed, 5);
        System.out.println("Добавлена дорога D <-> E (5)");

// ОДНОСТОРОННИЕ СВЯЗИ (используем обычный addPath на обычных City):

// B → C (односторонняя) - добавляем только от B к C
        cityB_mixed.addPath(cityC_mixed, 4);
        System.out.println("Добавлена дорога B → C (4) - ОДНОСТОРОННЯЯ");

// E → C (односторонняя) - добавляем только от E к C
        cityE_mixed.addPath(cityC_mixed, 6);
        System.out.println("Добавлена дорога E → C (6) - ОДНОСТОРОННЯЯ");
        
// Демонстрация маршрутов в смешанном графе
        System.out.println("\nМаршруты в смешанном графе:");

// Маршрут A → E (через двусторонние связи)
        Route mixedRouteAE = new Route(cityA_mixed, cityE_mixed);
        System.out.println("Маршрут из A в E: " + mixedRouteAE);

// Маршрут E → C (односторонняя связь - ДОЛЖЕН РАБОТАТЬ)
        Route mixedRouteEC = new Route(cityE_mixed, cityC_mixed);
        System.out.println("Маршрут из E в C: " + mixedRouteEC);

// Маршрут C → E (невозможен из-за односторонней связи E→C - ДОЛЖЕН БЫТЬ ПУСТЫМ)
        Route mixedRouteCE = new Route(cityC_mixed, cityE_mixed);
        System.out.println("Маршрут из C в E: " + mixedRouteCE);

// Маршрут B → C (односторонняя связь - ДОЛЖЕН РАБОТАТЬ)
        Route mixedRouteBC = new Route(cityB_mixed, cityC_mixed);
        System.out.println("Маршрут из B в C: " + mixedRouteBC);

// Маршрут C → B (невозможен из-за односторонней связи B→C - ДОЛЖЕН БЫТЬ ПУСТЫМ)
        Route mixedRouteCB = new Route(cityC_mixed, cityB_mixed);
        System.out.println("Маршрут из C в B: " + mixedRouteCB);

// Маршрут C → A (должен работать через двустороннюю связь A↔C)
        Route mixedRouteCA = new Route(cityC_mixed, cityA_mixed);
        System.out.println("Маршрут из C в A: " + mixedRouteCA);


        // Задание 6.5 - Сравнение городов
        System.out.println("7. ДЕМОНСТРАЦИЯ СРАВНЕНИЯ ГОРОДОВ (ЗАДАНИЕ 6.5)");
        System.out.println("==============================================");

        // Создаем тестовые города для сравнения по графу из задания 6.5
        City compareCity1 = new City("Город1");
        City compareCity2 = new City("Город2");
        City compareCity3 = new City("Город3");
        TwoWayCity compareCity4 = new TwoWayCity("Город4");
        City commonCity1 = new City("Общий1");
        City commonCity2 = new City("Общий2");

        // Настраиваем связи для демонстрации сравнения

        // Город1 и Город2 имеют одинаковые связи (с Общий1 и Общий2)
        compareCity1.addPath(commonCity1, 1);
        compareCity1.addPath(commonCity2, 2);

        compareCity2.addPath(commonCity1, 1);
        compareCity2.addPath(commonCity2, 2);

        // Город3 имеет другие связи
        compareCity3.addPath(commonCity1, 1);
        compareCity3.addPath(compareCity1, 3);  // другая связь

        // Двусторонний город с такими же связями
        compareCity4.addPath(commonCity1, 1);
        compareCity4.addPath(commonCity2, 2);

        System.out.println("Тестовые города для сравнения:");
        System.out.println("Город1: " + compareCity1);
        System.out.println("Город2: " + compareCity2);
        System.out.println("Город3: " + compareCity3);
        System.out.println("Город4 (двусторонний): " + compareCity4);

        // Сравнение городов по набору связей
        System.out.println("\nРезультаты сравнения городов:");
        System.out.println("Город1 и Город2 имеют одинаковые связи: " +
                compareCitiesByConnections(compareCity1, compareCity2));
        System.out.println("Город1 и Город3 имеют разные связи: " +
                !compareCitiesByConnections(compareCity1, compareCity3));
        System.out.println("Город1 и Город4 (двусторонний) имеют одинаковые связи: " +
                compareCitiesByConnections(compareCity1, compareCity4));

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }

    // Вспомогательный метод для сравнения городов по набору связей (задание 6.5)
    private static boolean compareCitiesByConnections(City city1, City city2) {
        City[] connections1 = city1.getConnectedCities();
        City[] connections2 = city2.getConnectedCities();

        // Если разное количество связей - города разные
        if (connections1.length != connections2.length) {
            return false;
        }

        // Проверяем, что все связи из city1 есть в city2
        for (City conn1 : connections1) {
            boolean found = false;
            for (City conn2 : connections2) {
                // Сравниваем только по имени города (стоимости не учитываются согласно заданию)
                if (conn1.getName().equals(conn2.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        // Проверяем обратно, что все связи из city2 есть в city1
        for (City conn2 : connections2) {
            boolean found = false;
            for (City conn1 : connections1) {
                if (conn2.getName().equals(conn1.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }
}