This is a game between two players: Both players simultaneously declare "one" or "two". Player 1 wins if the sum of the two declared numbers is odd and Player 2 wins if the sum is even. In either case the loser is obliged to pay the winner (in tokens) the sum of the two declared numbers. So Player 1 may have to pay 2 or 4 tokens but may win 3 tokens.

 
**Part 1: User vs Computer** The computer player will have a threshold variable, `t`. The computer will generate a random number between 0 and 1. If the number is greater than `t` the computer will declare "two" if the random number is less than `t` the computer will declare "one". 


**Part 2: Computer vs Computer Sim mode**
 Both players are computers in a simulated game, each with its own threshold (instance) variables `t` and and its own score (tokens won or lost so far in a session). This is to determine whether there is an advantage to be gained from being the odd player over the even player or vice versa. Advantage here  means that if enough games are played there is a strategy (threshold value) that one player can use that will guarantee positive average outcome regardless of the other player's strategy.