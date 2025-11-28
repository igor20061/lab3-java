package ru.lyaginskov.city;

import java.util.*;

public class Route {
    private City start;
    private City end;

    public Route(City start, City end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Города не могут быть null");
        }
        this.start = start;
        this.end = end;
    }

    public City getStart() {
        return start;
    }

    public void setStart(City start) {
        if (start == null) {
            throw new IllegalArgumentException("Город начала не может быть null");
        }
        this.start = start;
    }

    public City getEnd() {
        return end;
    }

    public void setEnd(City end) {
        if (end == null) {
            throw new IllegalArgumentException("Город конца не может быть null");
        }
        this.end = end;
    }

    public City[] getRoute() {

        LinkedList queue = new LinkedList();
        HashMap cameFrom = new HashMap();

        queue.add(start);
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            City current = (City) queue.removeFirst();

            if (current == end) {
                return buildPath(cameFrom);
            }

            City[] neighbors = current.getConnectedCities();
            for (int i = 0; i < neighbors.length; i++) {
                City neighbor = neighbors[i];
                if (!cameFrom.containsKey(neighbor)) {
                    cameFrom.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return new City[0];
    }

    private City[] buildPath(HashMap cameFrom) {
        ArrayList path = new ArrayList();
        City current = end;

        while (current != null) {
            path.add(current);
            current = (City) cameFrom.get(current);
        }

        Collections.reverse(path);
        City[] result = new City[path.size()];
        for (int i = 0; i < path.size(); i++) {
            result[i] = (City) path.get(i);
        }
        return result;
    }

    @Override
    public String toString() {
        City[] route = getRoute();
        if (route.length == 0) {
            return "Путь не найден";
        }

        String result = "";
        for (int i = 0; i < route.length; i++) {
            result += route[i].getName();
            if (i < route.length - 1) {
                result += " -> ";
            }
        }
        return result;
    }
}