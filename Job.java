package Adsaa;
import java.util.Arrays;
class Jobs {
    int id,deadline,profit;
    public Jobs(int id,int deadline,int profit){
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class Job{
    static int [] scheduleJobs(Jobs [] jobs,int n){
        Arrays.sort(jobs,(a,b) -> b.profit - a.profit);
        int maxDeadline=0;
        for(Jobs job:jobs){
            maxDeadline=Math.max(maxDeadline,job.deadline);
        }
        int [] schedule = new int[maxDeadline+1];
        boolean slot[] = new boolean[maxDeadline+1];
        Arrays.fill(schedule,-1);
        int totalProfit = 0;
        int jobCount = 0;
        for(Jobs job:jobs){
            for(int j =Math.min(maxDeadline,job.deadline);j>0;j--){
                if(!slot[j]){
                    schedule[j]=job.id;
                    slot[j]=true;
                    totalProfit+=job.profit;
                    jobCount++;
                    break;
                }
            }
        }
        System.out.println("Scheduled Jobs: ");
        for(int i=1;i<=maxDeadline;i++){
            if(schedule[i]!=-1){
                System.out.print("J"+schedule[i]+" ");
            }
        }
            System.out.println("\nTotal Profit: "+totalProfit);
        return new int[]{jobCount,totalProfit};
    }
    public static void main(String[] args) {
        Jobs [] jobs ={
            new Jobs(1,2,10),
            new Jobs(2,2,15),
            new Jobs(3,1,10),
            new Jobs(4,3,5),
            new Jobs(5,1,3)
        };
        scheduleJobs(jobs,jobs.length);
    }
}
