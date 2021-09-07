/***************************************************\
*                                                   *
*  This class represents both the interactive and   *       
*  simulation versions of the Odd-Even Game         *
*                                                   *                     
\***************************************************/

import java.util.Scanner;

public class Game{
    
    // Instance variables for part 1: interactive game
    private Scanner humanInput;
    private Player Comp;
    private int humanDecision; // 1 - odd; 2 - even
    private int compNumber; // Computer Player's declared number
    private int humanNumber; // Human Player's declared number
    private int humanScore; // Human Player's score
    
    // Instance variables for part 2: simulation
    private Player P1;
    private Player P2;
    private int p1Number;
    private int p2Number;
    
    // Game constructor for part 1: interactive game
    public Game(){
   
        Comp = new Player(0.5);
        humanInput = new Scanner(System.in);
        humanDecision = 0;
        humanNumber = 0;
        compNumber = 0;
        humanScore = 0;
        
    }
    
    /* Game constructor for part 2: simulation     *
     * Takes 2 doubles as parameters which set the *
     * initial thresholds for the computer players */
    public Game (double t1, double t2){
       
        P1 = new Player(t1);
        P2 = new Player(t2);
        p1Number = 0;
        p2Number = 0;
        
    }
    
    /* Play method for part 1: interactive game  *
     * Plays one interactive version of the game *
     * with the option for multiple rounds       */
    public void play(){
        
        humanDecide();
        
        int anotherRound = 1;
        
        while (anotherRound == 1){
        
        System.out.println("Enter 1 to declare one or 2 to declare two");
            
        humanNumber = humanInput.nextInt();
        compNumber = Comp.play();
        determineWinner();
            
        System.out.println("Enter 1 - another round or 2 - game over");
            
        anotherRound = humanInput.nextInt();
            
        }
        
        if (humanScore > Comp.getScore()){
            
            System.out.println("You win");
            
        }
        
        else if (humanScore < Comp.getScore()){
            
            System.out.println("You lose");
            
        }
        
        else{
            
            System.out.println("Draw");
            
        }
        
    }
    
    
    /* Play method for Part 2: simulation                      *
     * Takes a single int as a parameter signifying the number *
     * of computer vs. computer games that should be played    */
    public void play(int games){
        
        for(int i = 1; i <= games; i++){
            
            p1Number = P1.simPlay();
            p2Number = P2.simPlay();
            
            determineCompWinner();
            
        }
        
    }

    /* Accessor method for Player 1's current *
     * score (number of tokens) in part 2     */ 
    public int getP1Score(){
        
        return P1.getScore();
        
    }
    
    /* Accessor method for Player 1's current *
     * score (number of tokens) in part 2     */ 
    public int getP2Score(){
        
        return P2.getScore();
        
    }  
    
    
    //------------------------Private helper methods-------------------------//
    
    /* This method redistributes the tokens after   *
     * each round of the interactive game in part 1 */
    private void determineWinner(){
        
        int sum = compNumber + humanNumber;
        System.out.println("Sum is " + sum);
        
        boolean humanWin = (humanDecision == 2 && sum % 2 == 0) || 
                           (humanDecision == 1 && sum % 2 != 0);
        
        if (humanWin){
         
                System.out.println("Computer gives you " + sum + " tokens");
            
                humanScore = humanScore + sum;
                Comp.decreaseScore(sum);
            
        }
        
        else{
            
                System.out.println("You give Computer " + sum + " tokens");
            
                humanScore = humanScore - sum;
                Comp.increaseScore(sum);
            
        }
        
        System.out.println("Your current total is " + humanScore);
        System.out.println("Computer's current total is " + Comp.getScore());
        
    }
    
    /* This method redistributes the tokens after   *
     * each simulated game played in part 2         */
    private void determineCompWinner(){
        
        int sum = p1Number + p2Number;
        
        if (sum % 2 != 0){
            
            P1.increaseScore(sum);
            P2.decreaseScore(sum);
            
        }
        
        else{
            
            P1.decreaseScore(sum);
            P2.increaseScore(sum);
            
        }
        
    }
    
    /* This method records the decision of the human *
     * player to be either even or odd in part 1     */
    private void humanDecide(){
        
        System.out.println("Select 1-odd or 2-even");
        
        humanDecision = humanInput.nextInt();
        
        if (humanDecision == 1){
            
            System.out.println("You're odd, Computer will be even");
            
        }
        
        else{
            
            System.out.println("You're even, Computer will be odd");
            
        }
     
    }
    
}