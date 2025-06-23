package health_App;

import java.util.ArrayList;

public class Game_Symptoms {
	Long date;
	ArrayList<Integer> ratings;
	int number_of_symptoms;
	int symptom_sevarity;

	public Game_Symptoms() {
		ratings = new ArrayList<Integer>();
	}

	public void addRating(int rating) {
		if (rating <= 6 && rating >= 0) {
			if (rating != 0) {
				number_of_symptoms += 1;
				symptom_sevarity += rating;
			}
			ratings.add(rating);
		}
	}

	public long getDate() {
		return date;
	}

	public ArrayList<Integer> getRatings() {
		return ratings;
	}

	public int getNumberOfSymptoms() {
		return number_of_symptoms;
	}

	public int getSevarity() {
		return symptom_sevarity;
	}
}
