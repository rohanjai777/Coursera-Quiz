/*
Question 1.
Social network connectivity. Given a social network containing nn members and a log file containing mm timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.

Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.
*/
/*
To find if all the members are connected I used the concept of weighted Quick-union. If the size of tree gets equal to the n then we can say all the members are connected.
My Code:
*/
class MyClas {
    private int[] a;
    private int[] size;
    int N=0;
    public MyClas(int n){
        N=n;
        a = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            a[i]=i;
            size[i]=1;
        }
    }
    private int root(int x){
        while(x != a[x]){
            x=a[x];
        }
        return x;
    }
    public boolean connected(int p, int q){
        return root(p)==root(q);
    }
    public void union(int p,int q, String timestamp){
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        if(size[i] < size[j]){
            a[i] = j;
            size[j]+=size[i];
            if(size[j]==N){
                System.out.println("All Members are connected at Timestamp"+ timestamp);
            }
        }
        else{
            a[j] = i;
            size[i]+=size[j];
            if(size[i]==N){
                System.out.println("All Members are connected at Timestamp"+ timestamp);
            }
        }
    }
    
}
public class MyClass {
    public static void main(String args[]) {
      MyClas obj = new MyClas(6);
      obj.union(1,5, "2019-08-14 18:00:00");
      obj.union(2,4, "2019-08-14 18:00:01");
      obj.union(1,3, "2019-08-14 18:00:02");
      obj.union(5,2, "2019-08-14 18:00:03");
      obj.union(0,3,"2019-08-14 18:00:04");
      obj.union(2,1,"2019-08-14 18:00:05");
      
    }
}