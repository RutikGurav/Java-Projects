import java.util.Scanner;

class ATM {
    public static void main(String[] args) {
        float x, y;
        int ch;
        int password = 5158, enter_password;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t\t******************LOGIN PROCESS*******************\n\n");
        System.out.println("Enter password : ");
        enter_password = sc.nextInt();
        while (password != enter_password) {
            System.out.println("Enter password : ");
            enter_password = sc.nextInt();
        }
        System.out.println("\n\t\t\t******************WELCOME TO RUTTIK GURAV ATM*******************\n\n");
        System.out.println("Enter initial amount in your Account : ");
        x = sc.nextFloat();
        System.out.println("\n\t\t\t*************Available Transaction************\n\n");
        System.out.println("Enter-\n1.Creadit\n2.Debit\n3.Total\n");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("Enter Credit Amount : ");
                y = sc.nextFloat();
                x = x + y;
                System.out.println("Total Amount = " + x);
                break;
            case 2:
                System.out.println("Enter Debit Amount : ");
                y = sc.nextFloat();
                if (x >= y) {
                    x = x - y;
                    System.out.println("Total Amount = " + x);
                    break;
                } else {
                    System.out.println("Insufficient amount in your Account!!");
                    break;
                }
            case 3:
                System.out.println("Total Amount in your Account = " + x);
                break;

            default:
                System.out.println("Choose correct option for operation!!");
        }
        System.out.println("\n\t\t\t******************THANK YOU FOR VISITING RUTTIK GURAV ATM*******************\n\n");
    }
}