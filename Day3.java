/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
import java.io.*;
import java.util.*;

public class Day3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> Land = new ArrayList<String>();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("day3.txt"));
            String pathway;
            while ((pathway = br.readLine()) != null) {
                Land.add(pathway);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        String[] path = new String[Land.size()];
        Land.toArray(path);
        
        partOne(path);
        partTwo(path);
//
//        int moveRight = 0;
//        int moveDown = 0;
//        int treeCount = 0;
//
//        for (int i = 1; i < path.length; i++) {
//            System.out.println(path[i].charAt(moveRight));
//            moveRight += 3;
//            
//            if (moveRight >= path[i].length()) {
//                moveRight -= path[i].length();
//            }    
//            if (path[i].charAt(moveRight) == '#') {
//                treeCount++;
//            }
//        }
//        System.out.println("tree count: " + treeCount);
    }
public static void partOne(String []lines) {
        int x = 0;
        int w = lines[0].length();
        char tree = '#';
        int count = 0;
        for (int i = 1; i < lines.length; ++i) {
            x += 3;
            if (x >= w) {
                x -= w;
            }
            if (lines[i].charAt(x) == tree) {
                ++count;
            }
        }
        System.out.println(count);
    }
public static void partTwo(String[]lines) {
        long a = getTrees(lines,1, 1);
        long b = getTrees(lines, 3, 1);
        long c = getTrees(lines, 5, 1);
        long d = getTrees(lines, 7, 1);
        long e = getTrees(lines, 1, 2);

        System.out.println((a * b * c * d * e) + " " + a + " " + b + " " + c + " " + d + " " + e);
    }

    public static long getTrees(String [] lines, int right, int down) {
        int x = 0;
        int y = 0;
        int w = lines[0].length();
        int h = lines.length;
        char tree = '#';
        long count = 0;
        while (true) {
            x += right;
            y += down;
            if (x >= w) {
                x -= w;
            }
            if (y >= h) {
                break;
            }
            if (lines[y].charAt(x) == tree) {
                ++count;
            }
        }
        return count;
    }
}
