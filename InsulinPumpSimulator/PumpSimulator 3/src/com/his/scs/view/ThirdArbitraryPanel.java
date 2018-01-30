package com.his.scs.view;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class ThirdArbitraryPanel extends JPanel{

	private BSLLiveGraph graph;

	public ThirdArbitraryPanel() {
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setLayout(new CardLayout(0, 0));
		this.setBounds(530, 6, 250, 146);
	}

}
