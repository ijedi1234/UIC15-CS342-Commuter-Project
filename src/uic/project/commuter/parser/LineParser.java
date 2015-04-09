package uic.project.commuter.parser;

public abstract class LineParser {
	
	private ParserBehavior behavior;
	
	public String[] parse(String input) {
		return behavior.doParsing(input);
	}
	
	protected void setBehavior(ParserBehavior newBehavior) {
		behavior = newBehavior;
	}
}
