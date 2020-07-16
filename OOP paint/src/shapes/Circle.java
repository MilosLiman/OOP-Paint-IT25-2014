package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
	private Point center;
	private int radius;
	
	public Circle(){
		
	}
	
	public Circle(Point center, int radius){
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected){
		this(center, radius);
		setSelected(selected);
	}
	
	public Circle(Point center, int radius, Color edgeColor, Color innerColor){
		this(center, radius);
		setEdgeColor(edgeColor);
		setInnerColor(innerColor);
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public double area(){
		return radius * radius * Math.PI;
	}
	
	public void draw(Graphics g){
		//g.setColor(getInnerColor());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius() * 2, this.getRadius() * 2);
		//g.setColor(getEdgeColor());
		g.drawOval(this.getCenter().getX() - getRadius(), this.getCenter().getY() - getRadius(), getRadius() * 2, getRadius() * 2);
		
		if(isSelected()){
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3 - getRadius(), getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3 + getRadius(), getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3 - getRadius(), 6, 6);
			g.drawRect(getCenter().getX(), getCenter().getY() - 3 + getRadius(), 6, 6);
		}
	}
	
		
	public boolean equals(Object obj){
		if(obj instanceof Circle){
			Circle c = (Circle) obj;
			if(this.radius == c.getRadius() && this.center.equals(c.getCenter())){
				return true;
			}else{
				return false;
			}
			}else{
				return false;
		}
	}
	
	public boolean contains(int x, int y){
		return this.getCenter().distance(x, y) <= radius;
	}
	
	public boolean contains(Point p){
		return this.getCenter().distance(p.getX(), p.getY()) <= radius;
	}

	public void moveBy(int x, int y){
		center.moveBy(x, y);
	}

	//compareTo
	public int compareTo(Object o){
		if(o instanceof Circle){
			return (this.radius - ((Circle) o).radius);
		}
		return 0;
	}
	
	 public String toString(){
	        return "Center= " + center + ", radius= " + radius;
	    }
}
