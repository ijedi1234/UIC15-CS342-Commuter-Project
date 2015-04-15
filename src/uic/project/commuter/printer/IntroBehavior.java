package uic.project.commuter.printer;

public class IntroBehavior implements PrintBehavior 
{
	public void doPrinting() 
	{
		System.out.println("\n                       Hello, Welcome to Commuter Logistics Program!\n");
		System.out.println("                            - Created by authors of Group 12 - ");
		System.out.println("                                  Louis Ludkowski (Leader)    ");
		System.out.println("                                       Revanth Reddy     ");
		System.out.println("                                       Cameron Reuss     ");
		System.out.println("                                   Uladzislau Tarssunou  ");
		System.out.println("                                       Rinkal Parikh     \n");
		System.out.println(" The purpose of Commuter Logistics Program (CLS) is to create and modify a data structure consisting");
		System.out.println(" of carpools and commuters. The original specification requires that the data organizes commuters into");
		System.out.println(" groups for carpooling and fairly assigns dedicated driver for designated days. The CLS will ensure");
		System.out.println(" the original specification is met along with adding flexibility for commuters to mark themselves as");
		System.out.println(" unavailable for carpooling along with other features.\n");
		System.out.println("          REMINDER: Type 'help' if you need to print out the commands with description.\n");
	}
}
