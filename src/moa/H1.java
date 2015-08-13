package moa;

import java.util.Objects;

/**
 *
 * @author Admin Implementacao da Heuristica 1: numero de pecas fora da
 * configuracao final
 */
public class H1 implements IHeuristic {

    @Override
    public int getHeuristic(Board board) {
        int count = 0;
        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (!Objects.equals(board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
                    count++;
                }
            }
        }
        return count;
    }

}
