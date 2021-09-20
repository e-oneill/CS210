import java.util.*;

public class Outlier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sc.nextInt();
        }

        sc.close();

        arr =  bubbleSort(arr);

        if (arr[1] - arr[0] > arr[2] - arr[1])
        {
            System.out.println(arr[0]);
        }
        else if (arr[1] - arr[0] == arr[2] - arr[1])
        {
            System.out.println("NA");
        }
        else
        {
            System.out.println(arr[2]);
        }
    }

    public static int[] bubbleSort(int[] arr)
    {
        int leng = arr.length;

        for (int i = 0; i < leng -1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < leng - i - 1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (swapped)
            {
                break;
            }
        }

        return arr;
    }
}
