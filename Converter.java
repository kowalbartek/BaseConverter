/*
    Simple converter program that converts number from one base to another.
*/

import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        //Initiate scanner
        Scanner sc = new Scanner(System.in);
        //Prompt user for input
        System.out.println("Enter a number: ");
        String N = sc.next();
        System.out.println("What base is it in? ");
        int base1 = sc.nextInt();
        System.out.println("What base do you want to convert to? ");
        int base2 = sc.nextInt();
        //Close scanner
        sc.close();
        //Convert
        System.out.println(convertFromDecimalToBase((convertFromBaseToDecimal(N, base1)), base2));
    }

    //Convert from decimal to any base
    static String convertFromDecimalToBase(int num, int base) {
        StringBuilder str = new StringBuilder();
        int remainder;
        while (num > 0) {
            remainder = num % base;
            if (remainder > 9) {
                str.append((char) (remainder - 10 + 'A'));
            } else str.append(remainder);
            num /= base;
        }
        return str.reverse().toString();
    }

    //Convert from initial base to decimal
    static int convertFromBaseToDecimal(String num, int base) {
        int value = 0;
        int power = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit;
            char c = num.charAt(i);
            if (c >= '0' && c <= '9')
                digit = c - '0';
            else
                digit = c - 'A' + 10;
            value += digit * power;
            power = power * base;
        }
        return value;
    }
}