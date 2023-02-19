/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csc229lab04hw03;
import java.util.Scanner;

/**
 *
 * @author willi
 * GitHub Link: https://github.com/ackewj8/LabAssignment04HW03.git
 */
public class CSC229Lab04HW03 {
    public static void selectionSort(int[] a, int size) { // Used to sort the array
        int outer, inner, min; // Used to sort the array
        for (outer = 0; outer < size - 1; outer++) {
            min = outer;
            for (inner = outer + 1; inner < size; inner++) {
                if (a[inner] < a[min]) {
                    min = inner;
                }
            }
            int temp = a[outer];
            a[outer] = a[min];
            a[min] = temp;
        }
    }
    public static boolean binarySearch(int[] series, int key, int low, int high) { // Implementing binary search
        if (low > high) // cannot work with if low > high
            return false;
        else {
            int mid = (low + high) / 2;
            // if the key is the same as series' middle value
            if (key == series[mid])
                return true;
            // if the key is higher than series' middle value
            else if (key < series[mid])
                return binarySearch(series, key, low, mid - 1);
            // if the key is higher than series' middle value
            else
                // returns binarySearch's value
                return binarySearch(series, key, mid + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] num = new int[5]; // creating a new array
        int size = 5; // size of the array
        int reader;
        int key; // int user is searching for
        boolean ifFound; // Used to see if key was found
        Scanner scnr = new Scanner(System.in); // Reading user input
        // Reads user's integer values into the array
        for(int i = 0; i < num.length; ++i) {
            System.out.println("Please enter an integer: ");
            reader = scnr.nextInt(); // Scanner reads input value
            num[i] = reader; // num's element is assigned scnr's current value
        }
        // Message before sorting the array
        System.out.println("Now sorting array...");
        selectionSort(num, size); // Sorting the array
        for(int j = 0; j < size; ++j) { // Printing the sorted array
            System.out.println(num[j]);
        }
        // Asks the user what integer to search for
        System.out.println("What integer would you like to search for?: ");
        key = scnr.nextInt(); // Reads the integer the user is searching for
        int low = 0; // first value in num
        int high = num.length - 1; // last value in num
        ifFound = binarySearch(num, key, low, high);
        if (ifFound == true) { // If key was found
            System.out.println("Number " + key + " was found.");
        }
        else { // If key was not found
            System.out.println("Number " + key + " was not found.");
        }
    }
    
}
