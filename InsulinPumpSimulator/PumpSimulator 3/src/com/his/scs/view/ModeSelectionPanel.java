package com.his.scs.view;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class ModeSelectionPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6945935054941367258L;
	private BSLLiveGraph graph;

	public ModeSelectionPanel() {

		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setBounds(6, 6, 250, 146);
		this.setLayout(null);

	}

}
