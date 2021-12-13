package Labs.Week10;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        String[] array10 = {  "silver", "player", "test",  "revlis", "silver", "conundrum", "silver", "player", "test",  "revlis"};
        String[] array100 = new String[100];
        String[] array1000 = new String[1000];
        String[] array10000 = new String[10000];
        String[] array100000 = new String[100000];
        String[] arrayOED = new String[273000];

        for (int i = 0; i < array100.length; i++)
        {
            array100[i] = randomStringGenerator();
        }

        for (int i = 0; i < array1000.length; i++)
        {
            array1000[i] = randomStringGenerator();
        }

        for (int i = 0; i < array10000.length; i++)
        {
            array10000[i] = randomStringGenerator();
        }

        for (int i = 0; i < array100000.length; i++)
        {
            array100000[i] = randomStringGenerator();
        }

        for (int i = 0; i < arrayOED.length; i++)
        {
            arrayOED[i] = randomStringGenerator();
        }

        long start = System.currentTimeMillis();
        mergeSortArray(array10);
        long end = System.currentTimeMillis();
        
        System.out.println("Time to carry out array of 10 items: " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        mergeSortArray(array100);
        end = System.currentTimeMillis();
        System.out.println("Time to carry out array of 100 items: " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        mergeSortArray(array1000);
        end = System.currentTimeMillis();
        System.out.println("Time to carry out array of 1,000 items: " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        mergeSortArray(array10000);
        end = System.currentTimeMillis();
        System.out.println("Time to carry out array of 10,000 items: " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        mergeSortArray(array100000);
        end = System.currentTimeMillis();
        System.out.println("Time to carry out array of 100,000 items: " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        mergeSortArray(arrayOED);
        end = System.currentTimeMillis();
        System.out.println("Time to carry out array of the oxford dictionary: " + (end - start) + " milliseconds");
    }

    public static void mergeSortArray(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            // System.out.print(array[i] + " ");
        }

        // System.out.println();

        recMergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++)
        {
            // array[i] = rand.nextLong();
            // System.out.print(array[i] + " (" + stringScore(array[i]) + ") " );
        }
        // System.out.println();
    }

    public static String randomStringGenerator() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return generatedString;
    }



    public static int stringScore(String str)
    {
        int score = 0;
        for (int i = 0; i < str.length(); i++)
        {
            score += (int) str.charAt(i);
        }

        return score;
    }
    
    public static void merge(String[] array, int first, int second, int upperBound)
    {
        int worker = 0;
        int lowerBound = first;
        int mid = second -1;
        int size = upperBound - lowerBound+1;
        String[] workSpace = new String[size];

        while (first <= mid && second <= upperBound)
        {
            if (stringScore(array[first]) < stringScore(array[second]) )
            {
                workSpace[worker++] = array[first++];
            }
            else if (stringScore(array[first]) == stringScore(array[second])) 
            {
                int compareTo = array[first].compareTo(array[second]);
                // System.out.println("Two strings have the same score: " + array[first] + " & " + array[second] + " Compare to Result: " + compareTo);
                if (compareTo > 0)
                {
                    workSpace[worker++] = array[second++];
                }
                else 
                {
                    workSpace[worker++] = array[first++];
                }
            }
            else 
            {
                workSpace[worker++] = array[second++];
            }
        }

        while (first <= mid)
        {
            workSpace[worker++] = array[first++];
        }

        while (second <= upperBound)
        {
            workSpace[worker++] = array[second++];
        }

        for (int i = 0; i < size; i++)
        {
            array[lowerBound+i] = workSpace[i];
        }
    }

    public static void recMergeSort(String[] workSpace, int lower, int upper)
    {
        if (lower == upper) {
            return;
        }
        else {
            int mid = (lower + upper) / 2;
            recMergeSort(workSpace, lower, mid);
            recMergeSort(workSpace, mid+1, upper);

            merge(workSpace, lower, mid+1, upper);
        }
    }
}
