/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Collections;
import java.util.Stack;
/**
 *
 * @author c16324
 */
public class Deck extends Stack<Card>{
    Deck(){
        
    }
    /*
    シャッフル
    */
    void shuffle(){
        Collections.shuffle(this);
    }
}
