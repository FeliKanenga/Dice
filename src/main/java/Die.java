import java.util.ArrayList;
import java.util.Scanner;

public class Die {
    int sides;
    int value;
   int [] probabilities;

   //constructor
   public Die (int dieSides, int ... probabilities){
        this.sides = dieSides;
        this.probabilities = probabilities;
    }

    public void roll(){

        //probabilities will apply only if each value on a die is represented
        if(sides == probabilities.length) {
            int sum = 0;
            for (int i : probabilities) {
                    sum += i ;
            }
            if(sum == 0) {
                System.out.println("probability sum must be greater than 0");
            }

            // double used to work as a fraction
            ArrayList<Double> probabilityWeight = new ArrayList<>();

            // checking for negative numbers and adding onto the ArrayList
            for (int x=0; x < probabilities.length ; x++){
                int currentValue = probabilities[x];
                if(currentValue < 0){
                    System.out.println("negative probabilities are not allowed");
                }
                if( x > 0){
                    probabilityWeight.add( currentValue / sum + probabilityWeight.get(x-1));
                }else {
                    probabilityWeight.add((double) (currentValue / sum));
                }
            }

            // declaring random variable to generate numbers

            double random = Math.random();

            ArrayList <Integer> number = new ArrayList<>();

            // new Array of probability

            for(int j = 1 ; j <= sides ; j++){
                number.add(j);
            }
            for(int k = 0 ; k < probabilityWeight.size() ; k++){
                if(random < probabilityWeight.get(k)){
                    value = number.get(k);
                    break;
                }
            }
        }else {
            value = (int) (Math.random()*sides + 1);
        }
    }

    // new probabilities
    public int [] setProbabilities(int ... newProbability){
        probabilities = newProbability;
        return newProbability;
    }
}
