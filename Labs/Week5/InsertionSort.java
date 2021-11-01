package Labs.Week5;
import java.util.*;
public class InsertionSort {
    static int[] arr = new int[20];
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        
        for (int outer = 1; outer < arr.length; outer++)
        {
            int temp = arr[outer];
            int inner = outer;
            while ( inner > 0 && arr[inner-1] >= temp)
            {
                arr[inner] = arr[inner - 1];
                inner--;
            }
            arr[inner] = temp;
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
