package com.example.shiro;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Person{

    public static void main(String[] args) {
        String [] arr={"1","1","2","3"};
        ArrayList<String> list=new ArrayList<>();
        for (int i=0;i<arr.length;i++)
        {
            list.add(arr[i]);
        }
        Set set=new HashSet(list);
            System.out.println(set);
    }
}
