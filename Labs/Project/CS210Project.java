package Labs.Project;

import java.util.*;
import java.security.*;

public class CS210Project {
    // CREATING THE HIGH LEVEL STATIC VARIABLES THAT WILL DRIVE THE EXECUTION
    public static Dictionary dict = new Dictionary();
    // Number of rows in words.txt that contain nouns
    public static int nouns = 842;
    // Number of rows in words.txt that contain verbs - some verbs contain sentence
    // chunks to help them make sense
    public static int verbs = 62;
    // Number of rows in words.txt that contain adjectives
    public static int adjectives = 145;
    // Number of random sentences to be generated
    public static int bound = 2000000;

    // Arrays to hold the sentence and hash
    public static String[] sentenceArray = new String[bound];
    public static HashString[] hashArray = new HashString[bound];

    public static void main(String[] args) {

        // region 
        boolean debugMode = true; // boolean for enabling and disabling debug variables and strings
        long CurrTime;
        long startTime = System.currentTimeMillis();
        long lastTime = startTime;
        // Debug variables used to track the execution of the program
        int tracker = 0;
        int percentTracker = 0;
        int duplicates = 0;
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
        if (debugMode) {
            System.out.println("Hashmap Constructed"); // Notify user that we are moving to iteration phase of the programme
        }

        for (int i = 0; i < bound; i++) {
            HashString hash1 = hashArray[i];
            for (int j = i + 1; j < bound; j++) {
                if (sentenceArray[i].equals(sentenceArray[j])) {
                    if (debugMode) {
                        //increment duplicate tracker
                        duplicates++;
                    }
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
                if (matches >= 22 && debugMode) {
                    //Print a string whenever a pair meets or betters my current record (manually added)
                    System.out.println("\n" + score + "\nBetween:\n" + sentenceArray[i] + "\nAND\n" + sentenceArray[j]);
                }
            }
            if (debugMode) {
                // region This is a debug block of code, for tracking the execution of the
                // program during larger test runs
                tracker++;
                if (tracker % (bound / 10) == 0) {

                    // Measure time since start and construct a string chunk to display this to the
                    // user for information
                    CurrTime = System.currentTimeMillis();
                    long timeSinceStart = CurrTime - startTime;
                    int seconds = (int) timeSinceStart / 1000;
                    String sinceStartChunk = "Time since start: " + seconds + " seconds. ";
                    if (seconds > 60) {
                        int minutes = seconds / 60;
                        seconds = seconds % 60;
                        sinceStartChunk = "Time since start: " + minutes + " minutes, " + seconds + " seconds. ";
                    }
                    // Measure time since last 10% block was completed and construct a string chunk
                    // to display this to the user
                    long timeSinceLast = CurrTime - lastTime;
                    seconds = (int) timeSinceLast / 1000;
                    String sinceLastChunk = "Time since last 10%: " + seconds + " seconds.";
                    if (seconds > 60) {
                        int minutes = seconds / 60;
                        seconds = seconds % 60;
                        sinceLastChunk = "Time since last 10%: " + minutes + " minutes, " + seconds + " seconds. ";
                    }

                    System.out.println("Finished entry " + tracker + ". " + sinceStartChunk + sinceLastChunk);
                    lastTime = CurrTime;
                    percentTracker++;
                } else if (tracker % (bound / 100) == 0) {
                    System.out.print(++percentTracker + "%... ");
                }
                // endregion;
            }

        }
        System.out.println("The closest hash found was " + score + "\nBetween:\n" + string1 + "\nAND\n" + string2);
        if (debugMode) {System.out.println("Duplicates: " + duplicates);} //print number of duplicates - if more than a small amount, the random generator isn't good enough
    }
    //sha256 function as provided
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
