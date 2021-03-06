package com.hashmap;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListMapTest {
    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturn_ParanoidFrequency(){
        String sentence = "Paranoids are not paranoid because they are paranoid but"+
                          "because they keep putting themselves deliberately into" +
                          "paranoid avoidable situations";
        MyLinkedHashMap<String,Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words){
            Integer value = myLinkedHashMap.get(word);
            if(value == null) value=1;
            else value=value+1;
            myLinkedHashMap.add(word,value);
        }
        int frequency = myLinkedHashMap.get("paranoid");
        System.out.println(myLinkedHashMap);
        Assert.assertEquals(3,frequency);
    }
}
