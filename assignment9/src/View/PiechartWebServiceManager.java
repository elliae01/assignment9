package View;

import java.io.IOException;
import java.io.PrintWriter;
import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.PieChart;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.data.PieChartSlice;
import de.toolforge.googlechartwrapper.label.ChartTitle;

public class PiechartWebServiceManager {
	public enum ChartType {
		totalCholesterol, BMI, bloodPressure
	}

	private final int CHART_COUNT = 3;
	private final int WIDTH = 570;
	private final int HEIGHT = 250;

	private Dimension chartDimensions = new Dimension(WIDTH, HEIGHT);

	private PieChart[] pieCharts = new PieChart[CHART_COUNT];

	public PiechartWebServiceManager() {
		for (int index = 0; index < CHART_COUNT; index++) {
			pieCharts[index] = new PieChart(chartDimensions);
		}

		pieCharts[0].addChartColor(new ChartColor(new Color(240, 50, 200)));
		pieCharts[1].addChartColor(new ChartColor(new Color(50, 50, 240)));
		pieCharts[2].addChartColor(new ChartColor(new Color(185, 0, 15)));
		pieCharts[0].setChartTitle(new ChartTitle("Total Cholesteral"));
		pieCharts[1].setChartTitle(new ChartTitle("Body Mass Index"));
		pieCharts[2].setChartTitle(new ChartTitle("Blood Pressure"));

	}

	/**
	 * Adds another pie slice to the specified chart type.
	 * @param type
	 * @param label
	 * @param value
	 */
	public void addPieSlice(ChartType type, String label, int value) {
		switch (type) {
		case totalCholesterol:
			pieCharts[0].addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(value).label(label).build());
			break;
		case BMI:
			pieCharts[1].addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(value).label(label).build());
			break;
		case bloodPressure:
			pieCharts[2].addPieChartSlice(new PieChartSlice.PieChartSliceBuilder(value).label(label).build());
			break;
		default:
			System.out.println("INVALID CHART TYPE");
			break;
		}

	}

	/**
	 * Prints urls to console.
	 */
	public void printUrls() {
		System.out.println("Cholesterol:\n" + pieCharts[0].getUrl());
		System.out.println("BMI:\n" + pieCharts[1].getUrl());
		System.out.println("Blood Pressure:\n" + pieCharts[2].getUrl());
	}

	/**
	 * Returns the url for a specific chart given by the param type.
	 * @param type
	 * @return
	 */
	public String getUrl(ChartType type) {
		switch (type) {
		case totalCholesterol:
			return pieCharts[0].getUrl();
		case BMI:
			return pieCharts[1].getUrl();
		case bloodPressure:
			return pieCharts[2].getUrl();
		default:
			return "ERROR: Type does not exist, no URL available.";
		}
	}
	
	/**
	 * Create an html file that contains the links to the piecharts
	 * @param url
	 */
	public void createHTMLFileWithPieCharts(String[] url) {
		try {
			PrintWriter writer = new PrintWriter("C:\\Patient_Health_Screen\\Chart_HTML\\Charts.html", "UTF-8");

			writer.println("<!DOCTYPE html");
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>Health Screen Results</title>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println();
			writer.println("<center>");
			writer.println("<h1>Health Screening Results</h1>");

			writer.println("<h3></h3>");
			writer.println("<img src = \"" + url[0] + "\" style=width:" + WIDTH + ";height:" + HEIGHT + ">");

			writer.println("<h3></h3>");
			writer.println("<img src = \"" + url[1] + "\" style=width:" + WIDTH + ";height:" + HEIGHT + ">");

			writer.println("<h3></h3>");
			writer.println("<img src = \"" + url[2] + "\" style=width:" + WIDTH + ";height:" + HEIGHT + ">");

			writer.println("</body>");
			writer.println("</html>");

			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to save urls in pie chart file.");
			e.printStackTrace();
		}
	}

	/**
	 * Open the pie charts on a web browser.
	 */
	public void launchPiechartWebPage() {
		try {

			Process process = new ProcessBuilder(

					"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe",
					"C:\\Patient_Health_Screen\\Chart_HTML\\charts.html").start();

			process.getInputStream();

		} catch (Exception e) {
			System.out.println("Failed to open charts file.");
			e.printStackTrace();
		}
	}
}
