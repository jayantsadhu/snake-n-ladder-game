package services;

import entities.Board;
import entities.Cell;
import entities.Player;
import exceptions.CellOutOfBoundException;
import repositories.BoardRepo;

public class SnakeLadderBoard implements Board {

    private final BoardRepo boardRepo;
    private final int finalPosition;

    public SnakeLadderBoard(int finalPosition) {
        boardRepo = BoardRepo.getInstance();
        this.finalPosition = finalPosition;
        for(int cellNo=0 ; cellNo<=finalPosition ; cellNo++)
            boardRepo.addCell(new Cell(cellNo, false, false, cellNo, cellNo));

    }
    public void setSnakeHead(int pos, int endPos) {
        if(pos>finalPosition || endPos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = boardRepo.getCell(pos);
        cell.setSnakeHead(endPos);
    }

    public void resetSnakeHead(int pos) {
        if(pos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = boardRepo.getCell(pos);
        cell.resetSnakeHead();
    }

    public void setLadderBottom(int pos, int endPos) {
        if(pos>finalPosition || endPos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = boardRepo.getCell(pos);
        cell.setLadderBottom(endPos);
    }

    public void resetLadderBottom(int pos) {
        if(pos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = boardRepo.getCell(pos);
        cell.resetLadderBottom();
    }

    @Override
    public void move(Player player, int moveBy) {
        int curPos = player.getCurrentPosition();
        int endPos = curPos + moveBy;
        if(endPos>finalPosition) return;

        while(endPos!=boardRepo.getCell(endPos).getFinalCellPosition())
            endPos = boardRepo.getCell(endPos).getFinalCellPosition();

        player.setCurrentPosition(endPos);
        if(endPos==finalPosition)
            player.setWinner(true);
    }
}
