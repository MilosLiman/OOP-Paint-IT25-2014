package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	
	private int x;
	private int y;
	
	public Point(){
		
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected){
		this(x,y);
		setSelected(selected);
	}
	
	//KONSTR. SA COLOR
	public Point(int x, int y, Color edgeColor){
		this(x,y);
		setEdgeColor(edgeColor);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double distance(int x2, int y2){
		int dx = this.x - x2;
		int dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Point){
			Point p = (Point) obj;
			if(p.x == this.x && p.y == this.y){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(getEdgeColor());
		g.drawLine(this.x - 2, y, this.x + 2, y);
		g.drawLine(x, this.y-2, x, this.y+2);
	}
	
	public boolean contains(int x, int y){
		return this.distance(x, y) <=3;
	}
	
	public void moveBy(int dx, int dy){
		this.x = this.x + dx;
		this.y = this.y + dy;
	}
	
	//compareTo ????
	public int compareTo(Object o){
		if(o instanceof Point){
			Point start = new Point(0, 0);
			return (int) (this.distance(start.getX(), start.getY()) - ((Point) o).distance(start.getX(), start.getY()));
		}
		return 0;
	}
	
	public String toString(){
		return "(" + this.x + ", " + this.y + ")";
	}
}
