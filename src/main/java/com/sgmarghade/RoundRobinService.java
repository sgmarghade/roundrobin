package com.sgmarghade;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;


public class RoundRobinService<T>
{

    private BlockingQueue<T> queue ;
    private ReentrantLock lock = new ReentrantLock();

    public RoundRobinService(List<T> objectList,boolean shuffleObjects){

        this.queue = new LinkedBlockingDeque<T>(objectList.size());
        if(shuffleObjects) {
            Collections.shuffle(objectList);
        }
        initializeQueue(objectList);
    }

    private void initializeQueue(List<T> objectList) {
        for(T object : objectList){
            queue.add(object);
        }
    }

    public T getNextObject(){
        lock.lock();
        try{
            T data = queue.poll();
            queue.add(data);
            return data;
        }finally {
            lock.unlock();
        }
    }

}
