/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moa;

import java.security.InvalidParameterException;

/**
 *
 * @author guest-pEDpUc
 */
public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {

        if (x < 0 || x >= Config.BoardWidth) {
            throw new InvalidParameterException("Posição x não pode ser menor que zero ou maior que a largura");
        }

        if (y < 0 || y >= Config.BoardHeight) {
            throw new InvalidParameterException("Posição y não pode ser menor que zero ou maior que a altura");
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }

        Position position = (Position) obj;

        return position.getX() == this.x && position.getY() == this.y;

    }

}
