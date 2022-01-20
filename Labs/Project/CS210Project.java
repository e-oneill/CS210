package Labs.Project;

import java.util.*;
import java.security.*;

public class CS210Project {
    // CREATING THE HIGH LEVEL STATIC VARIABLES THAT WILL DRIVE THE EXECUTION
    // Using a hashmap to store original string as key and hashed string as value
    public static final HashMap<String, HashString> strings = new HashMap<String, HashString>();

    public static Dictionary dict = new Dictionary();
    // Number of rows in words.txt that contain nouns
    public static int nouns = 202;
    // Number of rows in words.txt that contain verbs
    public static int verbs = 62;
    // Number of rows in words.txt that contain adjectives
    public static int adjectives = 145;
    public static int bound = 90000;
    // Arrays to hold the sentence and hash
    public static String[] sentenceArray = new String[bound];
    public static HashString[] hashArray = new HashString[bound];

    public static void main(String[] args) {

        // region

        long CurrTime;
        long startTime = System.currentTimeMillis();
        long lastTime = startTime;
        int tracker = 0;
        int percentTracker = 0;

        // These three variables will be used to track the most matches found
        int score = 0;
        String string1 = "";
        String string2 = "";
        // endregion;

        // Start by generating random sentences, getting their hash and storing both in
        // a hashmap
        for (int i = 0; i < bound; i++) {
            String sentence = randomSentenceBuilder();

            HashString hash = new HashString(sha256(sentence));
            // strings.put(sentence, hash);
            sentenceArray[i] = sentence;
            hashArray[i] = hash;
        }

        System.out.println("Hashmap Constructed"); // Notify user that we are moving to iteration phase of the programme
        for (int i = 0; i < bound; i++) {
            HashString hash1 = hashArray[i];
            for (int j = i + 1; j < bound; j++) {
                if (sentenceArray[i].equals(sentenceArray[j]))
                {
                    continue;
                }
                HashString hash2 = hashArray[j];
                int matches = compareHashStrings(hash1, hash2);
                if (matches > score) {
                    // if the number of matches between these two strings beats our current record,
                    // we overwrite the tracker variables defined at the start
                    score = matches;
                    string1 = sentenceArray[i];
                    string2 = sentenceArray[j];
                    // this if statement is used to ensure that any matching sentences that beat or
                    // equal my current best are output

                }
                if (matches >= 21) {
                    System.out.println("\n" + score + "\nBetween:\n" + sentenceArray[i] + "\nAND\n" + sentenceArray[j]);
                }
            }
            tracker++;
            if (tracker % (bound / 10) == 0) {
                // This is a debug block of code, for tracking the execution of the program when
                // it is taking longer
                CurrTime = System.currentTimeMillis();
                System.out.println("Finished entry " + tracker + ". Time since start: " + (CurrTime - startTime) / 1000 + " seconds. Time since last 10%: " + (CurrTime - lastTime) / 1000 + " seconds.");
                lastTime = CurrTime;
                percentTracker++;
            } else if (tracker % (bound / 100) == 0) {
                System.out.print(++percentTracker + "%... ");
            }
        }
        // region Using an iterator to iterate through the hashmap
        // Iterator<Map.Entry<String, HashString>> iter = strings.entrySet().iterator();

        // while (iter.hasNext()) {
        // Map.Entry<String, HashString> m = iter.next();
        // HashString mHash = m.getValue();
        // // Inner loop - each entry in the hashmap will be tested against every other
        // // entry
        // for (Map.Entry<String, HashString> s : strings.entrySet()) {

        // // System.out.println("Current element: " + m.getKey());
        // if (mHash != s.getValue()) {

        // HashString sHash = s.getValue();

        // int matches = compareHashStrings(mHash, sHash);

        // if (matches > score) {
        // // if the number of matches between these two strings beats our current
        // record,
        // // we overwrite the tracker variables defined at the start
        // score = matches;
        // string1 = m.getKey();
        // string2 = s.getKey();
        // // this if statement is used to ensure that any matching sentences that beat
        // or
        // // equal my current best are output

        // }
        // if (matches >= 21) {
        // System.out.println("\n" + score + "\nBetween:\n" + m.getKey() + "\nAND\n" +
        // s.getKey());
        // }
        // }
        // }
        // tracker++;

        // if (tracker % (bound / 10) == 0) {
        // // This is a debug block of code, for tracking the execution of the program
        // when
        // // it is taking longer
        // CurrTime = System.currentTimeMillis();
        // System.out.println("Finished entry " + tracker + ". Time since start: " +
        // (CurrTime - startTime) / 1000
        // + " seconds. Time since last 10%: " + (CurrTime - lastTime) / 1000 + "
        // seconds.");
        // lastTime = CurrTime;
        // } else if (tracker % (bound / 100) == 0) {
        // System.out.print(++percentTracker + "%... ");
        // }
        // iter.remove();

        // }
        // endregion;
        System.out.println("The closest hash found was " + score + "\nBetween:\n" + string1 + "\nAND\n" + string2);
    }

    public static String sha256(String input) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return (e.toString());
        }
    }

    // This compare function is made to mimic the compareValues internal java
    // function (which is what is called when you use compareTo)
    // I used this so we could modify the return from a lexigraphical comparison to
    // the number of charactersthat match
    public static int compareHashStrings(HashString one, HashString two) {
        int score = 0;
        int lim = 64;
        byte v1[] = one.value;
        byte v2[] = two.value;
        for (int k = 0; k < lim; k++) {
            byte c1 = v1[k];
            byte c2 = v2[k];
            if (c1 == c2) {
                score++;
            }
        }

        return score;
    }

    public static String randomSentenceBuilder() {
        Random rand = new Random();
        String sentence = "";
        boolean adjective;
        String word;
        int seed;
        sentence += "The ";
        adjective = rand.nextBoolean();
        if (adjective) {
            // get adjective
            seed = (nouns + verbs) + rand.nextInt(adjectives);
            word = dict.getWord(seed);
            word = word.substring(0, word.length() - 1);
            sentence += word + " ";
        }

        // get the first noun
        seed = rand.nextInt(nouns);
        word = dict.getWord(seed);
        word = word.substring(0, word.length() - 1);
        sentence += word + " ";

        // get the verb
        seed = nouns + rand.nextInt(verbs);
        word = dict.getWord(seed);
        word = word.substring(0, word.length() - 1);
        sentence += word + " the ";
        adjective = rand.nextBoolean();
        if (adjective) {
            // get adjective
            seed = (nouns + verbs) + rand.nextInt(adjectives);
            word = dict.getWord(seed);
            word = word.substring(0, word.length() - 1);
            sentence += word + " ";
        }

        // get second noun
        seed = rand.nextInt(nouns);
        word = dict.getWord(seed);
        word = word.substring(0, word.length() - 1);
        sentence += word;
        sentence += ".";

        return sentence;

    }
}

// Creating a custom String class, so I can access the array of characters that
// underlies the data, as it is private in the String class
// String is also marked final, so I can't just extend the String class and add
// a public Getter function
// This may seem over-the-top, but it led to a 20% decrease in execution time
class HashString {
    public byte[] value;

    public HashString(String original) {
        value = new byte[original.length()];
        for (int i = 0; i < original.length(); i++) {
            value[i] = (byte) original.charAt(i);
        }
    }
}
