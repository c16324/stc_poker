
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c16324
 */
public class PokerRule {
    /*役の判定*/
     String string(int i){
        String[] y ={"ロイヤルストレートフラッシュ","ストレートフラッシュ","4カード","フルハウス","フラッシュ","ストレート","3カード","2ペア","1ペア","役ナシ"};
        
        return y[i];
    }
     
 public int check(List<Card> card){
     
     
 int straight = checkStraight(card);
 int flush = checkFlush(card);
 int ownpair = checkOnePair(card);
 int twopair = checkTwoPair(card);
 int threecard = checkThreeCard(card);
 int fourcard = checkFourCard(card);
 int fullhouse = checkFullHouse(card);
 int result;
 
 /*ロイヤルストレートフラッシュ*/
 if(((card.get(0)).getNumber()) == 1 && straight == 1 && flush == 1){
 result= 0;
 return result;
 }
 
 /*ストレートフラッシュ*/
 if(straight == 1 && flush == 1){
 result = 1;
 return result;
 }
 
 /*4カード*/
 if(fourcard == 1){
 result = 2;
 return result;
 }
 
 /*フルハウス*/
 if(fullhouse == 1){
 result = 3;
 return result;
 }
 
 /*フラッシュ*/
 if(flush == 1){
 result = 4;
 return result;
 }
 
 /*ストレート*/
 if(straight == 1){
 result = 5;
 return result;
 }
 
 /*3カード*/
 if(threecard == 1){
 result = 6;
 return result;
 }
 
 /*2ペア*/
 if(twopair == 1){
 result = 7;
 return result;
 }
 
 /*1ペア*/
 if(ownpair == 1){
 result = 8;
 return result;
 }
 
 result = 9;
 return result;
 
 }
 
 /*フルハウスかどうか*/
 int checkFullHouse(List<Card> card){
 
 if(((card.get(0)).getNumber()) == ((card.get(1)).getNumber()) && ((card.get(2)).getNumber()) == ((card.get(3)).getNumber()) && ((card.get(3)).getNumber()) == ((card.get(4)).getNumber()))
 return 1;
 
 else if(((card.get(0)).getNumber()) == ((card.get(1)).getNumber()) && ((card.get(1)).getNumber()) == ((card.get(2)).getNumber()) && ((card.get(3)).getNumber()) == ((card.get(4)).getNumber()))
 return 1;
 
 return 0;
 }
 
 /*フラッシュかどうか*/
 int checkFlush(List<Card> card){
 
 for(int i = 0;i < 4;i++){
 if(((card.get(i)).getSuit()) == ((card.get(i + 1)).getSuit())){
 
 }
 else{
 return 0;
 }
 }
 return 1;
 }
 
 /*ストレートかどうか*/
 int checkStraight(List<Card> card){
 int count = ((card.get(0)).getNumber());
 
 if(((card.get(0)).getNumber()) == 1 && ((card.get(1)).getNumber()) == 10 && ((card.get(2)).getNumber()) == 11 &&
 ((card.get(3)).getNumber())== 12 && ((card.get(4)).getNumber()) == 13){
 return 1;

 }
 
 
 for(int i = 1;i < 5;i++){
 if(count == ((card.get(i)).getNumber()) - 1){
 count = ((card.get(i)).getNumber());
 }
 else{
 return 0;
 }
 }
 return 1;
 
 }
 

 
 /*1ペアかどうか*/
 int checkOnePair(List<Card> card){
 for(int i = 0;i < 4;i++){
 if(((card.get(i)).getNumber()) == ((card.get(i + 1)).getNumber())){
 return 1;
 }
 }
 return 0;
 }
 
 /*2ペアかどうか*/
 int checkTwoPair(List<Card> card){
 int count = 0;
 for(int i = 0;i < 4;i++){
 if(((card.get(i)).getNumber()) == ((card.get(i + 1)).getNumber())){
 count++;
 i++;
 }
 }
 if(count == 2){
 return 1;
 }
 return 0;
 }
 
 
 /*3カードか*/
 int checkThreeCard(List<Card> card){
 for(int i = 0;i < 3;i++){
 if(((card.get(i)).getNumber()) == ((card.get(i + 1)).getNumber())){
 if(((card.get(i + 1)).getNumber())== ((card.get(i + 2)).getNumber()))
 return 1;
 }
 }
 return 0;
 }
 
 /*4カードか*/
 int checkFourCard(List<Card> card){
 for(int i = 0;i < 2;i++){
 if(((card.get(i)).getNumber()) == ((card.get(i + 1)).getNumber())){
 if(((card.get(i + 1)).getNumber()) == ((card.get(i + 2)).getNumber()))
 if(((card.get(i + 2)).getNumber()) == ((card.get(i + 3)).getNumber()))
 return 1;
 }
 }
 return 0;
 }
 
 /*手札のカードの中で一番強いカードを返す*/
 int checkSCard(List<Card> card){
 //配列の中身が昇順になっているので、配列の0番目に1があれば14を返す。
 if(((card.get(0)).getNumber()) == 1)
 return 14;
 
 //それ以外の場合は、配列の最後が一番大き値になっているので、その値を返す。
    return (card.get(4)).getNumber();
 
 }
 

 
}

