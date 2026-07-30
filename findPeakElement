// 162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int mid = nums.length / 2;

        //case where border
        int ref = Integer.MIN_VALUE;
        if(mid+1 >= nums.length){
            if(nums[mid] > ref && nums[mid] > nums[mid-1]) return mid;
        }else if(mid-1 < 0){
            if(nums[mid] > ref && nums[mid] > nums[mid+1]) return mid;
        }

        //normal cases
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
        if(nums[mid] < nums[mid-1]){
            nums = splitLogN(nums, 0, mid);
            return findPeakElement(nums);
        }
        if(nums[mid] < nums[mid+1]){
            nums = splitLogN(nums, mid+1, nums.length);
            return (mid+1) + findPeakElement(nums);
        }
        return -1;
    }

    public int[] splitLogN(int[] nums, int lo, int hi){
        nums = Arrays.copyOfRange(nums, lo, hi);
        return nums;
    }
}
