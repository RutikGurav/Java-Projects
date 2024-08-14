import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create a FileWriter to write the output to a file
            FileWriter file = new FileWriter("test.txt");

            // Fixed bus capacity
            int capacity = 40;

            System.out.print("Enter the number of reservation seats for the Bus: ");
            int res = scanner.nextInt();

            int[] arr = new int[res];

            // Get the seat numbers to reserve
            for (int i = 0; i < res; i++) {
                System.out.printf("Enter seat number of member %d between 1 to %d to be reserved: ", i + 1, capacity);
                arr[i] = scanner.nextInt();
            }

            // Write the header to the file
            file.write("\n**************************************************************************************************\n");
            file.write("\n***************************** WELCOME TO BUS RESERVATION SYSTEM **********************************\n");
            file.write("\n**************************************************************************************************\n\n");
            file.write(String.format("DATE : %s\t\t\t\t\t\t\t\t\t\t\t\t\t\t TIME : %s\n\n", java.time.LocalDate.now(), java.time.LocalTime.now()));
            file.write("            ----------------------------------      ----------------------------------\n");
            file.write("            |   SEAT NO.   |      STATUS     |      |   SEAT NO.   |      STATUS     |\n");
            file.write("            ----------------------------------      ----------------------------------\n");


            // Write the reservation status of each seat
            for (int i = 1; i <= 20; i++) {
                boolean isBookedLeft = false;
                boolean isBookedRight = false;

                // Check left side (seats 1-20)
                for (int j = 0; j < res; j++) {
                    if (i == arr[j]) {
                        isBookedLeft = true;
                    }
                }

                // Check right side (seats 21-40)
                for (int j = 0; j < res; j++) {
                    if (i + 20 == arr[j]) {
                        isBookedRight = true;
                    }
                }

                String leftStatus = isBookedLeft ? "BOOKED" : "EMPTY";
                String rightStatus = isBookedRight ? "BOOKED" : "EMPTY";

                file.write(String.format("            |       %2d      |     %-10s |      |       %2d      |     %-10s |\n", i, leftStatus, i + 20, rightStatus));
            }
            file.write("            ----------------------------------      ----------------------------------\n");


            file.write("\n**************************************************************************************************\n");
            file.write("\n********************************* THANK YOU FOR VISITING *****************************************\n");
            file.write("\n**************************************************************************************************\n\n");

            System.out.println("Successfully created....!!!");

            // Close the file writer
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}


