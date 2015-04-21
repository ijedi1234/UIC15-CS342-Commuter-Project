package uic.project.commuter.fileOperator;

import java.io.File;
import uic.project.commuter.carPoolData.*;

public interface FileOperationBehavior {

	/**
	 * This function will do a designated operation on the file provided related to the commuter data located in the tree.
	 * 
	 * @param tree
	 *            this is the data structure that holds all the commuters and their relevant information.
	 * @param file
	 *            this is the file to perform the file operation upon.
	 * @return the success of the operation.
	 */
	public boolean doFileOperation(CarPoolComponent tree, File file);

}
