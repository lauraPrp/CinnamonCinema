
# CinnamonCinema  Movie Theatre Seating Challenge
**Test-Driven Development approach - RED-GREEN-REFACTOR**

**This program allocate seats to customers purchasing tickets for a movie theatre. Cinnamon Cinemas provided some criteria for how the program should be built.**

> The Cinnamon Cinemas Movie Theatre has 15 seats, arranged in 3 rows of
> 5 Rows are assigned a letter from a to c Seats are assigned a number
> from 1 to 5

**Acceptance Criteria and Assumptions**
The program allocates seats based on a ***random integer “number of seats” between 1 and 3*** from the available seats starting from seat A1 and filling the auditorium from  left to right, front to back
All of the seats are available for sale when the program starts  and the program continue to allocate a random number of seats ~~*until it finds there are not enough seats left to complete the request*~~  Until no more seat is available
**Once there are not enough seats available to be allocated then the program can halt**

Tunning the class App/Main.java program starts and assignements are visible the console/shell
- Seats are organised in a grid of rows A to C and seats number 1 to 5
- all seats are unassigned (U - purple)
- a random generated number between 1 and 3 is defined and a red message "seat purchased: " is shown
- seats become assigned (A - yellow)
- When all seat are allocated a red "SOLD OUT" is printed
- There might be not enough seats to allocatem, the programs alert with a red "Not enough seats available" message

![image ](.....)

*****************************************************************************************
**Further improvements**
- the customer can choose their seats
