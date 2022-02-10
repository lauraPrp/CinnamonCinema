package org.laura.cinnamoncinema;

public class Cinema {
    private int maxSeats = 15;
    private int availableSeats;
    private int rowNum = 3;
    private int colNum = 5;
    private Seat currentSeat;
    private Seat[][] emptyTheatre;

    public Cinema(int rows, int cols) {
        Seat[][] seatArray= new Seat[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            currentSeat =new Seat();
            // @todo:does it make sense to initialize row and cols for each seat?
            currentSeat.setBooked(false);
                seatArray[i][j]=currentSeat;
            }
        }
        this.emptyTheatre=seatArray;
    }


    public int book(int seatToBook) {
        if (seatToBook > 3)
            throw new UnsupportedOperationException("You can book max 3 seats");

        return maxSeats - seatToBook;

    }

    public Seat[][] getEmptyTheatre() {
        return emptyTheatre;
    }

    public void setEmptyTheatre(Seat[][] emptyTheatre) {
        this.emptyTheatre = emptyTheatre;
    }


}
