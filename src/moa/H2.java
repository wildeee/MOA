package moa;

/**
 *
 * @author Admin Implementacao da heuristica 2: Numero de pecas fora de
 * sequencia na configuracao final
 */
public class H2 implements IHeuristic {

    @Override
    public int getHeuristic(Board board) {
        EMovementType move = EMovementType.RIGHT;
        int count = 0;
        int row = 0;
        int col = 0;
        int lastPiece = board.getPieceAt(row, col).getNumber();
        col++;

        boolean[][] visited = new boolean[Config.BoardWidth][Config.BoardHeight];
        visited[0][0] = true;

        while (!(row == 2 && col == 1)) {

            if (board.getPieceAt(row, col).getNumber() != lastPiece + 1) {
                count++;
            }
            lastPiece = board.getPieceAt(row, col).getNumber();

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

}
