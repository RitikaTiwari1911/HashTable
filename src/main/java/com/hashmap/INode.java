package com.hashmap;

public interface INode<K> {
    K getKey();
    public void setKey(K key);

    INode getNext();
    void setNext(INode next);
}
