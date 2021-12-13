package Labs.Week9;
import java.util.*;

public class RecursiveBirthdayProbability {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        double prob = 0;
        if (people > 365)
        {
            prob = 1.000;
        }
        else if (people > 0) 
        {
            prob = 1d - recursiveNotSameBirthday(people);
            
        }

        double rounded = Math.round(prob * 1000) / 1000d;
        System.out.println(rounded);
        sc.close();
    }

    public static double recursiveNotSameBirthday(double people)
    {
        if (people == 1)
        {
            return 1d;
        }
        else 
        {
            return recursiveNotSameBirthday(people - 1) * (1 - (people-1)/365);
        }
    }
}
