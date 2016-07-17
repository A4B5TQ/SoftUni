package javaOOPBasics.methods.lastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Number {
    private Integer number;

    public Number(Integer number){
        this.number = number;
    }

    public String getLastNumberName(){
        String name = "";

        int lastDigit = this.number % 10;

        switch (lastDigit){
            case 0: name = "zero"; break;
            case 1: name = "one"; break;
            case 2: name = "two"; break;
            case 3: name = "three"; break;
            case 4: name = "four"; break;
            case 5: name = "five"; break;
            case 6: name = "six"; break;
            case 7: name = "seven"; break;
            case 8: name = "eight"; break;
            case 9: name = "nine"; break;
        }

        return name;
    }
}
public class LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Integer num = Integer.parseInt(sc.readLine());

        Number number = new Number(num);

        System.out.println(number.getLastNumberName());
    }
}
