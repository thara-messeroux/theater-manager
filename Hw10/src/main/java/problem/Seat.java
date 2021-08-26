package problem;

import java.util.Objects;

/**
 * Class Seat representing a seat of the row
 */
public class Seat {

  private String name;
  private String reservedFor = null;

  public Seat(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReservedFor() {
    return reservedFor;
  }

  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    return name.equals(seat.name) && reservedFor.equals(seat.reservedFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, reservedFor);
  }

  @Override
  public String toString() {
    if (reservedFor == null) {
      return "_";
    } else {
      return "X";
    }
  }
}

