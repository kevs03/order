package com.kevin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.loadStrings ("BMW","VW","Nissan","Honda","Susuki","Seat","Mitsubishi","Hiunday","Chevrolet","Ford");

        var sortLenghtAnonymousClass = main.sortLenghtAnonymousClass();
        System.out.println("Longitud: Clase anónima");
        main.showList(sortLenghtAnonymousClass);
        System.out.println("--------------------------");

        var sortLenghtLambdaFunction = main.sortLenghtLambaFunction();
        System.out.println("Longitud: Expresión Lambda");
        main.showList(sortLenghtLambdaFunction);
        System.out.println("--------------------------");

        var sortLenghtReference = main.sortLenghtReference();
        System.out.println("Longitud: Método De referencia");
        main.showList(sortLenghtReference);
        System.out.println("--------------------------");

        var sortAlphabeticByAnonymousClass = main.sortAlphabeticAnonymousClass();
        System.out.println("Orden alfabético: Clase anónima");
        main.showList(sortAlphabeticByAnonymousClass);
        System.out.println("--------------------------");

        var sortAlphabeticByLambda = main.sortAlphabeticLambdaFunction();
        System.out.println("Orden alfabético: Expresión Lambda");
        main.showList(sortAlphabeticByLambda);
        System.out.println("--------------------------");

        var sortAlphabeticByReference = main.sortAlphabeticReference();
        System.out.println("Orden alfabético: Método De referencia");
        main.showList(sortAlphabeticByReference);
    }

    public void loadStrings(String...strings){
        for (var string : strings) this.strings.add(string);
    }

    public List<String> sortAlphabeticAnonymousClass(){
        List<String> strings = this.strings;
        Collections.sort(strings ,new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });
        return strings;
    }

    public List<String> sortAlphabeticLambdaFunction(){
        List<String> strings = this.strings;
        strings.sort((str1,str2) -> str1.compareToIgnoreCase(str2));
        return strings;
    }

    public List<String> sortAlphabeticReference(){
        List<String> strings = this.strings;
        SortAlphabetic sortAlphabetic = new SortAlphabetic();
        Collections.sort(strings,sortAlphabetic::compare);
        return strings;
    }

    public List<String> sortLenghtAnonymousClass(){
        List<String> strings = this.strings;
        strings.sort( new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        return strings;
    }

    public List<String> sortLenghtLambaFunction(){
        List<String> strings = this.strings;
        Collections.sort(strings,(str1,str2) ->  str1.length() - str2.length());
        return strings;
    }

    public List<String> sortLenghtReference(){
        List<String> strings = this.strings;
        SortLenght sortLenght = new SortLenght();
        strings.sort(sortLenght::compare);
        return strings;
    }
    
    public void showList(List<String> list){
        list.forEach(System.out::println);
    }
}

class SortAlphabetic implements Comparator{

    public static int sort(Object o, Object o1) {
        return o.toString().compareToIgnoreCase(o1.toString());
    }

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
}

class SortLenght implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().length() - o2.toString().length();
    }
}