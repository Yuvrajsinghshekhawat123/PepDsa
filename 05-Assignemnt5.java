
import java.util.*;
class Solution {
    boolean solve(int[] pos,int m,int maxForce){
        int force=pos[0];
        int count=1;
        for(int i=1;i<pos.length;i++){
            if(Math.abs(pos[i]-force) >= maxForce){
                force=pos[i];
                count++;
            }
            if(count==m) return true;
        }
        return false;
    }
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int left=1;
        int right=pos[pos.length-1]-pos[0];

        int ans=0;
        while(left <= right){
            int mid=(left+right)/2;

            boolean maxForce=solve(pos,m,mid);
            if(maxForce){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
                 
            }
        }
        return ans;

    }
}