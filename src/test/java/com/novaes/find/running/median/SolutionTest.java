/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.find.running.median;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kbos
 */
public class SolutionTest {
    @Test
    public void test1() {
        double[] d = new double[]{12.0,8.0,5.0,4.5,5.0,6.0};
        assertArrayEquals(d, Solution.runningMedian(new int[]{12,4,5,3,8,7}), 0);
    }
    
    @Test
    public void test2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/home/kbos/Downloads/input01.txt"));
        Scanner scannerOut = new Scanner(new File("/home/kbos/Downloads/output01.txt"));
        int aCount = Integer.parseInt(scanner.nextLine().trim());
        int[] a = new int[aCount];
        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }
        double[] d = new double[aCount];
        for (int aItr = 0; aItr < aCount; aItr++) {
            double aItem = Double.parseDouble(scannerOut.nextLine().trim());
            d[aItr] = aItem;
        }
        assertArrayEquals(d, Solution.runningMedian(a), 0);
    }
    
    
    
    
}
