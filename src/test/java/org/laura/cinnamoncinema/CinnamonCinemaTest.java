package org.laura.cinnamoncinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;

public class CinnamonCinemaTest {
    public Cinema cinemaCinnamon;
    @BeforeEach
public void setUpCinemaManager(){
        //arrange
        cinemaCinnamon = new Cinema();
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
    public void assignCorrectSeatFirstBookingRowANumberOne(){
        Seat bookedSeat =new Seat();
        assertEquals('a',bookedSeat.getRow());
        assertEquals('1',bookedSeat.getNumber());
    }

}
