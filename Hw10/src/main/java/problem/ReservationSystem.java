package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class ReservationSystem, creates a theater and interacts with the user
 */
public class ReservationSystem {

  private static final int SEAT_PER_ROW = 10;
  private static final int ASCII_A = 65;
  private static final int NUMBER_OF_ROWS = 15;
  private static final int FIRST_ROW_NUMBER = 1;

  /**
   * Interacts with the user
   *
   * @param args -  contains the supplied command-line arguments as an array of String objects.
   */
  public static void main(String[] args) {

    // Create a Theater
    Theater theater = createTheater();
    ReservationsService reservationsService = new ReservationsService(theater);
    Scanner input = new Scanner(System.in); // get a reference from the keyboard to read user input
    // Interacting with user
    boolean isDone = false;
    while (!isDone) {
      System.out.println("What would you like to do?");
      String command = input.next();
      if (command.equalsIgnoreCase("Show")) { // Homogenisation
        System.out.println(reservationsService.show());
        System.out.println();
      } else if (command.equalsIgnoreCase("Done")) { // Homogenisation
        return;
      } else if (command.equalsIgnoreCase("Reserve")) { // Homogenisation
        int numberOfSeatsRequired = input.nextInt();
        System.out.println("Do you need wheelchair accessible seats?");
        String response = input.next(); // gives us the next thing that the user typed in
        boolean isAccessibleRequired = response.equalsIgnoreCase("Yes");
        int isReservationSucceeded = reservationsService
            .reserve(null, numberOfSeatsRequired, isAccessibleRequired,
                false);
        if (isReservationSucceeded >= 0) {
          input.nextLine();
          System.out.println("What's your name?");
          String name = input.nextLine(); // for Jean Claude
          isReservationSucceeded = reservationsService
              .reserve(name, numberOfSeatsRequired, isAccessibleRequired,
                  true);
          if (isReservationSucceeded >= 0) {
            System.out.println("I've reserved " + numberOfSeatsRequired
                + " seats for you at the Roxy in row, " + isReservationSucceeded + ", " + name
                + ".");
          }
          System.out.println(reservationsService.show());

        } else {
          System.out.println("Sorry, we don't have that many seats together for you. ");
        }
      }
    }
  }

  /**
   * Creates a theater
   *
   * @return - Returns a Theater
   */
  public static Theater createTheater() {
    String name = "Boch Theater";
    List<Row> rowList = new ArrayList<>();

    // creating the 1st row
    for (int i = 0; i < NUMBER_OF_ROWS; i++) {
      boolean isAccessible = i % 2 == 0; // when i even, accessible = true
      Row row = new Row(i + FIRST_ROW_NUMBER, isAccessible);

      // creating seat name
      for (int j = 0; j < SEAT_PER_ROW; j++) {
        char seatName = ASCII_A;
        seatName += j;

        // creating a seat
        Seat seat = new Seat(String.valueOf(seatName));
        row.add(seat);
      }
      rowList.add(row);
    }
    Theater theater = new Theater(name, rowList);
    return theater;
  }
}
