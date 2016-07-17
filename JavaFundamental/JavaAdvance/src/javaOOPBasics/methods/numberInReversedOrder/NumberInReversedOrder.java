package javaOOPBasics.methods.numberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DecimalNumber{
    private Double decimalNumber;

    public DecimalNumber(Double decimalNumber){
        this.decimalNumber = decimalNumber;
    }

    public void printInReversedOrder(){
        String number = this.decimalNumber.toString();
        StringBuilder reversedNumber = new StringBuilder(number.length());
        if (number.endsWith(".0"))
            number = number.replaceFirst("[.0]+","");

        for (int i = number.length() - 1; i >= 0; i--) {
            reversedNumber.append(number.charAt(i));
        }

        System.out.println(reversedNumber.toString());
    }
}
public class NumberInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Double num = Double.parseDouble(sc.readLine());

        DecimalNumber decimalNumber = new DecimalNumber(num);

        decimalNumber.printInReversedOrder();
    }
}
