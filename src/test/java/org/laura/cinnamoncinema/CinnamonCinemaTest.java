package org.laura.cinnamoncinema;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinnamonCinemaTest {

    @Test
    public void bookOneSeat(){
        Cinema cinemaCinnamon=new Cinema();


       int result = cinemaCinnamon.book(1);

        assertEquals(14,1+result);
    }

}
