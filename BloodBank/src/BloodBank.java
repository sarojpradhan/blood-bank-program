
import java.util.*;

public class BloodBank {
	private ArrayList<BloodGroup> list_of_blood_types;
	private Scanner reader;

	public BloodBank() {
		this.list_of_blood_types = new ArrayList<BloodGroup>();
		this.reader = new Scanner(System.in);
	}

	public void printMenu() {
		System.out.print("\n-----BLOOD BANK PROGRAM-----" + "\n To add blood enter: 1\n " + "To list blood enter: 2\n "
				+ "To take blood enter: 3\n " + "To exit the program enter: 0\n");
	}

	public void startProgram() {

		while (true) {
			printMenu();
			System.out.print("\nGive me your choice: ");
			String userInput = this.reader.nextLine();

			if (userInput.equals("1")) {
				storeBlood();
			}
			if (userInput.equals("2")) {
				printBloodInfo();
			}
			if (userInput.equals("3")) {
				takeBlood();
			}
			if (userInput.equals("0")) {
				System.out.print("Thank you for using the service. Please visit again!");
				break;
			}
		}
	}

	private String[] knownBloodGroup() {
		String[] known_blood_group = { "A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-" };

		return known_blood_group;
	}

	private void printKnownBloodGroup() {
		String[] known_blood_group = knownBloodGroup();
		for (int i = 0; i < known_blood_group.length; i++) {
			System.out.print(known_blood_group[i] + " ");
		}
		System.out.println("\n");
	}

	private void storeBlood() {
		String[] known_blood_group = knownBloodGroup();

		System.out.print("\nEnter blood group name: ");
		String blood_group = this.reader.nextLine().toUpperCase();

		boolean blood_found = false;

		for (int i = 0; i < known_blood_group.length; i++) {
			if (known_blood_group[i].equals(blood_group)) {
				blood_found = true;
				BloodGroup bloodGroup = new BloodGroup(blood_group);
				this.list_of_blood_types.add(bloodGroup);
				System.out.println("\n==> "+ blood_group + " blood stored successfully <==\n");
				break;
			}
		}

		if (blood_found == false) {
			System.out.println("\nYou are only allowed to add following blood group type: ");
			printKnownBloodGroup();
		}
	}

	private void printBloodInfo() {

		ArrayList<String> blood_type_string = new ArrayList<String>();
		blood_type_string = bloodTypeString();
		System.out.println("____________________________");
		System.out.println("\nBlood group | Total packet");
		System.out.println("____________________________");
		Set<String> each_blood_group_count = new HashSet<String>(blood_type_string);

		if (each_blood_group_count.size() > 0) {
			for (String blood_type : each_blood_group_count) {

				System.out.println("\n" + blood_type + "         |   "
						+ Collections.frequency(blood_type_string, blood_type) + " packets");
				System.out.println("----------------------------");

			}
		} else {
			System.out.println("\n    Blood not available!    ");
			System.out.println("____________________________");
		}

	}

	private ArrayList<String> bloodTypeString() {
		ArrayList<String> blood_type_string = new ArrayList<String>();
		for (BloodGroup bg : list_of_blood_types) {
			String blood = bg.getBloodType();
			blood_type_string.add(blood);
		}
		return blood_type_string;
	}

	private void takeBlood() {
		System.out.print("Enter blood type: ");
		String user_input = this.reader.nextLine().toUpperCase();

		int counter = 0;
		for (BloodGroup bg : this.list_of_blood_types) {
			if (bg.getBloodType().equals(user_input)) {
				this.list_of_blood_types.remove(bg);
				counter++;
				System.out.println("\n==> "+ user_input + " blood taken successfully <==\n");
				break;
			}
		}

		if (counter == 0) {
			System.out.println("\n ==> " + user_input + " blood not available! <==\n");
		}
	}

}
