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

public class Card{

//Initialize instance variables:
private String suit;
private String rank;
private int value;

//Initialize constructor
public Card(){
}


public Card(String suit, String rank){
this.suit = suit;
this.rank = rank;
  

if(rank.equals("2")){
value = 2;
}
else if(rank.equals("3")){
value = 3;
}
else if(rank.equals("4")){
value = 4;
}
else if(rank.equals("5")){
value = 5;
}
else if(rank.equals("6")){
value = 6;
}
else if(rank.equals("7")){
value = 7;
}
else if(rank.equals("8")){
value = 8;
}
else if(rank.equals("9")){
value = 9;
}
else if(rank.equals("10")){
value = 10;
}
else if(rank.equals("Jack")){
value = 11;
}
else if(rank.equals("Queen")){
value = 12;
}
else if(rank.equals("King")){
value = 13;
}
else if(rank.equals("Ace")){
value = 14;
}
//^
}


public String getSuit(){
return suit;
}

public String getRank(){
return rank;
}

public int getValue(){
return value;
}

public void setSuit(String suit){
this.suit = suit;
}

public void setRank(String rank){
this.rank = rank;
}

public void setValue(int value){
this.value = value;
}
//^

public String toString(){ 
return rank + " " + suit;
}

public Card copy(Card card){ 
Card tp = new Card (card.getSuit(), card.getRank());
return tp;
}

public int isGreater(Card card){ 
int tp;
if (value > card.getValue()){ 
tp = 1;
}
else if (value < card.getValue()){ 
tp = 2;
}
else { 
tp = 3;
}
return tp; 
}
}
