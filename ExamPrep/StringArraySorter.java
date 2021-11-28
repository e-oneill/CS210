package ExamPrep;
import java.util.*;
public class StringArraySorter {
    static String[] strings = new String[3];
    public static void main(String[] args) {
        
        // Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++)
        {
            strings[i] = scanner.nextLine();
        }
        scanner.close();
        sortByUniques(strings);

        for (int i = 0; i < strings.length; i++)
        {
            System.out.println(strings[i] + " (" + wordUniques(strings[i]) + ")");
        }

    }

    public static int wordUniques(String word)
    {
            
            int characters[] = new int[26];
            int unique = 0;
            for (int j = 0; j < word.length(); j++)
            {
                int characterNum = word.charAt(j) - 97;
                if (characters[characterNum]== 0)
                {
                    characters[characterNum] = 1;
                    unique++;
                }
            }

            return unique;
    }

    public static void sortByUniques(String[] arr)
    {
        for (int outer = 1; outer < arr.length; outer++)
        {
            int inner = outer;
            String temp = arr[inner];
            while (inner > 0 && wordUniques(arr[inner - 1]) <= wordUniques(arr[inner]))
            {
                if (wordUniques(arr[inner - 1]) == wordUniques(arr[inner]))
                {
                    if (arr[inner-1].compareToIgnoreCase(temp) < 0)
                    {
                        break;
                    }
                }
                
                arr[inner] = arr[inner-1];
                inner--;
            }
            arr[inner] = temp;
        }

        
    }

    // The Big O notation of this algorithm is O (n^2) in the worst case.
    // These for this is that the selection sort contains a for loop and a nested while loop, meaning that the size of the operation grows at a rate of n^2 
    // In Big O Notation, we disregard smaller orders of function, e.g. the order N of the uniqueScores() method
}
