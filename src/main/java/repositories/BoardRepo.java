package repositories;

import entities.Cell;
import exceptions.CellOutOfBoundException;
import util.ConsolePrint;
import util.Print;

import java.util.ArrayList;
import java.util.List;

public class BoardRepo {
    private final List<Cell> board;

    public BoardRepo() {
        board = new ArrayList<>();
    }

    public Cell getCell(int pos) {
        return board.get(pos);
    }

    public Cell setCell(int pos, Cell cell) {
        return board.set(pos, cell);
    }

    public void addCell(Cell cell) {
        board.add(cell);
    }

    public static BoardRepo getInstance() {
        return SingletonInstance.INSTANCE;
    }

     static class SingletonInstance {
          private final static BoardRepo INSTANCE = new BoardRepo();
    }
}
