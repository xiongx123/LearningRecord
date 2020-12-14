package com.demo.queue;
/**
 *
 * 数组实现简单队列
 *
 */
public class QueueDemoArray {

    //数组实现队列

    // 队列是一个先进后出机构。即消费可以保证顺序性

    private  Object[] objects;

    private int length;

    private final static int DEFAULT_LOAD_FACTOR = 10;

    private int size;

    //指向队列最后一个位置:
    private int tail = 0;

    //指针 指向下一个
    private int head = 0;

    //当最后一个位置 + 1 % 最大长度 == 下一个位置的话 则表示队列满了。

    public QueueDemoArray() {
        length = DEFAULT_LOAD_FACTOR;
        objects = new Object[length];
    }

    private Boolean isFull(){
        return (tail + 1) % length == head;
    }


    public void push(Object o) {
        if (isFull()) {
            System.out.println("队列满！");
            return;
        }
        objects[tail] = o;
        tail++;
        if (tail > length) {
            tail = 0;
        }
    }

    public Object pull() {
        if (tail == head) {
            System.out.printf("队列为空!");
            return null;
        }
        Object o = objects[head];
        objects[head] = null;
        head++;
        if (head > length) {
            head = 0;
        }
        return o;
    }


    public static void main(String[] args) {
        QueueDemoArray queueDemo = new QueueDemoArray();
        queueDemo.push(1);
        queueDemo.push(3);
        queueDemo.push(9);
        queueDemo.push(2);
        queueDemo.push(7);
        for (int i = 0; i < queueDemo.length; i++) {
            Object pull = queueDemo.pull();
            if (pull == null) {
                break;
            }
            System.out.println((Integer) pull);
        }
    }

}
