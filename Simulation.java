/***************************************************\
*                                                   *
*  This class runs simulations to determine         *
*  whether or not the Odd-Even game is fair and if  *
*  not who has the advantage and what strategy      *
*  realizes that adavantage.                        *
*                                                   *
\***************************************************/

public class Simulation{
    
    public static void main(String[] args){
        
        Game sim;
        double currentMin = Integer.MAX_VALUE;// least tokensPerGame(inner loop)
        double p1MaxMin = Integer.MIN_VALUE; // largest currentMin 
        // double p2MaxMin = Integer.MIN_VALUE;  
        double tokensPerGame = 0;
        int numberOfGames = 100000;
        double optimalP1Threshold = 0;
        // double optimalP2Threshold = 0;
        
        //--------------Testing for Player 1's optimal threshold--------------//
        
        /*The code below determines Player 1's optimal threshold using a *
         * nested for loop structure to test different combinations of   *
         * thresholds to obtain the best case scenario for Player 1      */
        for (double t1 = 0.02; t1 < 1.0; t1 = t1 + 0.02){
            
            currentMin = Integer.MAX_VALUE;
            
            for (double t2 = 0.02; t2 < 1.0; t2 = t2 + 0.02){
                
                sim = new Game(t1, t2);
                sim.play(numberOfGames);
                tokensPerGame = (double) sim.getP1Score() / numberOfGames;
                
                if (tokensPerGame < currentMin){
                    
                    currentMin = tokensPerGame;
    
                }
                
            }
            
            if (currentMin > p1MaxMin){
                
                p1MaxMin = currentMin;
                optimalP1Threshold = t1;
                
            }
             
        }
        
        System.out.println("Player 1's optimal threshold is " 
                           + optimalP1Threshold);
        System.out.println("with a lowest possible average tokens per game of "
                           + p1MaxMin);
        
        /* Since the worst Player 1 can do with a threshold of about 0.58 is *
         * a positive number of tokens, it shows that the game is not fair   *
         * and Player 1 has the advantage. No matter what threshold Player 2 *
         * uses, Player 1 still wins a net positive number of tokens with    *
         * this optimal threshold.                                           */
        
        
        //--------------Testing for Player 2's optimal threshold--------------//
        
        /*The code below determines Player 2's optimal threshold using a *
         * nested for loop structure to test different combinations of   *
         * thresholds to obtain the best case scenario for Player 2      */
        
        /*
        for (double t2 = 0.02; t2 < 1.0; t2 = t2 + 0.02){
            
            currentMin = Integer.MAX_VALUE;
            
            for (double t1 = 0.02; t1 < 1.0; t1 = t1 + 0.02){
                
                sim = new Game(t1, t2);
                sim.play(numberOfGames);
                tokensPerGame = (double) sim.getP2Score() / numberOfGames;
                
                if (tokensPerGame < currentMin){
                    
                    currentMin = tokensPerGame;
    
                }
                
            }
            
            if (currentMin > p2MaxMin){
                
                p2MaxMin = currentMin;
                optimalP2Threshold = t2;
                
            }
             
        }
        
        System.out.println("Player 2's optimal threshold is " 
                           + optimalP2Threshold);
        System.out.println("with a lowest possible average tokens per game of "
                           + p2MaxMin);
        */
        /* It turns out Player 2's optimal threshold is also about 0.58.     *
         * However, even with this ideal threshold, Player 2's lowest        *
         * possible average tokens per game is negative which implies that   *
         * Player 2 is at a disadvantage and further confirms that the game  *
         * is unfair.                                                        */
        
    }
    
}