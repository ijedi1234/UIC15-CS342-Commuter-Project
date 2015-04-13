package uic.project.commuter.fileOperator;

import java.io.File;
import uic.project.commuter.carPoolData.*;

public class FileSavingBehavior implements FileOpBehavior {
	
	@Override
	public boolean doFileOp(CarPoolComponent tree, File file) {
		return true;
	}
	
}
