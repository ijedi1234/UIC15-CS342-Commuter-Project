package uic.project.commuter.printer;

public class HelpPrinter extends Printer {
	
	public HelpPrinter() {
		this.setBehavior(new HelpBehavior());
	}
	
}
