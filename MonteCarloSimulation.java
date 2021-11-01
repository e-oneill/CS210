import java.util.*;

public class MonteCarloSimulation {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int t = 13000;
        // long start = System.currentTimeMillis();
        int collisions = 0;
        sc.close();
        if (x == 1){
            System.out.println("100");
        }
        else {
        for (int r = 0; r < t; r++){
        //region ArrayList method
        List<Integer> pupils = new ArrayList<Integer>();
        Random rand = new Random();
            for (int i = 0; i < n; i++)
            { 
                int innerCollisions = 0;
                Integer integer = rand.nextInt(364);
                if (pupils.contains(integer)){
                    innerCollisions++;
                    if (innerCollisions >= x-1) { collisions++; break;}
                    List<Integer> subPupils = new ArrayList<Integer>();
                    for (int j = 1; j <= x ; j++)
                    {
                        if (subPupils.size() == 0) {subPupils = pupils.subList(pupils.indexOf(integer)+1, pupils.size());}
                        if (subPupils.contains(integer)) {
                            innerCollisions++;
                        } else {
                            break;
                        }
                        if (innerCollisions >= x-1){
                            collisions++;
                            break;
                        }
                        subPupils = subPupils.subList(subPupils.indexOf(integer)+1, subPupils.size());
                    }
                    if (innerCollisions >=x-1)
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
        System.out.println(probInt);
        }
        // System.out.println("Raw probability:" + prob);
        // long time = System.currentTimeMillis() - start;
        // double seconds = ((double) time) / 1000.00;
        // System.out.println("Runtime: " + seconds + " seconds");
    }
}
