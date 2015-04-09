package uic.project.commuter.fileOperator;

import java.io.File;
import uic.project.commuter.carPoolData.*;

public abstract class FileOperator {
	
	private FileOpBehavior behavior;
	
	public boolean operate(CarPoolComponent tree, File file) {
		return behavior.doFileOp(tree, file);
	}
	
	protected void setBehavior(FileOpBehavior newBehavior) {
		behavior = newBehavior;
	}
}
