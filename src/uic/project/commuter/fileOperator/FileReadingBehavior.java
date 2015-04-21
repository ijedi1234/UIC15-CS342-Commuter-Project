package uic.project.commuter.fileOperator;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import uic.project.commuter.carPoolData.*;
import uic.project.commuter.carPoolData.iterator.CarPoolComposite;

public class FileReadingBehavior implements FileOperationBehavior {

	/**
	 * This function will read the file provided and place the information into the tree.
	 * 
	 * @param tree
	 *            this is the data structure that holds all the commuters and their relevant information.
	 * @param file
	 *            this is the file to perform the file operation upon.
	 * @return if the operation was successful.
	 */
	@SuppressWarnings("resource")
	@Override
	public boolean doFileOperation(CarPoolComponent tree, File file) {

		// Make sure the file object is not null.
		if (file == null) {
			System.err.println("The file can not be loaded."); //$NON-NLS-1$
			return false;
		}

		// Warn the user if the an existing file will be over-written.
		if (!file.exists()) {
			System.err.println("The file does not exist."); //$NON-NLS-1$
			return false;
		}

		// Open the file
		
		// Make sure the provided file path ends correctly.
		String file_path = file.getAbsolutePath();
		
		// DOUBLE CHECK TO SEE IF THIS WORKS.
		if (file_path.endsWith(".txt")) { //$NON-NLS-1$
			file_path = file_path.substring(0, file_path.indexOf(".txt")); //$NON-NLS-1$
		}
		
		if (!file_path.endsWith(".csv")) { //$NON-NLS-1$
			file_path += ".csv"; //$NON-NLS-1$
		}
		
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(file_path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		String currentCarPool = "N/A"; //$NON-NLS-1$
		
		try {
			while ((strLine = br.readLine()) != null) {				
				
				String[] line = strLine.split(","); //$NON-NLS-1$
				
				// Trim each line.
				for (int i = 0; i < line.length; i++) {
					line[i] = line[i].trim();
				}
				
				if (line[0].equals("M")) { //$NON-NLS-1$
					if (currentCarPool.equals("N/A")) { //$NON-NLS-1$						
						tree.addCommuter(new CommuterElement(line[1], Boolean.parseBoolean(line[2]), Double.parseDouble(line[4]), Boolean.parseBoolean(line[3])), tree.findCarpool("")); //$NON-NLS-1$
					} else {
						tree.addCommuter(new CommuterElement(line[1], Boolean.parseBoolean(line[2]), Double.parseDouble(line[4]), Boolean.parseBoolean(line[3])), tree.findCarpool(currentCarPool));
					}
				} else if (line[0].equals("P")) { //$NON-NLS-1$
					// Set the current name of the current carpool.
					currentCarPool = line[1];
					try {
						double passedDouble = Double.parseDouble(line[3]);
						tree.addCarpool(new CarPoolComposite(line[1], Boolean.parseBoolean(line[2]), passedDouble), passedDouble);
					} catch (NumberFormatException e) {
						System.out.println("Invalid double!"); //$NON-NLS-1$
					}
				} else {
					System.err.println("The text file contains an invalid data line that will be ignored."); //$NON-NLS-1$
					System.err.println("The following line does not begin with a \"M\" or \"P\"."); //$NON-NLS-1$
					System.err.println(strLine);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
