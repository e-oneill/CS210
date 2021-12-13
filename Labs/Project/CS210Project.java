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
        int bound = 7500;
        int words = 6;

        //These three variables will be used to track the most matches found
        int score = 0;
        String string1 = "";
        String string2 = "";

        for (int i = 0; i < bound; i++)
        {
            String sentence = "";
            for (int j = 0; j < words; j++)
            {
                int seed = rand.nextInt(466550);
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

        for (Map.Entry<String, String> m : strings.entrySet()) {
            for (Map.Entry<String, String> s: strings.entrySet())
            {
                
                if (m.getKey() != s.getKey())
                {
                    int counter = 0;
                    String mHash = m.getValue();
                    String sHash = s.getValue();

                    for (int i = 0; i < mHash.length(); i++)
                    {
                        if (mHash.charAt(i) == sHash.charAt(i))
                        {
                            counter++;
                        }
                        
                    }

                    if (counter > score)
                        {
                            score = counter;
                            string1 = m.getKey();
                            string2 = s.getKey();
                        }
                }
            }
            
        }
        System.out.println("The closest hash found was " + score + "\nBetween:\n" + string1 + "\nAND\n" + string2 );
    }

    public static String sha256(String input){
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
}
