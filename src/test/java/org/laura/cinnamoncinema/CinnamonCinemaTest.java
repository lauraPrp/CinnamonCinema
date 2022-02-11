package org.laura.cinnamoncinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CinnamonCinemaTest {
    public Cinema cinemaCinnamon;
    Seat[][] seats;
    ArrayList<Seat> seatsToBook;

    @BeforeEach
    public void setUpCinemaManager() {
        //arrange
        cinemaCinnamon = new Cinema();
        seats = cinemaCinnamon.getEmptyTheatre();
    }

    @Test
    public void bookOneSeatTest() {
        ArrayList<Seat> bookedSeats = cinemaCinnamon.book(1);
        //assert
        assertEquals(1, bookedSeats.size());
    }

    @Test
    public void tryBookingAllSeatsTest() {
        assertThrows(UnsupportedOperationException.class, () -> cinemaCinnamon.book(15));
    }

    @Test
    public void checkAllSeatAreBookableWhenNoBookingHasBeenMadeTest() {
        //act
        Seat currentSeat;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                currentSeat = seats[i][j];
                assertFalse(currentSeat.isBooked());
            }
        }
    }

    @Test
    public void assignCorrectSeatFirstBookingRowANumberOneTest() {
        //arrange
        ArrayList<Seat> bookedSeats = cinemaCinnamon.book(1);

        //assert
        assertEquals('A', bookedSeats.get(0).getRow());
        assertEquals(0, bookedSeats.get(0).getSeatNumber());
    }

    @Test
    public void generateRandomNumberTest() {
        int generatedNumber = cinemaCinnamon.generateRandomBookingsNumber();

        assertTrue(generatedNumber >= 1 && generatedNumber <=3);
    }

    @Test
    public void generateRandomBookingTest() {

        //act
        int numberSeatsToBook = cinemaCinnamon.generateRandomBookingsNumber();
        seatsToBook = cinemaCinnamon.book(numberSeatsToBook);
        assertEquals(numberSeatsToBook,seatsToBook.size());

    }
    @Test
    public void generateRandomBookingUntilTheatreisFullTest() {
        for(int i=0;i<5;i++) {
            int numberSeatsToBook = 3;
            seatsToBook = cinemaCinnamon.book(numberSeatsToBook);
            assertEquals(numberSeatsToBook, seatsToBook.size());
        }

    }
}
