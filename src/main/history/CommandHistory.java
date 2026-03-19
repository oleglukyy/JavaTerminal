package main.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stores the history of commands executed in the terminal. Allows bidirectional
 * navigation through previous commands using an internal cursor, simulating the
 * movement behavior of a real terminal.
 */

public class CommandHistory {

	private List<String> entries;
	private int cursor;
	private int maxSize;

	/**
	 * Creates a new CommandHistory with the given maximum size.
	 * 
	 * @param maxSize maximum number of commands to store
	 */

	public CommandHistory(int maxSize) {

		this.entries = new ArrayList<String>();
		this.maxSize = maxSize;
		resetCursor();

	}

	/**
	 * Adds a command to the history and resets the navigation cursor. If the
	 * history is full, removes the oldest command first.
	 * 
	 * @param command the command string to store
	 */

	public void add(String command) {

		if (entries.size() == maxSize) {
			entries.removeFirst();
		}

		entries.add(command);

		resetCursor();
	}

	/**
	 * Navigates to the previous command . Moves the cursor towards older commands.
	 * 
	 * @return the previous command, or empty if already at the oldest
	 */
	public Optional<String> navigateUp() {

		if (cursor <= 0) {
			return Optional.empty();
		}

		cursor--;

		return Optional.of(entries.get(cursor));

	}

	/**
	 * Navigates to the next command . Moves the cursor towards more recent
	 * commands.
	 * 
	 * @return the next command, or empty if already at the most recent
	 */
	public Optional<String> navigateDown() {

		if (cursor == entries.size()) {
			return Optional.empty();
		}

		cursor++;

		if (cursor == entries.size()) {
			return Optional.empty();
		}

		return Optional.of(entries.get(cursor));
	}

	/**
	 * Returns the full list of stored commands and resets the cursor.
	 * 
	 * @return unmodifiable view of all commands in order
	 */
	public List<String> getAll() {

		resetCursor();

		return entries;
	}

	/**
	 * Clears all stored commands and resets the cursor.
	 */
	public void clear() {

		entries.clear();

		resetCursor();
	}

	/**
	 * Returns the number of commands currently stored.
	 * 
	 * @return size of the history
	 */
	public int size() {

		return entries.size();

	}

	/**
	 * Resets the cursor to the default position (after the last entry). Called
	 * after add() and clear() to indicate no active navigation.
	 */
	private void resetCursor() {

		cursor = entries.size();

	}

}
