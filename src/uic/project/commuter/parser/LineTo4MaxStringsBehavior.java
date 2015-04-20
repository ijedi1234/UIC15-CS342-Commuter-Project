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
        //parsedInput = input.split(" ", 5);
        int i;
        for(i = 0; i < 3; i++) {
        	input = input.trim();
        	if(input.indexOf(" ") == -1) { //Prevents substring of -1.
        		parsedInput[i] = input;
        		input = "";
        		break;
        	}
        	parsedInput[i] = input.substring(0, input.indexOf(" "));
        	input = input.substring(input.indexOf(" "));
        }
        parsedInput[3] = input;

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
