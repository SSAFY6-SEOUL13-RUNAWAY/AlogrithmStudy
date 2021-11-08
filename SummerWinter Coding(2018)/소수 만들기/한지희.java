class Solution {

    public int solution(int[] nums) {
       int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {//뽑아
				for (int k = j+1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if(check(sum)) {
						cnt++;
					}
				}
			}
		}
		return cnt;
    }
    private static boolean check(int sum) {
		for (int i = 2; i < sum; i++) {//2부터임
			if(sum%i==0) return false;//나눠떨어지면 소수 아님
		}
		return true;
	}
}
