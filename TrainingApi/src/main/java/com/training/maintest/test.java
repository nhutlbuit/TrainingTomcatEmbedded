package com.training.maintest;

import org.springframework.util.StringUtils;

public class test {
     public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        System.out.println("concat: " + a.concat(b).concat(c)); 
        System.out.println("String.join: " + String.join("-", a, b, c));
        // System.out.println("concat: " + StringUtils.);
    }
}
