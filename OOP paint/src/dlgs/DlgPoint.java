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

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JtextFieldX;
	private JTextField JtextFieldY;
	
	private Point point = null;
	private Color edgeColor = null;
	private Color innerColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
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
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				JButton btnColorEdge = new JButton("Edge color");
				btnColorEdge.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						edgeColor = JColorChooser.showDialog(null, "Choose edge color", edgeColor);
						if(edgeColor == null){
							edgeColor = Color.BLACK;
						}
					}
				});
				GridBagConstraints gbc_btnColorEdge = new GridBagConstraints();
				gbc_btnColorEdge.insets = new Insets(0, 0, 5, 5);
				gbc_btnColorEdge.gridx = 0;
				gbc_btnColorEdge.gridy = 2;
				panel.add(btnColorEdge, gbc_btnColorEdge);
			}
			{
				JButton btnColorInner = new JButton("Inner color");
				btnColorInner.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				GridBagConstraints gbc_btnColorInner = new GridBagConstraints();
				gbc_btnColorInner.insets = new Insets(0, 0, 0, 5);
				gbc_btnColorInner.gridx = 0;
				gbc_btnColorInner.gridy = 3;
				panel.add(btnColorInner, gbc_btnColorInner);
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
							
							if(newX < 0 || newY < 0){
								JOptionPane.showMessageDialog(null, "You entered incorrect values.", "WRONG!", JOptionPane.ERROR_MESSAGE);
							}
							
							point = new Point(newX, newY, edgeColor);
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
	
	public Point getPoint(){
		return point;
	}
	
	public void setPoint(Point p){
		
		JtextFieldX.setText("" + p.getX());
		JtextFieldY.setText("" + p.getY());
		edgeColor = p.getEdgeColor();
	}

}
