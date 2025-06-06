import java.util.*;
public class jobsequencing {
    public static void main(String[] args) {
        int job[][]={{4,20},{1,10},{1,40},{1,30}};
        int n=job.length;
        Arrays.sort(job, Comparator.comparingInt(o -> o[1]));

        int time=0;
        int profit=0;
        for(int i = n-1;i>=0;i--){
            if(job[i][0]> time){
                profit+=job[i][1];
                time++;
            }
        }
        System.out.println(profit);


    }
}
