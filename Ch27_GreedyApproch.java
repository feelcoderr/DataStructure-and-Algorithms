import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
public class Ch27_GreedyApproch {
    //select the maximum number of activitys that can be done 
    static int activitySelection(int start[], int end[]){
        //step-1 sort according to end time
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        //sort
        //Lamda funtion -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        for(int i=0; i<end.length; i++){
            start[i] = activities[i][1];
            end[i] = activities[i][2];
        }

        int maxAct = 0;
        ArrayList<Integer> act = new ArrayList<>();

        //select activities which end's early so we can do more activities
        maxAct = 1;
        act.add(end[0]);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++){
            if(start[i]<=lastEnd){
                maxAct++;
                act.add(end[i]);
                lastEnd = end[i];
            }
        }
        return maxAct;
    }

    //Fractional knapsack
    public static int fractionalKnapsack(int weight[], int val[], int w){
        //ratio v/w
        double ratio[][] = new double[val.length][2];
        for(int i=0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i] /(double)weight[i];
        }

        //sort ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = w;
        int finalVal = 0;
        for(int i = ratio.length - 1; i >= 0; i++){
            int idx = (int)ratio[i][0];
            //add full item
            if(capacity >= weight[idx]){
                finalVal = finalVal + val[idx];
                capacity = capacity - weight[idx];
            }
            //add frictional item
            else{
                finalVal = finalVal + ((int)ratio[i][1] * capacity);
                break;
            }
        }
        return finalVal;
    }

    //Minimum sum of Absolute Difference
    public static int minDifferenceSum(int a[], int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int absSum = 0;
        for(int i=0; i<a.length; i++){
            absSum = absSum + Math.abs(a[i] - b[i]);
        }
        return absSum;
    }

    //Maximum length Chain of pairs
    public static int longestChainOfPairs(int pairs[][]){
        //sort pairs based on second number of pair
        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));
        int chainLength = 1;
        int chainEnd = pairs[0][1];

        for(int i=0; i<pairs.length; i++){
            if(chainEnd <= pairs[i][0]){
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }

        return chainLength;
    }

    //Indian Coins (Find min no. of coins/notes to make change)
    public static int minChange(int v, int currency[]){
        //sort currency's array
        Arrays.sort(currency);

        //make array to store coins/notes value
        ArrayList<Integer> coins = new ArrayList<>();

        int ans = 0;
        for(int i=currency.length - 1; i >= 0; i--){
            while(v >= currency[i]){
                v -= currency[i];
                ans++;
                coins.add(currency[i]);
            }
        }
        System.out.println(coins);
        return ans;
    }


    //Job sequence - get max profit by doing jobs in deadline
    static class Job{
        int deadLine;
        int profit;
        int id;

        Job(int id, int deadLine, int profit){
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }
    }
    public static int jobSequence(int jobInfo[][]){

        ArrayList<Job> jobs= new ArrayList<>();

        for(int i=0; i<jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) ->b.profit - a.profit); //descending order
        
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int i = 0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadLine > time){
                seq.add(curr.id);
                time++;
            }
        }
        int numOfJob = seq.size();
        System.out.println(seq);
        return numOfJob;
    }
    
    //Chocola Problem : compute minimul cost of breaking the whole chocolate into single sqares
    public static int minCostOfBreaking(Integer costVar[], Integer costHor[]){
        
        //Sort in descending order
        Arrays.sort(costVar, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0;
        int v = 0;
        
        //count of pieces
        int hp = 0;
        int vp = 0; 
        int cost = 0;

        while(h < costHor.length && v < costVar.length){
            if(costVar[v] <= costHor[h]){
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }else{
                cost += (costVar[v] * hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while(v < costVar.length){
            cost += (costVar[v] * hp);
            vp++;
            v++; 
        }

        return cost;
    }
    public static void main(String args[]){
        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};
        // System.out.println(activitySelection(start, end));

        // int a[] = {4, 1, 8, 7};
        // int b[] = {2, 3, 6, 5};
        // System.out.println(minDifferenceSum(a, b));

        // int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        // System.out.println(longestChainOfPairs(pairs));

        // int currency[] = {2000, 100, 500, 1, 5, 10, 50, 20, 2};
        // int v = 121;
        // System.out.println(minChange(v, currency));

        // int jobInfo[][] = {{4, 20}, {1, 10}, {1, 30}, {1, 40}}; // dead line, profit
        // System.out.println(jobSequence(jobInfo));

        Integer verticalCost[] = {4, 1, 2, 3, 1};
        Integer horizontalCost[] = {1, 4, 2};
        System.out.println(minCostOfBreaking(verticalCost, horizontalCost));
    }
}
