package com.his.scs.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.his.scs.helper.AppConstants;
import com.his.scs.helper.SaveToFile;
import com.his.scs.model.CalculateBSLAndGlucagon;
import com.his.scs.model.CalculateBSLAndInsulin;

public class PatientManualPanel extends JPanel {
	private double dosage = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8779702897679223872L;
	private JTextField insulinDoseField;
	private BSLLiveGraph graph;
	private JTextField glucagonDoseField;
	private JButton btnInjectInsulin;
	private JButton btnInjectGlucagon;

	public PatientManualPanel(BSLLiveGraph graph) {
		AppConstants.AUTO_ADJUST = true;
		this.graph = graph;
		this.setPreferredSize(new Dimension(242, 145));
		this.setBorder(null);
		this.setLayout(null);
		this.setVisible(false);
		this.revalidate();

		JLabel lblAutoMode = new JLabel("Manual Mode");
		lblAutoMode.setForeground(Color.GRAY);
		lblAutoMode.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		lblAutoMode.setBounds(81, 11, 92, 14);
		add(lblAutoMode);

		JLabel lblInsulinDose = new JLabel("Insulin Dose :");
		lblInsulinDose.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsulinDose.setBounds(10, 37, 107, 18);
		this.add(lblInsulinDose);

		insulinDoseField = new JTextField();
		insulinDoseField.setEditable(false);
		insulinDoseField.setBounds(115, 36, 48, 16);
		this.add(insulinDoseField);
		insulinDoseField.setColumns(10);

		JLabel lblMgdl = new JLabel("IU ");
		lblMgdl.setBounds(173, 37, 21, 18);
		add(lblMgdl);

		JLabel lblGlucagonDose = new JLabel("Glucagon Dose :");
		lblGlucagonDose.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGlucagonDose.setBounds(10, 65, 107, 16);
		add(lblGlucagonDose);

		glucagonDoseField = new JTextField();
		glucagonDoseField.setEditable(false);
		glucagonDoseField.setColumns(10);
		glucagonDoseField.setBounds(115, 65, 48, 16);
		add(glucagonDoseField);

		JLabel lblIu = new JLabel("IU ");
		lblIu.setBounds(173, 64, 21, 18);
		add(lblIu);

		populateValues();

		btnInjectInsulin = new JButton("Inject Insulin");
		btnInjectInsulin.setBounds(44, 92, 150, 20);
		btnInjectInsulin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				processInsulinButtonPressed();

			}
		});
		add(btnInjectInsulin);

		btnInjectGlucagon = new JButton("Inject Glucagon");
		btnInjectGlucagon.setBounds(44, 115, 150, 20);
		btnInjectGlucagon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				processGlucagonButtonPressed();

			}
		});
		this.add(btnInjectGlucagon);

		double iValue = Double.parseDouble(insulinDoseField.getText().toString());
		if (iValue == 0) {
			btnInjectInsulin.setEnabled(false);
			;
		}

		double gValue = Double.parseDouble(glucagonDoseField.getText().toString());
		if (gValue == 0) {
			btnInjectGlucagon.setEnabled(false);
		}

	}

	public void processInsulinButtonPressed() {

		dosage = Double.parseDouble(insulinDoseField.getText());
		double insAvailable = AppConstants.getTOTAL_INSULIN() - AppConstants.getTOTAL_INSULIN_USED();
		if (insAvailable >= dosage) {
			CalculateBSLAndInsulin object = new CalculateBSLAndInsulin();
			object.setInsulin(dosage);

			double fValue = object.calculateFinalLevelFromInsulinDosage();
			enableButtons(fValue);
			AppConstants.getReserve().updateInsulin(dosage);
			graph.setBslList(object.addBSLValuesToList(AppConstants.BSL_PREVIOUS));
			new SaveToFile(AppConstants.BSL_PREVIOUS, dosage, 0);
		} else {
			JOptionPane.showMessageDialog(this, "Insulin reserve is empty");
		}

	}

	public void processGlucagonButtonPressed() {

		dosage = Double.parseDouble(glucagonDoseField.getText());
		double glucAvailable = AppConstants.getTOTAL_GLUCAGON() - AppConstants.getTOTAL_GLUCAGON_USED();
		if (glucAvailable >= dosage) {
			CalculateBSLAndGlucagon object = new CalculateBSLAndGlucagon();
			object.setGlucagon(dosage);
			double fValue = object.calculateFinalLevelFromGlucagonDosage();
			enableButtons(fValue);
			AppConstants.getReserve().updateGlucagon(dosage);
			graph.setBslList(object.addBSLValuesToList(AppConstants.BSL_PREVIOUS));
			new SaveToFile(AppConstants.BSL_PREVIOUS, 0, dosage);
		} else {
			JOptionPane.showMessageDialog(this, "Glucagon reserve empty");
		}

	}

	protected void populateValues() {

		BufferedReader buffer = null;
		FileReader reader = null;

		try {

			reader = new FileReader(AppConstants.SET_MANUAL_MODE_FILE_PATH);
			buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null) {
				if (line != null) {
					String[] split = line.split(",");
					insulinDoseField.setText(split[1]);
					glucagonDoseField.setText(split[2]);
				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (buffer != null)
					buffer.close();

				if (reader != null)
					reader.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	private void enableButtons(double fValue) {
		if ((fValue <= (AppConstants.BSL_HIGH_DANGER / AppConstants.CONVERSION_FACTOR))
				&& (fValue >= (AppConstants.BSL_LOW_DANGER / AppConstants.CONVERSION_FACTOR))) {
			btnInjectInsulin.setEnabled(true);
			btnInjectGlucagon.setEnabled(true);
		} else if (fValue <= (AppConstants.BSL_LOW_DANGER / AppConstants.CONVERSION_FACTOR)) {
			btnInjectInsulin.setEnabled(false);
			btnInjectGlucagon.setEnabled(true);
		} else if (fValue >= (AppConstants.BSL_HIGH_DANGER / AppConstants.CONVERSION_FACTOR)) {
			btnInjectGlucagon.setEnabled(false);
			btnInjectInsulin.setEnabled(true);
		}

	}

	public void resetButtons() {
		if(btnInjectInsulin != null && btnInjectGlucagon != null) {
			btnInjectInsulin.setEnabled(true);
			btnInjectGlucagon.setEnabled(true);
		}
	}
}
