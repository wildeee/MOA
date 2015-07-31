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
                Piece emp = new Piece(iterationPiece);
                if (iterationPiece.getNumber() == Config.EmptyPiece) {
                    this.empty = new EmptyPiece(row, col);
                }
                this.pieces[row][col] = emp;
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

    public Piece getEmptyPiece() {
        return this.pieces[this.empty.getRow()][this.empty.getCol()];
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
        int row, col;
        switch (moveType) {
            case UP:
                row = this.empty.getRow() + 1;
                col = this.empty.getCol();
                if (row == Config.BoardHeight) {
                    throw new InvalidMovementException();
                }

                break;
            case DOWN:
                row = this.empty.getRow() - 1;
                col = this.empty.getCol();
                if (row == -1) {
                    throw new InvalidMovementException();
                }                
                break;
            case LEFT:
                row = this.empty.getRow();
                col = this.empty.getCol() + 1;
                if (col == Config.BoardWidth) {
                    throw new InvalidMovementException();
                }

                break;
            case RIGHT:
                row = this.empty.getRow();
                col = this.empty.getCol() - 1;
                if (col == -1) {
                    throw new InvalidMovementException();
                }
                break;
            default:
                throw new UnsupportedOperationException("Operação não suportada.");
        }
        this.swapPieces(returnBoard, row, col);
        return returnBoard;
    }

    private void swapPieces(Board board, int row, int col) {
        Piece temp = board.getEmptyPiece();
        board.pieces[board.empty.getRow()][board.empty.getCol()] = board.pieces[row][col];
        board.pieces[row][col] = temp;
        board.empty.setRow(row);
        board.empty.setCol(col);
    }
}
