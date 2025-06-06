import java.util.*;
public class sorting {
    static void insertion(int arr[]){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int curr=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>curr){
                arr[j+1]=arr[j];
                j--; 
            }
            arr[j+1]=curr;
        }
        System.out.println(Arrays.toString(arr));
    }
    static  void bubble(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n-1;j++){
                if(arr[j]<min){
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[]={55,45,23,51,19,8};
        bubble(arr);
        selection(arr);
        insertion(arr);
        
    }
}
