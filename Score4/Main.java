import java.util.Scanner;


/*In the main class the players enter their names, chips of their selection and the dimensions
of the board that they are going to play in.The names and chips are being assigned to 
the Player1 and Player2, the board is created after they enter the dimensions
and the game starts*/
public class Main {

	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("This is Score4");
		System.out.println("Please enter the name of the 1st player: ");
		String player1name = in.nextLine();
		System.out.println("Please enter the name of the 2nd player: ");
		String player2name = in.nextLine();
		

		
		
		
		
		/*In this part of the code i am asking the first player to select
		 a chip following with a small validity check.*/
		String chip1,chip2;
		boolean valid = true;
		
		System.out.println(player1name + " , please select a chip: ");
		chip1 = in.nextLine();
		if (!chip1.equals("o") && !chip1.equals("x"))
			                  valid = false;
		while(!valid) {
			valid = true;
			System.out.println("Incorrect input. Please select a chip(x or o): ");
			chip1 = in.nextLine();
			if (!chip1.equals("o") && !chip1.equals("x"))
		                      valid = false;
		}
		
		/*Based on the chip selection of the first player,the remaining chip
		 is assigned to the other player and a message about their selection is displayed*/
		if(chip1.equals("x")) {
			chip2 = "o";
			System.out.println(player2name + " , your chip is: o");
		}else {
			chip2 = "x";
			System.out.println(player2name + " , your chip is: x");
		}

		//The players are created
		Player player1 = new Player(player1name,chip1);
		Player player2 = new Player(player2name,chip2);
		
		
		/*In the following parts of the code, the players get asked to 
		 enter a number for the amount of rows and columns they want(between 4 and 15)
		 with a validity check.*/
		//The rows variable is assigned as 1 so the validity check loop starts.
		int rows=1;
		System.out.println("Please enter the number of rows(4-15): ");
		//Loop restarts if the input of the players doesn't comply with the bounds.
		while(rows<4 || rows>15) {
			
			//The input of the player.
			String input = in.nextLine();
			
			try {
				//The input is converted to integer to check if it complies with the bounds.
				rows = Integer.valueOf(input);
				if (rows<4 || rows>15)
					System.out.println("Incorrect input , enter a number between 4-15: ");
				//If the input isn't actually an integer but a string, aColumn is set as 0 so the loop restarts.
			}  catch (NumberFormatException e) {
				System.out.println("Incorrect input , enter a number between 4-15: ");
				rows = 1;
			}
		}
		
		//The columns variable is assigned as 1 so the validity check loop starts.
		int columns=1;
		System.out.println("Please enter the number of columns(4-15): ");
		//Loop restarts if the input of the players doesn't comply with the bounds.
		while(columns<4 || columns>15) {
			
			//The input of the player.
			String input = in.nextLine();
			
			try {
				//The input is converted to integer to check if it complies with the bounds.
				columns= Integer.valueOf(input);
				if (columns<4 || columns>15)
					System.out.println("Incorrect input , enter a number between 4-15: ");
					
			//If the input isn't actually an integer but a string, aColumn is set as 0 so the loop restarts. 
			}  catch (NumberFormatException e) {
				System.out.println("Incorrect input , enter a number between 4-15: ");
				columns = 1;
			}
		}
		
		
		//The board and the game is created.
        Board gboard = new Board(rows,columns);
		Game game = new Game(player1,player2,gboard);
        
		game.startGame();
		
		/*After the first game is completed, the players are being asked 
		 if the want to play again and while the answer is YES the game is being restarted.*/
		String answer;
		do {
		  System.out.println(player1.getName()+ "'s wins: "+ player1.getWins() + "     " + player2.getName()+ "'s wins: "+ player2.getWins());
		  System.out.println("Do you want to play again?(YES/NO)");
		  answer = in.nextLine();
		  while(!answer.equals("YES") && !answer.equals("NO")) {
			  System.out.println("Incorrect answer. Do you want to play again?(YES/NO)");
			  answer = in.nextLine();
		  }
		  if(answer.equals("YES")) {
			  gboard.clearBoard();
			  game.startGame();
		  }else
			  break;
		}while(answer.equals("YES")); 
		
		
		
		in.close();
      
	}

}