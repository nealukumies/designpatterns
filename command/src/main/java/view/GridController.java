package view;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static java.lang.Math.max;


//This is the receiver class that contains the core logic for managing the grid, cursor movement, and pixel toggling.
//
public class GridController{
    int gridSize = 8;
    int cellSize = 32;
    private Rectangle[][] cells = new Rectangle[gridSize][gridSize];
    private int[][] pixelData = new int[gridSize][gridSize];
    private int cursorRow = 0;
    private int cursorCol = 0;

    public GridPane buildGruid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));

        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                Rectangle rectangle = new Rectangle(cellSize, cellSize);
                rectangle.setFill(Color.MEDIUMPURPLE);
                rectangle.setStroke(Color.BLACK);
                grid.add(rectangle, col, row);
                cells[row][col] = rectangle;
            }
        }
        updateCursor();
        return grid;
    }

    public void moveCursorUp() {
        cells[cursorRow][cursorCol].setStroke(Color.BLACK);
        cursorRow = max(0, Math.min(0, cursorRow - 1));
        updateCursor();
    }
    public void moveCursorDown() {
        cells[cursorRow][cursorCol].setStroke(Color.BLACK);
        cursorRow = max(0, Math.min(gridSize - 1, cursorRow + 1));
        updateCursor();
    }
    public void moveCursorLeft() {
        cells[cursorRow][cursorCol].setStroke(Color.BLACK);
        cursorCol = max(0, Math.min(gridSize - 1, cursorCol - 1));
        updateCursor();
    }
    public void moveCursorRight() {
        cells[cursorRow][cursorCol].setStroke(Color.BLACK);
        cursorCol = max(0, Math.min(gridSize - 1, cursorCol + 1));
        updateCursor();
    }

    private void updateCursor() {
        cells[cursorRow][cursorCol].setStroke(Color.RED);
    }

    public void toggleCell() {
        Rectangle cell = cells[cursorRow][cursorCol];
        if (cell.getFill() == Color.MEDIUMPURPLE) {
            cell.setFill(Color.LIGHTGOLDENRODYELLOW);
            pixelData[cursorRow][cursorCol] = 1;
        } else {
            cell.setFill(Color.MEDIUMPURPLE);
            pixelData[cursorRow][cursorCol] = 0;
        }
    }

    public int[][] getPixelData() {
        return pixelData;
    }

}
