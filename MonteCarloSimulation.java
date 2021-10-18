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
        List<Integer> pupils = new ArrayList<Integer>();
        Random rand = new Random();
        
            for (int i = 0; i < n; i++)
            {
                int innerCollisions = 0;
                int birthday = rand.nextInt(364);
                Integer integer = Integer.valueOf(birthday);

                if (pupils.contains(integer)){
                    innerCollisions++;
                
                    for (int j = 1; j <= x; j++)
                    {
                        if (innerCollisions >= x-1){
                            
                            collisions++;
                            // System.out.println("Collision found " + integer);
                            // pupils.add(integer);
                            break;
                        }
                        List<Integer> subPupils = new ArrayList<Integer>();
                        subPupils = pupils.subList(pupils.indexOf(integer)+1, pupils.size());
                        if (subPupils.contains(integer)) {
                            innerCollisions++;
                        } else {
                            break;
                        }
                    }
                    if (innerCollisions >=x-1 && collisions > 0)
                    {
                        innerCollisions = 0;
                        break;
                    }
                } 
                pupils.add(integer);
            }
        
            // System.out.println(pupils.toString());
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
