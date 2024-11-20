

/*This class is very basic and simple.A player has a name and a chip and the only methods
in this class are the getters for the name and chip that are used by the other classes, 
and a simple win count.*/
public class Player {

	private String name;
    private String chip;
    private int wins;
    
    
    public Player(String aName,String aChip){
        name = aName;
        chip = aChip;
        wins = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public String getChip(){
        return chip;
    }
    
    public int getWins() {
    	return wins;
    }
	
    public void updateWins() {
    	wins++;
    }
	
}