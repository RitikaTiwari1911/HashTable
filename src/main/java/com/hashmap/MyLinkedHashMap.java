package com.hashmap;

import java.util.ArrayList;

public class MyLinkedHashMap<K,V> {
    private final int numBuckets;
    ArrayList<MyLinkedList<K>> myBucketArray;

    public MyLinkedHashMap() {
        this.numBuckets = 10;

        //create empty linkedList
        this.myBucketArray = new ArrayList<>(numBuckets);
        for(int i=0 ; i<numBuckets ; i++)
            this.myBucketArray.add(null);
    }
    //method to get the value of node for respective key
    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) return null;
        MyMapNode<K,V> myMapNode= (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    private int getBucketIndex(K key) {
        int hashcode = Math.abs(key.hashCode());
        int index = hashcode % numBuckets;
        System.out.println("Key :"+key+" hashcode :"+hashcode+" index :"+index);
        return index;
    }

    //adding key value
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if(myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index,myLinkedList);
        }
        MyMapNode<K,V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        if(myMapNode == null) {
            myMapNode=new MyMapNode<>(key,value);
            myLinkedList.append(myMapNode);
        }else{
            myMapNode.setValue(value);
        }
    }
    @Override
    public String toString() {
        return "MyLinkedHashMap List{"+myBucketArray+"}";
    }
}

