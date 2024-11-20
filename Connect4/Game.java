import java.util.Random;
import java.util.Scanner;




//The main logic of the game is in this class inside the startGame method. 
class Game {
	private Player player1;
	private Player player2;
	private Board board;
	private Player currentPlayer;

	
	public Game(Player player1,Player player2,Board board) {
	     this.player1 = player1;
	     this.player2 = player2;
	     this.board = board;
	     //Player1 is assigned temporarily.
		currentPlayer = player1 ;
	}
	
	//This method basically starts the game.
    public void startGame(){
        
        Scanner in = new Scanner(System.in);
        /*A random number between 0 and 1 is generated. If the generated number is 0,
	      then the first player is starting.Else the second player is starting.*/
	 	Random random = new Random();
		currentPlayer = (random.nextInt(2) == 0) ? player1 : player2;
        
        //The gameIsOn variable determines if the game is over or not.
    	boolean gameIsOn = true;
    	//While gameIsOn is true the loop restarts.
    	while(gameIsOn){
    	    
    	    //The board is displayed at the start of every round.
    	    board.printBoard();
    	    
    	    //The current player is called to enter the number of the column that he wants to drop his chip.
    	    System.out.println(currentPlayer.getName() + ", your turn. Select column: ");
    	    //aColumn is set to 0 to get inside the loop that will check the validity of the input.
    	    int aColumn = 0;
    	    //While the input inside the loop doesn't comply with the bounds or isn't valid, the loop restarts.
	     	while(aColumn<1 || aColumn>board.getColumns()) {
			    
	     		//The input of the player.
		    	String input = in.nextLine();
		    	//The valid variable shows the validity state of the input.
			    boolean valid = true;
			    try {
			    	//The input is converted to integer to check if it complies with the bounds.
			    	aColumn = Integer.valueOf(input);
			     	if (aColumn<1 || aColumn>board.getColumns()){
					    System.out.println("Incorrect input , enter a number between 1-" + board.getColumns() + ": ");
					    valid = false;
			     	}
			     	//If the input isn't actually an integer but a string, aColumn is set as 0 so the loop restarts. 
				}  catch (NumberFormatException e) {
			    	    System.out.println("Incorrect input , enter a number between 1-" + board.getColumns() + ": ");      
			    	    aColumn = 0;
			    	    valid = false;
		    	}
		    	
		    	
			    //If the input is valid but the column is full, aColumn becomes 0 and the loop restarts.
		     	if(valid && board.columnIsFull(aColumn-1)){
		             System.out.println("This column is full. Please select another column: ");
		    	     aColumn = 0;
		        }
		    	
		     	
		   }
		   
		   //The validity check is over so the board is updated.
	       //aColumn-1 so i am inside the bounds of the table.
		   board.dropChip(currentPlayer,aColumn-1);
		   

		   /* After updating the board, the following checks are made:
		   1. If the current player wins, the game ends.
		   2. If the board is full and no winner is found, it's a draw, and the game ends.
		   3. If no winner and the board is not full, the turn switches to the other player. */

		   if(board.checkForWinner(currentPlayer)){
		       System.out.println("Congratulations " + currentPlayer.getName() + ",you won!");
		       currentPlayer.updateWins();
		       gameIsOn = false;
		   }else if(board.boardIsFull()){
		       System.out.println("Draw.The board is full.");
		       gameIsOn = false;
		   }else {
		       currentPlayer = (currentPlayer.getName().equals(player1.getName())? player2 : player1);
		   }
		   
		   
		   
    	   
    	}
    
    	
    	
    }
    		
    
    
   
    
}


