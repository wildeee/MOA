package moa;

public class Piece implements Cloneable {

    private int number;

    public Piece(Piece p) {
        try {
            Piece pi = (Piece) p.clone();
            number = pi.getNumber();
        } catch (CloneNotSupportedException ex) {
        }
    }

    public Piece(int number) {
        this.number = number;
    }

    public Integer getNumber() {
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
