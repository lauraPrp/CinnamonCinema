package App;

import org.laura.cinnamoncinema.Cinema;

import java.util.InputMismatchException;

public class Main {

    public static int generateRandomBookingsNumber() {
        final int min = 1;
        final int max = 3;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        System.out.println("\nThis app books seats at the Cinnamon Cinema\n");
        int allocatableSeats =15;

        int number = 0;
        while (allocatableSeats > 0) {
            cinema.print();
            try {
                number =generateRandomBookingsNumber();
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
            System.out.println("seat requested: "+number);
        }
        if (allocatableSeats == 0)

            cinema.print();
        System.out.println("SOLD OUT");
    }

}
