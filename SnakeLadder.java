public class SnakeLadder{
	static final int initialPosition = 0;
    	static final int winingPosition = 100;
    	static final int ladder = 1;
    	static final int snake = 2;
    	static int playPosition = 0;
    	static int player1Position = 0;
    	static int player2Position = 0;
    	static int chance = 0;
    	public static void main(String[] args) {
        	switchPlayer();
    	}

      	static void CheckForOption() {
		int rollDice = (int) Math.floor(Math.random() * 6 + 1);
        	int checkForOption = (int) Math.floor(Math.random() * 10) % 3;
        	if (checkForOption == ladder) {
            		playPosition = playPosition + rollDice;
        	} 
		else if (checkForOption == snake) {
            		playPosition = playPosition - rollDice;
                	chance = chance + 1;
            	}
         	else {
            		playPosition = playPosition;
            		chance = chance + 1;
        	}

        	if (playPosition < initialPosition) {
            		playPosition = initialPosition;
        	} 
		else if (playPosition == winingPosition) {
            		playPosition = winingPosition;
        	} 
		else if (playPosition > winingPosition) {
            		playPosition = playPosition-rollDice;
        	}
    	}

    	static void switchPlayer() {
        	while (player1Position < winingPosition && player2Position < winingPosition) {
            		if (chance % 2 == 0) {
                		playPosition = player1Position;
                		CheckForOption();
                		player1Position = playPosition;
                		if (playPosition == winingPosition) {
                    			System.out.println("player 1 won");
                		}
            		} 
			else {
                		playPosition = player2Position;
                		CheckForOption();
                		player2Position = playPosition;
                		if (player2Position == winingPosition) {
                    			System.out.println("player 2 won");
                	}
            	}
        }
    }
}