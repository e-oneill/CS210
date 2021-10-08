import java.util.*;
public class LCM2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] nums = new long[3];

        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = sc.nextLong();
            if (nums[i] < 0)
            {
                nums[i] = nums[i] * - 1;
            }
        }
        sc.close();
        nums = bubbleSort(nums);

        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0)
        {
            System.out.println("0");
        }
        else if (nums[0] == 0 || nums[1] == 0 || nums[2] == 0)
        {
            System.out.println("NA");
        }
        else
        {
            long lcm = getLowestCommonMultiple(nums[2], getLowestCommonMultiple(nums[1], nums[0]));
            System.out.println(lcm);
        }
    }

    public static long getLowestCommonMultiple(long a, long b)
    {
        long gcd = getGreatestCommonDivisor(a, b);

        return (a*b) / gcd;
    }

    public static long getGreatestCommonDivisor(long a, long b)
    {
        if (b == 0) return a;
        else return (getGreatestCommonDivisor(b, a%b));
    }

    public static long[] bubbleSort(long[] arr)
    {
        int leng = arr.length;

        for (int i = 0; i < leng -1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < leng - i - 1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    long temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
        }
        return arr;
    }
}
