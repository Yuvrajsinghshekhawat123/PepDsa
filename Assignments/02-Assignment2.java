import java.util.*; 
 
 class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int left=1;
        int right=stalls[stalls.length-1] - stalls[0];
        int ans=-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            
            boolean canPlace=solve(stalls,k,mid);
            if(canPlace){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
        
        
    }
        
    boolean solve(int[] stalls,int k,int maxDist){
        int cow=1;
        int post=stalls[0];
        
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-post >= maxDist){
                post=stalls[i];
                cow++;
            }
            if(cow==k) return true;
        }
        return false;
    }
    
}