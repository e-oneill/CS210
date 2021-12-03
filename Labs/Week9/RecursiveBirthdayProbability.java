package Labs.Week9;
import java.util.*;

public class RecursiveBirthdayProbability {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double people = sc.nextDouble();
        double rounded = 0;
        if (people > 365)
        {
            rounded = 1;
        }
        else if (people > 0) 
        {
            double prob = 1d - recursiveBirthday(people);
            rounded = Math.round(prob * 1000) / 1000d;
        }

        
        System.out.println(rounded);
        sc.close();
    }

    public static double recursiveBirthday(double people)
    {
        if (people == 1)
        {
            return 1d;
        }
        else 
        {
            return recursiveBirthday(people - 1) * (1 - (people-1)/365);
        }
    }
}
