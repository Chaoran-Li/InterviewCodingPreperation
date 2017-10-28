package com.chaoran;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

/**
 * Created by chaoranli on 10/24/17.
 * pure storage interview question
 */
class CallBack {
    String name;

    public CallBack() {

    }

    public CallBack(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("CallBack Event " + this.name + "is running now");
    }
}

// not thread safe
public class EventFire {
    Queue<CallBack> events = new LinkedList<>();
    boolean isFired = false;

    public void register(CallBack cb) {
        if (!isFired) {
            events.offer(cb);
        } else {
            cb.call();
        }
    }

    public void fire() {
        while (!events.isEmpty()) {
            events.poll().call();
        }

        isFired = true;
    }

}

class EventFireWithThreadSafe {
    Queue<CallBack> events = new LinkedList<>();
    boolean isFired = false;
    Lock lock;

    public void register(CallBack cb) {
        lock.lock();
        if (!isFired) {
            events.offer(cb);
            lock.unlock();
        } else {
            cb.call();
            lock.unlock();
        }
    }

    public void fire() {
        lock.lock();
        while (!events.isEmpty()) {
            events.poll().call();
            lock.unlock();
        }

        isFired = true;
        lock.unlock();
    }
}
