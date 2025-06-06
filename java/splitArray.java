import java.util.*;
public class splitArray {
    static void split(int arr[],int k){
        int quad=arr.length/k;
        int extra=arr.length%k;

        int ans[]= new int[k];
        Arrays.fill(ans,quad);
        for(int i=0;i<extra;i++){
            ans[i]++;
        }

        System.out.println(Arrays.toString(ans));
        int sum=0;
        int idx=0;
        for(int i=0;i<k;i++){
            int tempsum=0;
            for(int j=0;j<ans[i];j++){
                tempsum+=arr[idx++];
            }
            sum=Math.max(tempsum,sum);
        }
        System.out.println(sum);


    }
    public static void main(String[] args) {
        int arr[]={1, 1,2};
        int k=2;
        split(arr,k);

    }
}
