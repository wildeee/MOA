/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moa;

import java.util.Comparator;

/**
 *
 * @author Luis Gustavo
 */
public class NodeComparator implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.getPeso(),o2.getPeso());
    
    }
    
}
