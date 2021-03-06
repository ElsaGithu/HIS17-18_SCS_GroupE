package com.his.scs.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.his.scs.helper.AppConstants;

public class EmergencyPatientHistoryView extends javax.swing.JFrame {

	/**
	 * Creates new form EmergencyPatientHistoryView
	 */
	public EmergencyPatientHistoryView() {
		HomeFrame homeFrame = new HomeFrame();
		homeFrame.dispose();

		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		lblMainHead = new javax.swing.JLabel();
		lblEmergencyMode = new javax.swing.JLabel();
		lblPatientHistory = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		btnBack = new javax.swing.JButton();
		lblPatientDetails = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		doctorNameField = new javax.swing.JTextField();
		contactNoField = new javax.swing.JTextField();
		clinicAddressField = new javax.swing.JTextField();
		emergencyNoField = new javax.swing.JTextField();
		lblDoctorDetails = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		patientNameField = new javax.swing.JTextField();
		patientWeightField = new javax.swing.JTextField();
		patientAgeField = new javax.swing.JTextField();
		lblKgs = new javax.swing.JLabel();
		lblYears = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

		lblMainHead.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		lblMainHead.setText("Insulin/Glucagon Pump");

		lblEmergencyMode.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
		lblEmergencyMode.setText("EMERGENCY MODE");


		lblPatientHistory.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
		lblPatientHistory.setText("Patient History :");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(205)
										.addComponent(lblMainHead))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(261)
										.addComponent(lblEmergencyMode))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(285)
										.addComponent(lblPatientHistory)))
						.addContainerGap(247, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(lblMainHead)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEmergencyMode)
						.addGap(18)
						.addComponent(lblPatientHistory)
						.addContainerGap(25, Short.MAX_VALUE))
				);
		jPanel1.setLayout(jPanel1Layout);

		createTable();
		populateTable();
		populateValues();

		btnBack.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
		btnBack.setText("Back to Home Screen");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		lblPatientDetails.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
		lblPatientDetails.setText("Patient Details -");

		jLabel4.setText("Name:");

		jLabel5.setText("Phone:");

		jLabel6.setText("Clinic:");

		jLabel7.setText("Emergency No:");

		doctorNameField.setEditable(false);
		doctorNameField.setColumns(15);

		contactNoField.setEditable(false);
		contactNoField.setColumns(15);

		clinicAddressField.setEditable(false);
		clinicAddressField.setColumns(15);
		
		emergencyNoField.setEditable(false);
		emergencyNoField.setColumns(15);

		lblDoctorDetails.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
		lblDoctorDetails.setText("Doctor Details -");

		jLabel10.setText("Age:");

		jLabel11.setText("Name:");

		jLabel12.setText("Weight:");

		patientNameField.setEditable(false);
		patientNameField.setColumns(15);

		patientWeightField.setEditable(false);
		patientWeightField.setColumns(15);

		patientAgeField.setEditable(false);
		patientAgeField.setColumns(15);

		lblKgs.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
		lblKgs.setText("kgs ");

		lblYears.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
		lblYears.setText("years ");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(btnBack)
														.addGap(369))
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addGap(15)
																		.addComponent(jLabel12))
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addGap(19)
																		.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
																				.addComponent(jLabel10)
																				.addComponent(jLabel11))))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
																				.addComponent(patientWeightField, 0, 0, Short.MAX_VALUE)
																				.addComponent(patientAgeField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblKgs)
																				.addComponent(lblYears)))
																.addComponent(patientNameField, 0, 0, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(jLabel4)
																.addComponent(jLabel5)
																.addComponent(jLabel7)
																.addComponent(jLabel6))
														.addGap(18)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(contactNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(doctorNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(clinicAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(emergencyNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(54))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(lblPatientDetails)
										.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
										.addComponent(lblDoctorDetails)
										.addGap(165))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
										.addGap(101))))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPatientDetails)
								.addComponent(lblDoctorDetails))
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(18)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(doctorNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4))
										.addGap(12)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(contactNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(26)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
																.addComponent(jLabel11)
																.addComponent(patientNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
																.addComponent(jLabel10)
																.addComponent(patientAgeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(lblYears)
														.addPreferredGap(ComponentPlacement.RELATED)))))
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(5)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblKgs)
												.addComponent(jLabel12)
												.addComponent(patientWeightField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(11)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(emergencyNoField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel7))))
						.addGap(18)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(clinicAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addGap(34)
						.addComponent(btnBack)
						.addGap(8))
				);
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		getContentPane().setLayout(layout);


		pack();
	}// </editor-fold>    


	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// TODO add your handling code here:
		this.setVisible(false);
		HomeFrame theView = new HomeFrame();
		theView.setVisible(true);
	}  

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(EmergencyPatientHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EmergencyPatientHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EmergencyPatientHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EmergencyPatientHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EmergencyPatientHistoryView().setVisible(true);
			}
		});
	}

	protected void createTable() {
		String[] columnNames = { "No", "Time", "BGL (mg/dL)", "Insulin Dose (IU)", "Glucagon Dose (IU)"};
		tableModel = new DefaultTableModel(columnNames, 0);
		/**/

		patientHistoryTable = new JTable(tableModel);
		//JScrollPane scrollPane = new JScrollPane(patientHistoryTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		//		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//patientHistoryTable.setFillsViewportHeight(true);
		//patientHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane1.setViewportView(patientHistoryTable);

		patientHistoryTable.setBounds(15, 12, 100, 100);
		patientHistoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		patientHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		patientHistoryTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		patientHistoryTable.getColumnModel().getColumn(2).setPreferredWidth(70);
		patientHistoryTable.getColumnModel().getColumn(3).setPreferredWidth(80);
		patientHistoryTable.getColumnModel().getColumn(4).setPreferredWidth(90);
		patientHistoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


	}

	protected void populateTable() {

		BufferedReader buffer = null;
		FileReader reader = null;

		try {

			reader = new FileReader(AppConstants.PATIENT_HISTORY_FILE_PATH);
			buffer = new BufferedReader(reader);

			String line;
			int rowCount = 0;
			while ((line = buffer.readLine()) != null) {
				if (line != null) {

					String[] split = line.split(",");
					tableModel.addRow(new Object[] {Integer.toString(rowCount+1), split[0],split[1],split[2],split[3]});
					rowCount++;
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

	protected void populateValues() {

		BufferedReader buffer = null;
		FileReader reader = null;

		try {

			reader = new FileReader(AppConstants.PATIENT_DETAILS_FILE_PATH);
			buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null) {
				if (line != null) {
					String[] split = line.split(",");
					patientNameField.setText(split[0]);
					patientAgeField.setText(split[1]);
					patientWeightField.setText(split[2]);
					doctorNameField.setText("Dr."+split[4]);
					contactNoField.setText(split[5]);
					clinicAddressField.setText(split[6]);
					emergencyNoField.setText(split[7]);
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

	// Variables declaration - do not modify                     
	private javax.swing.JButton btnBack;
	private javax.swing.JLabel lblMainHead;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel lblKgs;
	private javax.swing.JLabel lblYears;
	private javax.swing.JLabel lblEmergencyMode;
	private javax.swing.JLabel lblPatientDetails;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel lblDoctorDetails;
	private javax.swing.JLabel lblPatientHistory;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField doctorNameField;
	private javax.swing.JTextField contactNoField;
	private javax.swing.JTextField clinicAddressField;
	private javax.swing.JTextField emergencyNoField;
	private javax.swing.JTextField patientNameField;
	private javax.swing.JTextField patientWeightField;
	private javax.swing.JTextField patientAgeField;
	private javax.swing.JTable patientHistoryTable;
	private DefaultTableModel tableModel;
	// End of variables declaration                   
}