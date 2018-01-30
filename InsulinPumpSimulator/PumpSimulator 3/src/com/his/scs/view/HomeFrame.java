package com.his.scs.view;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.his.scs.controller.DoctorVerificationController;
import com.his.scs.controller.EmergencyPatientHistoryController;
import com.his.scs.helper.AppConstants;
import com.his.scs.helper.WarningConstants;
import com.his.scs.model.DoctorVerificationModel;
import com.his.scs.model.EmergencyPatientHistoryModel;

public class HomeFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5967112968229959021L;

	private BSLLiveGraph graph = new BSLLiveGraph("");
	private JRadioButton rdbtnPatientManual;
	private JFrame frame;
	private JButton btnSelectOk;

	public HomeFrame() {
		this.frame = this;
		this.setTitle("Insulin / Glucagon Pump");
		this.setBounds(0, 0, 818, 710);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		//Adding chart panel
		this.getContentPane().add(graph, BorderLayout.CENTER);
		//Adding upper layout
		CompleteUpperPanel upperPanel = new CompleteUpperPanel(graph);
		this.getContentPane().add(upperPanel, BorderLayout.NORTH);
		upperPanel.setLayout(null);

		ModeSelectionPanel modeSelectionPanel = new ModeSelectionPanel();
		modeSelectionPanel.setBounds(6, 6, 250, 146);
		upperPanel.add(modeSelectionPanel);

		JRadioButton rdbtnPatientAuto = new JRadioButton("Patient Auto");
		rdbtnPatientAuto.setSelected(true);
		rdbtnPatientAuto.setActionCommand("PatientAuto");
		rdbtnPatientAuto.setBounds(19, 6, 141, 23);
		modeSelectionPanel.add(rdbtnPatientAuto);

		rdbtnPatientManual = new JRadioButton("Patient Manual");
		rdbtnPatientManual.setActionCommand("PatientManual");
		rdbtnPatientManual.setBounds(19, 30, 141, 23);
		modeSelectionPanel.add(rdbtnPatientManual);

		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setActionCommand("Doctor");
		rdbtnDoctor.setBounds(19, 54, 141, 23);
		modeSelectionPanel.add(rdbtnDoctor);

		JRadioButton rdbtnEmergency = new JRadioButton("Emergency");
		rdbtnEmergency.setActionCommand("Emergency");
		rdbtnEmergency.setBounds(19, 78, 141, 23);
		modeSelectionPanel.add(rdbtnEmergency);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnPatientAuto);
		btnGroup.add(rdbtnPatientManual);
		btnGroup.add(rdbtnDoctor);
		btnGroup.add(rdbtnEmergency);

		isPatientManualEnabled();

		btnSelectOk = new JButton("Ok");
		btnSelectOk.setBounds(170, 106, 60, 29);
		modeSelectionPanel.add(btnSelectOk);

		LevelIndicationPanel levelIndicationPanel = new LevelIndicationPanel();
		levelIndicationPanel.setBounds(260, 6, 250, 146);
		upperPanel.add(levelIndicationPanel);

		ThirdArbitraryPanel thirdArbitraryPanel = new ThirdArbitraryPanel();
		thirdArbitraryPanel.setBounds(520, 6, 250, 146);
		upperPanel.add(thirdArbitraryPanel);

		PatientAutoPanel autoPanel = new PatientAutoPanel(graph) ;
		thirdArbitraryPanel.add(autoPanel, "name_584031747892528");
		PatientManualPanel manualPanel = new PatientManualPanel(graph);
		thirdArbitraryPanel.add(manualPanel, "name_584033932389480");

		btnSelectOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(rdbtnPatientAuto.isSelected()) {
					graph.setComponent(autoPanel);
					if (AppConstants.AUTO_ADJUST) {
						WarningConstants.setBSLLevelWarning(false);
						graph.determineBand(AppConstants.BSL_PREVIOUS);
						AppConstants.AUTO_ADJUST=false;
					}
					AppConstants.MODE=AppConstants.PATIENT_MODE_AUTO;

					manualPanel.resetButtons();
					thirdArbitraryPanel.removeAll();
					thirdArbitraryPanel.repaint();;
					thirdArbitraryPanel.revalidate();

					thirdArbitraryPanel.add(autoPanel);
					autoPanel.resetLabel();
					thirdArbitraryPanel.repaint();
					thirdArbitraryPanel.revalidate();
				} 

				if(rdbtnPatientManual.isSelected()) {
					graph.setComponent(manualPanel);
					AppConstants.AUTO_ADJUST=true;
					AppConstants.MODE=AppConstants.PATIENT_MODE_MANUAL;
					thirdArbitraryPanel.removeAll();
					thirdArbitraryPanel.repaint();
					thirdArbitraryPanel.revalidate();

					thirdArbitraryPanel.add(manualPanel);
					thirdArbitraryPanel.repaint();
					thirdArbitraryPanel.revalidate();

				} 

				if(rdbtnDoctor.isSelected()) {
					WarningConstants.setBSLLevelWarning(false);
					AppConstants.AUTO_ADJUST=false;
					AppConstants.BSL_PREVIOUS = AppConstants.BSL_SAFE;
					AppConstants.MODE=AppConstants.DOCTOR_MODE;
					
					DoctorVerificationView theView = new DoctorVerificationView();
					DoctorVerificationModel theModel = new DoctorVerificationModel();
					DoctorVerificationController theController = new DoctorVerificationController(theView, theModel);
					theView.setVisible(true);
					frame.dispose();
				}

				if(rdbtnEmergency.isSelected()) {
					WarningConstants.setBSLLevelWarning(false);
					AppConstants.AUTO_ADJUST=false;
					AppConstants.BSL_PREVIOUS = AppConstants.BSL_SAFE;
					AppConstants.MODE=AppConstants.EMERGENCY_MODE;
					
					EmergencyPatientHistoryView theView = new EmergencyPatientHistoryView();
					EmergencyPatientHistoryModel theModel = new EmergencyPatientHistoryModel();
					EmergencyPatientHistoryController theController = new EmergencyPatientHistoryController(theView, theModel);
					theView.setVisible(true);
					frame.dispose();
				}
			}
		});

	}

	public void isPatientManualEnabled() {
		BufferedReader buffer = null;
		FileReader reader = null;

		try {
			reader = new FileReader(AppConstants.SET_MANUAL_MODE_FILE_PATH);
			buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null) {
				if (line != null) {
					String[] split = line.split(",");
					if(split[0].equals("0")) {
						rdbtnPatientManual.setEnabled(false);
					}else {
						rdbtnPatientManual.setEnabled(true);
					}
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


}
