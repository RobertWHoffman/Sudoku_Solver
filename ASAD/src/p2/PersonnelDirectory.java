package p2;
import java.util.Scanner;

public class PersonnelDirectory {

	public static void main(String[] args) {
		Personnel per = new Personnel();
		totalObjects total = new totalObjects();
		Scanner scan = new Scanner(System.in);
		PersonnelFactory pf = new PersonnelFactory();
		String firstN, lastN, middleN;
		int choice = -1;

		do {

			System.out.println("Welcome to the Personnel Directory Management System");
			System.out.println("====================================================");

			System.out.println("\n\n\t 1. Add Personel");
			System.out.println("\n\t 2. Find Personel");
			System.out.println("\n\t 3. Print Names");
			System.out.println("\n\t 4. Number of Entries in the Directory");

			System.out.println("\n\t Select one of the options above (1, 2, 3, 4)");
			choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter personnel type : ");
				String type = scan.nextLine();

				per.addPersonnel(pf.createPersonnel(type, scan));
				total.objectAdded();

				break;

			case 2:

				System.out.println("Enter firts name : ");
				firstN = scan.nextLine();

				System.out.println("Enter last name : ");
				lastN = scan.nextLine();

				if (!per.searchPersonnel(firstN, lastN)) {
					total.objectAdded();
				}

				break;

			case 3:

				System.out.println(
						"Enter the order 0: first, middle,  last, 1: first, last, middle, 2: last, first , middle ");
				int order = scan.nextInt();
				per.printAllPersonnel(order);

				break;

			case 4:
				System.out.println("Total Entries : " + total.getTotalObjects());

				break;

			}

		} while (true);

	}

}