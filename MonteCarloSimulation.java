import java.util.*;

public class MonteCarloSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int t = 100000;
        int collisions = 0;
        sc.close();
        for (int r = 0; r < t; r++){
        //region Array method
        // int[] pupils = generateRandomBirthdays(n);

        //     for (int b = 0; b < pupils.length; b++)
        //     {
        //         int innerCollisions = 0;  
        //         for (int j = 1; j < pupils.length; j++)
        //         {
                  
        //             if (pupils[j] == pupils[b] && b != j)
        //             {
        //                 innerCollisions++;
        //                 break;
        //             }
                    
        //         }
        //         if (innerCollisions > 0){
        //             collisions += innerCollisions;
        //             break;
        //         }

        //     }
        // endregion;
        
        //region HashSet method
        Set<Integer> pupils = new HashSet<Integer>();
        Random rand = new Random();
        int innerCollisions = 0;
            for (int i = 0; i < n; i++)
            {
                int birthday = rand.nextInt(364);
                Integer integer = Integer.valueOf(birthday);
                if (pupils.contains(integer)){
                    innerCollisions++;
                    if (innerCollisions >= x-1){
                        innerCollisions = 0;
                        collisions++;
                        break;
                        }
                } 
                pupils.add(integer);
            }
        

        }

        float prob = (float)collisions / t;
        int probInt = (int) (prob*100);
        System.out.println("After " + t + " tests we had " + collisions + " collisions, result in probability of: " + probInt + "%");
    }

    public static int[] generateRandomBirthdays(int n)
    {
        int[] pupils = new int[n];
        Random rand = new Random();

        for (int i = 0; i < pupils.length; i++)
        {
            pupils[i] = rand.nextInt(364);
            // System.out.print(pupils[i] + " ");
        }
        return pupils;
    }

}
