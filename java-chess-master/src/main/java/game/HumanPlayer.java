package game;

import board.Board;
import board.Position;
import move.Move;
import move.MovePositions;
import piece.Color;
import piece.PieceType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public HumanPlayer(Color color) {
        super(color);
    }

    @Override
    public PieceType getTypeForPromotion(Board board) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What piece type would you like to getTypeForPromotion to?");
            return PieceType.valueOf(bufferedReader.readLine());
        } catch (Exception e) {
            System.out.println("That's not a type you can getTypeForPromotion to.  Please try again.");
            return getTypeForPromotion(board);
        }
    }

    @Override
    public Move makeNextMove(Board board) {
        Position start = getPosition(color.name() + " make your move.  Enter the start position of your move:");
        Position end = getPosition("Now enter the end position:");
        return new Move(new MovePositions(start, end), board, this);
    }

    private Position getPosition(String message) {
        try {
            System.out.println(message);
            return new Position(bufferedReader.readLine());
        } catch (Exception e) {
            System.out.println("I didn't understand that.  Please try again.");
            return getPosition(message);
        }
    }
}
