package org.laura.cinnamoncinema;

public class Cinema {
    int maxSeats =15;
    int availableSeats;

  public int book(int seatToBook){
      return maxSeats-seatToBook;

  }

}
