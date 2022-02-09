package org.laura.cinnamoncinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;

public class CinnamonCinemaTest {

    @Test
    public void bookOneSeat() {
        //arrange
        Cinema cinemaCinnamon = new Cinema();
        //act
        int result = cinemaCinnamon.book(1);
        //assert
        assertEquals(14, result);
    }

    @Test
    public void tryBookingAllSeats() {

        Cinema cinemaCinnamon = new Cinema();

        assertThrows(UnsupportedOperationException.class, () -> cinemaCinnamon.book(15));
    }


}
