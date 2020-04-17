public class DiceFactory {

    DiceFactory(){
    }
    static void makeDie(int sides){
        int value;

        value = (int) (Math.random()*sides + 1);
        System.out.println("Your lucky number = " + value);
    }

}