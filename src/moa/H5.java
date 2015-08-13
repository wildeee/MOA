package moa;

/**
 *
 * @author Admin
 * Implementacao da Heuristica 5: valor maximo entre as heuristicas 1 2 e 3
 */
public class H5 implements IHeuristic {

    @Override
    public int getHeuristic(Board board) {
        return Integer.max(Integer.max(new H1().getHeuristic(board), new H2().getHeuristic(board)), new H3().getHeuristic(board));
    }
    
}
