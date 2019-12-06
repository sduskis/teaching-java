package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

  private static class TextFields {
    private final TextField[][] values;

    public TextFields() {
      values = new TextField[9][9];
      for (int x = 0; x < 9; x++) {
        for (int y = 0; y < 9; y++) {
          values[x][y] = new TextField();
          values[x][y].setText("-");
          values[x][y].setMaxWidth(30);
        }
      }
    }

    GridPane constructGridPane(int row, int col) {
      GridPane gridPane = new GridPane();
      int startX = row * 3;
      int startY = col * 3;
      for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
          gridPane.add(values[startX + x][startY + y], y, x);
        }
      }
      return gridPane;
    }
  }

  static TextFields textFields;

  @Override public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Sudoku");

    textFields = new TextFields();

    GridPane valuePane = new GridPane();
    valuePane.setHgap(5);
    valuePane.setVgap(5);
    valuePane.setGridLinesVisible(true);
    GridPane[][] subPanes = new GridPane[3][3];
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        subPanes[x][y] = textFields.constructGridPane(x, y);
        subPanes[x][y].setGridLinesVisible(false);
        valuePane.add(subPanes[x][y], y, x);
      }
    }

    Button button = new Button("Print");
    button.onActionProperty().setValue(Control.createPrintHandler(textFields.values));
    BorderPane root = new BorderPane();
    root.setCenter(valuePane);
    root.setBottom(button);

    BorderPane.setAlignment(button, Pos.BOTTOM_CENTER);
    BorderPane.setAlignment(valuePane, Pos.CENTER);
    primaryStage.setScene(new Scene(root, 400, 450));
    updateBoard();
    primaryStage.show();

  }

  private void updateBoard() {
    setValues(Playground.getArray());
  }

  static void setValues(int[][] board) {
    if (board.length != 9) {
      System.err.println("ERROR! BAD ARRAY! It has " + board.length + " rows.");
      return;
    }
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y++) {
        if (board[x].length != 9) {
          System.err.println("ERROR! BAD ARRAY! It has " + board[x].length + " columns in row " + x);
          return;
        }
        if (board[x][y] > 9 || board[x][y] < 0) {
          System.err.printf("ERROR! BAD ARRAY! board[%d][%d] = %d\n", x, y, board[x][y]);
          return;
        }
        String s = board[x][y] == 0 ? "-" : String.valueOf(board[x][y]);
        textFields.values[x][y].setText(s);
      }
    }
    System.err.println("Very nice array.  You win the prize");
  }

  public static void main(String[] args) {
    launch(args);

  }
}
