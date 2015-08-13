package moa;

public class Config {

    public static final int EmptyPiece = 0;

    public static final int BoardWidth = 4;

    public static final int BoardHeight = 4;

    public static final Piece[][] Answer = {
        {
            new Piece(1),
            new Piece(2),
            new Piece(3),
            new Piece(4)
        }, {
            new Piece(12),
            new Piece(13),
            new Piece(14),
            new Piece(5)},
        {
            new Piece(11),
            new Piece(0),
            new Piece(15),
            new Piece(6)
        }, {
            new Piece(10),
            new Piece(9),
            new Piece(8),
            new Piece(7)
        }
    };

    public static final IHeuristic Heuristica = new H5();
}
