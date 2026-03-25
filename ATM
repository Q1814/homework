import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000;
        
        while (true) {
            System.out.println("\n1. Balance 2. Withdraw 3. Deposit 0. Exit");
            System.out.print("Choose: ");
            int c = sc.nextInt();
            
            if (c == 1) System.out.println("Balance: " + balance);
            else if (c == 2) {
                System.out.print("Amount: ");
                double a = sc.nextDouble();
                if (a <= 0 || a % 100 != 0) System.out.println("Invalid amount");
                else if (a > balance) System.out.println("Insufficient funds");
                else {
                    balance -= a;
                    System.out.println("Success. New: " + balance);
                }
            } else if (c == 3) {
                System.out.print("Amount: ");
                double a = sc.nextDouble();
                if (a > 0) balance += a;
                System.out.println("Success. New: " + balance);
            } else if (c == 0) break;
            else System.out.println("Invalid choice");
        }
        sc.close();
    }
}
