package com.datastruct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Author: 王俊超
 * Time: 2016-05-25 20:44
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class HeapTest {

    // 产生的随机数数的个数
    private final static int NUM = 50;
    // 下边界，包含
    private final static int LOWER = 0;
    // 上边界，不包含
    private final static int UPPER = 100;


    private static List<Integer> getNumber() {
        List<Integer> arr = new ArrayList<>(NUM);
        Random random = new Random();

        for (int i = 0; i < NUM; i++) {
            arr.add(LOWER + random.nextInt(UPPER - LOWER));
        }

        return arr;
    }

    @Test
    public void testMaxHeapWithoutComparator() {
        List<Integer> arr = getNumber();
        System.out.println(arr);
        Heap<Integer> maxHeap = new Heap<>(arr);
        System.out.println(maxHeap);
    }

    @Test
    public void testMaxHeapWithComparator() {
        List<Integer> arr = getNumber();
        System.out.println(arr);
        Heap<Integer> maxHeap = new Heap<>(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(maxHeap);
    }

    /**
     * 使用自定义类进行操作
     */
    @Test
    public void testMaxHeapWithComparator2() {
        List<Node> nodes = getNodes();

        System.out.println("HeapTest.testMaxHeapWithComparator2");
        System.out.println(nodes);
        Heap<Node> maxHeap = new Heap<>(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getVal() - o2.getVal();
            }
        });
        System.out.println(maxHeap);
    }

    @Test
    public void testMinHeapWithComparator() {
        List<Integer> arr = getNumber();
        System.out.println(arr);
        Heap<Integer> maxHeap = new Heap<>(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(maxHeap);
    }

    /**
     * 使用自定义类进行操作
     */
    @Test
    public void testMinHeapWithComparator2() {
        List<Node> nodes = getNodes();

        System.out.println("HeapTest.testMaxHeapWithComparator2");
        System.out.println(nodes);
        Heap<Node> maxHeap = new Heap<>(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.getVal() - o1.getVal();
            }
        });
        System.out.println(maxHeap);
    }

    private List<Node> getNodes() {
        List<Integer> arr = getNumber();
        List<Node> nodes = new ArrayList<>();

        for (Integer i : arr) {
            nodes.add(new Node(i));
        }
        return nodes;
    }

}
