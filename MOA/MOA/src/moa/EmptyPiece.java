/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moa;

/**
 *
 * @author guest-pEDpUc
 */
public class EmptyPiece extends Piece {

    private final int row;
    private final int col;
    
    public EmptyPiece(int number, int row, int col) {
        super(number);
        this.row = row;
        this.col = col;
    }

    public EmptyPiece(Piece p, int row, int col) {
        super(p);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}
