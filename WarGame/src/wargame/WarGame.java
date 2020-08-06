/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

/**
 *
 * @author Gurveer Singh
 */


import java.util.Scanner; //Imports the Scanner
import java.util.ArrayList; //Imports Array Lists
import wargame.GroupOfcards;

public class WarGame{
    
public static void main(String[] args){
Scanner scan = new Scanner(System.in); //Creates a new Scanner called 'scan'
  
//Initialize String variables:
String player1;
String player2;
String choose;
String rwinner = "";
String gamewinner = "";
  

int temp;
int play = 1;
boolean winner;
  
while (play != 0){ 
winner = false; 
GroupOfcards deck = new GroupOfcards(); //Creates deck obj
deck.shuffle(); 

//creating arrays for players for Deck and the War Deck
ArrayList<Card> Deckp1 = new ArrayList<>(20);
ArrayList<Card> Deckp2 = new ArrayList<>(20);
ArrayList<Card> warDeck = new ArrayList<>(12);
distributeDeck(Deckp1, Deckp2, deck); // divide the Deck in two parts 

//The lines take input from the user for and  execute results
System.out.println("WAR GAME! \n");
System.out.print("Enter first player's name:\n ");
player1 = scan.nextLine();
System.out.print("Enter second player's name:\n ");
player2 = scan.nextLine();
System.out.println(player1 + "\t\t\t\t\t" + player2 + "\t\t\tWinner");
//^

while (!winner){ 
System.out.print(Deckp1.get(0) + " \t" + Deckp1.size() + "\t\t" + Deckp2.get(0) + " \t" + Deckp2.size() + "\t\t"); 
int a = Deckp1.get(0).isGreater(Deckp2.get(0));
if (a == 1){ //When Deck1's first card has more value than Deck 2 first card

Deckp1.add(Deckp2.get(0));
Deckp1.add(Deckp1.get(0));
Deckp1.remove(0);
Deckp2.remove(0);
rwinner = player1;
}
if (a == 2){ //When Deck2's first card has more value than Deck 1's first card

Deckp2.add(Deckp1.get(0));
Deckp2.add(Deckp2.get(0));
Deckp2.remove(Deckp2.get(0));
Deckp1.remove(0);
rwinner = player2;
}
if (a == 3) 
rwinner = "WAAARRRR";
System.out.println(rwinner);
if (a == 3){ 
rwinner = "WAAARRRR";
System.out.print(Deckp1.get(0) + " \t" + Deckp1.size() + "\t\t" + Deckp2.get(0) + " \t" + Deckp2.size() + "\t\t");
if (Deckp1.size() <= 4){ 
rwinner = player2;
gamewinner = player2;
break; 
}
else if (Deckp2.size() <= 4){ 
rwinner = player1;
System.out.println(rwinner);
gamewinner = player1;
break; 
}

warDtrans(Deckp1, Deckp2, warDeck); // this method adds 4 cards of both players to the warDeck
temp = warDeck.get(3).isGreater(warDeck.get(7));

if(temp == 1){ //player 1 wins..
while (warDeck.size() != 0) {
Deckp1.add(warDeck.get(0));
warDeck.remove(0);
rwinner = player1;
}
}
else if (temp == 2){ // player 2 wins..
while (warDeck.size() != 0){
Deckp2.add(warDeck.get(0));
warDeck.remove(0);
rwinner = player2;
}
}

  
else{ 
shift(warDeck); // method shift move all the cards to the right
temp = warDeck.get(3).isGreater(warDeck.get(7));


if (temp == 1){ //player 1 wins..
while (warDeck.size() != 0){
Deckp1.add(warDeck.get(0));
warDeck.remove(0);
rwinner = player1;
}
}
else if (temp == 2){ //player 2 wins..
while (warDeck.size() != 0){
Deckp2.add(warDeck.get(0));
warDeck.remove(0);
rwinner = player2;
}
}}

System.out.println(rwinner);}
if (Deckp1.size() == 52){ //When Deck 1 has 52 cards, player 1 wins
gamewinner = player1;
winner = true;
}
if (Deckp2.size() == 52){ //When Deck 2 has 52 cards, player 2 wins
gamewinner = player2;
winner = true;
}}



System.out.println(gamewinner + " Hey Congratulations! You are the Winner !");
System.out.print("Want to Play again?(y/n) \n ");


choose = scan.nextLine().toLowerCase();
choose = "" + choose.charAt(0);
if (choose.equals("y")){ 
play = 1;
System.out.println();
}
else{ 
play = 0;}
}
System.out.print("Thanks For Playing! ");
}

public static void shift(ArrayList<Card> warDeck) { //shift is a method which moves all the cards in warDeck again
warDeck.add(warDeck.get(3));
warDeck.remove(3);
warDeck.add(2, warDeck.get(7));
warDeck.remove(7);
}

public static void distributeDeck(ArrayList<Card> Deck1, ArrayList<Card> Deck2, GroupOfcards deck){ //divideDeck is a method which divides the Deck evenly for both players
for (int x = 0; x < 26; x++){
Deck1.add(deck.getShuffledDeck(x));
Deck2.add(deck.getShuffledDeck(x+20));
}
}

public static void warDtrans(ArrayList<Card> Deck1, ArrayList<Card> Deck2, ArrayList<Card> warDeck){ 
for (int a = 0; a < 4 && Deck1.size() < 48; a++){
warDeck.add(Deck1.get(0));
Deck1.remove(0);
}
for (int i = 0; i < 4 && Deck2.size() < 48; i++){
warDeck.add(Deck2.get(0));
Deck2.remove(0);
}}}
