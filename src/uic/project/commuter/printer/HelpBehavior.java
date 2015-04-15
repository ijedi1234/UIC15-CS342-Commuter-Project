package uic.project.commuter.printer;

public class HelpBehavior implements PrintBehavior 
{
	public void doPrinting() 
	{
			/**
	 * This behavior provides help if the user needs to read the written commands along with
	 * descriptions. 
	 */
	
	public void doPrinting() 
	{
		System.out.println("\n The following commands with descriptions which will be in between asterisks:\n");
		System.out.println(" help **Prints commands information**\n");
		System.out.println(" read <filepath> **Reads a .csv file. An error message will be printed if not found**\n");
		System.out.println(" save <filepath> **Saves the current data structure for the carpool. An error will be returned**\n");
		System.out.println(" print carpools **Prints out the existing carpools**\n");
		System.out.println(" print all **Prints carpool data structure information**\n");
		System.out.println(" print cp <carpool> **Prints a carpool's commuters**\n");
		System.out.println(" print self <objectName> **Prints the data for the given object corresponding to objectName**\n");
		System.out.println(" ping **Indicates to the program to change the leader of all carpools**\n");
		System.out.println(" ping <carpool> **Indicates to the program to add to the distance for the leader of a carpool**\n");
		System.out.println(" check com <commuter> **Checks the existence of the commuter**\n");
		System.out.println(" check cp <carpool> **Checks the existence of the carpool**\n");
		System.out.println(" add com <commuter> **Adds a new commuter into the carpool**\n");
		System.out.println(" add com <commuter> <carpool> **Adds a new commuter to the specified carpool**\n");
		System.out.println(" add cp <carpool1> <distance1> <carpool2> <distance2> ... <carpoolN> <distanceN> "
				+ "\n **Adds new carpools with a set distance from the carpool origin point and end point.**\n");
		System.out.println(" move <commuter> <carpool> **Moves a commuter to the specified carpool**\n");
		System.out.println(" remove cp <carpool> **Removes a carpool**\n");
		System.out.println(" remove com <commuter> **Removes a commuter**\n");
		System.out.println(" toggle <commuter> **Overrides the program's decision for leader and causes a specific commuter to be leader**\n");
		System.out.println(" activate com <commuter> **Activates the specified commuter**\n");
		System.out.println(" activate cp <carpool> **Activates the specified carpool**\n");
		System.out.println(" deactivate com <commuter> **Deactivates the specified commuter**\n");
		System.out.println(" deactivate cp <carpool> **Deactivates the specificed carpool**\n");
		System.out.println(" quit **offers to save the data structure. If yes, the filename will be taken from input and saved. \n"
				+ "       Otherwise, nothing will happen so program will quit afterwards.**\n");
	}
}
