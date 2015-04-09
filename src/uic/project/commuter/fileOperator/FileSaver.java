package uic.project.commuter.fileOperator;

public class FileSaver extends FileOperator {
	
	public FileSaver(){
		this.setBehavior(new FileSavingBehavior());
	}
}
