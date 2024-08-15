import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String name;
    double amount;

    Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Personal Expense Tracker:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Expense Name: ");
                    scanner.nextLine(); // consume the newline
                    String name = scanner.nextLine();
                    System.out.print("Enter Expense Amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(name, amount));
                    System.out.println("Expense added successfully!\n");
                    break;

                case 2:
                    System.out.println("\nExpenses:");
                    for (Expense expense : expenses) {
                        System.out.println("Name: " + expense.name + ", Amount: " + expense.amount);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter Expense Name to delete: ");
                    scanner.nextLine(); // consume the newline
                    String deleteName = scanner.nextLine();
                    Expense expenseToDelete = null;
                    for (Expense expense : expenses) {
                        if (expense.name.equals(deleteName)) {
                            expenseToDelete = expense;
                            break;
                        }
                    }
                    if (expenseToDelete != null) {
                        expenses.remove(expenseToDelete);
                        System.out.println("Expense deleted successfully!\n");
                    } else {
                        System.out.println("Expense not found.\n");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Personal Expense Tracker.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }
}
 
