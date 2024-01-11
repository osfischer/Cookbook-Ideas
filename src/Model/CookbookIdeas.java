package Model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CookbookIdeas {
	public Set<String> ideas;
	public ArrayList<String> usedIdeas;
	
	public CookbookIdeas() {
		ideas = new HashSet<String>();
		usedIdeas = new ArrayList<String>();
	}
	
	public String addIdea(String idea) {
		if (ideas.contains(idea) || usedIdeas.contains(idea)) {
			return "Already in the book \n";
		}
		ideas.add(idea);
		return "Added " + idea + " to the cookbook \n";
	}
	
	public String removeIdea(String idea) {
		for (String cookbookIdea : ideas) {
			if (cookbookIdea.matches(idea)) {
				ideas.remove(idea);
				return "Removed " + idea + " from the cookbook \n";
			}
		}
		for (String cookbookIdea : usedIdeas) {
			if (cookbookIdea.matches(idea)) {
				usedIdeas.remove(idea);
				return "Removed " + idea + " from the cookbook \n";
			}
		}
		return "Not found \n";
	}
	
	public String useIdea(String idea) {
		ideas.remove(idea);
		usedIdeas.add(idea);
		if (ideas.size() == 0) {
			System.out.println("No more ideas in the book, resetting");
			resetIdeas();
		}
		return "Have fun making " + idea;
	}
	
	public void resetIdeas() {
		ideas.addAll(usedIdeas);
		usedIdeas.removeAll(usedIdeas);
	}
	
	public void printAllIdeas() {
		printRemainingIdeas();
		printUsedIdeas();
	}
	
	public void printRemainingIdeas() {
		System.out.println("These are the cookbook items you have not used yet:");
		for (String cookbookIdea : ideas) {
			System.out.println(cookbookIdea);
		}
		System.out.println();
	}
	
	public void printUsedIdeas() {
		System.out.println("These are the cookbook items you have used already:");
		for (String cookbookIdea : usedIdeas) {
			System.out.println(cookbookIdea);
		}
		System.out.println();
	}
	
	public String getRandomItem() {
	    int rnd = new Random().nextInt(ideas.size());
	    return ideas.get(rnd);
	}
}