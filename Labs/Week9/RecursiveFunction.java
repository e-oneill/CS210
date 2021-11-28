
package Labs.Week9;
import java.util.*;
public class RecursiveFunction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextInt();
        sc.close();
        System.out.println(function(num));
    }

    public static long function(long num)
    {
        if (num == 1)
        {
            return 2;
        }
        else
        {
            return 4 * function(num - 1) - (3 * num);
        }
    }
}
