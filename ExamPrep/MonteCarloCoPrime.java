package ExamPrep;
import java.util.*;

public class MonteCarloCoPrime {
    public static void main(String[] args) {
        int tests = 200000;
        Random rand = new Random();
        int matches = 0;

        for (int i = 0; i < tests; i++)
        {
            int upperBound = 500000;
            int x = rand.nextInt(upperBound);
            int y = rand.nextInt(upperBound);
            
            // x = 12;
            // y = 49;
            boolean coPrime = true;
            for (int j = 2; j < Math.sqrt(Math.max(x, y)); j++)
            {
                if (x % j == 0 && y % j == 0)
                {
                    coPrime = false;
                    break;
                }
            }
            
            if (coPrime == true)
            {
                matches++;
            }
            // System.out.println(x + " " +y + " " + coPrime + " " + matches);

        }
        
        int prob = Math.round(((float) matches / tests) * 100);
        System.out.println(prob);
    }

    
}
