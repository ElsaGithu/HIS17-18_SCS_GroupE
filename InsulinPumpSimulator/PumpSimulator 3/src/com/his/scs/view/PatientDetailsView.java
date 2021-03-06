package com.his.scs.view;

import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.his.scs.helper.AppConstants;

public class PatientDetailsView extends javax.swing.JFrame {

	/**
	 * Creates new form PatientDetailsView
	 */
	public PatientDetailsView() {
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
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		nameField = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		genderCombo = new javax.swing.JComboBox<>();
		saveDetailsButton = new javax.swing.JButton();
		saveDetailsButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButton2 = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		doctorNameField = new javax.swing.JTextField();
		clinicAddressField = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		ageFieldFormatted = new javax.swing.JFormattedTextField();
		contactNoFormatted = new javax.swing.JFormattedTextField();
		dateFormatted = new javax.swing.JFormattedTextField();
		emergencyContactFormatted = new javax.swing.JFormattedTextField();
		weightFieldFormatted = new javax.swing.JFormattedTextField();
		jLabel17 = new javax.swing.JLabel();


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel1.setText("Insulin/Glucagon Pump");

		jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
		jLabel2.setText("DOCTOR MODE");
		jLabel9 = new javax.swing.JLabel();

		jLabel9.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
		jLabel9.setText("Patient Details :");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(142)
										.addComponent(jLabel1))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(211)
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(jLabel9)
												.addComponent(jLabel2))))
						.addContainerGap(148, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel2)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jLabel9)
						.addGap(33))
				);
		jPanel1.setLayout(jPanel1Layout);

		jLabel3.setText("Name:");

		jLabel4.setText("Age:");

		jLabel5.setText("Weight:");

		jLabel6.setText("Sex:");

		nameField.setColumns(15);
		nameField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
		jLabel7.setText("years ");

		jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
		jLabel8.setText("kg");

		genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "Male", "Female", "other" }));
		genderCombo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		saveDetailsButton.setText("Save Details");
		saveDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new Font("Tahoma", Font.BOLD, 11)); // NOI18N
		jButton2.setText("Back");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
		jLabel10.setText("Doctor Contact Information* :");

		jLabel11.setText("Doctor's Name:");

		jLabel12.setText("Contact Number:");

		jLabel13.setText("Clinic Address:");

		jLabel14.setText("Emergency Contact Number:");

		jLabel15.setText("Dr.");

		doctorNameField.setColumns(15);
		doctorNameField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField4ActionPerformed(evt);
			}
		});

		clinicAddressField.setColumns(15);

		ageFieldFormatted.setColumns(3);
		try {
			ageFieldFormatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}

		//jFormattedTextField1.setValue(new Integer());
		ageFieldFormatted.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextField1ActionPerformed(evt);
			}
		});

		jLabel16.setText("Date of Patient's last visit: ");

		contactNoFormatted.setColumns(15);
		try {
			contactNoFormatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+49 ### #######")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		contactNoFormatted.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextField2ActionPerformed(evt);
			}
		});

		dateFormatted.setColumns(10);
		try {
			dateFormatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##.####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		dateFormatted.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextField3ActionPerformed(evt);
			}
		});

		emergencyContactFormatted.setColumns(15);
		try {
			emergencyContactFormatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+49 ### #######")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		emergencyContactFormatted.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextField4ActionPerformed(evt);
			}
		});

		weightFieldFormatted.setColumns(3);
		try {
			weightFieldFormatted.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		// jFormattedTextField5.setValue(new Integer());
		weightFieldFormatted.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextField5ActionPerformed(evt);
			}
		});

		jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel17.setForeground(new java.awt.Color(153, 153, 153));
		jLabel17.setText("'dd.MM.yyyy'");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(71)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jLabel11, Alignment.TRAILING)
												.addComponent(jLabel12, Alignment.TRAILING)
												.addComponent(jLabel13, Alignment.TRAILING)
												.addComponent(jLabel14, Alignment.TRAILING)
												.addComponent(jLabel16, Alignment.TRAILING))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(contactNoFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(clinicAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(emergencyContactFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(dateFormatted, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jLabel17))
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(jLabel15)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(doctorNameField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addGap(64)
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
																.addComponent(jLabel4)
																.addComponent(jLabel6)
																.addComponent(jLabel5)
																.addComponent(jLabel3))
														.addGap(18)
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
																.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addComponent(ageFieldFormatted, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jLabel7))
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addComponent(weightFieldFormatted, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jLabel8))
																.addComponent(genderCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addGap(10)
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
																.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel10)))))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(30)
										.addComponent(jButton2)
										.addGap(348)
										.addComponent(saveDetailsButton)))
						.addContainerGap(45, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(jLabel7)
								.addComponent(ageFieldFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(weightFieldFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8)
								.addComponent(jLabel5))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel6)
								.addComponent(genderCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(28)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel10)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel11)
								.addComponent(jLabel15)
								.addComponent(doctorNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(contactNoFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel13)
								.addComponent(clinicAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel14)
								.addComponent(emergencyContactFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel16)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(dateFormatted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel17)))
						.addGap(99))
				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap(369, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(saveDetailsButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2))
						.addGap(21))
				);
		jPanel2Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel7, jLabel8});
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		pack();

		populateValues();
	}// </editor-fold>                        

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
	}                                          

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// TODO add your handling code here:
		this.setVisible(false);

		DoctorHomeView theView = new DoctorHomeView();
		theView.setVisible(true);
	}                                        

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// TODO add your handling code here:
	}                                        

	private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
		// TODO add your handling code here:
	}                                                    

	private void jFormattedTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
		// TODO add your handling code here:
	}                                                    

	private void jFormattedTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
		// TODO add your handling code here:
	}                                                    

	private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
		// TODO add your handling code here:
	}                                                    

	private void jFormattedTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
		// TODO add your handling code here:
	}   

	public void SaveDetailsListener(java.awt.event.ActionListener listenForSaveButton) {
		saveDetailsButton.addActionListener(listenForSaveButton);
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
					nameField.setText(split[0]);
					ageFieldFormatted.setText(split[1]);
					weightFieldFormatted.setText(split[2]);
					genderCombo.setSelectedItem(split[3]);
					doctorNameField.setText(split[4]);
					contactNoFormatted.setText(split[5]);
					clinicAddressField.setText(split[6]);
					emergencyContactFormatted.setText(split[7]);
					dateFormatted.setText(split[8]);
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
			java.util.logging.Logger.getLogger(PatientDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PatientDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PatientDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PatientDetailsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>



		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PatientDetailsView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton saveDetailsButton;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> genderCombo;
	private javax.swing.JFormattedTextField ageFieldFormatted;
	private javax.swing.JFormattedTextField contactNoFormatted;
	private javax.swing.JFormattedTextField dateFormatted;
	private javax.swing.JFormattedTextField emergencyContactFormatted;
	private javax.swing.JFormattedTextField weightFieldFormatted;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField nameField;
	private javax.swing.JTextField doctorNameField;
	private javax.swing.JTextField clinicAddressField;
	// End of variables declaration    

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	public void displaySuccessMessage(String successMessage) {
		JOptionPane.showMessageDialog(this, successMessage);
	}

	public javax.swing.JButton getSaveDetailsButton() {
		return saveDetailsButton;
	}

	public void setSaveDetailsButton(javax.swing.JButton saveDetailsButton) {
		this.saveDetailsButton = saveDetailsButton;
	}

	public javax.swing.JComboBox<String> getGenderCombo() {
		return genderCombo;
	}

	public void setGenderCombo(javax.swing.JComboBox<String> genderCombo) {
		this.genderCombo = genderCombo;
	}

	public javax.swing.JFormattedTextField getAgeFieldFormatted() {
		return ageFieldFormatted;
	}

	public void setAgeFieldFormatted(javax.swing.JFormattedTextField ageFieldFormatted) {
		this.ageFieldFormatted = ageFieldFormatted;
	}

	public javax.swing.JFormattedTextField getContactNoFormatted() {
		return contactNoFormatted;
	}

	public void setContactNoFormatted(javax.swing.JFormattedTextField contactNoFormatted) {
		this.contactNoFormatted = contactNoFormatted;
	}

	public javax.swing.JFormattedTextField getDateFormatted() {
		return dateFormatted;
	}

	public void setDateFormatted(javax.swing.JFormattedTextField dateFormatted) {
		this.dateFormatted = dateFormatted;
	}

	public javax.swing.JFormattedTextField getEmergencyContactFormatted() {
		return emergencyContactFormatted;
	}

	public void setEmergencyContactFormatted(javax.swing.JFormattedTextField emergencyContactFormatted) {
		this.emergencyContactFormatted = emergencyContactFormatted;
	}

	public javax.swing.JFormattedTextField getWeightFieldFormatted() {
		return weightFieldFormatted;
	}

	public void setWeightFieldFormatted(javax.swing.JFormattedTextField weightFieldFormatted) {
		this.weightFieldFormatted = weightFieldFormatted;
	}

	public javax.swing.JTextField getNameField() {
		return nameField;
	}

	public void setNameField(javax.swing.JTextField nameField) {
		this.nameField = nameField;
	}

	public javax.swing.JTextField getDoctorNameField() {
		return doctorNameField;
	}

	public void setDoctorNameField(javax.swing.JTextField doctorNameField) {
		this.doctorNameField = doctorNameField;
	}

	public javax.swing.JTextField getClinicAddressField() {
		return clinicAddressField;
	}

	public void setClinicAddressField(javax.swing.JTextField clinicAddressField) {
		this.clinicAddressField = clinicAddressField;
	}


}
