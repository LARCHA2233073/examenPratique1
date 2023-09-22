package com.example.examenpratique1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by utilisateur on 2016-09-16.
 */
public class Collider {
    public interface ICollider{
        public boolean collide(Point p, Rect c);
    }
    public static List<Boolean> getColliderList(ICollider collider){
        Point[] points = {
            new Point(6,6), new Point(10,10), new Point(20,20), new Point(0,5), new Point(5, 0)
        };
        Rect[] rectangles = {
            new Rect(5,5,10, 10), new Rect(0,0,9, 11), new Rect(10,10,24, 35), new Rect(5, 0,20, 20), new Rect(0,5,40,40)
        };
        List<Boolean> results = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            results.add(collider.collide(points[i], rectangles[i]));
        }
        return results;
    }
}
