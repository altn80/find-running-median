/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.find.running.median;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author kbos
 */
public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        List<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minMemory = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxMemory = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            add(minMemory, maxMemory, a[i]);
            // Impar
            if(maxMemory.isEmpty()) {
                result.add(0.0);
            }
            if (maxMemory.size() > minMemory.size()) {
                result.add(maxMemory.peek().doubleValue());
            } else {
                
                result.add((maxMemory.peek().doubleValue() + minMemory.peek().doubleValue()) / 2);
            }
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
        /*
         * Write your code here.
         */
    }
    
    static void add(PriorityQueue<Integer> minMemory, PriorityQueue<Integer> maxMemory, Integer element) {
        if (maxMemory.isEmpty()) {
            maxMemory.add(element);
            return;
        }
        if(maxMemory.size() == minMemory.size()) {
            if(element < maxMemory.peek()) {
                maxMemory.add(element);
            } else {
                minMemory.add(element);
                maxMemory.add(minMemory.remove());
            }
        } else {
            if (element > maxMemory.peek()) {
                minMemory.add(element);
            } else {
                maxMemory.add(element);
                minMemory.add(maxMemory.remove());
            }
        }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
