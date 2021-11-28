package Labs.Week9;
import java.util.*;


public class RecursiveBankWorth 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int years = sc.nextInt();
        double interestRate = sc.nextDouble();
        double bal = sc.nextDouble();
        
        
        sc.close();
        double interest = calcInterest(bal, interestRate, years);
        double rounded = Math.round(interest * 100) / 100d;
        System.out.println(rounded);
    }

    public static double calcInterest(double balance, double interestRate, int years) {
        if (years == 0)
        {
            return balance;
        }
        else 
        {
            return calcInterest(balance*(1+interestRate/100), interestRate, years-1);
        }
    }
}
