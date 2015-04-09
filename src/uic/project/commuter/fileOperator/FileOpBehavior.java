package uic.project.commuter.fileOperator;

import java.io.File;
import uic.project.commuter.carPoolData.*;

public interface FileOpBehavior {
	
	public boolean doFileOp(CarPoolComponent tree, File file);
	
}
