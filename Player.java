/***************************************************\
*                                                   *
*  This class represents a computer player in the   *       
*  the Odd-Even Game                                *
*                                                   *
\***************************************************/
 
public class Player{ 
    
    // Instance variables
    private double t;    
    private int score;    
    
    // Constructor
    public Player(double threshold){
        
        t=threshold;        
        score=0;
        
    }    
    
    // Play method for part 1: interactive game
    public int play(){
        
        if (Math.random() < t){
            
            System.out.println("Computer declared 1");
            return 1;
            
        }
        
        else{
            
            System.out.println("Computer declared 2");
            return 2;
            
        }
        
    }
    
    /* Play method for part 2: simulation                          *
     * This is basically the same as the play method above but     *
     * without the print statements to ensure smoother simulations */ 
    public int simPlay(){
        
        if (Math.random() < t){
            
            return 1;
            
        }
        
        else{
            
            return 2;
            
        }
        
    }
    
    // Accessor method for the current score (number of tokens)
    public int getScore(){
        
        return score;
        
    }
    
    // Mutator method for adding tokens
    public void increaseScore(int winnings){
        
        score = score + winnings;
        
    }
    
    // Mutator method for subtracting tokens
    public void decreaseScore(int tokensLost){
        
        score = score - tokensLost;
        
    }
    
}