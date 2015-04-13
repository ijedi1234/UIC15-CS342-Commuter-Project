package uic.project.commuter;

import java.io.File;
import java.util.Scanner;
import uic.project.commuter.printer.*;
import uic.project.commuter.fileOperator.*;
import uic.project.commuter.parser.*;
import uic.project.commuter.carPoolData.*;
import uic.project.commuter.carPoolData.iterator.CarPoolComposite;

public class MainClass {
	
	private static Printer introPrint = new IntroPrinter(); //This object handles printing the introduction.
	private static Printer helpPrinter = new HelpPrinter(); //This object handles printing the help.
	private static LineParser parser = new LineTo4MaxStringsParser(); //This object handles parsing a taken string.
	private static CarPoolComponent tree = new CarPoolComposite(); //This object is the data structure itself.
	private static FileOperator saver = new FileSaver(); //This object handles file saving.
	private static FileOperator reader = new FileReader(); //This object reads information into the data structure.

	/**
	 * This is the main method; it dictates program operation on a higher level.
	 * @param args - The "argv"
	 */
	public static void main(String[] args) {
		//Begin with printing the introduction.
		introPrint.print();
		//Initialize the input objects.
		String[] inputArgs = new String[4];
		Scanner argsObject = new Scanner(System.in);
		//Ensure the inputs are readable.
		for(int i = 0; i < 4; i++) {
			inputArgs[i] = "";
		}
		//This loop must continue until prompted to quit.
		while(inputArgs[0].equals("quit") == false) {
			//Inform the user that the program is ready for commands.
			System.out.print("Enter command: ");
			//Acquire the inputs.
			String inputLine = argsObject.nextLine();
			//Split the inputs into 4 strings.
			inputArgs = parser.parse(inputLine);
			//The first argument is given to a new value for clarity.
			String command = inputArgs[0];
			//The large if statement for command dictation is here.
			if(command.equals("help")) {
				//If help, print out what the commands are and do.
				helpPrinter.print();
			} else if(command.equals("read")) {
				//Reads the file information into tree.
				reader.operate(tree, new File(inputArgs[1]));
			} else if(command.equals("save")) {
				//Saves the current state of the data structure into the given file.
				saver.operate(tree, new File(inputArgs[1]));
			} else if(command.equals("print")) {
				//Must create a differentiator to handle the next argument.
				String differentiator = inputArgs[1];
				if(differentiator.equals("carpools")) {
					//Prints the sublevel.
					tree.printLevel();
				} else if(differentiator.equals("all")) {
					//Prints all sub-objects.
					tree.printAll();
				} else if(differentiator.equals("cp")) {
					//Prints the sublevel for the designated carpool.
					CarPoolComponent foundObject = tree.findCarpool(inputArgs[2]);
					if(foundObject == null) {
						System.out.println("Error: There is no carpool with that name.");
					} else {
						foundObject.printSelf();
					}
				} else if(differentiator.equals("self")) {
					//Prints the information for the given object, should it exist.
					CarPoolComponent foundObject = tree.findCommuter(inputArgs[2]);
					if(foundObject != null) {
						foundObject.printSelf();
						continue;
					}
					foundObject = tree.findCarpool(inputArgs[2]);
					if(foundObject != null) {
						foundObject.printSelf();
					} else {
						System.out.println("Error: No object exists with that name.");
					}
				} else {
					//This code is used if the second command doesn't work.
					System.out.println("Error: No match for second command.");
				}
			} else if(command.equals("ping")) {
				//Must create a differentiator to handle the next argument.
				String differentiator = inputArgs[1];
				if(differentiator.equals("")) {
					//Will automatically set all the carpool leaders.
					tree.determineLazyCommuter();
				} else {
					//Will use the differentiator as the carpool name, and change it.
					tree.determineLazyCommuter(differentiator);
				}
			} else if(command.equals("check")) {
				//Must create a differentiator to handle the next argument.
				String differentiator = inputArgs[1];
				if(differentiator.equals("com")) {
					if(tree.findCommuter(inputArgs[2]) != null) {
						System.out.println("An instance of this commuter was found.");
					} else {
						System.out.println("An instance of this commuter was not found.");
					}
				} else if(differentiator.equals("cp")) {
					if(tree.findCarpool(inputArgs[2]) != null) {
						System.out.println("An instance of this commuter was found.");
					} else {
						System.out.println("An instance of this commuter was not found.");
					}
				} else {
					System.out.println("Error: Invalid second argument.");
				}
			} else if(command.equals("add")) {
				//Must create a differentiator to handle the next argument.
				String differentiator = inputArgs[1];
				String[] secondSet = new String[4];
				secondSet = parser.parse(inputArgs[3]);
				if(differentiator.equals("com")) {
					tree.addCommuter(tree.findCommuter(inputArgs[2]), tree.findCarpool(secondSet[0]));
				} else if(differentiator.equals("cp")) {
					tree.addCarpool(tree.findCarpool(inputArgs[2]), Double.parseDouble(secondSet[0]));
				} else {
					System.out.println("Error: Invalid second argument.");
				}
			} else if(command.equals("move")) {
				tree.moveCommuter(tree.findCommuter(inputArgs[1]), tree.findCarpool(inputArgs[2]));
			} else if(command.equals("remove")) {
				//Must create a differentiator to handle the next argument.
				String differentiator = inputArgs[1];
				if(differentiator.equals("com")) {
					tree.removeCommuter(tree.findCommuter(inputArgs[2]));
				} else if(differentiator.equals("cp")) {
					tree.removeCarpool(tree.findCarpool(inputArgs[2]));
				} else {
					System.out.println("Error: Invalid second argument.");
				}
			} else if(command.equals("toggle")) {
				//Informs the tree to override the leader of a carpool.
				tree.toggleLeader(tree.findCommuter(inputArgs[1]), tree);
			} else if(command.equals("activate")) {
				tree.activate(inputArgs[1]);
			} else if(command.equals("deactivate")) {
				tree.deactivate(inputArgs[1]);
			} else if(command.equals("quit")) {
				break;
			} else {
				System.out.println("Error: That command does not exist.");
			}
		}
		System.out.print("\nWould you like to save? ");
		inputArgs = parser.parse(argsObject.nextLine());
		if(inputArgs[0].equals("yes") || inputArgs[0].equals("y")) {
			System.out.print("Enter the filename or filepath: ");
			inputArgs = parser.parse(argsObject.nextLine());
			saver.operate(tree, new File(inputArgs[0]));
		}
		argsObject.close();
	}
	
	/**
	 * This constructor shall prevent other classes from creating this class.
	 * No class should ever handle an instance of this class.
	 */
	private MainClass(){}

}
