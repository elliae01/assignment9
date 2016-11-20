package assignment9;

import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.Dimension;
import de.toolforge.googlechartwrapper.PieChart;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.data.PieChartSlice;

enum CHART_TYPE
{
	totalCholesterol,
	BMI,
	bloodPressure
}

public class PiechartWebServiceManager 
{
	private final int CHART_COUNT = 3;
	
	private Dimension chartDimensions = new Dimension(500, 250);
	
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
	
	public boolean openWebPage()
	{
		return false;
	}
}
