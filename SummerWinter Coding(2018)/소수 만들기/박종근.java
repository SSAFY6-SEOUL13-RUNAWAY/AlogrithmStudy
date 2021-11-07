class Solution {
	static int answer;
    
    public int solution(int[] nums) {
		answer = 0;
		Comb(0, 0, 0, nums);
		return answer;
    }
    
    private static void Comb(int start, int cnt, int sum, int[] nums) {
		if(cnt == 3) {
			for (int i = 2; i < sum; i++) {
				if(sum%i==0) return;
			}
			answer++;
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			Comb(i+1, cnt+1, sum+nums[i], nums);
		}
	}
}