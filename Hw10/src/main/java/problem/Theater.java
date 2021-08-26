package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Theater, representing a theater
 */
public class Theater {

  private String name;
  private List<Row> rowList;
  private List<Integer> accessibleRows;

  public Theater(String name, List<Row> rowList) {
    this.name = name;
    this.rowList = rowList;
    this.accessibleRows = new ArrayList<>();
    for (Row singleRow : rowList) {
      if (singleRow.getAccessible()) {
        accessibleRows.add(singleRow.getRowNumber());
      }
    }
    validateAccessibleRows();
  }

  public void validateAccessibleRows() {
    if (this.accessibleRows.size() == 0) {
      throw new IllegalArgumentException("Error : There should be a least 1 accessible row!");
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Row> getRowList() {
    return rowList;
  }

  public void setRowList(List<Row> rowList) {
    this.rowList = rowList;
  }

  public List<Integer> getAccessibleRows() {
    return accessibleRows;
  }

  public void setAccessibleRows(List<Integer> accessibleRows) {
    this.accessibleRows = accessibleRows;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Theater theater = (Theater) o;
    return name.equals(theater.name) && rowList.equals(theater.rowList) && accessibleRows
        .equals(theater.accessibleRows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, rowList, accessibleRows);
  }

  @Override
  public String toString() {
    String s = "";
    for (Row row : rowList) {
      s = s + row.toString() + System.lineSeparator(); // Calling the toString method on the row
    }
    return s;
  }
}