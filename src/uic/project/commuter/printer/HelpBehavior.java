package uic.project.commuter.printer;

public class HelpBehavior implements PrintBehavior 
{
	public void doPrinting() 
	{
		System.out.println();
		System.out.println(" The following commands with description:");
		System.out.println();
		System.out.println(" read <filepath>");
		System.out.println(" save <filepath>");
		System.out.println(" print carpools");
		System.out.println(" print all");
		System.out.println(" print cp <carpool>");
		System.out.println(" print self <objectName>");
		System.out.println(" ping");
		System.out.println(" ping <carpool>");
		System.out.println(" check com <commuter>");
		System.out.println(" check cp <carpool>");
		System.out.println(" add com <commuter>");
		System.out.println(" add com <commuter> <carpool>");
		System.out.println(" add cp <carpool1> <distance1> <carpool2> <distance2> ... <carpoolN> <distanceN>");
		System.out.println(" move <commuter> <carpool>");
		System.out.println(" remove cp <carpool>");
		System.out.println(" remove com <commuter>");
		System.out.println(" toggle <commuter>");
		System.out.println(" activate com <commuter>");
		System.out.println(" activate cp <carpool>");
		System.out.println(" deactivate com <commuter>");
		System.out.println(" deactivate cp <carpool>");
		System.out.println(" quit");
		System.out.println();
	}
}
