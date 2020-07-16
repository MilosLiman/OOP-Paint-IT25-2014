package dlgs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Point;
import shapes.Rectangle;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JtextFieldX;
	private JTextField JtextFieldY;
	private JTextField JtextFieldW;
	private JTextField JtextFieldH;
	
	private Rectangle rectangle = null;
	private Color edgeColor = null;
	private Color innerColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblXCenter = new JLabel("X center:");
				GridBagConstraints gbc_lblXCenter = new GridBagConstraints();
				gbc_lblXCenter.insets = new Insets(0, 0, 5, 5);
				gbc_lblXCenter.anchor = GridBagConstraints.EAST;
				gbc_lblXCenter.gridx = 0;
				gbc_lblXCenter.gridy = 0;
				panel.add(lblXCenter, gbc_lblXCenter);
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
				JLabel lblYCenter = new JLabel("Y center:");
				GridBagConstraints gbc_lblYCenter = new GridBagConstraints();
				gbc_lblYCenter.anchor = GridBagConstraints.EAST;
				gbc_lblYCenter.insets = new Insets(0, 0, 5, 5);
				gbc_lblYCenter.gridx = 0;
				gbc_lblYCenter.gridy = 1;
				panel.add(lblYCenter, gbc_lblYCenter);
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
				JLabel lblWidth = new JLabel("Width: ");
				GridBagConstraints gbc_lblWidth = new GridBagConstraints();
				gbc_lblWidth.anchor = GridBagConstraints.EAST;
				gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
				gbc_lblWidth.gridx = 0;
				gbc_lblWidth.gridy = 2;
				panel.add(lblWidth, gbc_lblWidth);
			}
			{
				JtextFieldW = new JTextField();
				GridBagConstraints gbc_JtextFieldW = new GridBagConstraints();
				gbc_JtextFieldW.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldW.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldW.gridx = 1;
				gbc_JtextFieldW.gridy = 2;
				panel.add(JtextFieldW, gbc_JtextFieldW);
				JtextFieldW.setColumns(10);
			}
			{
				JLabel lblHight = new JLabel("Hight:");
				GridBagConstraints gbc_lblHight = new GridBagConstraints();
				gbc_lblHight.anchor = GridBagConstraints.EAST;
				gbc_lblHight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHight.gridx = 0;
				gbc_lblHight.gridy = 3;
				panel.add(lblHight, gbc_lblHight);
			}
			{
				JtextFieldH = new JTextField();
				GridBagConstraints gbc_JtextFieldH = new GridBagConstraints();
				gbc_JtextFieldH.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldH.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldH.gridx = 1;
				gbc_JtextFieldH.gridy = 3;
				panel.add(JtextFieldH, gbc_JtextFieldH);
				JtextFieldH.setColumns(10);
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
				gbc_btnEdgeColor.gridy = 4;
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
				gbc_btnInnerColor.gridy = 5;
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
						
						try{
							
						int newX = Integer.parseInt(JtextFieldX.getText());
						int newY = Integer.parseInt(JtextFieldY.getText());
						int newW = Integer.parseInt(JtextFieldW.getText());
						int newH = Integer.parseInt(JtextFieldH.getText());
						
						if(newX < 0 || newY < 0 || newW < 0 || newH < 0){
							JOptionPane.showMessageDialog(null,  "You entered incorrect values.", "WRONG!", JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						rectangle = new Rectangle(new Point(newX, newY), newW, newH, edgeColor, innerColor);
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

	public Rectangle getRectangle(){
		return rectangle;
	}
	
	public void setPoint(Point p){
		JtextFieldX.setText("" + p.getX());
		JtextFieldY.setText("" + p.getY());
	}
	
	public void setColors(Color edgeColor, Color innerColor){
		this.edgeColor = edgeColor;
		this.innerColor = innerColor;
	}
	
	public void setRectangle(Rectangle r){
		JtextFieldX.setText("" + r.getUpperLeft().getX());
		JtextFieldY.setText("" + r.getUpperLeft().getY());
		JtextFieldW.setText("" + r.getWidth());
		JtextFieldH.setText("" + r.getHeight());
		edgeColor = r.getEdgeColor();
		innerColor = r.getInnerColor();
	}
}
