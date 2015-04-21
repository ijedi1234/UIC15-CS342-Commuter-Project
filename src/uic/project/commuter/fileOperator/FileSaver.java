package uic.project.commuter.fileOperator;

public class FileSaver extends FileOperator {

	/**
	 * This is the constructor for the FileSaver that will assign a default behavior of FileSavingBehavior.
	 */
	public FileSaver() {
		this.setBehavior(new FileSavingBehavior());
	}
}