package View;

import View.PiechartWebServiceManager.ChartType;

public class PiechartUIinterface {

	private String[] url;

	public PiechartUIinterface() {

	}

	/**
	 * Takes in patient data for a specific day and calculates the totals for
	 * each classification. Each total is then added to each classification for
	 * the cholesterol, blood pressure, and BMI pieCharts.
	 * 
	 * @param data
	 * @return totals for classification
	 */
	public String[] chartExport(String[] data) {

		String[] classifications = { "DESIRABLE", "BORDERLINE", "HIGH", "UNDERWEIGHT", "% NORMAL", "OVERWEIGHT",
				"OBESE", "*NORMAL", "PREHYPERTENSION", "STAGE 1 HYPERTENSION", "STAGE 2 HYPERTENSION",
				"HYPERTENSIVE CRISIS" };
		int[] total = new int[12];

		for (int j = 0; j < classifications.length; j++) {
			int k = 0;
			for (int i = 0; i < data.length; i++) {
				if (data[i].contains(classifications[j])) {
					k = k + 1;
				}
			}
			total[j] = k;
		}

		PiechartWebServiceManager pc = new PiechartWebServiceManager();

		pc.addPieSlice(ChartType.totalCholesterol, "Desirable", total[0]);
		pc.addPieSlice(ChartType.totalCholesterol, "Borderline High", total[1]);
		pc.addPieSlice(ChartType.totalCholesterol, "High", total[2]);

		pc.addPieSlice(ChartType.BMI, "Underweight", total[3]);
		pc.addPieSlice(ChartType.BMI, "Normal", total[4]);
		pc.addPieSlice(ChartType.BMI, "Overweight", total[5]);
		pc.addPieSlice(ChartType.BMI, "Obese", total[6]);

		pc.addPieSlice(ChartType.bloodPressure, "Normal", total[7]);
		pc.addPieSlice(ChartType.bloodPressure, "Prehypertension", total[8]);
		pc.addPieSlice(ChartType.bloodPressure, "Stage 1 Hypertension", total[9]);
		pc.addPieSlice(ChartType.bloodPressure, "Stage 2 Hypertension", total[10]);
		pc.addPieSlice(ChartType.bloodPressure, "Hypertensive Crisis", total[11]);

		url = new String[3];
		url[0] = pc.getUrl(ChartType.totalCholesterol);
		url[1] = pc.getUrl(ChartType.BMI);
		url[2] = pc.getUrl(ChartType.bloodPressure);

		return url;
	}

}
