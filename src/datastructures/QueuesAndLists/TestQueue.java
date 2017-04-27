/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.QueuesAndLists;

import java.util.Random;

/**
 * @author Dominick Martelly
 */
public class TestQueue {

    /**
     * @param args none needed
     */
    public static void main(String[] args) {
        Queue myQueue = new Queue();
        Random R = new Random();

        for (int i = 0; i < 5; i++)
            myQueue.addFirst(R.nextInt(100));
        System.out.println(myQueue);

        System.out.println("Dequeue " + myQueue.dequeue() + " | " + myQueue);

        myQueue.enqueue(112);
        System.out.println(myQueue);

        myQueue.enqueue(-6);
        System.out.println(myQueue);

        myQueue.addFirst(355);
        System.out.println(myQueue);

        System.out.println("Is the queue empty?: " + myQueue.isEmpty());

        System.out.println("The size of the queue is " + myQueue.sizeofQueue());

        System.out.println("The 5th element of the queue is " + myQueue.nthElement(5));

        System.out.println("The 3rd element of the queue is " + myQueue.nthElement(3));

        System.out.println("The 1st element of the queue is " + myQueue.getFirst());
    }
}
