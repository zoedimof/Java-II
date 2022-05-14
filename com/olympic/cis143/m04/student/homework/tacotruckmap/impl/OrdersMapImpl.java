package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class OrdersMapImpl implements Orders {
	
	private Map<String, ArrayList<TacoImpl>> tacoMap = new HashMap<>();

    @Override
    public void createOrder(final String orderid) {
    	ArrayList<TacoImpl> tacoArray = new ArrayList<>();
    	tacoMap.put(orderid, tacoArray);
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	tacoMap.get(orderid).add(taco);
    }

    @Override
    public boolean hasNext() {
    	Iterator<String> iter = this.tacoMap.keySet().iterator();
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
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	if(!tacoMap.containsKey(orderid))
    	{
    		throw new OrderDoesNotExistException(orderid);
    	}
    	
    	List<TacoImpl> tacos = tacoMap.get(orderid);
    	tacoMap.remove(orderid);
        return tacos;
    }

    @Override
    public int howManyOrders() {
        return tacoMap.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
    	if(!tacoMap.containsKey(orderid))
    	{
    		throw new OrderDoesNotExistException(orderid);
    	}
    	
    	return tacoMap.get(orderid);
    }
}
