package com.datastruct;

import java.util.*;

/**
 * 堆数据结构，如果数数元素是可以比较的，就不需要传入比较器对象，如果数据是可以比较的就要传入比较器，
 * 根据传入的比较器，可以实现大顶堆和小顶堆。
 * Author: 王俊超
 * Time: 2016-05-25 19:30
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Heap<T> {
    // 堆中元素存放的集合
    private List<T> data;
    // 比较器
    private Comparator<T> comparator;

    /**
     * 无参构造函数
     */
    public Heap() {
        data = new ArrayList<>(64);
    }

    /**
     * 构造函数
     *
     * @param t 元素
     */
    public Heap(T t) {
        this();
        add(t);
    }

    /**
     * 构造函数
     *
     * @param t          元素对象
     * @param comparator 比较器对象
     */
    public Heap(T t, Comparator<T> comparator) {
        this.comparator = comparator;
        add(t);
    }

    /**
     * 构造函数
     *
     * @param comparator 比较器对象
     */
    public Heap(Comparator<T> comparator) {
        if (comparator == null) {
            throw new NullPointerException("比较器不能为空");
        }

        this.comparator = comparator;
        this.data = new ArrayList<>(64);
    }

    /**
     * 构造函数
     *
     * @param arr 数据数组
     */
    public Heap(T[] arr) {
        if (arr == null) {
            throw new NullPointerException("数据据为空");
        }

        this.data = new ArrayList<>(arr.length);
        this.add(arr);
    }

    /**
     * 构造函数
     *
     * @param arr        数据数组
     * @param comparator 比较器对象
     */
    public Heap(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new NullPointerException("数据据为空");
        }

        if (comparator == null) {
            throw new NullPointerException("比较器为空");
        }

        this.comparator = comparator;
        this.data = new ArrayList<>(arr.length);
        add(arr);
    }

    /**
     * 构造函数
     *
     * @param coll 数据集合
     */
    public Heap(Collection<T> coll) {
        if (coll == null) {
            throw new NullPointerException("数据据为空");
        }

        this.data = new ArrayList<>(coll.size());
        add(coll);
    }


    /**
     * 构造函数
     *
     * @param coll       数据集合
     * @param comparator 比较器对象
     */
    public Heap(Collection<T> coll, Comparator<T> comparator) {
        if (coll == null) {
            throw new NullPointerException("数据据为空");
        }

        this.comparator = comparator;
        this.data = new ArrayList<>(coll.size());
        add(coll);
    }


    /**
     * 获取比较器对象
     *
     * @return 比较器对象
     */
    public Comparator<T> getComparator() {
        return comparator;
    }

    /**
     * 设置比较器对象
     *
     * @param comparator 比较器对象
     */
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * 向上调整堆
     *
     * @param idx 被上移元素的起始位置
     */
    public void shiftUp(int idx) {
        // 检查是位置是否正确
        if (idx < 0 || idx >= data.size()) {
            throw new IllegalArgumentException(idx + "");
        }

        // 获取开始调整的元素对象
        T intent = data.get(idx);

        // 如果不是根元素，则需要上移
        while (idx > 0) {
            // 找父元素对象的位置
            int parentIdx = (idx - 1) / 2;
            // 获取父元素对象
            T parent = data.get(parentIdx);
            //上移的条件，子节点比父节点大，此处定义的大是以比较器返回值为准
            if (compare(intent, parent) > 0) {
                // 将父节点向下放
                data.set(idx, parent);
                idx = parentIdx;
                // 记录父节点下放的位置
            }
            // 子节点不比父节点大，说明父子路径已经按从大到小排好顺序了，不需要调整了
            else {
                break;
            }
        }

        // index此时记录是的最后一个被下放的父节点的位置（也可能是自身），
        // 所以将最开始的调整的元素值放入index位置即可
        data.set(idx, intent);
    }

    /**
     * 向下调整堆
     *
     * @param idx 被下移的元素的起始位置
     */
    public void shiftDown(int idx) {
        // 检查是位置是否正确
        if (idx < 0 || idx >= data.size()) {
            throw new IllegalArgumentException(idx + "");
        }

        // 获取开始调整的元素对象
        T intent = data.get(idx);
        // 获取开始调整的元素对象的左子结点的元素位置
        int leftIdx = idx * 2 + 1;
        // 如果有左子结点
        while (leftIdx < data.size()) {
            // 取左子结点的元素对象，并且假定其为两个子结点中最大的
            T maxChild = data.get(leftIdx);
            // 两个子节点中最大节点元素的位置，假定开始时为左子结点的位置
            int maxIdx = leftIdx;

            // 获取右子结点的位置
            int rightIdx = leftIdx + 1;
            // 如果有右子结点
            if (rightIdx < data.size()) {
                T rightChild = data.get(rightIdx);
                // 找出两个子节点中的最大子结点
                if (compare(rightChild, maxChild) > 0) {
                    maxChild = rightChild;
                    maxIdx = rightIdx;
                }
            }

            // 如果最大子节点比父节点大，则需要向下调整
            if (compare(maxChild, intent) > 0) {
                // 将较大的子节点向上移
                data.set(idx, maxChild);
                // 记录上移节点的位置
                idx = maxIdx;
                // 找到上移节点的左子节点的位置
                leftIdx = 2 * idx + 1;
            }
            // 最大子节点不比父节点大，说明父子路径已经按从大到小排好顺序了，不需要调整了
            else {
                break;
            }

        }
        // index此时记录是的最后一个被上移的子节点的位置（也可能是自身），
        // 所以将最开始的调整的元素值放入index位置即可
        data.set(idx, intent);
    }

    /**
     * 比较两个数的大小
     *
     * @param o1 数一
     * @param o2 数二
     * @return 比较结果
     */
    private final int compare(Object o1, Object o2) {
        return comparator == null ? ((Comparable<? super T>) o1).compareTo((T) o2)
                : comparator.compare((T) o1, (T) o2);
    }

    /**
     * 添加一个元素
     *
     * @param item 添加的元素
     */
    public void add(T item) {
        // 将元素添加到最后
        data.add(item);
        // 上移，以完成重构
        shiftUp(data.size() - 1);
    }


    /**
     * 向堆中添加元素
     *
     * @param arr 元素数组
     */
    public void add(T[] arr) {
        if (arr != null) {
            for (T t : arr) {
                add(t);
            }
        }
    }

    /**
     * 向堆中添加元素
     *
     * @param coll 元素集合
     */
    public void add(Collection<T> coll) {
        if (coll != null) {
            for (T t : coll) {
                add(t);
            }
        }
    }

    /**
     * 获取堆顶元素，但不删除
     *
     * @return 堆顶元素
     */
    public T getTop() {
        // 如果堆已经为空，就抛出异常
        if (data.isEmpty()) {
            throw new NoSuchElementException("堆已经为空");
        }

        return data.get(0);
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶结点
     */
    public T deleteTop() {
        // 如果堆已经为空，就抛出异常
        if (data.isEmpty()) {
            throw new NoSuchElementException("堆已经为空");
        }

        // 获取堆顶元素
        T first = data.get(0);
        // 删除最后一个元素
        T last = data.remove(data.size() - 1);

        // 删除元素后，如果堆为空的情况，说明删除的元素也是堆顶元素
        if (data.size() == 0) {
            return last;
        } else {
            // 将删除的元素放入堆顶
            data.set(0, last);
            // 自上向下调整堆
            shiftDown(0);
            // 返回堆顶元素
            return first;
        }
    }

    /**
     * 获取堆的大小
     *
     * @return 堆的大小
     */
    public int size() {
        return data.size();
    }

    /**
     * 判断堆是否为空
     *
     * @return 堆是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 清空堆，如果有比较器，不会删除比较器
     */
    public void clear() {
        data.clear();
    }

    /**
     * 删除元素，并且清空比较器对象
     */
    public void delete() {
        data.clear();
        comparator = null;
    }

    /**
     * 获取堆中所有的数据
     *
     * @return 堆中所在的数据
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 堆信息描述
     *
     * @return 堆信息描述字符串
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
