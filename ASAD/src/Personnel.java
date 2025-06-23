import java.util.*;

public class Personnel {

	public ArrayList<Person> personList;

	public Personnel() {
		personList = new ArrayList<Person>();
	}

	public void addPersonnel(Person p) {
		personList.add(p);
	}

	public Boolean searchPersonnel(String firstN, String lastN) {
		boolean found = false;
		int loc = -1;
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).first.equals(firstN) && personList.get(i).last.equals(lastN)) {
				found = true;
				loc = i;
			}
		}

		if (found) {
			System.out.println("Found");
			personList.get(loc).printName(0);
			return found;
		} else {
			System.out.println("not found");
			Person p1 = new Person(lastN, firstN, " ");
			addPersonnel(p1);
			return found;
		}
	}

	public void printAllPersonnel(int order) {
		for (int i = 0; i < personList.size(); i++) {
			personList.get(i).printName(order);
		}
	}
}