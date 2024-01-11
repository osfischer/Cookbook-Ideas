package Views;
import java.util.Scanner;

import Model.CookbookIdeas;

public class ConsoleView {

	public static void main(String[] args) {
		CookbookIdeas cookbook = new CookbookIdeas();
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("Pick a mode:");
			System.out.println("View (v)  Delete (d)  Add (a)  Reset (r)  Manual Choice (m)");
			System.out.println("Or press enter again to get something chosen for you for dinner");
			String userLine = userInput.nextLine().toLowerCase();
			switch(userLine) {
			case "v":
				cookbook.printAllIdeas();
				break;
			case "d":
				System.out.println("Type an item to delete, if you want a list, type 'v'");
				userLine = userInput.nextLine().toLowerCase();
				if (userLine.equals("v")) {
					cookbook.printAllIdeas();
					userLine = userInput.nextLine().toLowerCase();
				}
				System.out.println(cookbook.removeIdea(userLine));
				break;
			case "a":
				System.out.println("Type in an item you would like to add, if you want to see the current list, type 'v'");
				userLine = userInput.nextLine().toLowerCase();
				if (userLine.equals("v")) {
					cookbook.printAllIdeas();
					userLine = userInput.nextLine().toLowerCase();
				}
				System.out.println(cookbook.addIdea(userLine));
				break;
			case "r":
				System.out.println("Resetting the cookbook to give you all the options again");
				cookbook.resetIdeas();
			case "m":
				System.out.println("Type in an item you would like to use, if you want to see the current list, type 'v'");
				userLine = userInput.nextLine();
				if (userLine.equals("v")) {
					cookbook.printAllIdeas();
					userLine = userInput.nextLine().toLowerCase();
				}
				if (!cookbook.ideas.contains(userLine) && !cookbook.ideas.contains(userLine)) {
					System.out.println(cookbook.addIdea(userLine));
				}
				cookbook.useIdea(userLine);
				break;
			case "":
				boolean flag = true;
				while (flag) {
					String randomDinner = cookbook.getRandomItem(); 
					System.out.println("The randomized choice for you today was: " + randomDinner);
					System.out.println("Would you like to use it? Type (Y/N)");
					userLine = userInput.nextLine().toLowerCase();
					switch(userLine) {
					case "y":
						cookbook.useIdea(randomDinner);
						flag = false;
						break;
					default:
						System.out.println("Getting you a new idea!");
					}
				}
			default:
				System.out.println("Unknown command");
			}
		}
		
	}
}
