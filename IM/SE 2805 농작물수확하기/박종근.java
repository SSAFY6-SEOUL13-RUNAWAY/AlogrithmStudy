package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class SE2805농작물수확하기 {
    static int T;
    static int[][] map;
    static int N;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
         
        T = sc.nextInt();
        int sum;
        for (int t = 1; t <= T; t++) {
            sum = 0;
            N = sc.nextInt();
            map = new int[N][];
            for (int i = 0; i < N; i++) {
                map[i] = new int[N];
            }
             
            for (int i = 0; i < N; i++) {
                String num = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = (num.toCharArray()[j]-'0');
                }
            }
             
            for (int i = 0; i < N; i++) {
                int start = Math.abs((N/2)-i);
                for (int j = start; j < start + (2*(N/2 - start)) + 1; j++) {
                    sum += map[i][j];
                }
            }
             
            System.out.printf("#%d %d\n",t,sum);
             
        }
         
    }
}