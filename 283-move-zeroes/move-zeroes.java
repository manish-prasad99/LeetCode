class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0; // Pointer to place the non-zero element
        
        // Traverse through the array and move non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        // Fill the remaining elements with zeroes
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
