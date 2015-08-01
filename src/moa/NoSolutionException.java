/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moa;

/**
 *
 * @author guest-rc7n4B
 */
public class NoSolutionException extends Exception {

    public NoSolutionException() {
        super("Não existe solução");
    }
}
