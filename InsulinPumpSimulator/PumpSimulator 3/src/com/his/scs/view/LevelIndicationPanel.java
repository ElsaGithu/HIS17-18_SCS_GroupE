package com.his.scs.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;

import com.his.scs.helper.AppConstants;
import com.his.scs.helper.SaveHormoneReserves;
import com.his.scs.helper.WarningConstants;
import com.his.scs.model.HormoneBean;

@SuppressWarnings("deprecation")
public class LevelIndicationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4904277699955513944L;

	private JProgressBar pBarInsulin;
	private JProgressBar pBarGlucagon;
	private double insulin;
	private double glucagon;

	public LevelIndicationPanel() {

		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setBounds(268, 6, 250, 146);

		this.setLayout(null);

		JLabel lblInsulin = new JLabel("Insulin");
		lblInsulin.setBounds(6, 6, 61, 16);
		this.add(lblInsulin);

		JLabel lbLGlucagon = new JLabel("Glucagon");
		lbLGlucagon.setBounds(6, 55, 61, 16);
		this.add(lbLGlucagon);

		JLabel lblBattery = new JLabel("Battery");
		lblBattery.setBounds(6, 100, 61, 16);
		this.add(lblBattery);

		pBarGlucagon = new JProgressBar();
		pBarGlucagon.setForeground(new Color(34, 139, 34));
		pBarGlucagon.setBounds(79, 53, 131, 18);
		pBarGlucagon.setValue(100);
		pBarGlucagon.setStringPainted(true);
		this.add(pBarGlucagon);

		JProgressBar pBarBattery = new JProgressBar();
		pBarBattery.setForeground(new Color(34, 139, 34));
		pBarBattery.setBounds(79, 100, 131, 18);
		pBarBattery.setValue(100);
		pBarBattery.setStringPainted(true);
		this.add(pBarBattery);

		pBarInsulin = new JProgressBar();
		pBarInsulin.setForeground(new Color(34, 139, 34));
		pBarInsulin.setBounds(79, 6, 131, 18);
		pBarInsulin.setValue(100);
		pBarInsulin.setStringPainted(true);

		this.add(pBarInsulin);

		JButton btnPlusBattery = new JButton("+");
		btnPlusBattery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int value = pBarBattery.getValue();
				pBarBattery.setValue(value+10);
				if(pBarBattery.getValue()<=20) {
					JOptionPane.showMessageDialog(null, "Battery Level too Low. Please Recharge!", "ALERT!" , 0);
				}
			}
		});
		btnPlusBattery.setBounds(169, 124, 41, 16);
		add(btnPlusBattery);

		JButton btnMinusBattery = new JButton("-");
		btnMinusBattery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int value = pBarBattery.getValue();
				pBarBattery.setValue(value-10);
				if(pBarBattery.getValue()<=20) {
					JOptionPane.showMessageDialog(null, "Battery Level too Low. Please Recharge!", "ALERT!" , 0);
				}
			}
		});
		btnMinusBattery.setBounds(79, 124, 41, 16);
		add(btnMinusBattery);

		JButton btnRefillIns = new JButton("Refill");
		btnRefillIns.setBounds(93, 27, 105, 20);
		btnRefillIns.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AppConstants.setTOTAL_INSULIN_USED(0.0);
				new SaveHormoneReserves().writeToFile(0.0, AppConstants.HORMONE_TYPE_INSULIN);
				pBarInsulin.setValue(100);
				WarningConstants.setInsulinLevelWarning(false);

			}
		});
		add(btnRefillIns);

		JButton btnrefillGluc = new JButton("Refill");
		btnrefillGluc.setBounds(93, 75, 105, 20);
		btnrefillGluc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AppConstants.setTOTAL_GLUCAGON_USED(0.0);
				new SaveHormoneReserves().writeToFile(0.0, AppConstants.HORMONE_TYPE_GLUCAGON);
				pBarGlucagon.setValue(100);
				WarningConstants.setGlucagonLevelWarning(false);

			}
		});
		add(btnrefillGluc);
		String hormoneLevels = new SaveHormoneReserves().readFromFile();
		String[] split = hormoneLevels.split(",");
		insulin = Double.parseDouble(split[0]);
		glucagon = Double.parseDouble(split[1]);
		initializeHormoneReserves();
		initializeProgressBars();
		updateProgress();


	}

	private void initializeProgressBars() {
		double insulinAvailable = (AppConstants.getTOTAL_INSULIN() - AppConstants.getTOTAL_INSULIN_USED());
		int Insulinpercent = (int) ((insulinAvailable) / (AppConstants.getTOTAL_INSULIN()) * 100);
		pBarInsulin.setValue(Insulinpercent);

		double glucagonAvailable = (AppConstants.getTOTAL_GLUCAGON() - AppConstants.getTOTAL_GLUCAGON_USED());
		int Glucagonpercent = (int) ((glucagonAvailable) / (AppConstants.getTOTAL_GLUCAGON()) * 100);
		pBarGlucagon.setValue(Glucagonpercent);

	}

	private void initializeHormoneReserves() {
		AppConstants.setTOTAL_INSULIN_USED(insulin);
		AppConstants.setTOTAL_GLUCAGON_USED(glucagon);
	}




	@SuppressWarnings("deprecation")
	private void updateProgress() {
		AppConstants.getReserve().addObserver(new Observer() {

			@Override
			public void update(Observable arg0, Object arg1) {
				HormoneBean hormone = (HormoneBean)arg1;
				if(hormone.getType() == AppConstants.HORMONE_TYPE_INSULIN) {
					pBarInsulin.setValue(hormone.getAmount());
					if ( (hormone.getAmount() <= 20) && (!WarningConstants.isInsulinLevelWarning())) {
						JOptionPane.showMessageDialog(LevelIndicationPanel.this, "Insulin level is low");
						WarningConstants.setInsulinLevelWarning(true);
					}


				}
				else {
					pBarGlucagon.setValue(hormone.getAmount());
					if ( (hormone.getAmount() <= 20) && (!WarningConstants.isInsulinLevelWarning())) {
						JOptionPane.showMessageDialog(LevelIndicationPanel.this, "Glucagon level is low");
						WarningConstants.setGlucagonLevelWarning(true);
					}
				}

			}
		});

	}
}
