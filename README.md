# TheaterManagerSystem
Created a reservation system for movie theaters

Short Description of the TODO Application:
This program implements a reservation system for movie theaters that automatically 
places users in the most desirable seats available for their party. The user will be able to interact with the system in order to show the available seats, reserve seats with optional accessibility feature. The user also has the option to reserve up to 10 seats in a row, depending on the remaining available seats. The system is on a first come/ first serve basis, and will place the user at the best available seat at the moment which means it will start from the middle and out. The purpose of this is not to be too far or too close to the cinema screen. If no rows contain a sufficient number of unreserved seats, the system will apologize and decline to make a reservation. The “show” command indicates which rows are wheelchair-accessible. Whereas seats in rows that are not accessible are represented by “_”, seats in rows that are wheelchair accessible should be represented by “=”.

![Theater](https://media.github.ccs.neu.edu/user/8933/files/88dcf900-1241-11ec-8759-0d5f3e049966)

Todo data structure
A Theater Reservation System contains 5 classes:

1. ReservationsService
2. ReservationSystem
3. Row
4. Seat
5. Theater

ReservationsService class
1. Class ReservationService implements a reservation system for movie theaters that automatically places users in the most desirable seats available for their party.

ReservationSystem class
2. Class ReservationSystem, creates a theater and interacts with the user

Row class
3. Class Row, representing a row of the theater.

Seat class
4. Class Seat representing a seat of the row

Theater class
5.Class Theater, representing a theater
