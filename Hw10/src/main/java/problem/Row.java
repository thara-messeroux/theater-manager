package problem;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Row, representing a row of the theater.
 */
public class Row extends ArrayList<Seat> {

  private int rowNumber;
  private boolean isAccessible;

  public Row(int rowNumber, boolean isAccessible) {
    this.rowNumber = rowNumber;
    this.isAccessible = isAccessible;
  }

  public int getRowNumber() {
    return rowNumber;
  }

  public void setRowNumber(int rowNumber) {
    this.rowNumber = rowNumber;
  }

  public boolean getAccessible() {
    return isAccessible;
  }

  public void setAccessible(boolean accessible) {
    isAccessible = accessible;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return rowNumber == seats.rowNumber && isAccessible == seats.isAccessible;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowNumber, isAccessible);
  }

  @Override
  public String toString() {

    // Printing out the row number & seats in a row
    String s = "";
    s = s + String.format("%2s", this.rowNumber); // allocates 2 position for the row number
    for (Seat seat : this) { // For each seat in a row
      if(seat.getReservedFor() == null) {
        if (isAccessible) {
          s = s + " =";
        } else {
          s = s + " _";
        }
      } else {
        s = s + " X";
      }
    }
    return s;
  }
}