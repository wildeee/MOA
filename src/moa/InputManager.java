package moa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {

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
