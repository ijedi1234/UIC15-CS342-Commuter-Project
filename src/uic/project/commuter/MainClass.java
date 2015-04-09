package uic.project.commuter;

import uic.project.commuter.printer.*;
import uic.project.commuter.fileOperator.*;
import uic.project.commuter.parser.*;
import uic.project.commuter.carPoolData.*;
import uic.project.commuter.carPoolData.iterator.CarPoolComposite;

public class MainClass {
	
	private Printer introPrint = new IntroPrinter();
	private Printer helpPrinter = new HelpPrinter();
	private LineParser parser = new LineTo4MaxStringsParser();
	private CarPoolComponent tree = new CarPoolComposite();
	private FileOperator saver = new FileSaver();
	private FileOperator reader = new FileReader();

	public static void main(String[] args) {
		
	}
	
	/**
	 * This constructor shall prevent other classes from creating this class.
	 * No class should ever handle an instance of this class.
	 */
	private MainClass(){}

}
