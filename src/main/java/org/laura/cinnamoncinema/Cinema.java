package org.laura.cinnamoncinema;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Cinema {

    private final Dictionary<Integer,Character> cinemaRows;
    private final int allSeats = 15;

    private final int COL_NUM = 5;

    private Seat[][] emptyTheatre;

    public Cinema() {
        cinemaRows = new Hashtable<>();
        cinemaRows.put(0, 'A');
        cinemaRows.put(1, 'B');
        cinemaRows.put(2, 'C');
        //  Seat[][] seatArray = new Seat[cinemaRows.size()][cols];
        emptyTheatre = new Seat[cinemaRows.size()][COL_NUM];
        for (int i = 0; i < cinemaRows.size(); i++) {
            for (int j = 0; j < COL_NUM; j++) {
                Seat currentSeat = new Seat();
                currentSeat.setBooked(false);
                currentSeat.setRow( cinemaRows.get(i));
                currentSeat.setSeatNumber(j);
                emptyTheatre[i][j] = currentSeat;
            }
        }
        //this.emptyTheatre = emptyTheatre;
    }


    public ArrayList<Seat> book(int seatToBook) {
        final int MAX_BOOKABLE_SEATS = 3;
        if (seatToBook > MAX_BOOKABLE_SEATS) throw new UnsupportedOperationException("You can book max 3 seats");
        //ArrayList<Seat> bookedSeats=  checkNextAvailableSeat();
        return checkNextAvailableSeat();

    }

    public Seat[][] getEmptyTheatre() {
        return emptyTheatre;
    }

    public void setEmptyTheatre(Seat[][] emptyTheatre) {
        this.emptyTheatre = emptyTheatre;
    }

    private ArrayList<Seat> checkNextAvailableSeat() {
        ArrayList<Seat> avalableSeats = new ArrayList<>();
        int availableSeats = 0;
        boolean freeSeatFound = false;
        for (int i = 0; i < cinemaRows.size(); i++) {
            for (int j = 0; j < COL_NUM; j++) {

                if (!emptyTheatre[i][j].isBooked()) {
                    freeSeatFound = true;
                    avalableSeats.add(emptyTheatre[i][j]);
                    break;
                }
            }
            if (freeSeatFound)
                break;
        }
        return avalableSeats;

    }


}
