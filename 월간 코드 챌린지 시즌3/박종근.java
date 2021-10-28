class Solution {
    public int solution(int[] numbers) {
        int numbersSum = 0;
        for(int i = 0; i<numbers.length; i++) numbersSum += numbers[i];
        return 45-numbersSum;
    }
}
