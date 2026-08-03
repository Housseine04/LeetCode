// 18. 4Sum

/*
* General idea : fix 2 values (for loops) + use 2 pointers on a sorted array
* Complexity : O(nlogn) sorting + O(n³) search
* Use of long to avoid overflow
* Use of HashSet for unicity of resulting sub-arrays
*/

public static List<List<Integer>> fourSum(int[] nums, int target) {
       Arrays.sort(nums); // [-2,-1,0,1,2]
        //fix 2 vals + 2 pointers
        HashSet<List<Integer>> result = new HashSet<>();
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int ptrRight = j+1, ptrLeft = nums.length - 1;
                long searchedValue = (long) target - nums[i] - nums[j];
                while(ptrRight < ptrLeft){
                    if((long) nums[ptrRight] + nums[ptrLeft] == searchedValue){
                        result.add(List.of(nums[i],nums[j],nums[ptrRight],nums[ptrLeft]));
                        ptrLeft--;
                        ptrRight++;
                    }else{
                        if(nums[ptrRight] + nums[ptrLeft] < searchedValue){
                            ptrRight++;
                        }else{
                            ptrLeft--;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
