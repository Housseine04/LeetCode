// 41. First Missing Positive

/*
* General idea : Looking for a missing value (before / between / after) successive integers. Use indexes of array to track mismatch
* Complexity : O(n)
*/

class Solution {
    public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        if(nums.length == 1){
            if(nums[0] != 1 ) return 1;
            else{
                return 2;
            }
        }

        //play with indexes and number values
        int limit = nums.length;

        //number curr should be placed at position curr - 1
        // if curr > limit , place at end and shrink limit
        int i = 0;
        while(i < limit){
            int curr = nums[i];
            if (i == curr - 1){ // already at good pos
                i++;
                continue;
            }
            if(curr > limit || curr <= 0){ //not in interval boundaries
                swap(i, limit - 1, nums);
                limit--;
            }else{ // correct
                if(nums[curr-1] == curr){
                    swap(i,  limit-1, nums);
                    limit--;
                }else{
                    swap(i, curr-1, nums);
                }
            }
        }

        // checking
        for(int k = 0; k< nums.length; k++){
            if(k + 1 != nums[k]) return k + 1;
        }

        return nums.length+1;
    }
    private static void swap(int idx1, int idx2, int[] nums){
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
        return;
    }
}
