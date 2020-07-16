package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Dount extends Circle{
	
	private int innerRadius;

	public Dount(){
		
	}
	
	public Dount(Point center, int radius, int innerRadius){
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Dount(Point center, int radius, int innerRadius, boolean selected){
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public Dount(Point center, int radius, int innerRadius, Color edgeColor, Color innerColor){
		super(center, radius, edgeColor, innerColor);
		this.innerRadius = innerRadius;
		//setEdgeColor(edgeColor);
		//setInnerColor(innerColor);
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public double area(){
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Path2D path = new Path2D.Double(Path2D.WIND_EVEN_ODD);
		
		path.append(new Ellipse2D.Double(getCenter().getX() - getRadius(), this.getCenter().getY() - getRadius(), getRadius()*2, getRadius()*2), false);
		path.append(new Ellipse2D.Double(getCenter().getX() - getInnerRadius(), this.getCenter().getY() - getInnerRadius(), getInnerRadius()*2, getInnerRadius()*2), false);
		
		//g2d.setColor(getInnerColor());
		g2d.fill(path);
		
		//g2d.setColor(getEdgeColor());
		g2d.drawOval(getCenter().getX() - getRadius(), this.getCenter().getY() - getRadius(), getRadius() * 2, getRadius() * 2);
		g2d.drawOval(getCenter().getX() - getInnerRadius(), getCenter().getY() - getInnerRadius(), getInnerRadius() * 2, getInnerRadius() * 2);
		
		if(isSelected()){
			g2d.setColor(Color.BLUE);
			g2d.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g2d.drawRect(getCenter().getX() - 3 - getRadius(), getCenter().getY() - 3, 6, 6);
			g2d.drawRect(getCenter().getX() - 3 + getRadius(), getCenter().getY() - 3, 6, 6);
			g2d.drawRect(getCenter().getX() - 3, getCenter().getY() - 3 - getRadius(), 6, 6);
			g2d.drawRect(getCenter().getX() - 3, getCenter().getY() - 3 + getRadius(), 6, 6);
		}
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Dount){
			Dount d = (Dount) obj;
			if(this.getRadius() == d.getRadius() && this.getCenter() == d.getCenter() && this.getInnerRadius() == d.getInnerRadius()){
			return true;
			}else{
			return false;
		}
	}else{
		return false;
		}
	}
	
	//?????????
	public boolean contains(int x, int y){
		double dc = this.getCenter().distance(x, y);
		return super.contains(x, y) && dc > innerRadius;
	}
	
	public int compareTo(Object o){
		if(o instanceof Dount){
			return (int) (this.area() - ((Dount) o).area());
		}
		return 0;
	}
	
	public String toString(){
		return super.toString() + ", inner radius= " + innerRadius;
	}
}
