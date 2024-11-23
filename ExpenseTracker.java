import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = ExpenseStorage.viewExpenses();
        
        while(true) {
            System.out.println("Choose an option: ");
            System.out.println("1.Add an expense");
            System.out.println("2.View expenses");
            System.out.println("3.Exit");
            int choice = scanner.nextInt();
            
            switch(choice) {
            case 1:
                System.out.println("Enter the date");
                String date = scanner.next();
                scanner.nextLine();
                System.out.println("Enter the description");
                String description = scanner.nextLine();
                System.out.println("Enter the description");
                String category = scanner.next();
                scanner.nextLine();
                System.out.println("Enter the amount");
                double amount = scanner.nextDouble();
                expenses.add(new Expense(date,description,category,amount));
                ExpenseStorage.saveExpenses(expenses);
                break;
            case 2:
                for(Expense e: expenses) {
                    System.out.println(e);
                }
                break;
            case 3:
                System.out.println("Bye bye");
                return;
            default:
                    System.out.println("Invalid choice");
                }
        
        }
        
    }
}
