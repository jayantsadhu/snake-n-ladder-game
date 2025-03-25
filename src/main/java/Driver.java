import entities.Board;
import entities.Dice;
import entities.Player;
import entities.SnakeLadderBoard;
import util.ConsolePrint;
import util.Print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) {

        Print print = ConsolePrint.getInstance();
        print.printMessage("Snake Ladder game!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxValue = 100;

        try {
            SnakeLadderBoard board = new SnakeLadderBoard(maxValue);
            Dice dice = new Dice(6);

            print.printMessage("Please enter snakes count: ");
            int s = Integer.parseInt(br.readLine());
            for(int i=1 ; i<=s; i++) {
                print.printMessage("Please enter snake "+i+" start and end positions respectively: ");
                String[] sPos = br.readLine().strip().split(" ");
                int start = Integer.parseInt(sPos[0]);
                int end = Integer.parseInt(sPos[1]);
                board.setSnakeHead(start, end);
            }
            print.printMessage("\n");

            print.printMessage("Please enter ladder count: ");
            int l = Integer.parseInt(br.readLine());
            for(int i=1 ; i<=l; i++) {
                print.printMessage("Please enter ladder "+i+" start and end positions respectively: ");
                String[] lPos = br.readLine().strip().split(" ");
                int start = Integer.parseInt(lPos[0]);
                int end = Integer.parseInt(lPos[1]);
                board.setLadderBottom(start, end);
            }
            print.printMessage("\n");

            print.printMessage("Please enter player count: ");
            int playerCount = Integer.parseInt(br.readLine());
            Player[] players = new Player[playerCount];
            for(int i=1 ; i<=playerCount ; i++) {
                print.printMessage("Please enter player "+i+" name: ");
                String playerName = br.readLine();
                players[i-1] = new Player(i, playerName, 0, false);
            }

            Player curPlayer = players[0];
            int step = 0;
            while(!curPlayer.isWinner()) {
                curPlayer = players[step%playerCount];
                int initialPos = curPlayer.getCurrentPosition();
                int diceRollVal = dice.playDice();
                board.move(curPlayer, diceRollVal);
                print.printMessage(curPlayer.getName()+" rolled a "+diceRollVal+" and moved from "+initialPos+" to "+curPlayer.getCurrentPosition());
                step++;
            }
            print.printMessage(curPlayer.getName()+" wins the game\n");
        } catch(Exception e) {
            print.printMessage(e.getMessage());
        }
        print.printMessage("Game is Over! Thanks for participating!");
    }
}
