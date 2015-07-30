package moa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board implements Cloneable {

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
            col++;
        }
    }
    
    public Board(Board board){
        this.id = Board.idCount++;
        try {
            Board b = (Board) board.clone();
            this.empty = b.empty;
            this.pieces = b.pieces;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Piece getEmptyPiece() {
        return this.empty;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Board)) {
            return false;
        }
        return this.id == ((Board) obj).id;
    }

    public Piece getPieceAt(int row, int col) {
        return this.pieces[row][col];
    }

    public boolean checkWin() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (!this.pieces[row][col].equals(Config.Answer[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board movePiece(EMovementType moveType) throws InvalidMovementException {
        Board returnBoard = new Board(this);
        switch (moveType){
            case UP:      
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            default:
                throw new UnsupportedOperationException("Operação não suportada.");
        }
        return returnBoard;
    }
}
