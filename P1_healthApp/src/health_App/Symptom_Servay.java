package health_App;

import java.util.Scanner;

public class Symptom_Servay {
	public Symptom_Servay(Health_App app, Scanner in) {
		Game_Symptoms gs = new Game_Symptoms();

		String base = "Please enter your ";
		String catagory = "(none (0),mild (1,2),moderate (3,4), & severe (5,6)): ";
		System.out.print(base + "Headache score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Pressure in head score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Neck pain score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Nausia or vomiting score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Dizziness score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Blurred vision score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Balance problems score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Sensitivity to light score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Sensitivity to noise score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Feeling slowed down score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Feeling like 'in a fog' score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "'Don't feel right' score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Difficulty concentrating score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Difficulty remembering score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Fatigue or low energy score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Confusion score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Drowiness score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Trouble falling asleep score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "More emotional score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "irritability score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Sadness score" + catagory);
		gs.addRating(in.nextInt());
		System.out.print(base + "Nervous or anxious score" + catagory);
		gs.addRating(in.nextInt());

		app.addGame(gs);

	}
}
