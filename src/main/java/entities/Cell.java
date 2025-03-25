package entities;

public class Cell {
    private int position;
    private boolean snakeHead;
    private boolean ladderBottom;
    private int snakeTail;
    private int ladderTop;

    public Cell(int position, boolean snakeHead, boolean ladderBottom, int snakeTail, int ladderTop) {
        this.position = position;
        this.snakeHead = snakeHead;
        this.ladderBottom = ladderBottom;
        this.snakeTail = snakeTail;
        this.ladderTop = ladderTop;
    }

    public int getFinalCellPosition() {
        int newPosition = position;
        if(snakeHead)
            newPosition = snakeTail;
        else if(ladderBottom)
            newPosition = ladderTop;
        return newPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(int snakeTail) {
        snakeHead = true;
        this.snakeTail = snakeTail;
    }

    public void resetSnakeHead() {
        snakeHead = false;
        snakeTail = position;
    }

    public boolean isLadderBottom() {
        return ladderBottom;
    }

    public void setLadderBottom(int ladderTop) {
        ladderBottom = true;
        this.ladderTop = ladderTop;
    }

    public void resetLadderBottom() {
        ladderBottom = false;
        this.ladderTop = position;
    }

    public int getSnakeTail() {
        return snakeTail;
    }

    public void setSnakeTail(int snakeTail) {
        this.snakeTail = snakeTail;
    }

    public int getLadderTop() {
        return ladderTop;
    }

    public void setLadderTop(int ladderTop) {
        this.ladderTop = ladderTop;
    }
}
