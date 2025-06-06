import java.util.*;
public class mergeSort {
    static void merge(int arr[],int start,int end){
       if(end>start){
        int mid=(end+start)/2;
        merge(arr, start, mid);
        merge(arr, mid+1, end);
        merging(arr,start,mid,end); 

       }
          
    }
    static void merging(int arr[],int start,int mid,int end){
        int i=start;
        int j=mid+1;
        ArrayList<Integer> temp= new ArrayList<>();
        while(i<=mid && j<=end){
            if (arr[i]>arr[j]) {
                temp.add(arr[j]);
                j++;
            }else{
                temp.add(arr[i]);
                i++;
            }
        }
        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=end){
            temp.add(arr[j]);
            j++;
        }
        for(int k=start;k<=end;k++){
            arr[k]=temp.get(k-start);
        }

    }
    public static void main(String[] args) {
        int arr[]={ 12, 11, 13, 5, 6, 7 };
        merge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
}
