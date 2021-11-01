package Labs.Week5;
import java.util.*;
public class SelectionSort {
    static int[] arr = new int[20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Random rand = new Random();
        arr = new int[size];
        sc.close();
        for (int i = 0; i < size; i++)
        {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int min;

        for (int outer = 0; outer < size; outer++)
        {
            min = outer;
            for (int i = outer+1; i < size; i++)
            {
                if (arr[i] < arr[min]) 
                {
                    min = i;
                }
            }
            swap(outer, min);
        }

        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }

    }

    public static void swap(int index1, int index2) 
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
