package uic.project.commuter.fileOperator;

public class FileReader extends FileOperator {
	
	public FileReader(){
		this.setBehavior(new FileReadingBehavior());
	}
}
