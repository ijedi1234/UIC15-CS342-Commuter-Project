package uic.project.commuter.printer;

public class HelpBehavior implements PrintBehavior 
{
        /**
	 * This behavior provides help if the user needs to read the written commands along with
	 * descriptions. 
	 */
	
	public void doPrinting() 
	{
		System.out.println("\n The following commands with descriptions which will be in between asterisks:");
		System.out.println(" help **Prints commands information**");
		System.out.println(" read <filepath> **Reads a .csv file. An error message will be printed if not found**");
		System.out.println(" save <filepath> **Saves the current data structure for the carpool. An error will be returned**");
		System.out.println(" print carpools **Prints out the existing carpools**");
		System.out.println(" print all **Prints carpool data structure information**");
		System.out.println(" print cp <carpool> **Prints a carpool's commuters**");
		System.out.println(" print self <objectName> **Prints the data for the given object corresponding to objectName**");
		System.out.println(" ping **Indicates to the program to change the leader of all carpools**");
		System.out.println(" ping <carpool> **Indicates to the program to add to the distance for the leader of a carpool**");
		System.out.println(" check com <commuter> **Checks the existence of the commuter**");
		System.out.println(" check cp <carpool> **Checks the existence of the carpool**");
		System.out.println(" add com <commuter> **Adds a new commuter into the carpool**");
		System.out.println(" add com <commuter> <carpool> **Adds a new commuter to the specified carpool**");
		System.out.println(" add cp <carpool> <distance> **Adds new carpools with a set distance from the carpool origin point and end point.**");
		System.out.println(" move <commuter> <carpool> **Moves a commuter to the specified carpool**");
		System.out.println(" remove cp <carpool> **Removes a carpool**");
		System.out.println(" remove com <commuter> **Removes a commuter**");
		System.out.println(" toggle <commuter> <carpool> **Overrides the program's decision for leader and causes a specific commuter to be leader**");
		System.out.println(" activate <commuter> **Activates the specified object**");
		//System.out.println(" activate cp <carpool> **Activates the specified carpool**\n");
		//System.out.println(" deactivate com <commuter> **Deactivates the specified commuter**\n");
		System.out.println(" deactivate <carpool> **Deactivates the specificed object**");
		System.out.println(" quit **offers to save the data structure. If yes, the filename will be taken from input and saved. "
				+ "       Otherwise, nothing will happen so program will quit afterwards.**");
	}
}
