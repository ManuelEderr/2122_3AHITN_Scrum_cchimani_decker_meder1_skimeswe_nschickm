package model;

import java.util.Objects;

public class Coordinate {
    public Integer x;
    public Integer y;
    public Integer rotate;


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

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
