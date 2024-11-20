

/*This class is made to create the board,display it, modify it, check if the board or a column is full
and check for a winner.*/
public class Board {

    private int rows;
    private int columns;
    private String[][] board;
    
    
    private static final int TO_WIN = 4;
    
    public Board(int numRows,int numColumns){
        rows = numRows;
        columns = numColumns;
        board = new String[rows][columns];   
        
        //the symbol "-" is going to represent an empty space.
        for (int i = 0;i < rows;i++) {
        	for(int j = 0;j < columns; j++) {
        		board[i][j] = "-";
        	}
        }
    }
    
    
    //This method displays the board
    public void printBoard() {
    	
    	for (int i = 0;i < rows;i++) {
    		System.out.print("| ");
        	for(int j = 0;j < columns; j++) {
        		System.out.print(board[i][j] + " ");
        		if (j == columns-1)
        			System.out.println("|");
        	}
        }
    	
    	for(int j = 0;j < columns + 10;j++) {
    		System.out.print("-");
    	}
    	System.out.println("");
    	
    	
    	System.out.print("  1 ");
    	for(int j = 1;j < columns; j++) {
    		System.out.print(j+1 + " ");
    	}
    	System.out.println("");
    }
    
    
    
    //A simple getter method.
    public int getColumns(){
        return columns;
    }
    
    
    
  
    //This method returns true if the column is full.
    public boolean columnIsFull(int aColumn){
        
    	//If the top of the column is empty, then the column isn't full.
        if(board[0][aColumn].equals("-"))
            return false;
        else 
            return true;
        
        
    }
    
    
    
    
    //This method returns true if the board is full.
    public boolean boardIsFull(){
        
    	//If any element of the first row is empty, then the board isn't empty.
        for(int j = 0;j < columns;j++){
                if(board[0][j].equals("-"))
                    return false;
        }
        return true;
        
    }
    
    
    
    /*This method is checking for a winner and returns true if there are 4 identical chips in a row
     horizontally,vertically or diagonally*/
    public boolean checkForWinner(Player aPlayer){
        String chip = aPlayer.getChip();    
        
        
        //Looking for 4 identical chips in a row horizontally.
        for (int i = rows-1;i>=0;i--){
            int inarow = 0;
            for (int j = 0;j<columns;j++){
                if(board[i][j].equals(chip)) {
                    inarow++;
                    if (inarow == TO_WIN)
                    	return true;
                }else
                	inarow = 0;
            }   
        }
        
      //Looking for 4 identical chips in a row vertically.
        for (int j = columns-1;j>=0;j--){
            int inarow = 0;
            for (int i = 0;i<rows;i++){
                if(board[i][j].equals(chip)) {
                    inarow++;
                    if (inarow == TO_WIN)
                    	return true;
                }else
                	inarow = 0;
            }
        }
        
        
        
        
        
      //Looking for 4 identical chips in a row diagonally to the right.
        for(int x = 3; x < rows; x++ ){
            for(int z = 0; z < columns-3;z++) {
            	int inarow = 0;
            	for(int i = 0; i < 4;i++) {
            		if(board[x-i][z+i].equals(chip))
            			inarow++;
            		else 
            			break;
            		if (inarow == TO_WIN)
                        return true;
            	}
            }
        }
        
        
      //Looking for 4 identical chips in a row diagonally to the left.
        for(int x = 3; x < rows; x++ ){
            for(int z = columns - 1; z > 2;z--) {
            	int inarow = 0;
            	for(int i = 0; i < 4;i++) {
            		if(board[x-i][z-i].equals(chip))
            			inarow++;
            		else 
            			break;
            		if (inarow == TO_WIN)
                        return true;
            	}
            }
        }
        
        
        
        
        return false;
    }
    
    
    
    /*This method updates the board by dropping a chip 
     of the player to the selected column.*/
    public void dropChip(Player aPlayer,int aColumn){
        
        String chip = aPlayer.getChip();
        
        
        for(int i = rows-1;i>=0;i--){
            if(board[i][aColumn].equals("-")){
                board[i][aColumn] = chip;
                break;
            }
        }
        
        
    }
    
    
    
    //This method clears the board in case the players want to replay the game.
    public void clearBoard() {
    	
        for (int i = 0;i < rows;i++) {
        	for(int j = 0;j < columns; j++) {
        		board[i][j] = "-";
        	}
        }
        
    }
	
    
}