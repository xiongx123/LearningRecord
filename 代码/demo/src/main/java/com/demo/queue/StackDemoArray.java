package com.demo.queue;

/**
 *
 * 数组实现简单栈
 *
 */
public class StackDemoArray {

    Object[] objects;

    //表示最新加入数据
    private int tail = -1;

    StackDemoArray(){
        objects = new Object[10];
    }

    public void add(Object o){
        if (tail > objects.length) {
            System.out.println("栈已满");
            return;
        }

        objects[++tail] = o;
    }

    public Object remove(){
        if (tail < 0) {
            System.out.println("栈已空");
            return null;
        }
        Object o =  objects[tail] ;
        objects[tail] = null;
        tail--;
        return o;
    }

    public static void main(String[] args) {
        StackDemoArray stackDemo = new StackDemoArray();
        for (int i = 0; i < 10; i++) {
            System.out.println("添加" + i);
            stackDemo.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stackDemo.remove());
        }
    }

}
