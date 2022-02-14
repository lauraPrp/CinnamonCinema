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
        final String ERR_NO_MORE_SEATS_AVAILABLE = "No more seats available";
        final String ERR_NOT_ENOUGH_SEATS_AVAILABLE = "Not enough seats available";
        final String ERR_TOO_MANY_TICKET_REQUESTED = "You can book max " + MAX_BOOKABLE_SEATS + " seats";

        ArrayList<Seat> assignedSeats = new ArrayList<>();
        if (getAlreadyBookedSeats() == MAX_SEATS_NUMBER)
            throw new UnsupportedOperationException(ERR_NO_MORE_SEATS_AVAILABLE);

        if (seatsToBook > MAX_BOOKABLE_SEATS)
            throw new UnsupportedOperationException(ERR_TOO_MANY_TICKET_REQUESTED);

        int updatedSeat = 0;
        while (updatedSeat < seatsToBook) {

            if (MAX_SEATS_NUMBER - getAlreadyBookedSeats() < seatsToBook - updatedSeat)
                throw new UnsupportedOperationException(ERR_NOT_ENOUGH_SEATS_AVAILABLE);
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


    private int getAlreadyBookedSeats() {
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



    private int findRowNumber(char value) throws IllegalStateException {
        final int ERROR_IN_FINDING_ROW_NUMBER = 9;
        OptionalInt any = cinemaRows
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(), value))
                .mapToInt(Map.Entry::getKey)
                .findAny();
        try {
            if (any.isPresent()) {
                return any.getAsInt();
            }
        } catch (IllegalStateException ise) {
            ise.printStackTrace();
        }
        // this should never happen, cinemaRows is never empty
        return ERROR_IN_FINDING_ROW_NUMBER;
    }
    public void print() {
        final String ANSI_COLOUR_YELLOW = "\u001B[33m";
        final String ANSI_COLOUR_PURPLE = "\u001B[35m";
        final String ANSI_COLOUR_RED = "\u001B[31m";
        final String ASSIGNED_SEAT = "A";
        final String UNASSIGNED_SEAT = "U";
        Seat[][] seats = allSeats;
        for (int i = 0; i < seats.length; i++) { //rows
            if(i==0){
                System.out.print( ANSI_COLOUR_RED+"   1  2  3  4  5\na");
            }else if(i==1)
                System.out.print( "b");
            else if(i==2)
                System.out.print( "c");
            for (int j = 0; j < seats[i].length; j++) { //cols

                if (seats[i][j].isBooked()) {
                    System.out.print(ANSI_COLOUR_YELLOW + "  " +
                            ASSIGNED_SEAT +
                            ANSI_COLOUR_RED);
                } else {
                    System.out.print(ANSI_COLOUR_PURPLE + "  " +
                            UNASSIGNED_SEAT +
                            ANSI_COLOUR_RED);
                }
            }
            System.out.println();
        }
    }
}

