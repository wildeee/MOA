package moa;

public abstract class Node {

    private Board board;

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract int getResultado();

    public int getEstimatedRolls() {
        int count = 0;

        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (this.board.getPieceAt(row, col).getNumber() != Config.Answer[row][col].getNumber()) {
                    count++;
                }
            }
        }

        return count;
    }

}
