/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moa;

import java.util.Objects;

/**
 *
 * @author Admin Implementacao da heuristica 3: distancia retangular da posicao
 * de destino na configuracao final
 */
public class H3 implements IHeuristic {

    @Override
    public int getHeuristic(Board board) {
        int count = 0;
        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (!Objects.equals(board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
                    int target = Config.Answer[row][col].getNumber();
                    for (int i = 0; i < Config.BoardWidth; i++) {
                        for (int j = 0; j < Config.BoardHeight; j++) {
                            if (target == board.getPieceAt(i, j).getNumber()) {
                                count += Math.abs(row - i) + Math.abs(col - j);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
