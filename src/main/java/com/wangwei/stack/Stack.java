package com.wangwei.stack;

public interface Stack<E> {
    int getSize();

    void push(E e);

    E pop();

    boolean isEmpty();

    E peek();

}
