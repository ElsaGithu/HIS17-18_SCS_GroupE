package com.his.scs.view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import com.his.scs.helper.AppConstants;
import com.his.scs.helper.SaveToFile;
import com.his.scs.helper.WarningConstants;
import com.his.scs.model.CalculateBSLAndGlucagon;
import com.his.scs.model.CalculateBSLAndInsulin;

/**
 * An example to show how we can create a dynamic chart.
 */
public class BSLLiveGraph extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360349860764906405L;

	/** The time series data. */
	private TimeSeries series;
	private Timer timer = new Timer(100, this);


	private ArrayList<Double> bslList;
	private static int count = 0;
	private JLabel hormoneAmount;
	private Component component;


	private JButton btnProcess;
	/**
	 * Constructs a new dynamic chart application.
	 *
	 * @param title
	 *            the frame title.
	 */
	public BSLLiveGraph(final String title) {

		this.setBackground(Color.GRAY);
		this.series = new TimeSeries("Blood Sugar Level", Millisecond.class);

		final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
		final JFreeChart chart = createChart(dataset);
		chart.setBackgroundPaint(new Color(0xf0f0f0));
		final ChartPanel chartPanel = new ChartPanel(chart);
		this.add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));

		XYPlot plot = (XYPlot) chart.getPlot();

		ValueMarker markerLower = new ValueMarker(80); 
		markerLower.setPaint(Color.green);
		plot.addRangeMarker(markerLower);
		markerLower.setStroke(new BasicStroke(2.0f));

		ValueMarker markerUpper = new ValueMarker(120); 
		markerUpper.setPaint(Color.green);
		markerUpper.setStroke(new BasicStroke(2.0f));
		plot.addRangeMarker(markerUpper);

		ValueMarker markerUpperDanger = new ValueMarker(AppConstants.BSL_HIGH_DANGER); 
		markerUpperDanger.setPaint(Color.black);
		markerUpperDanger.setStroke(new BasicStroke(2.0f));
		plot.addRangeMarker(markerUpperDanger);

		ValueMarker markerLowerDanger = new ValueMarker(AppConstants.BSL_LOW_DANGER); 
		markerLowerDanger.setPaint(Color.black);
		markerLowerDanger.setStroke(new BasicStroke(2.0f));
		plot.addRangeMarker(markerLowerDanger);

		timer.start();

	}

	/**
	 * Creates a sample chart.
	 *
	 * @param dataset
	 *            the dataset.
	 *
	 * @return A sample chart.
	 */
	private JFreeChart createChart(final XYDataset dataset) {
		final JFreeChart chart = ChartFactory.createTimeSeriesChart("Blood Sugar Level Vs Time", "Current Time",
				"BSL in mg/dL", dataset, true, true, false);
		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(new Color(0xffffff));
		//		plot.setBackgroundPaint(Color.YELLOW);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.black);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.black);

		ValueAxis xaxis = plot.getDomainAxis();
		xaxis.setAutoRange(true);

		// Domain axis would show data of 60 seconds for a time
		// xaxis.setFixedAutoRange(60000.0); // 60 seconds
		xaxis.setAutoRange(true);
		xaxis.setVerticalTickLabels(true);

		ValueAxis yaxis = plot.getRangeAxis();
		yaxis.setAutoRange(true);
		yaxis.setRange(0.0, 300);

		return chart;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		double plotValue=0;
		if (bslList != null ) {
			if (count < bslList.size()) {

				AppConstants.BSL_PREVIOUS = bslList.get(count);
				plotValue=bslList.get(count++) * AppConstants.CONVERSION_FACTOR;


			} else if(count == bslList.size()){

				AppConstants.BSL_PREVIOUS = bslList.get(count-1);
				plotValue = bslList.get(count-1) * AppConstants.CONVERSION_FACTOR;
				count=0;
				bslList=null;
				if(AppConstants.MODE == AppConstants.PATIENT_MODE_AUTO) {
					if(btnProcess!= null)
						btnProcess.setEnabled(true);
					determineBand(AppConstants.BSL_PREVIOUS);
				}

			}
		}
		else {
			plotValue = AppConstants.BSL_PREVIOUS * AppConstants.CONVERSION_FACTOR;

		}
		if(plotValue <= AppConstants.BSL_LOW_DANGER || plotValue >= AppConstants.BSL_HIGH_DANGER) {
			Toolkit.getDefaultToolkit().beep();
			if(AppConstants.MODE == AppConstants.PATIENT_MODE_MANUAL && !WarningConstants.isBSLLevelWarning()) {

				WarningConstants.setBSLLevelWarning(true);
			}
		}else {
			WarningConstants.setBSLLevelWarning(false);
		}
		if ( (AppConstants.MODE == AppConstants.DOCTOR_MODE) ||
				(AppConstants.MODE == AppConstants.EMERGENCY_MODE)) {
			plotValue = AppConstants.BSL_SAFE* AppConstants.CONVERSION_FACTOR;
			bslList=null;
		}
		this.series.add(new Millisecond(), plotValue);

	}

	public ArrayList<Double> getBslList() {
		return bslList;
	}

	public void setBslList(ArrayList<Double> bslList) {
		count=0;
		this.bslList = bslList;
	}
	public void determineBand(double bslValue) {
		double glucagon = 0;
		double insulin = 0;
		DecimalFormat df = new DecimalFormat(".##");

		if (bslValue < AppConstants.BSL_SAFE_LOWER) {
			CalculateBSLAndGlucagon glucagonCaseObject = new CalculateBSLAndGlucagon();
			glucagon = glucagonCaseObject.calculateGlucagon(bslValue);
			double glucAvailable = AppConstants.getTOTAL_GLUCAGON() - AppConstants.getTOTAL_GLUCAGON_USED();
			if (glucAvailable >= glucagon) {
				AppConstants.getReserve().updateGlucagon(glucagon);
				setBslList(glucagonCaseObject.addBSLValuesToList(bslValue));
				hormoneAmount.setText(df.format(glucagon) + " IU Glucagon injected");
				new SaveToFile(AppConstants.BSL_PREVIOUS, 0, glucagon);
			} else {
				AppConstants.showMessage(component,"Glucagon not available. Please refill");
			}
		} else if (bslValue > AppConstants.BSL_SAFE_UPPER) {
			CalculateBSLAndInsulin insulinCaseObject = new CalculateBSLAndInsulin();
			insulin = insulinCaseObject.calculateInsulin(bslValue);
			double insulinAvailable = AppConstants.getTOTAL_INSULIN() - AppConstants.getTOTAL_INSULIN_USED();
			if (insulinAvailable >= insulin) {
				AppConstants.getReserve().updateInsulin(insulin);
				setBslList(insulinCaseObject.addBSLValuesToList(bslValue));
				hormoneAmount.setText(df.format(insulin) + " IU Insulin injected");
				new SaveToFile(AppConstants.BSL_PREVIOUS, insulin, 0);
			} else {
				AppConstants.showMessage(component,"Insulin not available. Please refill");
			}
		}
	}

	public void setHormoneAmountLabel(JLabel hormoneAmount) {
		this.hormoneAmount = hormoneAmount;
	}
	public JLabel getHormoneAmountLabel() {
		return this.hormoneAmount;
	}
	public void setButton(JButton btnProcess) {
		this.btnProcess = btnProcess;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		BSLLiveGraph.count = count;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}




}
