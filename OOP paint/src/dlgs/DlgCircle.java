package dlgs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Circle;
import shapes.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JtextFieldX;
	private JTextField JtextFieldY;
	private JTextField JtextFieldR;
	
	private Circle circle = null;
	private Color edgeColor = null;
	private Color innerColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblCenterX = new JLabel("Center X:");
				GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
				gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
				gbc_lblCenterX.anchor = GridBagConstraints.EAST;
				gbc_lblCenterX.gridx = 0;
				gbc_lblCenterX.gridy = 0;
				panel.add(lblCenterX, gbc_lblCenterX);
			}
			{
				JtextFieldX = new JTextField();
				GridBagConstraints gbc_JtextFieldX = new GridBagConstraints();
				gbc_JtextFieldX.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldX.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldX.gridx = 1;
				gbc_JtextFieldX.gridy = 0;
				panel.add(JtextFieldX, gbc_JtextFieldX);
				JtextFieldX.setColumns(10);
			}
			{
				JLabel lblCenterY = new JLabel("Center Y:");
				GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
				gbc_lblCenterY.anchor = GridBagConstraints.EAST;
				gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
				gbc_lblCenterY.gridx = 0;
				gbc_lblCenterY.gridy = 1;
				panel.add(lblCenterY, gbc_lblCenterY);
			}
			{
				JtextFieldY = new JTextField();
				GridBagConstraints gbc_JtextFieldY = new GridBagConstraints();
				gbc_JtextFieldY.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldY.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldY.gridx = 1;
				gbc_JtextFieldY.gridy = 1;
				panel.add(JtextFieldY, gbc_JtextFieldY);
				JtextFieldY.setColumns(10);
			}
			{
				JLabel lblRadius = new JLabel("Radius:");
				GridBagConstraints gbc_lblRadius = new GridBagConstraints();
				gbc_lblRadius.anchor = GridBagConstraints.EAST;
				gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblRadius.gridx = 0;
				gbc_lblRadius.gridy = 2;
				panel.add(lblRadius, gbc_lblRadius);
			}
			{
				JtextFieldR = new JTextField();
				GridBagConstraints gbc_JtextFieldR = new GridBagConstraints();
				gbc_JtextFieldR.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldR.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldR.gridx = 1;
				gbc_JtextFieldR.gridy = 2;
				panel.add(JtextFieldR, gbc_JtextFieldR);
				JtextFieldR.setColumns(10);
			}
			{
				JButton btnEdgeColor = new JButton("Edge color");
				btnEdgeColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edgeColor = JColorChooser.showDialog(null, "Choose color", edgeColor);
						
						if(edgeColor == null){
							edgeColor = Color.BLACK;
						}
					}
				});
				GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
				gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 5);
				gbc_btnEdgeColor.gridx = 0;
				gbc_btnEdgeColor.gridy = 3;
				panel.add(btnEdgeColor, gbc_btnEdgeColor);
			}
			{
				JButton btnInnerColor = new JButton("Inner color");
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColor = JColorChooser.showDialog(null, "Choose color", innerColor);
						
						if(innerColor == null){
							innerColor = Color.WHITE;
						}
					}
				});
				GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
				gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
				gbc_btnInnerColor.gridx = 0;
				gbc_btnInnerColor.gridy = 4;
				panel.add(btnInnerColor, gbc_btnInnerColor);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
						
						int newX = Integer.parseInt(JtextFieldX.getText());
						int newY = Integer.parseInt(JtextFieldY.getText());
						int newR = Integer.parseInt(JtextFieldR.getText());
						
						if(newX < 0 || newY < 0 || newR < 1){
							JOptionPane.showMessageDialog(null, "You entered incorrect values.", "WRONG!", JOptionPane.ERROR_MESSAGE);
						}
						
						circle = new Circle(new Point(newX, newY), newR, edgeColor, innerColor);
						dispose();
						
						}catch(Exception ex){
							JOptionPane.showMessageDialog(null, "You entered incorrect values.", "WRONG!", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Circle getCircle(){
		return circle;
	}
	
	public void setCircle(Circle c){
		JtextFieldX.setText("" + c.getCenter().getX());
		JtextFieldY.setText("" + c.getCenter().getY());
		JtextFieldR.setText("" + c.getRadius());
		edgeColor = c.getEdgeColor();
		innerColor = c.getInnerColor();
	}
	
	public void setPoint(Point p){
		JtextFieldX.setText("" + p.getX());
		JtextFieldY.setText("" + p.getY());
	}
	
	public void setColors(Color edgeColor, Color innerColor){
		this.edgeColor = edgeColor;
		this.innerColor = innerColor;
	}

}
