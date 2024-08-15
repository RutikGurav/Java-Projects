import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
}

public class TaskManagementApp {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Task Management Application:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Task Description: ");
                    scanner.nextLine(); // consume the newline
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    System.out.println("Task added successfully!\n");
                    break;

                case 2:
                    System.out.println("\nTasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task task = tasks.get(i);
                        System.out.println((i + 1) + ". " + task.description + " - " + (task.isCompleted ? "Completed" : "Pending"));
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter Task Number to update: ");
                    int taskNum = scanner.nextInt();
                    if (taskNum > 0 && taskNum <= tasks.size()) {
                        Task taskToUpdate = tasks.get(taskNum - 1);
                        System.out.print("Enter new description: ");
                        scanner.nextLine(); // consume the newline
                        taskToUpdate.description = scanner.nextLine();
                        System.out.print("Mark as completed? (yes/no): ");
                        String markCompleted = scanner.nextLine();
                        taskToUpdate.isCompleted = markCompleted.equalsIgnoreCase("yes");
                        System.out.println("Task updated successfully!\n");
                    } else {
                        System.out.println("Invalid Task Number.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Task Number to delete: ");
                    int deleteNum = scanner.nextInt();
                    if (deleteNum > 0 && deleteNum <= tasks.size()) {
                        tasks.remove(deleteNum - 1);
                        System.out.println("Task deleted successfully!\n");
                    } else {
                        System.out.println("Invalid Task Number.\n");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the Task Management Application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }
}
