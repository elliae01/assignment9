package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PatientFile {
	private List<String> list;
	private String[] stringArr;

	public PatientFile() {

	}

	/**
	 * Appends current date to output file.
	 * 
	 * @param date
	 * @return path
	 */
	public String pathForDate(String date) {
		return "C:\\Patient_Health_Screen\\" + date + "_summary.txt";
	}

	/**
	 * Creates output file and appends patient data.
	 * 
	 * @param data
	 * @param date
	 */
	public void outFile(String[] data, String date) {

		try {

			Writer fileWriter = new FileWriter(pathForDate(date), true);

			for (int i = 0; i < data.length; i++) {
				fileWriter.append(data[i]);
				if (i != data.length - 1) {
					fileWriter.append("\r\n");
				}

			}

			fileWriter.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * Reads input file and stores in array.
	 * 
	 * @param selectedFile
	 * @return array with patient summary
	 */
	public String[] inFile(File selectedFile) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(selectedFile));

			String line = null;

			list = new ArrayList<String>();
			int i = 0;
			while ((line = br.readLine()) != null) {
				list.add(line);
				// System.out.println(line);
				stringArr = list.toArray(new String[i]);
				i++;
			}

			// System.out.println(stringArr[1]);
			br.close();

		} catch (IOException e1) {

			e1.printStackTrace();

		}
		return stringArr;

	}
}
