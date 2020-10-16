package com.cb.fts.sample.service;

public class ScoreCalc {


    public static void main(String[] args) {

//        int quantity = 68; //robot chicken
//        double p = 6.9/2;

//        int quantity = 6778; // star wars
//        double p = 8.1/2;


        int quantity = 5111; //rogue one
        double p = 7.4/2;
////
//        "vote_average": 8.1,
//                "vote_count": 6778

        System.out.println(  5*p/10 + 5*(1-Math.exp(((-1*quantity)/100))));
    }
}
