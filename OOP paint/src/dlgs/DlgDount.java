package dlgs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Dount;
import shapes.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JtextFieldX;
	private JTextField JtextFieldY;
	private JTextField JtextFieldR;
	private JTextField JtextFieldI;
	
	private Dount dount = null;
	private Color edgeColor = null;
	private Color innerColor = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDount dialog = new DlgDount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDount() {
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
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				JLabel lblOuterRadius = new JLabel("Radius:");
				GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
				gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
				gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblOuterRadius.gridx = 0;
				gbc_lblOuterRadius.gridy = 2;
				panel.add(lblOuterRadius, gbc_lblOuterRadius);
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
				JLabel lblInnerRadius = new JLabel("Inner radius:");
				GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
				gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
				gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblInnerRadius.gridx = 0;
				gbc_lblInnerRadius.gridy = 3;
				panel.add(lblInnerRadius, gbc_lblInnerRadius);
			}
			{
				JtextFieldI = new JTextField();
				GridBagConstraints gbc_JtextFieldI = new GridBagConstraints();
				gbc_JtextFieldI.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldI.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldI.gridx = 1;
				gbc_JtextFieldI.gridy = 3;
				panel.add(JtextFieldI, gbc_JtextFieldI);
				JtextFieldI.setColumns(10);
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
							int newR = Integer.parseInt(JtextFieldR.getText());
							int newI = Integer.parseInt(JtextFieldI.getText());
							
							if(newX < 0 || newY < 0 || newI < 1 || newI >= newR){
								JOptionPane.showMessageDialog(null, "You entered incorrect values.", "WRONG!", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							dount = new Dount(new Point(newX, newY), newR, newI, edgeColor, innerColor);
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
	
	public Dount getDount(){
		return dount;
	}
	
	public void setDount(Dount d){
		JtextFieldX.setText("" + d.getCenter().getX());
		JtextFieldY.setText("" + d.getCenter().getY());
		JtextFieldR.setText("" + d.getRadius());
		JtextFieldI.setText("" + d.getInnerRadius());
		edgeColor = d.getEdgeColor();
		innerColor = d.getInnerColor();
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
