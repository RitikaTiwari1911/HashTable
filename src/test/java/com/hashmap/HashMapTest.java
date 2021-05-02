package com.hashmap;

import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {
    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
        String sentence = "To be or not to be";
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null) value = 1;
            else value = value + 1;
            myHashMap.add(word, value);
        }

        int frequency = myHashMap.get("to");
        int frequency1 = myHashMap.get("be");
        int frequency2 = myHashMap.get("or");

        System.out.println(myHashMap);
        Assert.assertEquals(2, frequency);
        Assert.assertEquals(2, frequency1);
        Assert.assertEquals(1, frequency2);
        }
    }




