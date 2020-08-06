
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;
import java.util.ArrayList;
import java.util.Random; 

/**
 *
 * @author Gurveer Singh
 */


public class GroupOfcards{

Random random = new Random();

private ArrayList <Card> Deck = new ArrayList <Card>(52);
private ArrayList <Card> Shuffled = new ArrayList <Card>(52);


public GroupOfcards(){

String suit = "";
String rank = "";


for(int x = 0; x < 4; x++){
if(x == 0){
suit = "Clubs";
}
else if(x == 1){
suit = "Hearts";
}
else if(x == 2){
suit = "Spades";
}
else if(x == 3){
suit = "Diamonds";
}
for(int y = 1; y <= 13; y++){
if(y == 1){
rank = "Ace";
}
else if(y > 1 && y < 11){
rank = "" + y;
}
else if(y == 11){
rank = "Jack";
}
else if(y == 12){
rank = "Queen";
}
else if(y == 13){
rank = "King";
}
Card card = new Card(suit, rank);
Deck.add(card);
}}
}

public Card getShuffledDeck(int i){ 
if(!Shuffled.isEmpty()){
return Shuffled.get(i);
}
return null;
}

public void shuffle(){ // shuffles the card in a random order
ArrayList<Integer> tcards = new ArrayList<>(52); 
int count = 0;
while (count < 52){ // Shuffled deck in a random order
int cardnum = random.nextInt((51 - 0) + 1) + 0;
while (tcards.indexOf(cardnum) == -1){
tcards.add(count, cardnum); 
Shuffled.add(count, Deck.get(cardnum)); //Gets added to the Shuffled Array List
count++; 
}
}
}
}
