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

    public EmptyPiece(Position position, int number) {
        super(position, number);
    }

    public EmptyPiece(Piece p) {
        super(p);
    }

}
