import java.util.ArrayList;
import java.util.Random;
public class ContestDriver {

	public static void main(String[] args) {
		System.out.println("Starting Simulation");
		

		// Step -1 Compile the program as is to be sure it runs

		// Step 0 - Uncomment the two lines below, then add code to the Contestant class to make this compile
		// This creates a single Contestant and prints its attributes, just to show it can be done
		//Contestant ac = new Contestant("Billy",22);
		//System.out.println(ac);
		
		// Step 2
		// Create multiple Contestants and add them to an ArrayList
		// Do something simple to get started, but remember, you will need
		// to generate up to 1,000,000 Contestants	
		int numberOfContestants = 43;

		ArrayList<Contestant> contestantList = new ArrayList<>();
		for (int i = 0; i < numberOfContestants; i++){
			contestantList.add(
				new Contestant("Contestant " + (i + 1 ), 25)
			);
		}
		
		for (int i = 0; i < contestantList.size(); i++) {
			System.out.println(contestantList.get(i) + " is at index: " + i);
		}

		// Steps 3 and 4
		// Play a round
		// For each Contestant, flip a coin, then move the Contestant to
		// one end of the ArrayList or the other.
		Random random = new Random(); // Create a Random object to generate random numbers
		int numberOfRounds = 1; // Number of rounds to simulate

		// Loop through the specified number of rounds
		for (int round = 1; round <= numberOfRounds; round++){

			System.out.println("\n-- Round " + round + " ---");

			ArrayList<Contestant> startingOrder = new ArrayList<>(contestantList); // Create a copy of the original order of contestants

			// Loop trough contestant with a chance to flip a coin and move to the front or back of the list
			for (int i = 0; i < contestantList.size(); i++) {

				Contestant currentContestant = startingOrder.get(i); // Get the current contestant from the starting order
				boolean correctCoinFlip = random.nextBoolean(); // Simulate a coin flip (true or false)

				contestantList.remove(currentContestant); // Remove the contestant from the current list

					if (correctCoinFlip) {
						contestantList.add(0, currentContestant); // Move to the front of the list
					} else {
						contestantList.add(currentContestant); // Move to the back of the list
					}	
			}

			System.out.println("Position after round " + numberOfRounds + ";");

			for (int i = 0; i < contestantList.size(); i++) {
				Contestant contestant = contestantList.get(i);
				contestant.recordPosition(i);
				System.out.println(contestant + " is at index: " + i + " with average position: " + contestant.getCurrentPosition());
			}

			System.out.println("\n--- Average Position ---");

			for (int i = 0; i < contestantList.size(); i++) {
				Contestant contestant = contestantList.get(i);
				System.out.printf(
					"\n%s: %.2f",
					contestant.getName(),
					contestant.getAveragePosition()
				);
			}
		}
		
		// Steps 5 - 7
		// Repeat Steps 3 and 4 many times to gather data.
		// You will need to modify the Contestant class so each Contestant
		// will keep track of its individual statistics. Be smart about how you record its
		// position at the end of each round.


		System.out.println("\nFinished");

	}

}
