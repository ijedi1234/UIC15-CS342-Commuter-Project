package uic.project.commuter.fileOperator;

public class FileReader extends FileOperator {
		
	/**
	 * This is the constructor for the FileReader that will assign a default behavior of FileReadingBehavior.
	 */
	public FileReader(){
		this.setBehavior(new FileReadingBehavior());
	}
}
