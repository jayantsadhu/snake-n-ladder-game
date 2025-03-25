package entities;

import exceptions.CellOutOfBoundException;

public class SnakeLadderBoard implements Board {

    private final Cell[] slBoard;
    private final int finalPosition;

    public SnakeLadderBoard(int finalPosition) {
        this.finalPosition = finalPosition;
        this.slBoard = new Cell[finalPosition+1];
        for(int cellNo=0 ; cellNo<=finalPosition ; cellNo++)
            slBoard[cellNo] = new Cell(cellNo, false, false, cellNo, cellNo);

    }
    public void setSnakeHead(int pos, int endPos) {
        if(pos>finalPosition || endPos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = slBoard[pos];
        cell.setSnakeHead(endPos);
    }

    public void resetSnakeHead(int pos) {
        if(pos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = slBoard[pos];
        cell.resetSnakeHead();
    }

    public void setLadderBottom(int pos, int endPos) {
        if(pos>finalPosition || endPos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = slBoard[pos];
        cell.setLadderBottom(endPos);
    }

    public void resetLadderBottom(int pos) {
        if(pos>finalPosition)
            throw new CellOutOfBoundException();
        Cell cell = slBoard[pos];
        cell.resetLadderBottom();
    }

    @Override
    public void move(Player player, int moveBy) {
        int curPos = player.getCurrentPosition();
        int endPos = curPos + moveBy;
        if(endPos>finalPosition) return;

        while(endPos!=slBoard[endPos].getFinalCellPosition())
            endPos = slBoard[endPos].getFinalCellPosition();

        player.setCurrentPosition(endPos);
        if(endPos==finalPosition)
            player.setWinner(true);
    }
}
