import java.util.ArrayList;
import java.util.Random;
public class ContestDriver {

	public static void main(String[] args) {
		System.out.println("Starting Simulation");

		int numberOfContestants = 45000; // Set the number of contestants to create
		int[] roundCounts = {10, 100, 1000, 10000}; // Array of different round counts to test

		System.out.printf(
			"%12s %12s %16s%n",
			"Contestants",
			"Rounds",
			"Time (seconds)"		
		);

		ArrayList<Contestant> contestantList = new ArrayList<>();
		for (int i = 0; i < numberOfContestants; i++){
			contestantList.add(
				new Contestant("Contestant " + (i + 1 ), 25)
			);
		}
		
		//for (int i = 0; i < contestantList.size(); i++) {
		//	System.out.println(contestantList.get(i) + " is at index: " + i);
		//}

		Random random = new Random(); // Create a Random object to generate random numbers
		//int numberOfRounds = 4; // Number of rounds to simulate
		long startTime = System.nanoTime(); // Start measuring time

		// Loop through the specified number of rounds
		//for (int round = 1; round <= numberOfRounds; round++){

		// Loop through the specified number of rounds
		for (int numberOfRounds : roundCounts) {
			//System.out.println("\n-- Round " + round + " ---");

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

			//System.out.println("Position after round " + numberOfRounds + ";");

			// Loop through the contestantList and record their positions
			for (int i = 0; i < contestantList.size(); i++) {
				//Contestant contestant = contestantList.get(i);
				//contestant.recordPosition(i);
				//System.out.println(contestant + " is at index: " + i + " with average position: " + contestant.getCurrentPosition());
				contestantList.get(i).recordPosition(i);// Record the current position of the contestant
			}

		long endTime = System.nanoTime(); // End measuring time
		double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0; // Convert to seconds

		System.out.printf(
			"%12d %12d %16.6f%n",
			numberOfContestants,
			numberOfRounds,
			elapsedTimeInSeconds
		);


		//System.out.println("\nElapsed time: " + elapsedTimeInSeconds + " seconds");
		//System.out.println("\n--- Average Position ---");
			//for (int i = 0; i < contestantList.size(); i++) {
				//Contestant contestant = contestantList.get(i);
				//System.out.printf(
					//"\n%s: %.2f",
					//contestant.getName(),
					//contestant.getAveragePosition()
				//);
			//}

		}
		
		System.out.println("\nFinished");

	}

}
