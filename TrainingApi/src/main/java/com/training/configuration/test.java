package com.training.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("321", "956", "21", "9");
        List<String> sored = arr.stream().sorted((a, b) -> {return (b+a).compareTo(a+b);}).collect(Collectors.toList());
        sored.stream().forEach(System.out::print);

    }
}
