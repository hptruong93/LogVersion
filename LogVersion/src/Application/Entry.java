package Application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Entry {

	private final Calendar time;
	private String title;
	private final StringBuilder content;

	public Entry(Calendar time, String title) {
		this.time = time;
		this.title = title;
		content = new StringBuilder();
	}

	public Entry(Calendar time, String title, String content) {
		this.time = time;
		this.title = title;
		this.content = new StringBuilder(content);
	}

	protected static boolean existed(ArrayList<Entry> array, Calendar finding) {// Binary
																				// search
		int left = 0, right = array.size() - 1;
		int index;
		while (left < right) {
			index = (left + right) / 2;
			int compare = finding.compareTo(array.get(index).time);
			if (compare == 0) {
				return true;
			} else if (compare < 0) {
				right = index;
			} else {
				left = index;
			}
		}
		return false;
	}

	protected static ArrayList<Integer> find(ArrayList<Entry> array, String key) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		if (key.equals("")) {
			for (int i = 0; i < array.size(); i++) {
				output.add(i);
			}
		} else {
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i).content.indexOf(key) != -1) {
					output.add(i);
				}
			}
		}
		return output;
	}

	protected static void sort(ArrayList<Entry> array) {// Ascending order
		for (int i = 0; i < array.size(); i++) {
			for (int j = i + 1; j < array.size(); j++) {
				if (array.get(i).time.compareTo(array.get(j).time) > 0) {
					Entry temp = array.get(i);
					array.set(i, array.get(j));
					array.set(j, temp);
				}
			}
		}
	}

	protected void updateTitle(String newTitle) {
		title = newTitle;
	}

	protected void update(String update) {
		clearContent();
		content.append(update);
	}

	protected static final String START_LOG = "--------Start Entry--------------";
	protected static final String END_LOG = "--------End Entry--------------";
	protected static final String DATE = "Date: ";
	protected static final String TITLE = "***Title: ";
	protected static final String CONTENT = "***Log Content: ";

	protected void write(StringBuilder log) {
		log.append(START_LOG).append("\n");
		log.append(DATE).append(MainScreen.DEFAULT_DATE.format(new Date(time.getTimeInMillis())))
				.append("\n");
		log.append(TITLE).append(title).append("\n");
		log.append("\n");
		log.append(CONTENT).append("\n").append(content).append("\n");
		log.append("\n").append("\n");
		log.append(END_LOG).append("\n");
		log.append("\n").append("\n").append("\n").append("\n");
	}

	private void clearContent() {
		content.delete(0, content.length());
	}

	protected String title() {
		return title;
	}

	protected String content() {
		return new String(content);
	}

	@Override
	public String toString() {
		return MainScreen.DEFAULT_DATE.format(new Date(time.getTimeInMillis())) + " - " + title;
	}
}
