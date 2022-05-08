package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class DeckIteratorImpl implements Deck {
	
	//list that manages cards
	private ArrayList<Card> deck = new ArrayList<>();
	
	public DeckIteratorImpl(final boolean jokers) {
        this.createDeck(jokers);
    }
	
	//creates deck with or without jokers
	private void createDeck(final boolean jokers) {
    	
    	if(jokers == true)
    	{
    		Card joker = new Card(Card.Suit.NONE, Card.Value.JOKER);
    		this.deck.add(joker);
        	this.deck.add(joker);
    	}
    	
    	for(Card.Value value : Card.Value.values())
    	{
    		if(!value.equals(Card.Value.JOKER))
    		{
    			for(Card.Suit suit : Card.Suit.values())
        		{
    				if(!suit.equals(Card.Suit.NONE))
    				{
    					this.deck.add(new Card(suit, value));
    				}
        		}
    		}
    		
    	}
    }

	//returns the deck
	public List<Card> getDeck() {
		return this.deck;
	}

	//randomizes deck order
	public void shuffle() {
		Collections.shuffle(deck);
	}

	//checks if there are any cards next
	public boolean hasNext() {
    	if(deck.size() == 0)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
	}

	//returns a random card
	public Card dealCard() {
		Iterator<Card> iter = this.deck.iterator();
		int random = (int) Math.random() * deck.size();
		
		for(int i = 0; i < random; i++)
		{
			iter.next();
		}
		
    	Card card = deck.get(0);
    	deck.remove(0);
        return card;
	}

}
