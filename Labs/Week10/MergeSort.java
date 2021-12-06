package Labs.Week10;
import java.util.*;
public class MergeSort {

    public static void main(String[] args) {
        Random rand = new Random();
        long[] array = new long[8];
        for (int i = 0; i < 8; i++)
        {
            array[i] = rand.nextInt(1000);
            System.out.print(array[i] + " ");
        }

        System.out.println();

        recMergeSort(array, 0, 7);

        for (int i = 0; i < 8; i++)
        {
            // array[i] = rand.nextLong();
            System.out.print(array[i] + " ");
        }
    }
    
    public static void merge(long[] array, int first, int second, int upperBound)
    {
        int worker = 0;
        int lowerBound = first;
        int mid = second -1;
        int size = upperBound - lowerBound+1;
        long[] workSpace = new long[size];

        while (first <= mid && second <= upperBound)
        {
            if (array[first] < array[second])
            {
                workSpace[worker++] = array[first++];
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

    public static void recMergeSort(long[] workSpace, int lower, int upper)
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
