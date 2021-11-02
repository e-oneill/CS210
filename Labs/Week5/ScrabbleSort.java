package Labs.Week5;
import java.util.*;
public class ScrabbleSort {
    static String[] wordArray = new String[1];
    static int[] scoreArray = new int[1];
    static int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        wordArray = new String[n];
        for (int i = 0; i < n; i ++)
        {
            wordArray[i] = sc.nextLine();
        }
        sc.close();

        sortByScrabbleScore(wordArray);
    }

    public static int scrabbleScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++)
        {
            score += values[(int) (word.charAt(i))-97];
        }
        return score;
    }

    public static void sortByScrabbleScore(String[] arr) 
    {
        for (int outer = 1; outer < arr.length; outer++)
        {
            String temp = arr[outer];
            int inner = outer;
            while ( inner > 0 && scrabbleScore(arr[inner-1]) >= scrabbleScore(temp))
            {
                if (scrabbleScore(arr[inner-1]) == scrabbleScore(temp) && arr[inner-1].charAt(0) <= temp.charAt(0))
                {
                //Handling alphabetical order when two words have same score
                    int j = 0;
                    while (arr[inner-1].charAt(j) == temp.charAt(j))
                    {
                        j++;
                    }
                    if (arr[inner-1].charAt(j) < temp.charAt(j))
                    {
                        break;
                    }
                }
                arr[inner] = arr[inner - 1];
                inner--;
            }
            arr[inner] = temp;
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }


}
