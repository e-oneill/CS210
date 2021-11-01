import java.util.*;

public class MonteCarloSimulation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int x = sc.nextInt() - 1;
        final int t = 177000;
        // long start = System.currentTimeMillis();
        int collisions = 0;
        // sc.close();
        Random rand = new Random();
        if (x == 0)
        {
            System.out.println("100");
        }
        else if (n == 0)
        {
            System.out.println("0");
        }
        else
        {
            for (int r = 0; r < t; r++)
            {
            //region ArrayList method
            // List<Integer> pupils = new ArrayList<Integer>();
            int[] pupils = new int[365];
            
                for (int i = 0; i < n; i++)
                { 
                    Integer integer = rand.nextInt(364);
                    pupils[integer]++;
                    if (pupils[integer] == x+1) 
                    {
                        collisions++; 
                        break;
                    }
                    
                    // if (pupils.contains(integer))
                    // {
                    //     if (Collections.frequency(pupils, integer) >= x) 
                    //     {
                    //         collisions++;
                    //         break;
                    //     }
                    // }
                    // pupils.add(integer);
                }
            }
            // float prob = ;
        System.out.println(Math.round(((float) collisions / t) * 100));
        }
        
        

    }
}
