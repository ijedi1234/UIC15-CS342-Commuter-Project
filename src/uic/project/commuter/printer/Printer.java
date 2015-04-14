package uic.project.commuter.printer;

public abstract class Printer 
{
	private PrintBehavior behavior;
	
	public void print() 
	{
		behavior.doPrinting();
	}
	
	protected void setBehavior(PrintBehavior newBehavior) 
	{
		behavior = newBehavior;
	}
}
