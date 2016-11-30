package View;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.PieChart;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.data.PieChartSlice;
import de.toolforge.googlechartwrapper.label.ChartTitle;

enum CHART_TYPE
{
	totalCholesterol,
	BMI,
	bloodPressure
}

public class PiechartWebServiceManager 
{
	private final int CHART_COUNT = 3;
	private final int WIDTH = 500;
	private final int HEIGHT = 250;
	
	private Dimension chartDimensions = new Dimension(WIDTH, HEIGHT);
	
	private PieChart pieCharts[] = new PieChart[CHART_COUNT];
	
	public PiechartWebServiceManager()
	{
		for (int index = 0; index < CHART_COUNT; index++)
		{
			pieCharts[index] = new PieChart(chartDimensions);
		}
		
		pieCharts[0].addChartColor(new ChartColor(new Color(240, 50, 200)));
		pieCharts[1].addChartColor(new ChartColor(new Color(50, 50, 240)));
		pieCharts[2].addChartColor(new ChartColor(new Color(185, 0, 15)));
		pieCharts[0].setChartTitle(new ChartTitle("Total Cholesteral"));
		pieCharts[1].setChartTitle(new ChartTitle("Body Mass Index"));
		pieCharts[2].setChartTitle(new ChartTitle("Blood Pressure"));
	}
	
	public void addPieSlice(CHART_TYPE type, String label, int value)
	{
		
		switch (type)
		{
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
	
	// The URLs contain the individual pie charts.
	public void printUrls()
	{
		System.out.println("Cholesterol:\n" + pieCharts[0].getUrl());
		System.out.println("BMI:\n" + pieCharts[1].getUrl());
		System.out.println("Blood Pressure:\n" + pieCharts[2].getUrl());
	}
	
	public String getUrl(CHART_TYPE type)
	{
		switch(type)
		{
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
	
	public void createHTMLFileWithPieCharts()
	{
		try
		{
			PrintWriter writer = new PrintWriter("Charts/Charts.html", "UTF-8");
			
			writer.println("<!DOCTYPE html");
			writer.println("<html>");
			writer.println("<body>");
			writer.println();
			writer.println("<center>");
			writer.println("<h1>HealthScreeningResults</h1>");
			
			writer.println("<h3>Total Cholesterol </h3>");
			writer.println("<img src = \"" + pieCharts[0].getUrl() + "\" style=width:" + WIDTH + ";height:" + HEIGHT + ">");
			
			writer.println("<h3>Body Mass Index </h3>");
			writer.println("<img src = \"" + pieCharts[1].getUrl() + "\" style=width:" + WIDTH + ";height:" + HEIGHT + ">");
			
			writer.println("<h3>Blood Pressure </h3>");
			writer.println("<img src = \"" + pieCharts[2].getUrl() + "\" style=width:" + WIDTH + ";height:" + HEIGHT + ">");
			
			writer.println("</body>");
			writer.println("</html>");
			
			writer.close();
		}
		catch (IOException ex)
		{
			System.out.println("Failed to save urls in pie chart file.");
		}
	}
	
	public void launchPiechartWebPage()
	{
		try
		{
			Desktop desktop = Desktop.getDesktop();
			File file = new File("Charts/charts.html");
			desktop.browse(file.toURI());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
