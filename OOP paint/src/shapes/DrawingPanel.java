package shapes;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Frame");
		frame.getContentPane().add(new DrawingPanel());
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g){
		Point p = new Point(100, 100, true);
		p.draw(g);
		
		Line l = new Line(new Point(200,150), new Point(200,250), true);
		l.draw(g);
		
		Rectangle r = new Rectangle(new Point(500,100), 200, 100, true);
		r.draw(g);
		
		Circle c = new Circle(new Point(300, 200), 50, false);
		c.draw(g);
		
		Dount d = new Dount(new Point(350, 400), 60, 30, true);
		d.draw(g);
		
	}

}
