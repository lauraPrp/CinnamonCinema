package org.laura.cinnamoncinema;

import java.util.*;

public class Cinema {

    private final Map<Integer, Character> cinemaRows;
    private final int ROW_NUM = 3;
    private final int COL_NUM = 5;
    int MAX_SEATS_NUMBER = 15;
    private Seat[][] allSeats;

    public Cinema() {
        cinemaRows = new Hashtable<>();
        cinemaRows.put(0, 'A');
        cinemaRows.put(1, 'B');
        cinemaRows.put(2, 'C');

        allSeats = new Seat[ROW_NUM][COL_NUM];
        for (int i = 0; i < cinemaRows.size(); i++) {
            for (int j = 0; j < COL_NUM; j++) {
                Seat currentSeat = new Seat();
                currentSeat.setBooked(false);
                currentSeat.setRow(cinemaRows.get(i));
                currentSeat.setSeatNumber(j);
                allSeats[i][j] = currentSeat;
            }
        }
    }

    public ArrayList<Seat> book(int seatsToBook) {
        final int MAX_BOOKABLE_SEATS = 3;

        ArrayList<Seat> assignedSeats = new ArrayList<>();
        if (getAlreadyBookedSeats() == MAX_SEATS_NUMBER)
            throw new UnsupportedOperationException("No more seats available");

        if (seatsToBook > MAX_BOOKABLE_SEATS)
            throw new UnsupportedOperationException("You can book max 3 seats");

        int updatedSeat = 0;
        while (updatedSeat < seatsToBook) {

            if (MAX_SEATS_NUMBER - getAlreadyBookedSeats() < seatsToBook - updatedSeat)
                throw new UnsupportedOperationException("Not enough seats available");
            else {
                Seat currentSeat = checkFirstAvailableSeat();
                currentSeat.setBooked(true);
                this.allSeats[findRowNumber(currentSeat.getRow())][currentSeat.getSeatNumber()] = currentSeat;
                assignedSeats.add(currentSeat);
                updatedSeat++;
            }
        }
        return assignedSeats;
    }

    public Seat[][] getAllSeats() {
        return allSeats;
    }

    private Seat checkFirstAvailableSeat() {
        Seat firstAvailableSeat = new Seat();

        for (int i = 0; i < cinemaRows.size(); i++) {
            for (int j = 0; j < COL_NUM; j++) {
                if (!allSeats[i][j].isBooked()) {
                    return allSeats[i][j];
                }
            }
        }
        return firstAvailableSeat;
    }


    public int getAlreadyBookedSeats() {
        int bookedSeats = 0;
        for (int i = 0; i < cinemaRows.size(); i++) {
            for (int j = 0; j < COL_NUM; j++) {
                if (allSeats[i][j].isBooked()) {
                    bookedSeats++;
                }
            }
        }
        return bookedSeats;
    }

    private int findRowNumber(char value) {
        OptionalInt any = cinemaRows
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(), value))
                .mapToInt(Map.Entry::getKey)
                .findAny();
        return any.getAsInt();
    }
}