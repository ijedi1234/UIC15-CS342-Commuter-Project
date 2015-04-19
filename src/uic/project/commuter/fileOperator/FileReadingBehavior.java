package uic.project.commuter.fileOperator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import uic.project.commuter.carPoolData.*;

public class FileReadingBehavior implements FileOpBehavior {
	
	// First push. Will be finalized on Sunday.
	
	// TODO: Add comments.
	
	@Override
	public boolean doFileOp(CarPoolComponent tree, File file) {
		
		// Read the file here.
		
		// TODO: Add error checking.
		
        Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
        	// TODO: Remove the space before each element.
            System.out.print(scanner.next() + ",");
        }
        scanner.close();
	 
		
		return true;
	}
}
