package uic.project.commuter.fileOperator;

import java.io.File;
import uic.project.commuter.carPoolData.*;

public abstract class FileOperator {

	// This is the behavior that will perform the file operation.
	private FileOperationBehavior behavior;

	/**
	 * This function will perform the designated behavior onto the file.
	 * 
	 * @param tree
	 *            this is the data structure that holds all the commuters and their relevant information.
	 * @param file
	 *            this is the file to perform the file operation upon.
	 * @return if the operation was successful.
	 */
	public boolean operate(CarPoolComponent tree, File file) {
		return this.behavior.doFileOperation(tree, file);
	}

	/**
	 * This function will set a behavior to the FileOperator.
	 * 
	 * @param newBehavior
	 *            the behavior to set.
	 */
	protected void setBehavior(FileOperationBehavior newBehavior) {
		this.behavior = newBehavior;
	}
}
