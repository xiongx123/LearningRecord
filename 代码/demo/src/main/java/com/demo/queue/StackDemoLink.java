package com.demo.queue;


/**
 *
 * 链路实现简单栈
 *
 */
public class StackDemoLink {


    //头指针
    Entry tail;

    StackDemoLink() {
        tail = null;
    }


    public void add(Object o) {
        if(tail == null) {
            tail = new Entry( null, o);
        } else {
            tail = new Entry( tail, o);
        }
    }

    public Object remove() {
        if (tail == null) {
            System.out.println("队列为null!");
            return null;
        }
        Object o = tail.value;
        tail = tail.pre;
        return o;
    }


    public static void main(String[] args) {
        StackDemoLink queueDemoLink = new StackDemoLink();
        for (int i = 0; i < 110; i++) {
            queueDemoLink.add(i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(queueDemoLink.remove());
        }
    }

    class Entry{

        Entry() {
            this( null, null);
        }

        Entry ( Entry pre, Object value) {

            this.pre = pre;
            this.value = value;
        }



        Object value;

        //上一个指针
        Entry pre;
    }

}
