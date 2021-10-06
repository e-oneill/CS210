import java.util.*;
public class BinarytoDecimal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit)
        {
            int num = sc.nextInt();
            if (num == -1)
            {
                break;
            }
            
            int i = num;
            StringBuilder binaryNumber = new StringBuilder("");
    
            // //Converting using Euclidean Division
            // while (i > 0)
            // {
            //     binaryNumber.append((i%2));
            //     i = i / 2;
            // }
            // binaryNumber.reverse();
    
            
            //Converting via Subtraction
            long power = (long) (Math.log(num) / Math.log(2));
            long result = (long) Math.pow(2, power);
            i = num;
            int remainder = num;
            while (remainder > 0)
            {
                remainder = remainder - (int) (long) result;
                binaryNumber.append(1);
                power--;
                result = (long) Math.pow(2, power);
                while (result > remainder)
                {
                    binaryNumber.append(0);
                    power--;
                    result = (long) Math.pow(2,power);
                }
                i = (int) (long) result;
            }
    
            
            
            String output = binaryNumber.toString();
    
            // int num2 = (binaryNumber.length() + 7) & (-8);
            // if (num2 != binaryNumber.length())
            // {
            // output = String.format("%0" + (num2 - binaryNumber.toString().length() ) + "d%s",0,binaryNumber.toString());
            // }
    
            int foo = Integer.parseInt(output, 2);
            System.out.println("The binary representation of " + foo + " is " + output);
            
            // System.out.println("The largest power of 2 that divides into " + num + " is " + result);
        }

    }
}
