/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moa;

/**
 *
 * @author Admin
 * Implementacao da Heuristica 4: dar um peso para cada heuristica de 1 a 3, multiplicando os resultados por esse peso, de forma que a soma de todos os pesos seja igual a 1
 */
public class H4 implements IHeuristic {

    @Override
    public int getHeuristic(Board board) {
        final double p1 = 0.3;
        final double p2 = 0.3;
        final double p3 = 0.4;
        
        return (int) Math.floor((new H1().getHeuristic(board) * p1) + (new H2().getHeuristic(board) * p2) + (new H3().getHeuristic(board) * p3));
        
    }
    
}