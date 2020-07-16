package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	
	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle(){
		
	}
	
	public Rectangle(Point upperLeft, int width, int height){
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected){
		this(upperLeft, width, height);
		setSelected(selected);
	}

	public Rectangle(Point upperLeft, int width, int height, Color edgeColor, Color innerColor){
		this(upperLeft, width, height);
		setEdgeColor(edgeColor);
		setInnerColor(innerColor);
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//metoda za racunanje povrsine pravoug.
	public int area(){
		return width * height;
	}
	
	//metoda za crtanje
	public void draw(Graphics g){
		//g.setColor(getEdgeColor());
		g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.height);
		//g.setColor(getInnerColor());
		g.fillRect(this.getUpperLeft().getX() + 1, this.getUpperLeft().getY() + 1, this.width - 1, this.height - 1);
		
		if(isSelected()){
			g.setColor(Color.BLUE);
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3 + getWidth(), this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() + getHeight() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() + getWidth() - 3, this.getUpperLeft().getY() + getHeight() - 3, 6, 6);
			
		}
	}
	
	//metoda equals koja proverava da li su objekti isti
	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle r = (Rectangle) obj;
			if(this.upperLeft.equals(r.getUpperLeft()) && this.width == r.getWidth() && this.height == r.getHeight()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	//metoda contains, nakon sto korisnik klikne na oblik, treba da prodje kroz sve oblike i nadje onaj na koji je kliknuto
	public boolean contains(int x, int y){
		if(this.getUpperLeft().getX() <= x && x <= this.getUpperLeft().getX() + width && 
				this.getUpperLeft().getY() <= y && y <= this.getUpperLeft().getY() + height){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean constains(Point p){
		if(this.getUpperLeft().getX() <= p.getX() && p.getX() <= this.getUpperLeft().getX() + width && this.getUpperLeft().getY() <= p.getY() && p.getY() <= this.getUpperLeft().getY() + height){
			return true;
		}else{
			return false;
		}
	}

	//metoda za pomeranje
	public void moveBy(int x, int y){
		upperLeft.moveBy(x, y);
	}
	
	
	//metoda za??
	public int compareTo(Object o){
		if(o instanceof Rectangle){
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}
	
	public String toString(){
		return  "Upper left point=" + upperLeft + ", height=" + height + ", width=" + width;
	}
}
