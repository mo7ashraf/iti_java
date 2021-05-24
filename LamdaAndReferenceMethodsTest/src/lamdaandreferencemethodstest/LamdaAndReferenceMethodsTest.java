/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamdaandreferencemethodstest;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 *
 * @author dell
 */
public class LamdaAndReferenceMethodsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "Hello World sdfdgdfdfgfd";
        String s2 = "new Hello World";
        String s3="P@ssw0rd";
        /*
        // Using an anonymous class
        findNumbers(list, new BiPredicate<Integer, Integer>() {
        public boolean test(Integer i1, Integer i2) {
        return LamdaAndReferenceMethodsTest.isMoreThanFifty(i1, i2);
        }
        });
        // Using a lambda expression
        findNumbers(list, (i1, i2) -> LamdaAndReferenceMethodsTest.isMoreThanFifty(i1, i2));
         */
// Using a method reference
        String betterString = betterString(s1, s2, LamdaAndReferenceMethodsTest::isBetterString);
        System.out.println(betterString);
        boolean containAlphabet = containAlphabet(s3, LamdaAndReferenceMethodsTest::isLetter);
        System.out.println(containAlphabet);
    }

    public static boolean isBetterString(String s1, String s2) {
        return (s1.length() > s2.length());
    }

    public static String betterString(String s1, String s2, BiPredicate<String, String> p) {
        if (isBetterString(s1, s2)) {
            return s1;
        } else {
            return s2;
        }

    }

    public static boolean isLetter(String s1) {
        char[] s1_char_arr = s1.toCharArray();
        for (char c : s1_char_arr) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean containAlphabet(String s1, Consumer<String>c) {
        return isLetter(s1);
    }
}
