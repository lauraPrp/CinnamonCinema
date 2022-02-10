package org.laura.cinnamoncinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;

import static org.junit.jupiter.api.Assertions.*;

public class CinnamonCinemaTest {
    public Cinema cinemaCinnamon;
    public Seat[][] seats;
    @BeforeEach
public void setUpCinemaManager(){
        //arrange
        cinemaCinnamon = new Cinema(3,5);
        seats=cinemaCinnamon.getEmptyTheatre();
        }

        @Test
    public void bookOneSeat() {

        //act
        int result = cinemaCinnamon.book(1);
        //assert
        assertEquals(14, result);
    }

    @Test
    public void tryBookingAllSeats() {
        assertThrows(UnsupportedOperationException.class, () -> cinemaCinnamon.book(15));
    }
    @Test
    public void checkAllSeatAreBookable(){
       //act

        Seat currentSeat = new Seat();
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
               currentSeat= seats[i][j];
                assertEquals(false,currentSeat.isBooked());
            }
        }

    }

    @Test
    public void assignCorrectSeatFirstBookingRowANumberOne(){
       //arrange
        Seat bookedSeat =new Seat();
       //act
        int result = cinemaCinnamon.book(1);
        //assert
        assertEquals('a',bookedSeat.getRow());
        assertEquals('1',bookedSeat.getSeatNumber());
    }

}
