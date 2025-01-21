class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        
    int arr1=nums.length;
        
        Set <Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int arr2=set.size();
    if(arr1==arr2){
       return false;
    }
    else{
        return true;
    }       
         
    }
}