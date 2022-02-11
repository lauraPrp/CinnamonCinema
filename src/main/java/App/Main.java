package App;

import org.laura.cinnamoncinema.Cinema;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cinema cinema = new Cinema();
        System.out.println("this app books seats at the Cinnamon Cinema");
       int allocatableSeats= cinema.getAllSeats().length;

        Scanner sc = new Scanner(System.in);
       while(allocatableSeats>0) {
           try {
               System.out.println("Type the number of tickets you want to purchase: ");
               System.out.println("Or any letter to exit the program ");

               int number = sc.nextInt(); // We can read specific data.
               //System.out.println(number);
               cinema.book(number);

               allocatableSeats -= number;
           }catch(InputMismatchException ime){
               break;
           }
           catch(UnsupportedOperationException uoe){
               System.out.println(uoe.getMessage());
               if(uoe.getMessage().equals("No more seats available"))
                break;
           }
       }
        if(allocatableSeats == 0)
            System.out.println("SOLD OUT");

    }

}
