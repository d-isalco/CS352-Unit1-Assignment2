import java.util.ArrayList;
   
import java.util.Random;

public class ContestDriver2 {

	public static void main(String[] args) {
		System.out.println("Starting Simulation");

		// Step -1 Compile the program as is to be sure it runs
		// Step 0 - Uncomment the two lines below, then add code to the Contestant class to make this compile
		//This creates a single Contestant and prints its attributes, just to show it can be done
		
		// Step 2
		// Create multiple Contestants and add them to an LinkedList.
		// Do something simple to get started, but remember, you will need
		// to generate up to 1,000,000 Contestants	
        int numberOfContestants = 1000;
        int[] roundCounts = {10, 100, 1000, 10000};

		System.out.printf(
            "%12s %12s %16s%n",
            "Contestants", "Rounds", "Time (seconds)"
        );

		// it runs a separate test for each round count.
		for (int numberOfRounds : roundCounts) {

            // code starts each test with new contestants and fresh statistics.
			// Create a LinkedList to hold the Contestants
            ArrayList<Contestant> contestantList = new ArrayList<>();

            for (int i = 0; i < numberOfContestants; i++) {
                contestantList.add(
                    new Contestant("Contestant " + (i + 1), 25)
                );
            }

		// Steps 3 and 4
		// Play a round
		// For each Contestant, flip a coin, then move the Contestant to
		// one end of the LinkedList or the other.
		// Steps 5 - 7
		// Repeat Steps 3 and 4 many times to gather data.
		// You will need to modify the Contestant class so each Contestant
		// will keep track of its individual statistics. Be smart about how you record its
		// position at the end of each round.

		// A fixed seed makes the coin flips repeatable.
		// This is useful for testing and debugging, but you may want to
		// remove the seed later to see how the program performs with random data.
        //Random random = new Random(12345);
		Random random = new Random(0);

			// Start the timer for this test.
            long startTime = System.nanoTime();
		
			// perform the requested number of rounds.
            for (int round = 0; round < numberOfRounds; round++) {

                // hold the order at the beginning of this round.
                ArrayList<Contestant> startingOrder =
                    new ArrayList<>(contestantList);

				// For loop let each contestant flip a coin and move the contestant to the front or back of the list.
				// this simulates a game where the Contestants are moving around in the list.
                for (int i = 0; i < startingOrder.size(); i++) {
                    Contestant currentContestant =
                        startingOrder.get(i);

                    boolean correctCoinFlip = random.nextBoolean();

                    contestantList.remove(currentContestant);
					// Move the Contestant to the front or back of the list based on the coin flip.
                    if (correctCoinFlip) {
						// it moves the contestant to the front of the list.
                        contestantList.add(0, currentContestant);					
                    } else {
						// it moves the contestant to the back of the list.
                        contestantList.add(currentContestant);
                    }
                }

                // it record each contestant's position after the round we are on.
                for (int i = 0; i < contestantList.size(); i++) {
					// Record the position of the Contestant at index i in the list.
                    contestantList.get(i).recordPosition(i);
                }
            }

			// it calculate the elapsed time for this test.
            long endTime = System.nanoTime();

			// it calculate the elapsed time in seconds.
            double elapsedTimeInSeconds =
                (endTime - startTime) / 1_000_000_000.0;

			// Print the results for this test.
			// The %12d and %16.6f helps to format the align the output in columns.
            System.out.printf(
                "%12d %12d %16.6f%n",
                numberOfContestants,
                numberOfRounds,
                elapsedTimeInSeconds
            );
        }

		System.out.println("Finished");
	}

}
//Final codepublic class ContestDriver2 {
    
