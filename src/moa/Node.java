package moa;

import java.util.Objects;

public abstract class Node {

    private final Board board;

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract int getLevel();

    private int h1() { // Peças fora do lugar
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

    private int h2() { // Peças fora de sequencia
        EMovementType move = EMovementType.RIGHT;
        int count = 0;
        int row = 0;
        int col = 0;
        int lastPiece = this.board.getPieceAt(row, col).getNumber();
        col++;

        boolean[][] visited = new boolean[Config.BoardWidth][Config.BoardHeight];
        visited[0][0] = true;

        while (!(row == 2 && col == 1)) {

            if (this.board.getPieceAt(row, col).getNumber() != lastPiece + 1) {
                count++;
            }
            lastPiece = this.board.getPieceAt(row, col).getNumber();

            visited[row][col] = true;

            move = this.getNextMove(move, row, col, visited);
            switch (move) {
                case RIGHT:
                    col++;
                    break;
                case DOWN:
                    row++;
                    break;
                case LEFT:
                    col--;
                    break;
                case UP:
                    row--;
                    break;
            }
        }
        return count;
    }

    private int h3() { // Distância do lugar que deveria estar
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
                }
            }
        }
        return count;
    }

    private EMovementType getNextMove(EMovementType actualMovement, int row, int col, boolean[][] visited) {
        switch (actualMovement) {
            case RIGHT:
                if (col + 1 == Config.BoardWidth || visited[row][col + 1]) {
                    return EMovementType.DOWN;
                }
                break;
            case DOWN:
                if (row + 1 == Config.BoardHeight || visited[row + 1][col]) {
                    return EMovementType.LEFT;
                }
                break;
            case UP:
                if (row - 1 == -1 || visited[row - 1][col]) {
                    return EMovementType.RIGHT;
                }
                break;
            case LEFT:
                if (col - 1 == -1 || visited[row][col - 1]) {
                    return EMovementType.UP;
                }
                break;
        }
        return actualMovement;
    }

    public Integer getPeso() {
        return (int) Math.floor(((this.h1()) * 0.3) + (this.h2() * 0.3) + (this.h3() * 0.3) + this.getLevel());
    }

}
