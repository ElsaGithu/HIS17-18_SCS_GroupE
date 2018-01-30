package com.his.scs.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.his.scs.helper.AppConstants;
import com.his.scs.model.SimulateFallingBSL;
import com.his.scs.model.SimulateRisingBSL;

public class PatientAutoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8779702897679223872L;
	private JTextField textField;
	private double bslValue = 0;
	private JLabel lblHormoneAmount;
	private BSLLiveGraph graph;
	private final static double CONVERSION_FACTOR = 18.016;
	private JButton btnProcess;

	public PatientAutoPanel(BSLLiveGraph graph) {
		this.graph = graph;
		this.setPreferredSize(new Dimension(242, 145));
		this.setBorder(null);
		this.setLayout(null);
		this.setVisible(false);

		JLabel lblBloodSugarLevel = new JLabel("Sensor reading");
		lblBloodSugarLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloodSugarLevel.setBounds(6, 50, 108, 16);
		this.add(lblBloodSugarLevel);

		textField = new JTextField();
		textField.setBounds(126, 45, 64, 26);
		this.add(textField);
		textField.setColumns(10);

		btnProcess = new JButton("Process");
		btnProcess.setBounds(61, 88, 114, 26);
		btnProcess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				processButtonPressed();

			}
		});
		this.add(btnProcess);

		JLabel lblHormoneAmount = new JLabel("");
		lblHormoneAmount.setBounds(6, 123, 218, 16);
		add(lblHormoneAmount);
		graph.setHormoneAmountLabel(lblHormoneAmount);

		JLabel lblMgdl = new JLabel("mg/dL");
		lblMgdl.setBounds(196, 53, 49, 18);
		add(lblMgdl);

		JLabel lblAutoMode = new JLabel("Auto Mode");
		lblAutoMode.setForeground(Color.GRAY);
		lblAutoMode.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		lblAutoMode.setBounds(81, 11, 94, 14);
		add(lblAutoMode);



	}


	public void processButtonPressed() {

		try {
			bslValue = (Double.parseDouble(textField.getText()))/CONVERSION_FACTOR;
			selectRisingOrFalling();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid input");
		}




	}

	public void selectRisingOrFalling() {
		if ( (bslValue - AppConstants.BSL_PREVIOUS) > 0) {
			btnProcess.setEnabled(false);
			graph.setButton(btnProcess);
			graph.setBslList(new SimulateRisingBSL().addBSLValuesToList(AppConstants.BSL_PREVIOUS, bslValue));
		}else if ((bslValue - AppConstants.BSL_PREVIOUS) < 0) {
			btnProcess.setEnabled(false);
			graph.setButton(btnProcess);
			graph.setBslList(new SimulateFallingBSL().addBSLValuesToList(AppConstants.BSL_PREVIOUS, bslValue));
		}
	}

	public void resetLabel() {
		if(graph != null) {
			JLabel label = graph.getHormoneAmountLabel();
			if(label != null)
				label.setText("");
		}


	}


}
