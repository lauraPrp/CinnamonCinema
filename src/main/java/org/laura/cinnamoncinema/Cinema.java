package org.laura.cinnamoncinema;

public class Cinema {
    int maxSeats =15;
    int availableSeats;

  public int book(int seatToBook){
if(seatToBook>3)
    throw new UnsupportedOperationException("You can book max 3 seats");

    return maxSeats-seatToBook;

  }

}
