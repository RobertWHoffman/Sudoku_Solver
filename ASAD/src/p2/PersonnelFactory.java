package p2;
import java.util.Scanner;

public class PersonnelFactory {
	public PersonnelFactory() {

	}

	public Person createPersonnel(String type, Scanner scan) {
		Person p;

		System.out.println("Enter first name: ");
		String firstN = scan.nextLine();
		System.out.println("Enter last name: ");
		String lastN = scan.nextLine();
		System.out.println("Enter middle name: ");
		String middleN = scan.nextLine();

		switch (type) {
		case "Employee":
			System.out.println("Enter empploy id : ");
			int empID = scan.nextInt();
			System.out.println("Enter base salaey");
			double salary = scan.nextDouble();
			scan.nextLine();

			p = new Employee(lastN, firstN, middleN, empID, salary);
			break;

		default:
			p = new Person(lastN, firstN, middleN);
		}

		return p;
	}
}
