#堆 (数据结构)
　　堆（英语：Heap）是计算机科学中一类特殊的数据结构的统称。堆通常是一个可以被看做一棵树的数组对象。在队列中，调度程序反复提取队列中第一个作业并运行，因为实际情况中某些时间较短的任务将等待很长时间才能结束，或者某些不短小，但具有重要性的作业，同样应当具有优先权。堆即为解决此类问题设计的一种数据结构。

##逻辑定义
　　n个元素序列{k1,k2...ki...kn},当且仅当满足下列关系时称之为堆：<br>
>    $(k_i <= k_{2i},k_i <= k_{2i+1})或者(k_i >= k_{2i},k_i >= k_{2i+1}), (i = 1,2,3,4,...,n/2)$

##性质
　　堆的实现通过构造二叉堆（binary heap），实为二叉树的一种；由于其应用的普遍性，当不加限定时，均指该数据结构的这种实现。这种数据结构具有以下性质。<br>

    任意节点小于（或大于）它的所有后裔，最小元（或最大元）在堆的根上（堆序性）。
    堆总是一棵完全树。即除了最底层，其他层的节点都被元素填满，且最底层尽可能地从左到右填入。

　　将根节点最大的堆叫做最大堆或大根堆，根节点最小的堆叫做最小堆或小根堆。常见的堆有二叉堆、斐波那契堆等。

##API介绍
　　堆数据结构，如果数数元素是可以比较的，就不需要传入比较器对象，如果数据是可以比较的就要传入比较器，根据传入的比较器，可以实现大顶堆和小顶堆。


| 方法名      |    作用 | 时间复杂度  |
| :-------- | :-------- | :--: |
| Heap()  | 无参构造函数 |  -   |
| Heap(T t)     |   构造函数 |  -  |
| Heap(T t, Comparator< T > comparator)      |    构造函数 | -  |
| Heap(Comparator< T > comparator) | 构造函数 | - |
| Heap(Collection< T > coll) | 构造函数 | - |
| Heap(Collection< T > coll, Comparator< T > comparator) | 构造函数 | - |
| Comparator< T > getComparator() | 获取比较器对象 | - |
| setComparator(Comparator< T > comparator) | 设置比较器对象 | - |
| shiftUp(int idx) | 向上调整堆 | O(log(n)) |
| shiftDown(int idx) | 向下调整堆 | O(log(n)) |
| int compare(Object o1, Object o2) | 比较两个数的大小 | - |
| add(T item) | 添加一个元素 | O(log(n)) |
| add(T[] arr) | 添加一组元素 | O(n*log(n)) |
| add(Collection< T > coll) | 添加一组元素 | O(n*log(n)) |
| T getTop() | 获取堆顶元素，但不删除 | O(1) |
| T deleteTop() | 删除堆顶结点 | O(log(n)) |
| int size() | 获取堆的大小 | O(1) |
| boolean isEmpty() | 判断堆是否为空 | O(1) |
| clear() | 清空堆，如果有比较器，不会删除比较器 | - |
| delete() | 删除元素，并且清空比较器对象 | - |
| List< T > getData() | 获取堆中所有的数据 | - |
| toString() | 堆信息描述 | - |





