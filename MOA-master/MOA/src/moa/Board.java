package moa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board implements Cloneable {

    private static int idCount = 0;
    private final int id;
    private EmptyPiece empty;

    private Piece[][] pieces;

    public Board(List<Piece> pieces) {
        this.id = Board.idCount++;

        this.pieces = new Piece[Config.BoardWidth][Config.BoardHeight];
        int index;
        Piece iterationPiece;
        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                index = (row * Config.BoardWidth) + col;
                iterationPiece = pieces.get(index);
                if (iterationPiece.getNumber() == Config.EmptyPiece) {
                    EmptyPiece emp = new EmptyPiece(iterationPiece, row, col);
                    this.empty = emp;
                    this.pieces[row][col] = emp;
                } else {
                    this.pieces[row][col] = new Piece(iterationPiece);
                }
            }
        }

    }

    public Board(Board board) {
        this.id = Board.idCount++;
        try {
            Board b = (Board) board.clone();
            this.empty = b.empty;
            this.pieces = b.pieces;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EmptyPiece getEmptyPiece() {
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
        Piece target;
        switch (moveType) {
            case UP:
                if (this.empty.getRow() + 1 == Config.BoardHeight) {
                    throw new InvalidMovementException();
                }

                target = this.pieces[this.empty.getRow() + 1][this.empty.getCol()];

                break;
            case DOWN:
                if (this.empty.getRow() - 1 == -1) {
                    throw new InvalidMovementException();
                }

                target = this.pieces[this.empty.getRow() - 1][this.empty.getCol()];
                //Verificar como dar um "swap" nos valores
                break;
            case LEFT:
                if (this.empty.getCol() + 1 == Config.BoardWidth) {
                    throw new InvalidMovementException();
                }

                target = this.pieces[this.empty.getRow()][this.empty.getCol() + 1];
                break;
            case RIGHT:
                if (this.empty.getCol() - 1 == -1) {
                    throw new InvalidMovementException();
                }

                target = this.pieces[this.empty.getRow()][this.empty.getCol() - 1];
                break;
            default:
                throw new UnsupportedOperationException("Operação não suportada.");
        }
        return returnBoard;
    }
}
