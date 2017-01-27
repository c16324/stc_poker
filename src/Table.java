/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c16324
 */
public class Table {
    private int coins=0;
    
    public int getBetCoins(){
        return coins;
    }
    
    public void setBetCoins(int coins){
        this.coins += coins;
    }
    
    public void rewardCoins(){
        coins=0;
    }
}
