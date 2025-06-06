import java.util.*;
public class fractionalKnapsack {
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int total=50;
        double ratio[][]=new double[val.length][2];
        for(int i=0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1]= val[i]/(double)weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        for(int i=0;i<ratio.length;i++){
            System.out.println(Arrays.toString(ratio[i]));
        }
        int maximum=0;
        int capacity=total;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity  >= weight[idx]){
                maximum+=val[idx];
                capacity -= weight[idx];

            }else{
                maximum+=ratio[i][1] * capacity;
                capacity -= weight[idx];//no need for this
                break;
            }
        }
        System.out.println(maximum);


    }
}
