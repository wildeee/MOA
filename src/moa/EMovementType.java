package moa;

public class EMovementType {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    private static final int[] values = {EMovementType.UP, EMovementType.DOWN, EMovementType.LEFT, EMovementType.RIGHT};

    public static int[] values() {
        return EMovementType.values;
    }

}
