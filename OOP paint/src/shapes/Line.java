package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	public Line(){
		
	}
	
	public Line(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected){
		this(startPoint, endPoint);
		setSelected(selected);
	}
	
	public Line(Point startPoint, Point endPoint, Color edgeColor){
		this(startPoint, endPoint);
		setEdgeColor(edgeColor);
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public double length(){
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Line){
			Line l = (Line) obj;
			if(l.getStartPoint().equals(this.getStartPoint()) && l.getEndPoint().equals(this.getEndPoint())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public Point middleLine(){
		int middleX = (this.getStartPoint().getX() + this.getEndPoint().getX())/2;
		int middleY = (this.getStartPoint().getY() + this.getEndPoint().getY())/2;
		Point p = new Point(middleX, middleY);
		return p;

	}
	
	public void draw(Graphics g){
		g.setColor(getEdgeColor());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
		
		if (isSelected()){
			g.setColor(Color.BLUE);
			g.drawRect(this.getStartPoint().getX() - 3, this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() - 3, 6, 6);
			g.drawRect(this.middleLine().getX() - 3, this.middleLine().getY() - 3, 6, 6);
		}
	}
	
	public boolean contains(int x, int y){
		if((startPoint.distance(x, y) - endPoint.distance(x, y) - length() <= 0.05)){
			return true;
		}else{
			return false;
		}
	}
	
	public void moveBy(int x, int y){
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);
	}
	
	public int compareTo(Object o){
		if(o instanceof Line){
			return (int)(this.length() - ((Line) o).length());
		}
		return 0;
	}
	
	public String toString(){
		return this.getStartPoint() + "->" + this.getEndPoint();
	}

}
