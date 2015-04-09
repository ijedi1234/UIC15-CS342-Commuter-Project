package uic.project.commuter.parser;

public class LineTo4MaxStringsParser extends LineParser {
	
	public LineTo4MaxStringsParser() {
		this.setBehavior(new LineTo4MaxStringsBehavior());
	}
}
