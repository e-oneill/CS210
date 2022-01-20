package Labs.Project;
import java.util.Scanner;
import java.security.*;
public class StringComparer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String h1 = sha256(s1);
        String h2 = sha256(s2);
        int matches = 0;
        for (int i = 0; i < s1.length(); i++)
        {
            if (h1.charAt(i) == h2.charAt(i))
            {
                matches++;
            }
        }

        System.out.println(matches);
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
}
