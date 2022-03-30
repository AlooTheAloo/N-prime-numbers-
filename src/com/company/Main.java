package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static  String text = "";

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("pi_dec_1m.txt");
        Scanner filescan = new Scanner(f);
        while(filescan.hasNextLine())
            text += filescan.nextLine();
	    Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = FindIndex(n);
        for(int j = i; j < i + n; j++)
            System.out.print(text.charAt(j));
        System.out.print("\n" + i);
    }

    private static int FindIndex(int n){
        for(int i = 2; i < text.length(); i++){
            if(FindPrime(n, i))
                return i;
        }
        return -1;
    }

    private static boolean FindPrime(int n, int i){
        if(n == 0) return true;
        else if (IsPrime(text.charAt(i) - '0')){
            if(FindPrime(n - 1, i+1))
                return true;
        }
        return false;
    }

    private static boolean IsPrime(int k){
        if(k == 1) return false;
        for(int i = 2; i <= 5; i++){
            if(k % i == 0 && i != k){
                return false;
            }
        }
        return true;
    }


}
