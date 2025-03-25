package entities;

public class Player {
    private int id;
    private String name;
    private int currentPosition;
    private boolean winner;

    public Player(int id, String name, int currentPosition, boolean winner) {
        this.id = id;
        this.name = name;
        this.currentPosition = currentPosition;
        this.winner = winner;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
