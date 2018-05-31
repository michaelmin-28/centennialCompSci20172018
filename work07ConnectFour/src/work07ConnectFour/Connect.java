package work07ConnectFour;

public class Connect {

	public static void main(String[] args) {
		System.out.println("Welcome to Connect Four! Player one, your tokens will be");
		System.out.println("denoted with the number '1', while player two's tokens ");
		System.out.println("will be denoted with the number '2'. Good luck! ");
		Board play = new Board();
		System.out.println();
		System.out.println(play.boardBuilder());
		int counter = 1;
		while(play.boardCheck() == 0) {
			if (counter % 2 == 1) {
				System.out.println("Player One's turn. ");
				int input = play.getPlay();
				while (!play.validInput(input)) {
					System.out.println("That's invalid. Please place another token. ");
					System.out.println(play.boardBuilder());
					input = play.getPlay();
				}
				play.boardChange(input, counter);
				System.out.println(play.boardBuilder());
			}
			else {
				System.out.println("Player Two's turn. ");
				int input = play.getPlay();
				while (!play.validInput(input)) {
					System.out.println(play.boardBuilder());
					System.out.println("That's invalid. Please place another token. ");
					input = play.getPlay();
				}
				play.boardChange(input, counter);
				System.out.println(play.boardBuilder());
			}
			counter += 1;
			if (counter % 2 == 0) {
				counter = 2;
			}
			else {
				counter = 1;
			}
		}
		System.out.println("Congratulations to Player " + play.boardCheck() + "!");
		play.closeScanner();
	}
}
	
