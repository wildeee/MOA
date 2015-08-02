package moa;

import java.util.Comparator;
import java.util.Objects;

public abstract class Node implements Comparator<Node> {

    private final Board board;

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract int getLevel();

    private int getEstimatedRolls() {
        int count = 0;

        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (!Objects.equals(this.board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
                    int target = Config.Answer[row][col].getNumber();
                    for (int i = 0; i < Config.BoardWidth; i++) {
                        for (int j = 0; j < Config.BoardHeight; j++) {
                            if (target == this.board.getPieceAt(i, j).getNumber()) {
                                count += Math.abs(row - i) + Math.abs(col + j);
                            }
                        }
                    }
//                    count++;
                }
            }
        }

//        for (int row = 0; row < Config.BoardWidth; row++) {
//            for (int col = 0; col < Config.BoardHeight; col++) {
//                if (!Objects.equals(this.board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
//                    count++;
//                }
//            }
//        }
        return count;
    }

    private int getWrongPiecesAmount() {
        int count = 0;
        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (!Objects.equals(this.board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int compare(Node n1, Node n2) {
        return (n1.getEstimatedRolls()) - (n2.getEstimatedRolls());
    }

}
