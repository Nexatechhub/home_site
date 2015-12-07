package com.test;
import java.io.*; // used to allow user to input data

public class SnakeLadder{
    
    
    public static void main (String [] args) throws IOException{
        
        BufferedReader myInput2 = new BufferedReader (new InputStreamReader (System.in));
        
        int counter= 100,iteration=-1; 
        System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------------------------------");
        
        while (counter > 0){// start while
            if (counter%10 == 0 && counter != 100){
                if(iteration==-1)
                {
                    counter-=9;
                    iteration=1;
                }
                else
                {
                    System.out.print(counter+"\t");
                    counter-=10;
                    iteration=-1; 
                }
                if(counter!=0)
                System.out.print("\n" + counter + "\t"); 
            }
            else
            System.out.print(counter + "\t"); 
            counter+=iteration; 
        }// end while
        System.out.println();
        
        
        
        
        String sGame = "y"; 
        
        System.out.print ("Do you want to play? Y or N     >  "); 
        sGame = myInput2.readLine (); 
        System.out.print ("\n\n\n\n\n\n");
        while (sGame.equals ("y") || sGame.equals ("Y"))
        {
            sGame = startGame(sGame); 
        }
        System.out.println ("Bad Luck");
        
        
    } 
    
    
    
    
    
    
    public static String startGame (String start) throws IOException 
    {// start startGame method
        
        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        
        int userPosition = 1; 
        int compPosition = 1; 
        int diceRoll = 0; 
        int diceRoll2 = 0; 
        int userRoll = 1; 
        int compRoll = 1; 
        String playAgain = "y"; 
        
        int snakesLaddersArray [] = new int [6];
        snakesLaddersArray [0] = 54;
        snakesLaddersArray [1] = 90;
        snakesLaddersArray [2] = 99;
        snakesLaddersArray [3] = 9;
        snakesLaddersArray [4] = 40;
        snakesLaddersArray [5] = 67;
        
        
        while (playAgain.equals ("y") || playAgain.equals ("Y")){
            
            
            // gets the dice roll for user and computer
            userRoll =  getDice(diceRoll, diceRoll2); 
            compRoll =  getDice(diceRoll, diceRoll2); 
            System.out.println ("\t\t\t\t\t\tYou Rolled a " + userRoll + "\t\t"); 
            System.out.println ("\t\t\t\t\t\tThe Computer Rolled a " + compRoll + "\t"); 
            
            userPosition = userPosition + userRoll;

            compPosition = compPosition + compRoll;
            
            
            
            userPosition = getP(userPosition, userRoll, snakesLaddersArray);
            compPosition = compgetP(compPosition, compRoll, snakesLaddersArray, userPosition);
            
            System.out.println ("\t\t\t\t\tYou Position " + userPosition + "\t\t\t"); 
            System.out.println ("\t\t\t\t\tThe Computer Position " + compPosition + "\t\t"); 
            
            if (userPosition == 100 || compPosition == 100)
            {
                userPosition = 1;
                compPosition = 1;
                System.out.print ("Do you want to play? Y or N     >  ");
                playAgain = myInput.readLine ();
                System.out.print ("\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            
            
            
        }
        
        return playAgain;   
        }
    
    public static int getDice (int diceRoll, int diceRoll2)
    {// start getDies class
        diceRoll = (int)(Math.random()*6 )+1 ; 
        diceRoll2 = (int)(Math.random()*6 )+1 ; 
        int move = diceRoll + diceRoll2; 
        return move; 
    }
    
    public static int getP (int userPosition, int userRoll, int snakesLaddersArray []) throws IOException // recieves two parameter from startGame
    {
        
        
        if(userPosition == snakesLaddersArray[0]) 
        {
            userPosition = 19; 
            System.out.println ("\t\t\t\tYou Got A Snake, GO DOWN");
        }
        else if (userPosition == snakesLaddersArray[1]) 
        {
            userPosition = 48; 
            System.out.println ("\t\t\t\\tYou Got Bit By A Snake, GO DOWN");
            
        }
        else if (userPosition == snakesLaddersArray[2]) 
        {
            userPosition = 77; 
            System.out.println ("\t\t\t\tYou Got  A Snake, GO DOWN");
        }
        else if (userPosition == snakesLaddersArray[3]) 
        {
            userPosition = 34; 
            System.out.println ("\t\t\t\tYou Got A Ladder!! GO UP");
            
        }
        else if (userPosition == snakesLaddersArray[4]) 
        {
            userPosition = 64; 
            System.out.println ("\t\t\t\tYou Got A Ladder GO UP");
            
        }
        else if (userPosition == snakesLaddersArray[5]) 
        {
            
            
            userPosition = 86; 
            System.out.println ("\t\t\t\tYou Got A Ladder GO UP");
        }
        
        if (userPosition < 0 || userPosition > 112) 
        {
            System.out.println ("An error has occured please reset the game!!!!!!");
        }
        
        else if (userPosition > 100)
        {
            userPosition = userPosition - userRoll; 
            System.out.println ("You cant jump, you must land on a 100"); 
            
        }
        else if (userPosition >= 100)
        {
            System.out.println ("YOU WON, GOOD JOB"); 
            
        }
        
        
        
        return userPosition; 
    }
    
    public static int compgetP (int compPosition, int compRoll, int snakesLaddersArray [], int userPosition) throws IOException
    {
        
    	 if(userPosition == snakesLaddersArray[0]) 
         {
             userPosition = 19; // set new position
             System.out.println ("\t\t\t\tYou Got A Snake, GO DOWN!");
         }
         else if (userPosition == snakesLaddersArray[1]) 
         {
             userPosition = 48; // set new position
             System.out.println ("\t\t\t\\tYou Got Bit By A Snake, GO DOWN");
             
         }
         else if (userPosition == snakesLaddersArray[2]) 
         {
             userPosition = 77; // set new position
             System.out.println ("\t\t\t\tYou Got  A Snake, GO DOWN");
         }
         else if (userPosition == snakesLaddersArray[3]) 
         {
             userPosition = 34; // set new position
             System.out.println ("\t\t\t\tYou Got A Ladder!! GO UP");
             
         }
         else if (userPosition == snakesLaddersArray[4]) 
         {
             userPosition = 64; // set new position
             System.out.println ("\t\t\t\tYou Got A Ladder GO UP");
             
         }
         else if (userPosition == snakesLaddersArray[5]) 
         {
             
             
             userPosition = 86; // set new position
             System.out.println ("\t\t\t\tYou Got A Ladder GO UP");
         }
        
        
        if (compPosition < 0 || compPosition > 112) 
        {
            System.out.println ("An error has occured for the computer, please reset the game!!!!!!");
        }
        
        else if (compPosition > 100) 
        {
            compPosition = compPosition - compRoll; // get old position
            System.out.println ("THE COMPUTER CAN'T JUMP!!! He must land on a 100"); // give message that the computer cant jump
            
        }
        else if (compPosition >= 100 && userPosition != 100)
        {
            System.out.println ("THE COMPUTER WON, YOU FAILED"); // print out that the computer won
            
        }
        
        return compPosition; 
    } // end compgetPy
}//end class