package com.company;

/**
 * Created by yechang on 2016/10/9.
 */

import java.util.LinkedList;

/**
 * ���У����潫Ҫ���ʵ� URL
 */
public class Queue2 {
    // ʹ������ʵ�ֶ���
    private LinkedList queue = new LinkedList();

    // �����
    public void enQueue(Object t) {
        queue.addLast(t);
    }

    // ������
    public Object deQueue() {
        return queue.removeFirst();
    }

    // �ж϶����Ƿ�Ϊ��
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    // �ж϶����Ƿ���� t
    public boolean contians(Object t) {
        return queue.contains(t);
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
