package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
       
	    for(int i = 0; i < 10; i++) {
            s = s.replaceAll(words[i],i+"");
        }
        return Integer.parseInt(s);
    }
}
