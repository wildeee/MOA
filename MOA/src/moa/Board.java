package moa;

import java.util.List;

public class Board { 

    private static int idCount = 0;
    private final int id;
    private Piece empty;

    private Piece[][] pieces;

    public Board(List<Piece> pieces) {
        this.id = Board.idCount++;

        this.pieces = new Piece[Config.BoardWidth][Config.BoardHeight];
        
        int row = 0;
        int col = 0;

        for (Piece piece : pieces) {
            Piece newPiece = new Piece(piece);
            if (newPiece.getNumber() == Config.EmptyPiece) {
                this.empty = newPiece;
            }
            
            if (col > 3) {
                col = 0;
                row++;
            }
            
            this.pieces[row][col] = newPiece;
            
        }
    }

    public Piece getEmptyPiece() {
        return this.empty;
    }
    
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Board))
            return false;
        return this.id == ((Board) obj).id;
    }

    public boolean checkWin() {        
        return false;
    }

}
