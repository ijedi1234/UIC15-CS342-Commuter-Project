package uic.project.commuter.fileOperator;

public class FileSaver extends FileOperator {
	
	// TODO: Add commentation.
	
	public FileSaver(){
		this.setBehavior(new FileSavingBehavior());
	}
}
