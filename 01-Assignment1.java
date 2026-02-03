// calulator
import java.util.*;
 
 class Assignment1 {
    static void reverse(int arr[], int start, int end) {
        
        if (end > arr.length) {
            end = arr.length;
        }
         
        int rangeSize = end - start;
         
        for (int i = 0; i < rangeSize / 2; i++) {
    
            int left = start + i;
            int right = end - 1 - i;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public static void main(String[] args) {
        int num[]=new int[]{1,2,3,4,5};
        int k=3%num.length;
        int i=0;
         
        while(i < num.length ){
            reverse(num,i,(i+k));
            i+=k;
            
        }
       for(int j=0;j<5;j++){
         System.out.println(num[j]+" ");
       }
    }
}
