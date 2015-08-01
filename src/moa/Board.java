package moa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board implements Cloneable {

    private String id;
    private EmptyPiece empty;

    private Piece[][] pieces;

    public Board(List<Piece> pieces) {

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
        this.id = this.calculateHash();
    }

    public Board(Board board) {
        this.pieces = new Piece[Config.BoardWidth][Config.BoardHeight];
        try {
            Board b = (Board) board.clone();
            this.empty = new EmptyPiece(b.empty.getRow(), b.empty.getCol());
            for (int i = 0; i < Config.BoardWidth; i++) {
                for (int j = 0; j < Config.BoardHeight; j++) {
                    this.pieces[i][j] = new Piece(b.pieces[i][j]);
                }
            }

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
        return (this.id == null ? ((Board) obj).id == null : this.id.equals(((Board) obj).id));
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
        returnBoard.id = returnBoard.calculateHash();

        return returnBoard;
    }

    private void swapPieces(Board board, int row, int col) {
//        board.pieces[this.empty.getRow()][this.empty.getCol()] = new Piece(this.pieces[this.empty.getRow()][this.empty.getCol()]);;
//        board.pieces[row][col] = new Piece(this.pieces[row][col]);
//        board.empty = new EmptyPiece(this.empty.getRow(), this.empty.getCol());
        Piece temp = board.getEmptyPiece();
        board.pieces[board.empty.getRow()][board.empty.getCol()] = board.pieces[row][col];
        board.pieces[row][col] = temp;
        board.empty.setRow(row);
        board.empty.setCol(col);
    }

    public String getHash() {
        return this.id;
    }

    private String calculateHash() {
        StringBuilder builder = new StringBuilder();
        for (Piece[] piece : this.pieces) {
            for (Piece p : piece) {
                builder.append(p.getNumber().toString()).append('|');
            }
        }
        return builder.toString();
    }
}
