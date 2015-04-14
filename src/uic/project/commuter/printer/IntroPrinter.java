package uic.project.commuter.printer;

public class IntroPrinter extends Printer 
{
	public IntroPrinter() 
	{
		this.setBehavior(new IntroBehavior());
	}
}
