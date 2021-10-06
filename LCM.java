import java.util.*;
public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sc.nextInt();
        }

        sc.close();

        arr =  bubbleSort(arr);
        if (arr[0] + arr[1] + arr[2] == 0)
        {
            System.out.println("0");
        }
        else if (arr[0] * arr[1] <= 0 || arr[1] * arr[2] <= 0 || arr[0] * arr[2] <= 0)
        {
            System.out.println("NA");
        }
        else
        {   
            boolean multipleFound = false;
            //If LCM includes the the value of the three numbers x = 1, otherwise x = 2
            int x = 1;
            while(!multipleFound)
            {
                int currMult = arr[2] * x;
                if (currMult % arr[0] == 0 && currMult % arr[1] == 0)
                {
                    System.out.println(currMult);
                    multipleFound = true;
                }
                x++;
            }
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
            if (!swapped)
            {
                break;
            }
        }
        return arr;
    }
}
