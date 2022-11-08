package com.ethen.structure.queue;

/**
 * 最大优先级队列
 * <p>
 * 二叉堆还分为最大堆和最小堆。最大堆的性质是：每个节点都大于等于它的两个子节点。类似的，最小堆的性质是：每个节点都小于等于它的子节点。
 * <p>
 * 参考<a href='https://labuladong.gitee.io/algo/2/23/65/'>二叉堆详解实现优先级队列</a>
 *
 * @author ethenyang@126.com
 * @since 2022/11/08
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    // 保存真实数据
    private T[] values;

    // 当前队列中元素个数
    private int size = 0;

    public MaxPriorityQueue(int capacity) {
        // index=0的位置不存节点
        values = (T[]) new Comparable[capacity + 1];
    }

    /**
     * 返回最大节点
     * <p>
     */
    public T max() {
        return values[1];
    }

    /**
     * 插入元素
     */
    public void insert(T item) {
        // 元素个数+1
        size++;
        if (size > values.length) {
            throw new IndexOutOfBoundsException();
        }
        // 队列尾部添加元素
        values[size] = item;
        // 维持最大二叉堆结构(上浮)
        swim(size);
    }

    /**
     * 弹出最大元素
     */
    public T popMax() {
        T val = values[1];
        // 将root节点换到末位
        swap(1, size);
        // 删除末尾节点
        values[size] = null;
        size--;
        // 维持二叉堆结构
        sink(1);
        return val;
    }

    /**
     * 上浮第x个元素，维持最大堆性质
     */
    public void swim(int x) {
        while (x > 1 && lessThen(parent(x), x)) {
            // 如果x元素大于父节点，则上浮
            swap(parent(x), x);
            // 游标移动
            x = parent(x);
        }
    }

    /**
     * 下沉第x个元素，维持最大堆性质
     * (与较大的子节点交换位置)
     * <p>
     * todo 须理解完全二叉树
     */
    public void sink(int x) {
        // 如果存在子节点
        while (left(x) < size) {
            // 先假设左子节点比较大
            int max = left(x);
            // 如果存在右子节点，且右子节点较大
            if (right(x) < size && lessThen(max, right(x))) {
                max = right(x);
            }
            // 如果当前节点比两个子节点都要大，则无需下沉
            if (lessThen(max, x)) {
                break;
            }
            swap(max, x);
            // 移动游标
            x = max;
        }
    }

    // 交换x,y位置的元素
    private void swap(int x, int y) {
        T temp = values[x];
        values[x] = values[y];
        values[y] = temp;
    }

    // fixme 判断x是否小于y
    private boolean lessThen(int x, int y) {
        return values[x].compareTo(values[y]) < 0;
    }

    /**
     * 当前节点的父节点索引
     */
    public int parent(int index) {
        return index / 2;
    }


    /**
     * 当前节点的左孩子节点索引
     */
    public int left(int index) {
        return index * 2;
    }

    /**
     * 当前节点右孩子节点索引
     */
    public int right(int index) {
        return index * 2 + 1;
    }
}
