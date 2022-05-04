package com.olympic.cis143.m03.student.tacotruck.list;

import java.util.ArrayList;
import java.util.Iterator;

import com.olympic.cis143.m03.student.tacotruck.Orders;
import com.olympic.cis143.m03.student.tacotruck.TacoImpl;

public class OrdersListImpl implements Orders {

	//list that holds and manages TacoImpl
	private ArrayList<TacoImpl> tacoList = new ArrayList<>();
	
	//adds order to list
	public void addOrder(TacoImpl tacoOrder) {
		tacoList.add(tacoOrder);
	}

	//checks if there are any orders next
	public boolean hasNext() {
		Iterator<TacoImpl> iter = tacoList.iterator();
    	if(iter.hasNext())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
	}

	//returns next order and removes it
	public TacoImpl closeNextOrder() {
		TacoImpl taco = tacoList.get(0);
		tacoList.remove(0);
		return taco;
	}

	//returns numbers of orders left
	public int howManyOrders() {
		return tacoList.size();
	}

}
