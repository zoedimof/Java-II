package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders {
	
	private Set<TacoImpl> tacoSet = new HashSet<TacoImpl>();
	
    @Override
    public void addOrder(TacoImpl tacoOrder) {
    	this.tacoSet.add(tacoOrder);
    }

    @Override
    public boolean hasNext() {
    	Iterator<TacoImpl> iter = this.tacoSet.iterator();
    	if(iter.hasNext())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    @Override
    public TacoImpl closeNextOrder() {
    	TacoImpl taco = tacoSet.stream().findFirst().get();
		this.tacoSet.remove(taco);
		return taco;
    }

    @Override
    public int howManyOrders() {
        return this.tacoSet.size();
    }
}
