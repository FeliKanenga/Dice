import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Please enter the numbers 6 or 10 ");
            input = scanner.nextLine();

            if( numberValidation(input) && Integer.parseInt(input) == 6){
                Die dice = new Die(Integer.parseInt(input), 1,1,1,1,1,2);

                dice.roll();
                System.out.println("Initial value: " );
                DiceFactory.makeDie(Integer.parseInt(input));


                //changing probabilities of dice object, this should favour number 2
                dice.setProbabilities(1,4,1,1,1,1);
                dice.roll();
                System.out.println("Value after new probabilities : " );
                DiceFactory.makeDie(Integer.parseInt(input));


            }
            else if(numberValidation(input) && Integer.parseInt(input) == 10){

                Die dice = new Die(Integer.parseInt(input), 1,1,1,1,1,2,1,1,1,1);
                dice.roll();
                DiceFactory.makeDie(Integer.parseInt(input));

                System.out.println("Initial die value: " + dice.value);




            }
            else {
                System.out.println("Only integer values allowed and value must either be 6 or 10!");
            }
        }while (!numberValidation(input));

    }
    public static boolean numberValidation(String input){
        boolean bool = false;
        try{
            if(Integer.parseInt(input) == 6 || Integer.parseInt(input) == 10){
                bool = true;
            }
        }catch (NumberFormatException ex){
            bool = false;
        }
        return bool ;
    }
}

