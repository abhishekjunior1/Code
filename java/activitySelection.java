import java.util.*;
class activitySelection{
    static void method1(int start[],int end[]){
        int count=1;
        int endtime=end[0];
        for(int i=1;i<start.length;i++){
            if(start[i]> endtime){
                count++;
                endtime=end[i];
            }
        }
        System.out.println(count);  
    }
    static void method2(int start[],int end[]){
        int activity[][]=new  int[start.length][3];
        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));

        for(int i=0;i<activity.length-1;i++){
            System.out.println(Arrays.toString(activity[i]));
        }

        int count=1;
        int endtime=activity[0][2];
        for(int i=0;i<start.length;i++){
            if(activity[i][1]> endtime){
                count++;
                endtime=activity[i][2];
            }
        }
        System.out.println(count);




    }
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]=  {2,4,6,7,9,9};
        //method1(start,end);
        method2(start,end); 
    }
}