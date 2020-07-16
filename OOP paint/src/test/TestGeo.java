package test;

import shapes.*;
public class TestGeo {

	public static void main(String[] args) {
		
		Point point1 = new Point();
		Point point2 = new Point();
		point1.setX(100);
		point1.setY(120);
		
		System.out.println(point1.getX());
		System.out.println(point1.getY());

		
		Point p1 = new Point(5,10);
		Point p2 = new Point(10,12);
		double distance = p1.distance(10,12);
		System.out.println(distance);
		
		Rectangle r = new Rectangle();
		r.setUpperLeft(point1);
		r.setHeight(60);
		r.setWidth(80);
		
		System.out.println(r.getUpperLeft());
		System.out.println(r.getHeight());
		System.out.println(r.getWidth());
		
		System.out.println(r.area());

		Line l = new Line();
		l.setStartPoint(p1);
		l.setEndPoint(p2);
		
		System.out.println(l.middleLine());

	}

}
