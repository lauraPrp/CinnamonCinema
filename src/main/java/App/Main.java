package App;

import org.laura.cinnamoncinema.Cinema;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        System.out.println("this app books seats at the Cinnamon Cinema");
        int allocatableSeats =15;

        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (allocatableSeats > 0) {
            try {
                System.out.println("Type the number of tickets you want to purchase: ");
                System.out.println("Or any letter to exit the program ");

                number = sc.nextInt();
                cinema.book(number);

                allocatableSeats -= number;
            } catch (InputMismatchException ime) {
                allocatableSeats += number;
                break;
            } catch (UnsupportedOperationException uoe) {
                System.out.println(uoe.getMessage());
                if (uoe.getMessage().equals("No more seats available"))
                    break;
            }
        }
        if (allocatableSeats == 0)
            System.out.println("SOLD OUT");

    }

}
