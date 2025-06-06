import java.util.*;
public class mergeInterval {
    public static void main(String[] args) {
        int interval[][]= {{1,3},{2,6},{8,10}, {15,18}};
        // int interval[][]={{1,4},{4,5}};
        Arrays.sort(interval,Comparator.comparingInt(o->o[1]));
        int start=interval[0][0];
        int end=interval[0][1];
        for(int i=1;i<interval.length;i++){
            if(end < interval[i][0]){
                System.out.println(start+ " "+ end);
                start=interval[i][0];
            }
            end = interval[i][1];
            
        }
        System.out.println(start + " " + end);


    }
}
