package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import shapes.Shape;
import shapes.Point;

public class PanelDrawing extends JPanel {
	
	private ArrayList<Shape> listOfShapes = new ArrayList<Shape>();
	private int i;
	
	
	/**
	 * Create the panel.
	 */
	public PanelDrawing() {
		setBackground(Color.WHITE);

	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		super.paint(g);
		listOfShapes.forEach(shape -> shape.draw(g));
	}
	
	public void clearPane(){
		listOfShapes.clear();
		repaint();
	}
	
	public void addShape(Shape shape){
		listOfShapes.add(shape);
		repaint();
	}
	
	public Shape getShape(int index){
		return listOfShapes.get(index);
	}
	
	public void setShape(int index, Shape shape){
		listOfShapes.set(index, shape);
	}
	
	public void removeSelected(){
		listOfShapes.removeIf(shape -> shape.isSelected());
		repaint();
	}
	
	public void deselect(){
		listOfShapes.forEach(shape -> shape.setSelected(false));
	}
	
	public void select(Point p){
		for(i = listOfShapes.size() - 1; i >= 0; i--){
			if(listOfShapes.get(i).contains(p.getX(), p.getY())){
				listOfShapes.get(i).setSelected(true);
				repaint();
				return;
			}
		}
	}
	
	//sto -1 ????
	public int getSelected(){
		for(i = listOfShapes.size() - 1; i >= 0; i--){
			if(listOfShapes.get(i).isSelected()){
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty(){
		return listOfShapes.isEmpty();
	}
	
	public ArrayList<Shape> getShape(){
		return listOfShapes;
	}
}
