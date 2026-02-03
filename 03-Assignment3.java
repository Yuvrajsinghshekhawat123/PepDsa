 class Solution {
    public int minSwaps(int[] nums) {
        int[] arr=new int[2*nums.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=nums[i%nums.length];
        }

        int ones = 0;
        for (int n : nums) ones += n;


        int left=0;
        int minSwap=Integer.MAX_VALUE;
        int currOnes=0;


        for(int i=0;i<arr.length;i++){
             currOnes+=arr[i];

            if(i-left+1 > ones){
                currOnes-=arr[left];
                left++;
            }
            if(i-left+1 == ones){
                minSwap=Math.min(minSwap,ones-currOnes);
            }
            
              
        }

          minSwap=Math.min(minSwap,ones-currOnes);
          return minSwap;

    }
}