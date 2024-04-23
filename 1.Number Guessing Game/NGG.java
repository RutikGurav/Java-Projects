import java.util.Scanner;

class NGG {
    public static void main(String[] args) {

        int number, guess, ngueses = 1;
        Scanner sc = new Scanner(System.in);
        number = 1 + (int) (100 * Math.random());
        do {
            System.out.println("Guess the number between 1 to 100 : ");
            guess = sc.nextInt();
            if (guess > number) {
                System.out.println("Lower number please!!");
            } else if (guess < number) {
                System.out.println("Higher number please!!");
            } else {
                System.out.println("You guessed it in " + ngueses + " attempt!!");
            }
            ngueses++;
        } while (number != guess);
    }
}