import java.util.*;
public class Lab3 {
    public static void main(String[] args) {
        //Question: Input Int N
        //If N is Prime, return the distance to the subsequent prime number
        //Otherwise, return distance to preceding and subsequent prime numbers
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        //defining the boolean array. 21 is added to num as the largest gap between two primes in the working set is 20. 
        boolean[] primes = new boolean[num+21];
        //this method fills the array with false, where the number is not a prime
        primes = getPrimes(primes);
        //if num is not prime, find the previous
        if (!isPrime(num, primes)) { 
            int prevPrime = findPreviousPrime(num, primes);
            System.out.println(prevPrime);
        }
        int nextPrime = findSubsequentPrime(num, primes);
        System.out.println(nextPrime);
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

    public static boolean isPrime(int num, boolean[] arr)
    {
        if (arr[num] == true)
        {
            return true;
        }
        return false;
    }

    public static int findPreviousPrime(int num, boolean[] arr)
    {
        for (int i = num; i>=2;i--)
        {
            if (arr[i] == true)
            {
            return i;
            }
        }
        return -1;
    }

    public static int findSubsequentPrime(int num, boolean[] arr)
    {
        for (int i = num+1; i < arr.length;i++)
        {
            if (arr[i] == true)
            {
            return i;
            }
        }
        return -1; 
    } 
}
