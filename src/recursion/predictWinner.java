package recursion;

public class predictWinner {

        public boolean predictTheWinner(int[] nums) {
            return score(nums, 0, nums.length - 1) >= 0;
        }

        private int score(int[] nums, int left, int right) {
            if (left == right) return nums[left];
            int pickLeft = nums[left] - score(nums, left + 1, right);
            int pickRight = nums[right] - score(nums, left, right - 1);

            return Math.max(pickLeft, pickRight);
        }


}
