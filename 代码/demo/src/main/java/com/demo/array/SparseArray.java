package com.demo.array;

import java.util.concurrent.*;

public class SparseArray {

    /**
     * 记录一个棋盘
     * 支持复盘以及清除等操作
     *
     */

    private static int width = 9;

    private static int height = 9;

    private volatile int size = 0;


    public static void main(String[] args) {
//        ThreadPoolExecutor executorService =  new ThreadPoolExecutor(5,5,5, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
//        executorService.execute();
        int i =  1 << 29;
        int n = 0 << 29;
        System.out.println(n);
        Thread t = new Thread(()->{});
        t.start();
        try {
            t.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //棋盘
    int[][] arr = new int[height][width];

    //稀疏数组 压缩之后的数组
    //默认 第一列记录 长度 宽度 存放多少实际数字
    int[][] sparseArray = new int[][]{};

    private void initSparse() {
        sparseArray[0][0] = width;
        sparseArray[1][0] = height;
        sparseArray[2][0] = size;
    }

    private void updateSparse(int x, int y, int o) {
        sparseArray[0][size + 1] = x;
        sparseArray[1][size + 1] = y;
        sparseArray[2][size + 1] = o;
        sparseArray[2][0] = size++;
    }

    private int[][] toArray() {
        if (sparseArray.length == 0) {
            return new int[][]{};
        }
        int[][] temp = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            temp[sparseArray[0][i]][sparseArray[1][i]] = sparseArray[2][i];
        }

        return temp;
    }
}
