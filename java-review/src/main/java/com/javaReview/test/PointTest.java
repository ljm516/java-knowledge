package com.javaReview.test;


import com.javaReview.domain.module.Color;
import com.javaReview.domain.module.ColorPoint;
import com.javaReview.domain.module.Point;

/**
 * Created by jiangmingli on 2017/10/13.
 */
public class PointTest {

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp1 = new ColorPoint(1, 2, new Color("blue"));
        ColorPoint cp2 = new ColorPoint(1, 2, new Color("red"));
        ColorPoint cp3 = null;
        System.out.println(p.equals(cp1));
        System.out.println(p.equals(cp2));
        System.out.println(cp1.equals(cp2));
        System.out.println(cp1.equals(cp3));
    }
}
