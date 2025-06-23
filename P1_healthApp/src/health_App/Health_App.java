package health_App;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Health_App {
	ArrayList<Game_Symptoms> games;

	public Health_App() {
		games = new ArrayList<Game_Symptoms>();
	}

	public void summary() {
		Game_Symptoms g = games.get(games.size() - 1);
		System.out.println("Total number of symptoms: " + g.getNumberOfSymptoms());
		System.out.println("Symptom severity score: " + g.getSevarity());
		System.out.println("Overall rating: " + overallRating(games.size() - 1));
	}

	public String overallRating(int gamenumber) {
		Game_Symptoms pg = games.get(gamenumber - 1);
		Game_Symptoms cg = games.get(gamenumber);

		int tracker = 0;
		if (cg.getSevarity() < 10) {
			tracker = 1;
		} else if (cg.getSevarity() >= 10) {
			tracker = 2;
		} else if (cg.getSevarity() >= 15) {
			tracker = 3;
		}
		boolean dif = true;
		int diff = pg.getNumberOfSymptoms() - cg.getNumberOfSymptoms();
		if (diff > -2 && diff < 2) {
			dif = false;
		}

		if (!dif || tracker == 3) {
			return "very different"; // very
		}

		if (dif && tracker == 2) {
			return "unsure"; // unsure
		}
		return "no different"; // no diff
	}

	public String overallRating() {
		return overallRating(games.size() - 1);
	}

	public void addGame(Game_Symptoms game) {
		if (games.size() == 5) {
			games.remove(0);
		}
		games.add(game);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Health_App hp = new Health_App();
		boolean done = false;
		do {
			System.out.println("1. Symptom Entry");
			System.out.println("2. Display Symptom Summary");
			System.out.println("3. 'Risky Condition'");
			System.out.println("4. Exit");
			switch (in.nextInt()) {
			case 1:
				new Symptom_Servay(hp, in);
				break;
			case 2:
				hp.summary();
				break;
			case 3:

				String text = hp.overallRating();
				if (text.equals("very different")) {
					// System.out.println(text);

					JOptionPane.showMessageDialog(null, text, text, JOptionPane.ERROR_MESSAGE);
				} else if (text.equals("unsure")) {
					// System.out.println(text);

					JOptionPane.showMessageDialog(null, text, text, JOptionPane.WARNING_MESSAGE);
				} else if (text.equals("no different")) {
					// System.out.println(text);

					JOptionPane.showMessageDialog(null, text, text, JOptionPane.QUESTION_MESSAGE);
				}
				break;
			case 4:
				done = true;
				break;
			}
		} while (!done);
	}

}
