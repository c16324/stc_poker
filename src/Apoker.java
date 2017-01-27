/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author c16324
 */
public class Apoker {
    static Deck cards;//トランプ
    static Table table;//テーブル
    static PokerRule pokerRule;
    static Player humanPlayer;//プレーヤー
    static Player computerPlayer;
    
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        
        humanPlayer = new HumanPlayer("プレーヤ",100);
        computerPlayer = new ComputerPlayer("コンピュータ",100);
        pokerRule = new PokerRule(); 
        table = new Table();
        
        while(true){
            cards = Cards.newCards();//新しいトランプを準備
            cards.shuffle();//トランプをシャッフル
            dealCards();//プレーヤにカードを配る
            
            
            
            System.out.println("\nコインをいくらベットしますか？\n手持ちのコイン:"+humanPlayer.getCoins());
            int coin = stdIn.nextInt();
            
            table.setBetCoins(coin);
            humanPlayer.bet(coin);
            //CPUは毎回100コインかける
            System.out.println("CPU:100コインベットする！\n");
            table.setBetCoins(100);
            computerPlayer.bet(100);
            
            
            humanPlayer.displayHand();//手札を表示
            //computerPlayer.displayHand();
            
            changeHand();//手札を交換
            
            humanPlayer.sortCard();//昇順にソート
            computerPlayer.sortCard();
            System.out.print("自分\n");
            humanPlayer.displayHand();
            System.out.print("CPU\n");
            computerPlayer.displayHand();
            
            //勝敗を区別するための結果を取得,代入
            System.out.println("自分:"+pokerRule.string(pokerRule.check(humanPlayer.getHand())));
            humanPlayer.setResult(pokerRule.check(humanPlayer.getHand()));
            System.out.println("CPU:"+pokerRule.string(pokerRule.check(computerPlayer.getHand())));
            computerPlayer.setResult(pokerRule.check(computerPlayer.getHand()));
            
            //CPUと比較して勝敗を決める。
            if(humanPlayer.getResult() < computerPlayer.getResult()){
                System.out.println("あなたの勝ち!\n"+table.getBetCoins()+"コイン獲得しました。");
                humanPlayer.setCoins(table.getBetCoins());
                table.rewardCoins();
            }
            else if(humanPlayer.getResult() == computerPlayer.getResult())
                System.out.println("引き分け");
            else{
                System.out.println("あなたの負け!\nCPUが賭け金を全部手に入れました・・・");
                computerPlayer.setCoins(table.getBetCoins());
                table.rewardCoins();
            }
            
            
            System.out.println("continue(Y/n)?");   String yesno = stdIn.next();
            if(yesno.equals("n"))break;
        }
    }
    
    /*
    カードを配る
    */
    static void dealCards(){
        for(int i=0;i<5;i++){
            humanPlayer.drawIn(cards.pop());
            computerPlayer.drawIn( cards.pop());           
        }
    }
    /*
    手札を入れ替える
    */
    static void changeHand(){
        Scanner stdIn = new Scanner(System.in);
        int n=0;
        boolean flag = true;
        while(flag == true){
        System.out.println("何番目のカードを入れ替えますか？"); 
        int no = stdIn.nextInt();
        humanPlayer.drawOut(no-1);
        humanPlayer.displayHand();
        n++;
        System.out.println("まだ入れ替えますか？(Y/n");
        String yesno = stdIn.next();
        if(yesno.equals("n"))flag=false;
        }
        for(int i=0;i<n;i++)
            humanPlayer.drawIn(cards.pop());
    }
   
}
