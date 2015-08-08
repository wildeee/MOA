package moa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {

    public static void main(String[] args) {
        List<Integer> num = InputManager.ConsoleRead();
        List<Piece> pieces = new ArrayList<>();
        for (Integer inteiro : num) {
            pieces.add(new Piece(inteiro));
        }
        System.out.println(new TreeController(
                new Root(
                        new Board(pieces)
                )
        ).calculateMinPlays()
        );
    }
}

class Board implements Cloneable {

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

    public Board movePiece(int moveType) throws InvalidMovementException {
        Board returnBoard = new Board(this);
        int row, col;
        switch (moveType) {
            case EMovementType.UP:
                row = this.empty.getRow() + 1;
                col = this.empty.getCol();
                if (row == Config.BoardHeight) {
                    throw new InvalidMovementException();
                }

                break;
            case EMovementType.DOWN:
                row = this.empty.getRow() - 1;
                col = this.empty.getCol();
                if (row == -1) {
                    throw new InvalidMovementException();
                }
                break;
            case EMovementType.LEFT:
                row = this.empty.getRow();
                col = this.empty.getCol() + 1;
                if (col == Config.BoardWidth) {
                    throw new InvalidMovementException();
                }

                break;
            case EMovementType.RIGHT:
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

class Branch extends Node {

    private final int level;

    public Branch(Board board, Node parent) {
        super(board);
        this.level = parent.getLevel() + 1;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

}

class Config {

    public static final int EmptyPiece = 0;

    public static final int BoardWidth = 4;

    public static final int BoardHeight = 4;

    public static final Piece[][] Answer = {
        {
            new Piece(1),
            new Piece(2),
            new Piece(3),
            new Piece(4)
        }, {
            new Piece(12),
            new Piece(13),
            new Piece(14),
            new Piece(5)},
        {
            new Piece(11),
            new Piece(0),
            new Piece(15),
            new Piece(6)
        }, {
            new Piece(10),
            new Piece(9),
            new Piece(8),
            new Piece(7)
        }
    };
}

class EMovementType {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    private static final int[] values = {EMovementType.UP, EMovementType.DOWN, EMovementType.LEFT, EMovementType.RIGHT};

    public static int[] values() {
        return EMovementType.values;
    }

}

class EmptyPiece {

    private int row;
    private int col;

    public EmptyPiece(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    void setRow(int row) {
        this.row = row;
    }

    void setCol(int col) {
        this.col = col;
    }

}

class InputManager {

    public static List<Integer> ConsoleRead() {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> tabuleiroArr = new ArrayList<>();
        int index = 0;
        while (index <= 15 && sc.hasNextInt()) {
            tabuleiroArr.add(sc.nextInt());
        }

        return tabuleiroArr;
    }

}

class InvalidMovementException extends Exception {
}

abstract class Node {

    private final Board board;

    public Node(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public abstract int getLevel();

    private int h1() { // Peças fora do lugar
        int count = 0;
        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (!Objects.equals(this.board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
                    count++;
                }
            }
        }
        return count;
    }

    private int h2() { // Peças fora de sequencia
        int move = EMovementType.RIGHT;
        int count = 0;
        int row = 0;
        int col = 0;
        int lastPiece = this.board.getPieceAt(row, col).getNumber();
        col++;

        boolean[][] visited = new boolean[Config.BoardWidth][Config.BoardHeight];
        visited[0][0] = true;

        while (!(row == 2 && col == 1)) {

            if (this.board.getPieceAt(row, col).getNumber() != lastPiece + 1) {
                count++;
            }
            lastPiece = this.board.getPieceAt(row, col).getNumber();

            visited[row][col] = true;

            move = this.getNextMove(move, row, col, visited);
            switch (move) {
                case EMovementType.RIGHT:
                    col++;
                    break;
                case EMovementType.DOWN:
                    row++;
                    break;
                case EMovementType.LEFT:
                    col--;
                    break;
                case EMovementType.UP:
                    row--;
                    break;
            }
        }
        return count;
    }

    private int h3() { // Distância do lugar que deveria estar
        int count = 0;
        for (int row = 0; row < Config.BoardWidth; row++) {
            for (int col = 0; col < Config.BoardHeight; col++) {
                if (!Objects.equals(this.board.getPieceAt(row, col).getNumber(), Config.Answer[row][col].getNumber())) {
                    int target = Config.Answer[row][col].getNumber();
                    for (int i = 0; i < Config.BoardWidth; i++) {
                        for (int j = 0; j < Config.BoardHeight; j++) {
                            if (target == this.board.getPieceAt(i, j).getNumber()) {
                                count += Math.abs(row - i) + Math.abs(col + j);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private int getNextMove(int actualMovement, int row, int col, boolean[][] visited) {
        switch (actualMovement) {
            case EMovementType.RIGHT:
                if (col + 1 == Config.BoardWidth || visited[row][col + 1]) {
                    return EMovementType.DOWN;
                }
                break;
            case EMovementType.DOWN:
                if (row + 1 == Config.BoardHeight || visited[row + 1][col]) {
                    return EMovementType.LEFT;
                }
                break;
            case EMovementType.UP:
                if (row - 1 == -1 || visited[row - 1][col]) {
                    return EMovementType.RIGHT;
                }
                break;
            case EMovementType.LEFT:
                if (col - 1 == -1 || visited[row][col - 1]) {
                    return EMovementType.UP;
                }
                break;
        }
        return actualMovement;
    }

    public Integer getPeso() {
        return (int) Math.floor(((this.h1()) * 0.3) + (this.h2() * 0.3) + (this.h3() * 0.3) + this.getLevel());
    }

}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getPeso(), o2.getPeso());

    }

}

class Piece implements Cloneable {

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

class Root extends Node {

    public Root(Board board) {
        super(board);
    }

    @Override
    public int getLevel() {
        return 0;
    }

}

class TreeController {

    private final PriorityQueue<Node> nodeQueue;
    private final Map<String, Integer> inativos;

    public TreeController(Root root) {
        nodeQueue = new PriorityQueue<>(new NodeComparator());
        nodeQueue.add(root);
        inativos = new HashMap<>();

    }

    //Magic begins here!
    public int calculateMinPlays() {
        Node nodeIterator;
        while (!nodeQueue.isEmpty()) {
            nodeIterator = nodeQueue.remove();
            if (nodeIterator.getBoard().checkWin()) {
                return nodeIterator.getLevel();
            }

            inativos.put(nodeIterator.getBoard().getHash(), nodeIterator.getPeso());

            for (int move : EMovementType.values()) {
                try {
                    Board board = nodeIterator.getBoard().movePiece(move);
                    if (inativos.containsKey(board.getHash())) { // Assegurando que não hajam tabuleiros repetidos na árvore
                        if (nodeIterator.getPeso() >= inativos.get(board.getHash())) {
                            continue;
                        }
                    }
                    nodeQueue.add(new Branch(board, nodeIterator));
                } catch (InvalidMovementException ex) {
                }
            }
        }

        return -1;
    }
}
