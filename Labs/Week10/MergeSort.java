package Labs.Week10;
import java.util.*;
public class MergeSort {

    public static void main(String[] args) {
        Random rand = new Random();
        String[] array10 = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        String[] array100 = new String[100];
        for (int i = 0; i < array100.length; i++)
        {
            array100[i] = randomStringGenerator();
        }

        String[] array1000 = new String[1000];
        for (int i = 0; i < array1000.length; i++)
        {
            array1000[i] = randomStringGenerator();
        }

        String[] array10000 = new String[10000];
        for (int i = 0; i < array10000.length; i++)
        {
            array10000[i] = randomStringGenerator();
        }

        String[] array100000 = new String[100000];
        for (int i = 0; i < array100000.length; i++)
        {
            array100000[i] = randomStringGenerator();
        }

        String[] arrayOED = new String[273000];
        for (int i = 0; i < arrayOED.length; i++)
        {
            arrayOED[i] = randomStringGenerator();
        }

        long start = System.currentTimeMillis();
        mergeSortArray(array10);
        long end = System.currentTimeMillis();
        System.out.println("Array of ten items carried out in: " + (end - start) + " milliseconds");

        // start = System.currentTimeMillis();
        // mergeSortArray(array100);
        // end = System.currentTimeMillis();
        // System.out.println("Array of 100 items carried out in: " + (end - start) + " milliseconds");

        // start = System.currentTimeMillis();
        // mergeSortArray(array1000);
        // end = System.currentTimeMillis();
        // System.out.println("Array of 1,000 items carried out in: " + (end - start) + " milliseconds");

        // start = System.currentTimeMillis();
        // mergeSortArray(array10000);
        // end = System.currentTimeMillis();
        // System.out.println("Array of 10,000 items carried out in: " + (end - start) + " milliseconds");

        // start = System.currentTimeMillis();
        // mergeSortArray(array100000);
        // end = System.currentTimeMillis();
        // System.out.println("Array of 100,000 items carried out in: " + (end - start) + " milliseconds");

        // start = System.currentTimeMillis();
        // mergeSortArray(arrayOED);
        // end = System.currentTimeMillis();
        // System.out.println("Array of the OED carried out in: " + (end - start) + " milliseconds");
    }

    public static String randomStringGenerator()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
    
        return generatedString;
    }

    public static void mergeSortArray(String[] array)
    {
        // for (int i = 0; i < array.length; i++)
        // {
        //     System.out.print(array[i] + " ");
        // }

        // System.out.println();

        recMergeSort(array, 0, array.length - 1);

        for (int i = 0; i < 8; i++)
        {
            System.out.print(array[i] + " (" + wordScore(array[i]) + ") ");
        }
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
            if (wordScore(array[first]) < wordScore(array[second]))
            {
                workSpace[worker++] = array[first++];
            }
            // else if (wordScore(array[first]) == wordScore(array[second]) && array[first].compareToIgnoreCase(array[second]) < 0 )
            // {
            //         workSpace[worker++] = array[first++];
            // }
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

    public static int wordScore(String word)
    {
        int score = 0;
        for (int i = 0; i < word.length(); i++)
        {
            score += word.charAt(i);
        }

        return score;
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
