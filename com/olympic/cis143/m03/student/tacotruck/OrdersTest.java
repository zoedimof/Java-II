package com.olympic.cis143.m03.student.tacotruck;

import com.olympic.cis143.m03.student.tacotruck.list.OrdersListImpl;
import com.olympic.cis143.m02.student.tacotruck.queue.OrdersQueueImpl;

public class OrdersTest {

    public static void main(String[] args) {
        OrdersTest ordersTest = new OrdersTest();
        ordersTest.testHasNextFalse();
        ordersTest.testCloseNextOrder();
    }

    public void testHasNextFalse() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        com.olympic.cis143.m02.student.tacotruck.TacoImpl firstTaco2 = new com.olympic.cis143.m02.student.tacotruck.TacoImpl(com.olympic.cis143.m02.student.tacotruck.TacoImpl.Protien.BEAN, true);

        OrdersListImpl orders = new OrdersListImpl();
        OrdersQueueImpl orders2 = new OrdersQueueImpl();
        orders.addOrder(firstTaco);
        orders2.addOrder(firstTaco2);;
        if (!orders.hasNext() || !orders2.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        TacoImpl closedTaco = orders.closeNextOrder();
        com.olympic.cis143.m02.student.tacotruck.TacoImpl closedTaco2 = orders2.closeNextOrder();
        if (closedTaco == null || closedTaco2 == null) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco) || !closedTaco2.equals(firstTaco2)) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (orders.hasNext() || orders2.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");
    }

    public void testCloseNextOrder() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        TacoImpl secondTaco = new TacoImpl(TacoImpl.Protien.BEEF, true);
        com.olympic.cis143.m02.student.tacotruck.TacoImpl firstTaco2 = new com.olympic.cis143.m02.student.tacotruck.TacoImpl(com.olympic.cis143.m02.student.tacotruck.TacoImpl.Protien.BEAN, true);
        com.olympic.cis143.m02.student.tacotruck.TacoImpl secondTaco2 = new com.olympic.cis143.m02.student.tacotruck.TacoImpl(com.olympic.cis143.m02.student.tacotruck.TacoImpl.Protien.BEEF, true);
        
        OrdersListImpl orders = new OrdersListImpl();
        OrdersQueueImpl orders2 = new OrdersQueueImpl();
        
        orders.addOrder(firstTaco);
        orders.addOrder(secondTaco);
        orders2.addOrder(firstTaco2);
        orders2.addOrder(secondTaco2);
        TacoImpl shouldBeFirstTaco = orders.closeNextOrder();
        com.olympic.cis143.m02.student.tacotruck.TacoImpl shouldBeFirstTaco2 = orders2.closeNextOrder();
        
        if ((orders.howManyOrders() != 1) || (orders.howManyOrders() != 1)) {
            throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTaco) || firstTaco2.equals(shouldBeFirstTaco2)){
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first taco was first out.");
        }
    }
}
