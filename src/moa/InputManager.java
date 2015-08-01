package moa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputManager {
    
    public static List<Integer> ConsoleRead(){
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputBruto = bufferRead.readLine();
            List<Integer> inputs = new ArrayList<>();
        
            for (String str : inputBruto.split(" ")){
                inputs.add(Integer.parseInt(str));
            }
            return inputs;
        } catch (IOException ex) {
            Logger.getLogger(InputManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
