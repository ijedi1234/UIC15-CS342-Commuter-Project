package uic.project.commuter.parser;

public class LineTo4MaxStringsBehavior implements ParserBehavior {
	
	public String[] doParsing(String input) {
        // Create an array of strings to hold the parsed strings
        String[] parsedInput = new String[4];

        // Initialize with blanks
        for(int i = 0; i < 4; i++) {
            parsedInput[i] = "";
        }

        // Split the input using spaces as delimiters
        parsedInput = input.split(" ", 4);

        /*
        // Debug parsed string tokens (uncomment if needed)
        int i = 0;
        while (i < parsedInput.length) {
            System.out.println(parsedInput[i]);
            i++;
        }
        */

        return parsedInput;
	}
}
