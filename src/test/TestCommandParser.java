package test;

import main.core.CommandParser;
import main.core.ParsedCommand;
import main.history.CommandHistory;

public class TestCommandParser {

	public static void main(String[] args) {

		CommandParser parser = new CommandParser();
		ParsedCommand r1 = parser.parse(" mkdir newDir");
		ParsedCommand r2 = parser.parse(" mkdir newDir2 ");

		System.out.println("--------TEST 1--------");
		// Test 1: navigate up
		CommandHistory history = new CommandHistory(5);
		history.add(r1.toString());
		history.add(r2.toString());
		System.out.println(history.navigateUp());
		System.out.println(history.navigateUp());
		System.out.println(history.navigateUp());
		System.out.println(history.navigateUp());

		// Test 1: navigate down
		System.out.println("--------TEST 2--------");
		CommandHistory history2 = new CommandHistory(5);
		history.add(r1.toString());
		history.add(r2.toString());
		System.out.println(history.navigateDown());
		System.out.println(history.navigateDown());

	}

}
