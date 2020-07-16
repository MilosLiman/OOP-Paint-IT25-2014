package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dlgs.DlgPoint;
import dlgs.DlgRectangle;
import dlgs.DlgLine;
import dlgs.DlgCircle;
import dlgs.DlgDount;


import shapes.Point;
import shapes.Line;
import shapes.Circle;
import shapes.Dount;
import shapes.Rectangle;
import shapes.Shape;


import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class FrameDrawing extends JFrame {
	
	private final int OPERATION_DRAWING = 1;
	private final int OPERATION_EDIT_DELETE = 0;
	
	private int activeOperation = OPERATION_DRAWING;
	private PanelDrawing pnlDraw = new PanelDrawing();
	private ButtonGroup btnsOperation = new ButtonGroup();
	private ButtonGroup btnsShapes = new ButtonGroup();
	
	JToolBar toolBar = new JToolBar();
	private JToggleButton tglbtnDrawing = new JToggleButton("Drawing");
	private JToggleButton tglbtnModify = new JToggleButton("Modify");
	private JToggleButton tglbtnDelete = new JToggleButton("Delete");
	private JToggleButton tglbtnPoint = new JToggleButton("Point");
	private JToggleButton tglbtnLine = new JToggleButton("Line");
	private JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglbtnCircle = new JToggleButton("Circle");
	private JToggleButton tglbtnDount = new JToggleButton("Dount");
	private JToggleButton tglbtnColorEdge = new JToggleButton("Edge Color");
	private JToggleButton tglbtnColorInner = new JToggleButton("Inner Color");

	private Color edgeColor = Color.BLACK, innerColor = Color.WHITE;
	
	private boolean lineWaitingForSecondPoint = false;
	private Point lineFirstPoint;
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDrawing frame = new FrameDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("Paint");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnlDraw.addMouseListener(pnlDrawClickListener());
		pnlDraw.setBorder(new LineBorder(SystemColor.textHighlight, 5));
		contentPane.add(pnlDraw, BorderLayout.CENTER);
		pnlDraw.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		pnlDraw.add(panel_1, BorderLayout.CENTER);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		tglbtnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperationDrawing();
			}
		});
		toolBar.add(tglbtnDrawing);
		btnsOperation.add(tglbtnDrawing);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperationModifyDelete();
			}
		});
		toolBar.add(tglbtnModify);
		tglbtnModify.addActionListener(tglbtnModifyClickListener());
		btnsOperation.add(tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperationModifyDelete();
			}
		});
		toolBar.add(tglbtnDelete);
		tglbtnDelete.addActionListener(tglbtnDeleteClickListener());
		btnsOperation.add(tglbtnDelete);
		
		JPanel panel_2 = new JPanel();
		pnlDraw.add(panel_2, BorderLayout.CENTER);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		//POINT
		toolBar.add(tglbtnPoint);
		btnsShapes.add(tglbtnPoint);

		//LINE
		toolBar.add(tglbtnLine);
		btnsShapes.add(tglbtnLine);
	
		//Rectangle
		toolBar.add(tglbtnRectangle);
		btnsShapes.add(tglbtnRectangle);

		//Circle
		toolBar.add(tglbtnCircle);
		btnsShapes.add(tglbtnCircle);

		//Dount
		toolBar.add(tglbtnDount);
		btnsShapes.add(tglbtnDount);

		JPanel panel_3 = new JPanel();
		pnlDraw.add(panel_3, BorderLayout.CENTER);
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JToggleButton tglbtnEdgeColor = new JToggleButton("Edge color");
		toolBar.add(tglbtnEdgeColor);
		tglbtnEdgeColor.addActionListener(tglbtnColorEdgeClickListener());
		
		JToggleButton tglbtnInnerColor = new JToggleButton("Inner color");
		toolBar.add(tglbtnInnerColor);
		tglbtnInnerColor.addActionListener(tglbtnColorInnerClickListener());

	}
	
	private MouseAdapter pnlDrawClickListener(){
		return new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				Point mouseClick = new Point(e.getX(), e.getY());
				pnlDraw.deselect();
				
				if(!tglbtnLine.isSelected()) lineWaitingForSecondPoint = false;
				
				if (activeOperation == OPERATION_EDIT_DELETE) {
					pnlDraw.select(mouseClick);
					return;
				}
				
				if(tglbtnPoint.isSelected()){
					pnlDraw.addShape(new Point(mouseClick.getX(), mouseClick.getY(), edgeColor));
					return;
				}else if(tglbtnLine.isSelected()){
					
					if(lineWaitingForSecondPoint){
						pnlDraw.addShape(new Line(lineFirstPoint, mouseClick, edgeColor));
						lineWaitingForSecondPoint = false;
						return;
					}
					
					lineFirstPoint = mouseClick;
					lineWaitingForSecondPoint = true;
					return;
				}else if(tglbtnRectangle.isSelected()){
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setPoint(mouseClick);
					dlgRectangle.setColors(edgeColor, innerColor);
					dlgRectangle.setVisible(true);
					
					if(dlgRectangle.getRectangle() != null){
						pnlDraw.addShape(dlgRectangle.getRectangle());
						return;
					}
				}else if(tglbtnCircle.isSelected()){
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(mouseClick);
					dlgCircle.setColors(edgeColor, innerColor);
					dlgCircle.setVisible(true);
					
					if(dlgCircle.getCircle() != null){
						pnlDraw.addShape(dlgCircle.getCircle());
						return;
					}
				}else if(tglbtnDount.isSelected()){
					DlgDount dlgDount = new DlgDount();
					dlgDount.setPoint(mouseClick);
					dlgDount.setColors(edgeColor, innerColor);
					dlgDount.setVisible(true);
					
					if(dlgDount.getDount() != null){
						pnlDraw.addShape(dlgDount.getDount());
						return;
					}
				}
			}
		};
	}
	
	private ActionListener tglbtnModifyClickListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = pnlDraw.getSelected();
				if(index == -1){
					return;
				}
				
				Shape shape = pnlDraw.getShape(index);
				
				if(shape instanceof Point){
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint((Point) shape);
					dlgPoint.setVisible(true);
					
					if(dlgPoint.getPoint() != null){
						pnlDraw.setShape(index, dlgPoint.getPoint());
						pnlDraw.repaint();
					}
				}else if(shape instanceof Line){
					DlgLine dlgLine = new DlgLine();
					dlgLine.setLine((Line) shape);
					dlgLine.setVisible(true);
					
					if(dlgLine.getLine() != null){
						pnlDraw.setShape(index, dlgLine.getLine());
						pnlDraw.repaint();
					}
				}else if(shape instanceof Rectangle){
					DlgRectangle dlgRect = new DlgRectangle();
					dlgRect.setRectangle((Rectangle) shape);
					dlgRect.setVisible(true);
					
					if(dlgRect.getRectangle() != null){
						pnlDraw.setShape(index, dlgRect.getRectangle());
						pnlDraw.repaint();
					}
				}else if(shape instanceof Circle && !(shape instanceof Dount)){
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setCircle((Circle) shape);
					dlgCircle.setVisible(true);
					
					if(dlgCircle.getCircle() != null){
						pnlDraw.setShape(index, dlgCircle.getCircle());
						pnlDraw.repaint();
					}
				}else if(shape instanceof Dount){
					DlgDount dlgDount = new DlgDount();
					dlgDount.setDount((Dount) shape);
					dlgDount.setVisible(true);
					
					if(dlgDount.getDount() != null){
						pnlDraw.setShape(index, dlgDount.getDount());
						dlgDount.repaint();
					}
				}
				
			}
		};
	}
	
	private ActionListener tglbtnDeleteClickListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (pnlDraw.getSelected() == -1){
					return;
				}
				
				if(JOptionPane.showConfirmDialog(null, "Do you want to delete selected shapes?", "Agree", JOptionPane.QUESTION_MESSAGE) == 0){
					pnlDraw.removeSelected();
				}
			}
		};
	}

		private ActionListener tglbtnColorEdgeClickListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				edgeColor = JColorChooser.showDialog(null, "Choose color", edgeColor);
				if(edgeColor == null){
					edgeColor = Color.BLACK;
				}
			}
		};
	}
	
	private ActionListener tglbtnColorInnerClickListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e){
				innerColor = JColorChooser.showDialog(null, "Choose color", innerColor);
				if(innerColor == null){
					innerColor = Color.WHITE;
				}
			}
		};
	}
	
	private void setOperationDrawing(){
		activeOperation = OPERATION_DRAWING;
		
		pnlDraw.deselect();
		
		tglbtnModify.setEnabled(false);
		tglbtnDelete.setEnabled(false);	
		
		tglbtnPoint.setEnabled(true);
		tglbtnLine.setEnabled(true);
		tglbtnRectangle.setEnabled(true);
		tglbtnCircle.setEnabled(true);
		tglbtnDount.setEnabled(true);
		
		tglbtnColorEdge.setEnabled(true);
		tglbtnColorInner.setEnabled(true);
		
	}
	
	private void setOperationModifyDelete(){
		activeOperation = OPERATION_EDIT_DELETE;
		
		tglbtnModify.setEnabled(true);
		tglbtnDelete.setEnabled(true);
		
		tglbtnPoint.setEnabled(false);
		tglbtnLine.setEnabled(false);
		tglbtnRectangle.setEnabled(false);
		tglbtnCircle.setEnabled(false);
		tglbtnDount.setEnabled(false);
		
		tglbtnColorEdge.setEnabled(false);
		tglbtnColorInner.setEnabled(false);

	}

}
