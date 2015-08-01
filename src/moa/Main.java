package moa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> num = InputManager.ConsoleRead();
        List<Piece> pieces = new ArrayList<>();
        for (Integer inteiro : num) {
            pieces.add(new Piece(inteiro));
        }
        System.out.println(new TreeController(
                new Root(
                        new Board(pieces)
                )
        ).calculateMinPlays()
        );
    }

}
