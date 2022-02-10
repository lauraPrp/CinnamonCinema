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
    public Seat[][] seats;

    @BeforeEach
    public void setUpCinemaManager() {
        //arrange
        cinemaCinnamon = new Cinema();
        seats = cinemaCinnamon.getEmptyTheatre();
    }

    @Test
    public void bookOneSeat() {
        ArrayList<Seat> bookedSeats = cinemaCinnamon.book(1);
        //assert
        assertEquals(1, bookedSeats.size());
    }

    @Test
    public void tryBookingAllSeats() {
        assertThrows(UnsupportedOperationException.class, () -> cinemaCinnamon.book(15));
    }

    @Test
    public void checkAllSeatAreBookableWhenNoBookingHasBeenMade() {
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
    public void assignCorrectSeatFirstBookingRowANumberOne() {
        //arrange
        ArrayList<Seat> bookedSeats = cinemaCinnamon.book(1);

        //assert
        assertEquals('A', bookedSeats.get(0).getRow());
        assertEquals(0, bookedSeats.get(0).getSeatNumber());
    }

}
