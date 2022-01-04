package Labs.Project;

import java.util.*;
import java.security.*;
import java.io.*;

public class CS210Project {
    //Using a hashmap to store original string as key and hashed string as value
    public static final HashMap<String, String> strings = new HashMap<String, String>();

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Random rand = new Random();
        // System.out.println(dict.getSize());
        //Bounds sets the number of strings to be generated
        int bound = 9000;
        int words = 4;

        //These three variables will be used to track the most matches found
        int score = 0;
        String string1 = "";
        String string2 = "";
        int randBound = dict.getSize();
        for (int i = 0; i < bound; i++)
        {
            String sentence = "";
            for (int j = 0; j < words; j++)
            {
                int seed = rand.nextInt(randBound);
                String word = dict.getWord(seed);
                word = word.substring(0, word.length()-1);
                if (j == 0)
                {
                    sentence = (String) (Character.toUpperCase((Character) word.charAt(0)) + word.substring(1)) + " ";
                }
                else if (j == words - 1)
                {
                    sentence += word;
                }
                else 
                {
                    sentence += word + " ";
                }
                
                


            }
            sentence += ".";
            String hash = sha256(sentence);
            // System.out.println(sentence);
            strings.put(sentence, hash);
        }

        Iterator<Map.Entry<String, String>> iter = strings.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, String> m = iter.next();
            String mHash = m.getValue();
            for (Map.Entry<String, String> s: strings.entrySet())
            {
                
                // System.out.println("Current element: " + m.getKey());
                if (mHash != s.getValue())
                {
                    
                    // int counter = 0;
                    
                    String sHash = s.getValue();

                    // for (int i = 0; i < mHash.length(); i++)
                    // {
                    //     if (mHash.charAt(i) == sHash.charAt(i))
                    //     {
                    //         counter++;
                    //     }
                        
                    // }

                    int counter = compareStrings(mHash, sHash);

                    if (counter > score)
                        {
                            score = counter;
                            string1 = m.getKey();
                            string2 = s.getKey();
                        }
                }
            }
            // strings.remove(m.getKey());
            iter.remove();
        }
        System.out.println("The closest hash found was " + score + "\nBetween:\n" + string1 + "\nAND\n" + string2 );
    }

    public static String sha256(String input)
    {
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<data.length;i++){
                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
            }
            return sb.toString();
        }catch(Exception e){
            return(e.toString());
        }
    }

    public static int compareStrings(String one, String two)
    {
        int score = 0, i = 0, j = 0;
        char v1[] = new char[64];
        char v2[] = new char[64];
        one.getChars(0, 64, v1, 0);
        two.getChars(0, 64, v2, 0);
        if (v1[i++] == v2[j++])
        {
            score++;
        }
        return score;
    }
}
