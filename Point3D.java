package ru.lyaginskov.point;

public class Point3D extends Point {
    double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String Coordinates() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}