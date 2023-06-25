import java.util.ArrayList;
import java.util.Collections;
public class JobSequence {
    static class Job{
        int id;
        int deadLine;
        int profit;

        public Job(int i, int d, int p){
            this.id = i;
            this.deadLine = d;
            this.profit = p;
        }
    }
    public static void main(String args[]){
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};//deadLine, profit 

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        //sort objects of job (Lamda funx)
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);//descending order

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        int profit = 0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadLine > time){
                seq.add(curr.id);
                profit = profit + curr.profit;
                time++;
            }
        }
        System.out.println("chain size is "+ seq.size());
        System.out.println("Jobs sequence is " + seq);
        System.out.println("Max profit is "+ profit);
        return;
    }
}
