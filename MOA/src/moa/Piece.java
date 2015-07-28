package moa;

public class Piece implements Cloneable {

    private Position position;
    private int number;

    public Piece(Piece p) {
        try {
            Piece pi = (Piece) p.clone();
            position = pi.getPosition();
            number = pi.getNumber();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
    }

    public Piece(Position position, int number) {
        this.position = position;
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Piece)) {
            return false;
        }
        return this.number == ((Piece) obj).getNumber();
    }

}
