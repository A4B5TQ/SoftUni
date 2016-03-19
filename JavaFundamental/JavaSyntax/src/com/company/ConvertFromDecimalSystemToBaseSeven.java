package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConvertFromDecimalSystemToBaseSeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int decimalNumber = sc.nextInt();
        int sevenBase = convertBase(decimalNumber,7);
        System.out.println(sevenBase);


    }
    static Integer convertBase( int number, int base ) {

        List<Integer> remainder = new ArrayList<>();

        int count = 0;
        String result = "";

        while( number != 0 ) {
            remainder.add( count, number % base != 0 ? number % base : 0 );
            number /= base;

            try {
                result += remainder.get( count );

            } catch( NumberFormatException e ) {
                e.printStackTrace();
            }
        }
        return new Integer( new StringBuffer( result ).reverse().toString() );
    }
}
