package com.javaReview.domain.module;

/**
 * Created by jiangmingli on 2017/10/13.
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)){
            return false;
        }
        if (!(o instanceof ColorPoint)){
            return super.equals(o);
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
