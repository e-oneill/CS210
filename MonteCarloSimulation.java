import java.util.*;

public class MonteCarloSimulation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int t = 100000;
        long start = System.currentTimeMillis();
        int collisions = 0;
        sc.close();
        for (int r = 0; r < t; r++){
        //region ArrayList method
        List<Integer> pupils = new ArrayList<Integer>();
        Random rand = new Random();
        
            for (int i = 0; i < n; i++)
            {
                int innerCollisions = 0;
                int birthday = rand.nextInt(364);
                Integer integer = Integer.valueOf(birthday);

                if (pupils.contains(integer)){
                    innerCollisions++;
                    List<Integer> subPupils = new ArrayList<Integer>();
                    subPupils = pupils.subList(pupils.indexOf(integer)+1, pupils.size());
                    for (int j = 1; j <= x; j++)
                    {
                        if (innerCollisions >= x-1){
                            collisions++;
                            break;
                        }
                        if (subPupils.contains(integer)) {
                            innerCollisions++;
                        } else {
                            break;
                        }
                        subPupils = subPupils.subList(subPupils.indexOf(integer)+1, subPupils.size());
                    }
                    if (innerCollisions >=x-1 && collisions > 0)
                    {
                        innerCollisions = 0;
                        break;
                    }
                } 
                pupils.add(integer);
            }
        }

        float prob = (float)collisions / t;
        int probInt = Math.round(prob*100);
        System.out.println("After " + t + " tests we had " + collisions + " collisions, resulting in a probability of: " + probInt + "%");
        long time = System.currentTimeMillis() - start;
        double seconds = ((double) time) / 1000.00;
        System.out.println("Time to run: " + seconds + " seconds");
    }
}
