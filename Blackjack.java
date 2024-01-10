import java.util.Scanner;

public class Blackjack {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press Enter to begin!");
        scan.nextLine();

        int handValue = 0;
        //Getting the first and second random cards for the user
        int randomNumber1 = drawRandomCard();
        handValue += randomNumber1;
        String randomCard1 = cardString(randomNumber1);

        int randomNumber2 = drawRandomCard();
        handValue += randomNumber2;
        String randomCard2 = cardString(randomNumber2);
        System.out.println("\nYou get a \n" + randomCard1 + "\nand a \n" + randomCard2);

        System.out.println("Your total is: " + handValue);

        //Get two random cards for the dealer.
        int dealersHand = 0;
        int dealersNumber1 = drawRandomCard();
        dealersHand += dealersNumber1;
        String dealersCard1 = cardString(dealersNumber1);
        System.out.println("The dealer shows \n" + dealersCard1 + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");
        
        //Asking the player waether they want to 'hit' ot 'stay' and response accordingly based on their response
        while (true) {
            String hitOrStay = hitOrStay();
            if (hitOrStay.equals("hit")) {
                int randomNum = drawRandomCard();
                handValue += randomNum;
                String randomCard = cardString(randomNum);
                System.out.println("You get a \n" + randomCard);
                System.out.println("Your new total is: " + handValue);

                if (handValue > 21) {
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
            }
            else {
                break;
            }
        }

        //Displaying the dealers card for player
        int dealersNumber2 = drawRandomCard();
        dealersHand += dealersNumber2;
        String dealersCard2 = cardString(dealersNumber2);
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are \n" + dealersCard1 + "\nand a \n" + dealersCard2);

        //The dealer now draws card until the value of his hand is greater than 17
        while (dealersHand < 17) {
            int randomNum = drawRandomCard();
            dealersHand += randomNum;
            String randomCard = cardString(randomNum);
            System.out.println("Dealer gets a \n" + randomCard);
            System.out.println("Dealer's total is " + dealersHand);

            if (dealersHand > 21) {
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
        }

        if (handValue > dealersHand) {
            System.out.println("Player wins!");
        }
        else if (dealersHand > handValue) {
            System.out.println("Dealer wins!");
        }
        else {
            System.out.println("Tie");
        }

        scan.close();
    }

    /**
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
    */
    public static int drawRandomCard() {
        int random = (int) (Math.random() * 13 + 1);
        return random;
    }

    /**
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
    */
    public static String cardString(int cardNumber) {
        String card = " ";
        switch (cardNumber) {
            case 1:
                card = "   _____\n"+
                "  |A _  |\n"+ 
                "  | ( ) |\n"+
                "  |(_'_)|\n"+
                "  |  |  |\n"+
                "  |____V|\n";
                break;
            
            case 2: 
                card = "   _____\n"+              
                "  |2    |\n"+ 
                "  |  o  |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____Z|\n";
                break;
            
            case 3:
                card = "   _____\n" +
                "  |3    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____E|\n";
                break;
            
            case 4:
                card = "   _____\n" +
                "  |4    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  | o o |\n"+
                "  |____h|\n";
                break;

            case 5:
                card = "   _____ \n" +
                "  |5    |\n" +
                "  | o o |\n" +
                "  |  o  |\n" +
                "  | o o |\n" +
                "  |____S|\n";
                break;

            case 6:
                card = "   _____ \n" +
                "  |6    |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  |____6|\n";
                break;

            case 7:
                card = "   _____ \n" +
                "  |7    |\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |____7|\n";
                break;

            case 8:
                card = "   _____ \n" +
                "  |8    |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  |____8|\n";
                break;

            case 9:
                card = "   _____ \n" +
                "  |9    |\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |____9|\n";
                break;

            case 10:
                card = "   _____ \n" +
                "  |10  o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |___10|\n";
                break;
            
            case 11:
                card = "   _____\n" +
                "  |J  ww|\n"+ 
                "  | o {)|\n"+ 
                "  |o o% |\n"+ 
                "  | | % |\n"+ 
                "  |__%%[|\n";
                break;
            
            case 12:
                card = "   _____\n" +
                "  |Q  ww|\n"+ 
                "  | o {(|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%O|\n";
                break;
            
            case 13:
                card = "   _____\n" +
                "  |K  WW|\n"+ 
                "  | o {)|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%>|\n";
                break;
        }
        return card;
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'.
     *   3. Returns the user's option 
    */
    public static String hitOrStay() {
        System.out.println("Do you want to 'hit'(draw another card) or 'stay'(do nothing).");
        String input = scan.nextLine().toLowerCase();
        while (!input.equals("hit") && !input.equals("stay")) {
            System.out.println("Please write 'hit' or 'stay'.");
            input = scan.nextLine().toLowerCase();
        }
        return input;
    }
}

