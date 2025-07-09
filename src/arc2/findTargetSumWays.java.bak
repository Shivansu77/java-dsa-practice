public class findTargetSumWays {
    public int findTargetSumWays1(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    private int helper(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = helper(nums, index + 1, currentSum + nums[index], target);
        int sub = helper(nums, index + 1, currentSum - nums[index], target);

        return add + sub;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int target = 3;
        findTargetSumWays solution = new findTargetSumWays(); // Create an instance
        System.out.println(solution.findTargetSumWays1(nums, target)); // Output: 4
    }
}
