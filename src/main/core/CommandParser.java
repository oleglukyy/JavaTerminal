package main.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {

	/*
	 * splits the raw input into name command and args
	 * 
	 * @param rawInput users input
	 * 
	 * @return new ParsedCommand
	 */

	public ParsedCommand parse(String rawInput) {

		if (isEmptyOrBlank(rawInput)) {
			throw new IllegalArgumentException("Not valid command");
		}
		rawInput = rawInput.trim();

		List<String> args = new ArrayList<String>(Arrays.asList(rawInput.split("\\s+")));

		return new ParsedCommand(args.removeFirst(), args);

	}

	/*
	 * Checks if the input is empty
	 * 
	 * @param s input received from user
	 * 
	 * @return true if is empty, false is not empty
	 */
	public boolean isEmptyOrBlank(String s) {
		return s == null || s.isBlank();
	}

}
