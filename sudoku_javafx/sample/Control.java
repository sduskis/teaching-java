package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class Control {

  public static EventHandler<ActionEvent> createPrintHandler(TextField[][] textFields) {
    return event -> {
      System.out.println("int[][] board = {");
      for (int x = 0; x < 9; x++) {
        System.out.print("\t{");
        for (int y = 0; y < 9; y++) {
          String value = textFields[x][y].getText();
          if (value.equals("-")) {
            System.out.print(0);
          } else {
            System.out.print(value);
          }
          if (y != 8) {
            System.out.print(", ");
          }
        }
        System.out.println("}");
      }
      System.out.println("}");
    };
  }
}
