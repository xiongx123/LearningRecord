package com.demo.queue;

import java.util.HashMap;

/**
 *
 * 链路实现简单队列
 *
 */
public class QueueDemoLink {

    //头指针
    Entry head;

    QueueDemoLink() {
        head = new Entry();
    }

    public void add(Object o) {
        Entry next = head;
        Entry f = head;
        for(;;) {
            if (next == null) {
                next = new Entry(null, head, o);
                f.next = next;
                next.pre = f;
                break;
            }
            f = next;
            next = next.next;

        }
    }

    public Object remove() {
        Entry next = head.next;
        if (next == null) {
            System.out.println("队列为null!");
            return null;
        }
        head.next = next.next;
        next.pre = head;
        Object o = next.value;
        next.next = null;
        next.pre = null;
        next.value = null;
        return o;
    }


    public static void main(String[] args) {
//        QueueDemoLink queueDemoLink = new QueueDemoLink();
//        for (int i = 0; i < 10; i++) {
//            queueDemoLink.add(i);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(queueDemoLink.remove());
//        }
        String a = "a";
        int hash = 81; //hash(a);
        int n = 16;
        int index = (n - 1) & hash;
        int newCap = n << 1;
        int newCap1 = hash & (newCap - 1);
        // index 要么等于 newCap1
        // index 要么与 newCap1 相差 n
        System.out.println(index + ":" + newCap1);
    }

    /**
     *  0000 0101 0001
       &
     *  0000 0000 1111
       =
     *  0000 0000 0001
     *
     *  0000 0101 0001
       &
     *  0000 0001 1111
       =
     *  0000 0001 0001
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    class Entry{

        Entry() {
            this(null, null, null);
        }

        Entry (Entry next, Entry pre, Object value) {
            this.next = next;
            this.pre = pre;
            this.value = value;
        }

        //下一个指针
        Entry next;

        Object value;

        //上一个指针
        Entry pre;

    }

}
