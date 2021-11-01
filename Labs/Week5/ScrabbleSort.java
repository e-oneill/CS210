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
        scoreArray = new int[n];
        for (int i = 0; i < n; i ++)
        {
            wordArray[i] = sc.nextLine();
            scoreArray[i] = scrabbleScore(wordArray[i]);
        }

        for (int i = 0; i < n; i ++)
        {
            System.out.print(scoreArray[i] + " ");
        }
        sc.close();
    }

    public static int scrabbleScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++)
        {
            score += values[(int) (word.charAt(i))-97];
        }
        

        return score;
    }
}
