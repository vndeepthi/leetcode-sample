package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;
import static java.util.Comparator.comparing;

public class TestSorting {

 static class DVD {
     private String name;
     private String genre;

     public String getName() {
         return name;
     }

     public DVD(final String name, final String genre) {
         this.name = name;
         this.genre = genre;
     }

     public void setName(final String name) {
         this.name = name;
     }

     public String getGenre() {
         return genre;
     }

     public void setGenre(final String genre) {
         this.genre = genre;
     }

     @Override
     public String toString() {
         return "DVD{" +
                 "name='" + name + '\'' +
                 ", genre='" + genre + '\'' +
                 '}';
     }
 }

 public static void main(final String args[]){
     final List<DVD> allDvds = new ArrayList<>();
     allDvds.add(new DVD("Abbbb","Romance"));
     allDvds.add(new DVD("Manam","Family"));
     allDvds.add(new DVD("Frozen","Animation"));
     sort(allDvds, comparing(dvd -> dvd.getName()));
     System.out.println(allDvds);
     sort(allDvds, (DVD o1, DVD o2) ->  o1.getGenre().compareTo(o2.getGenre()));
     System.out.println(allDvds);
 }
}
