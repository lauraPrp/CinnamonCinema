package org.laura.cinnamoncinema;

import java.util.*;
import java.util.stream.Collectors;

public class Cinema {

    private final Map<Integer,Character> cinemaRows;


    private final int COL_NUM = 5;

    private Seat[][] emptyTheatre;

    public Cinema() {
        cinemaRows = new Hashtable<>();
        cinemaRows.put(0, 'A');
        cinemaRows.put(1, 'B');
        cinemaRows.put(2, 'C');
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

    }

    private int findKey(char value){
        OptionalInt any = cinemaRows
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(), value))
                .mapToInt(Map.Entry::getKey)
                .findAny();
        return any.getAsInt();
    }


    public ArrayList<Seat> book(int seatsToBook) {
        ArrayList<Seat> assignedSeats=new ArrayList<>();
        final int allSeats = 15;
        final int MAX_BOOKABLE_SEATS = 3;
        int updatedSeat=0;
        if (seatsToBook > MAX_BOOKABLE_SEATS) throw new UnsupportedOperationException("You can book max 3 seats");

        while(updatedSeat<seatsToBook) {
           ArrayList<Seat> unassignedSeats = checkNextAvailableSeat();

           if (allSeats - unassignedSeats.size() < seatsToBook)
               throw new UnsupportedOperationException("No more seats available");
           else {

               Seat currentSeat = new Seat();
                   updateSeat(unassignedSeats.get(0).getRow(), unassignedSeats.get(0).getSeatNumber());

                   currentSeat.setRow(unassignedSeats.get(0).getRow());
                   currentSeat.setSeatNumber(unassignedSeats.get(0).getSeatNumber());
                   currentSeat.setBooked(true);

                   assignedSeats.add(currentSeat);
               updatedSeat++;

           }
       }

        return assignedSeats ;
    }

    private void updateSeat(char row, int num){
        Seat seatToUpdate =this.emptyTheatre[findKey(row)][num];
        seatToUpdate.setBooked(true);
        this.emptyTheatre[findKey(row)][num]=seatToUpdate;
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

    public int generateRandomBookingsNumber() {

        int min = 1;
        int max = 3;

        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }


}
