package dlgs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Line;
import shapes.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField JtextFieldX1;
	private JTextField JtextFieldY1;
	private JTextField JtextFieldX2;
	private JTextField JtextFieldY2;
	
	private Line line = null;
	private Color edgeColor = null;
	private Color innerColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
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
				JLabel lblFirstX = new JLabel("First X:");
				GridBagConstraints gbc_lblFirstX = new GridBagConstraints();
				gbc_lblFirstX.insets = new Insets(0, 0, 5, 5);
				gbc_lblFirstX.anchor = GridBagConstraints.EAST;
				gbc_lblFirstX.gridx = 0;
				gbc_lblFirstX.gridy = 0;
				panel.add(lblFirstX, gbc_lblFirstX);
			}
			{
				JtextFieldX1 = new JTextField();
				GridBagConstraints gbc_JtextFieldX1 = new GridBagConstraints();
				gbc_JtextFieldX1.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldX1.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldX1.gridx = 1;
				gbc_JtextFieldX1.gridy = 0;
				panel.add(JtextFieldX1, gbc_JtextFieldX1);
				JtextFieldX1.setColumns(10);
			}
			{
				JLabel lblFirstY = new JLabel("First Y:");
				GridBagConstraints gbc_lblFirstY = new GridBagConstraints();
				gbc_lblFirstY.anchor = GridBagConstraints.EAST;
				gbc_lblFirstY.insets = new Insets(0, 0, 5, 5);
				gbc_lblFirstY.gridx = 0;
				gbc_lblFirstY.gridy = 1;
				panel.add(lblFirstY, gbc_lblFirstY);
			}
			{
				JtextFieldY1 = new JTextField();
				GridBagConstraints gbc_JtextFieldY1 = new GridBagConstraints();
				gbc_JtextFieldY1.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldY1.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldY1.gridx = 1;
				gbc_JtextFieldY1.gridy = 1;
				panel.add(JtextFieldY1, gbc_JtextFieldY1);
				JtextFieldY1.setColumns(10);
			}
			{
				JLabel lblSecondX = new JLabel("Second X:");
				GridBagConstraints gbc_lblSecondX = new GridBagConstraints();
				gbc_lblSecondX.anchor = GridBagConstraints.EAST;
				gbc_lblSecondX.insets = new Insets(0, 0, 5, 5);
				gbc_lblSecondX.gridx = 0;
				gbc_lblSecondX.gridy = 2;
				panel.add(lblSecondX, gbc_lblSecondX);
			}
			{
				JtextFieldX2 = new JTextField();
				GridBagConstraints gbc_JtextFieldX2 = new GridBagConstraints();
				gbc_JtextFieldX2.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldX2.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldX2.gridx = 1;
				gbc_JtextFieldX2.gridy = 2;
				panel.add(JtextFieldX2, gbc_JtextFieldX2);
				JtextFieldX2.setColumns(10);
			}
			{
				JLabel lblSecondY = new JLabel("Second Y:");
				GridBagConstraints gbc_lblSecondY = new GridBagConstraints();
				gbc_lblSecondY.anchor = GridBagConstraints.EAST;
				gbc_lblSecondY.insets = new Insets(0, 0, 5, 5);
				gbc_lblSecondY.gridx = 0;
				gbc_lblSecondY.gridy = 3;
				panel.add(lblSecondY, gbc_lblSecondY);
			}
			{
				JtextFieldY2 = new JTextField();
				GridBagConstraints gbc_JtextFieldY2 = new GridBagConstraints();
				gbc_JtextFieldY2.insets = new Insets(0, 0, 5, 0);
				gbc_JtextFieldY2.fill = GridBagConstraints.HORIZONTAL;
				gbc_JtextFieldY2.gridx = 1;
				gbc_JtextFieldY2.gridy = 3;
				panel.add(JtextFieldY2, gbc_JtextFieldY2);
				JtextFieldY2.setColumns(10);
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
							
							int newFirstX = Integer.parseInt(JtextFieldX1.getText());
							int newFirstY = Integer.parseInt(JtextFieldY1.getText());
							int newSecondX = Integer.parseInt(JtextFieldX2.getText());
							int newSecondY = Integer.parseInt(JtextFieldY2.getText());
							
							if(newFirstX < 0 || newFirstY < 0 || newSecondX < 0 || newSecondY < 0){
								JOptionPane.showMessageDialog(null, "You entered incorrect values.", "WRONG!", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							line = new Line(new Point(newFirstX, newFirstY), new Point(newSecondX, newSecondY), edgeColor);
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
	
	public Line getLine(){
		return line;
	}
	
	public void setLine(Line l){
		JtextFieldX1.setText("" + l.getStartPoint().getX());
		JtextFieldY1.setText("" + l.getStartPoint().getY());
		JtextFieldX2.setText("" + l.getEndPoint().getX());
		JtextFieldY2.setText("" + l.getEndPoint().getY());
		edgeColor = l.getEdgeColor();
	}

}
