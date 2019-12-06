package sample;

import static java.lang.System.out;

public class Playground {
  public static int[][] getArray() {
    int[][] board = {
        {0, 6, 0, 8, 0, 0, 0, 0, 0},
        {2, 0, 0, 1, 0, 0, 3, 4, 0},
        {0, 0, 0, 0, 5, 0, 0, 0, 9},
        {6, 1, 0, 0, 0, 0, 0, 3, 0},
        {3, 0, 0, 2, 4, 5, 0, 0, 8},
        {0, 8, 0, 0, 0, 0, 0, 9, 5},
        {1, 0, 0, 0, 2, 0, 0, 0, 0},
        {0, 9, 6, 0, 0, 3, 0, 0, 7},
        {0, 0, 0, 0, 0, 9, 0, 5, 0}
    };
    return board;
  }

  public static void main(String[] args) {
    printMe(getArray());
  }

  private static void printMe(int[][] a) {
    for (int y = 0; y < 9; y++) {
      for (int x = 0; x < 9; x++) {
        out.print(a[y][x]);
        out.print(" ");
      }
      out.println();
      if (y % 3 == 2) {
        printARow();
      }
    }
  }

  private static void printARow() {
    for (int i = 0; i < 18; i++) {
      out.print("-");
    }
    out.println();
  }
}
