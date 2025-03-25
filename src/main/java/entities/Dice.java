package entities;

import java.util.Random;

public class Dice {
    private int maxValue;

    public Dice(int maxValue) {
        this.maxValue = maxValue;
    }

    public int playDice() {
        Random random = new Random();
        return random.nextInt(1, maxValue+1);
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
