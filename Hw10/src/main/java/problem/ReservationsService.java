package problem;

import java.util.Objects;

/**
 * Class ReservationService implements a reservation system for movie theaters that automatically
 * places users in the most desirable seats available for their party.
 */
public class ReservationsService {

  private Theater theater;
  private static final int MIDPOINT_DIVISOR = 2;

  public ReservationsService(Theater theater) {
    this.theater = theater;
  }

  // to show the theater
  public String show() {
    return theater.toString();
  }

  /**
   * This Method is reserving any number of seats for the user in one row.
   *
   * @param nameOfTheUser        - String, representing name of user
   * @param numberOfSeats        - int, representing number of seats
   * @param isAccessibleRequired - boolean, representing it it should be accessible
   * @param confirmReservation   - boolean, reserves the seats
   * @return - Returns the row number where available seats were found and reserved, -1 otherwise.
   */
  public int reserve(String nameOfTheUser, int numberOfSeats, boolean isAccessibleRequired,
      boolean confirmReservation) {

    int numberOfRows = theater.getRowList().size(); // give us the number of rows in theater
    int startRow = numberOfRows / MIDPOINT_DIVISOR;
    boolean reservationSucceeded = false;
    int numberOfRowsFromCenter = 0;
    while (!reservationSucceeded
        && (startRow - numberOfRowsFromCenter >= 0)
        && (startRow + numberOfRowsFromCenter < numberOfRows)) {
      int rowToCheck = startRow - numberOfRowsFromCenter;
      Row row = theater.getRowList().get(rowToCheck);
      if (isAccessibleRequired && !row.getAccessible()) {
        numberOfRowsFromCenter++;
        continue;
      }
      int countOfAvailableSeats = 0;
      for (Seat seat : row) {
        if (seat.getReservedFor() == null) {
          countOfAvailableSeats++;
        }
      }
      if (countOfAvailableSeats >= numberOfSeats) {
        int numberOfSeatsReserved = 0;
        if (confirmReservation) {
          for (Seat seat : row) {
            if (seat.getReservedFor() == null) {
              if (numberOfSeatsReserved < numberOfSeats) {
                seat.setReservedFor(nameOfTheUser);
                numberOfSeatsReserved++;
              }
            }
          }
        }
        return row.getRowNumber();
      } else {
        numberOfRowsFromCenter++;
      }
    }
    return -1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationsService that = (ReservationsService) o;
    return theater.equals(that.theater);
  }

  @Override
  public int hashCode() {
    return Objects.hash(theater);
  }

  @Override
  public String toString() {
    return "ReservationsService{" +
        "theater=" + theater +
        '}';
  }
}
