import java.util.*;

public class Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int endCap = 8000;
        int endCap = sc.nextInt();
        boolean[] primes = new boolean[endCap+1];
        primes = getPrimes(primes);
        printPrimes(primes);
    }

    public static boolean[] getPrimes(boolean[] arr)
    {
        //start at 2, and set all values to true
        for (int i = 2; i < arr.length; i++)
        {
            arr[i] = true;
        }
        //outer loop starts at i and goes to the square root of the upper bound of the array.
        // Must subtract 1 from array length, as the array starts at 0. 
        for (int i = 2; i <= Math.sqrt((double) (arr.length-1)); i++)
        {
            //inner loop starts at i*2 and then iterates through array adding i to j and marking every multiple of i as Prime=false;
            for (int j = i*2; j < arr.length; j = j+i)
            {
                arr[j] = false;
            }
        }
        return arr;
    }

    public static void printPrimes(boolean[] arr)
    {
        int gap = 0;
        int lastPrime = 2;
        for (int i = 2; i < arr.length;i++)
        {
            if (arr[i] == true)
            {
            if (i - lastPrime > gap) gap = i - lastPrime;
            lastPrime = i;
            System.out.println(i);
            }
        }
        System.out.println(gap);
    }
}
