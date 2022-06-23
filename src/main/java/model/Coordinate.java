package model;

import java.util.Objects;

public class Coordinate {
    private Integer x;
    private Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getRotate() {
        return rotate;
    }

    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }

    private Integer rotate;


    public Coordinate(Integer x, Integer y, Integer rotate) {
        this.x = x;
        this.y = y;
        this.rotate = rotate;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                ", rotate=" + rotate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Float.compare(that.x, x) == 0 && Float.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Ein X-, Y-Wert und eine rotation werden gespeichert
     * für rotate gilt: 1 - horizontal
     * 2 - vertikal
     *
     * @param x -> x-Wert in einem Koordinatensystem
     * @param y -> y-Wert in einem Koordinatensystem
     */
    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}