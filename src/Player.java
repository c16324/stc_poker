
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;


/**
 *
 * @author c16324
 */
public class Player {
    private String name;
    private int coins = 0;
    private List<Card> hand;    //手札
    private int result=0;   //役の情報(数値化)
    /*コンストラクタ*/
    public Player(String name,int coins){
        this.name = name;
        this.coins = coins;
        hand = new ArrayList<>();
    }
    
    /*手札*/
    public List<Card> getHand(){
        return hand;
    }
    //手札を表示
    public void displayHand(){
        for(int i=0;i<hand.size();i++)
        System.out.print(i+1+"番 "+hand.get(i)+"\n");
    }
    //役の情報を取得
    public int getResult(){
        return result;
    }
    //役の情報を代入
    public void setResult(int i){
        this.result = i;
    }
    /*コインを用意する。*/
    public void setCoins(int num){
        this.coins = num;
    }
    
    public int getCoins(){
        return coins;
    }
    
    /*コインをかける*/
    public void bet(int num){
        coins -= num;
    }
    /*カードを捨てる*/
    Card drawOut(int index){
        return hand.remove(index);
    }
    /*カードを引く(手札に加える)*/
    void drawIn(Card pop) {
        hand.add(pop);
    }
    
    public int  r(int i){
        return (hand.get(i)).getNumber();
    }
    
    public int  s(int i){
        return (hand.get(i)).getSuit();
    }
    
    int checkMin(int j){
        int min = hand.get(j).getNumber();
        int a = j;
        for(int i = j;i < 5;i++){
            if(min > hand.get(i).getNumber()){
               min = hand.get(i).getNumber();
               a = i;
            }
        }
        return a;
    }
    
    /*カードの数字を小さい順に並びかえ*/
    void sortCard(){
        Card tCard = new Card();
        int c;
        
        for(int i = 0;i < 4;i++){
            c = checkMin(i);
            tCard = hand.get(i);
            hand.set(i, hand.get(c));
            hand.set(c, tCard);
        }
    }
    
}
