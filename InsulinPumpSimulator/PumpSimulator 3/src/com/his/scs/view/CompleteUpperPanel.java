package com.his.scs.view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CompleteUpperPanel extends JPanel {
	private BSLLiveGraph graph;
	private JRadioButton rdbtnPatientManual;

	/**
	 * Create the panel.
	 */
	public CompleteUpperPanel(BSLLiveGraph graph) {
		this.graph = graph;
		this.setBorder(null);
		this.setPreferredSize(new Dimension(797, 166));
		this.setLayout(null);

	}
}
