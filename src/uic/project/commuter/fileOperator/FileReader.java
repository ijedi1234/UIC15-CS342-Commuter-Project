package uic.project.commuter.fileOperator;

public class FileReader extends FileOperator {
	
	// TODO: Add commentation.
	
	public FileReader(){
		this.setBehavior(new FileReadingBehavior());
	}
}
