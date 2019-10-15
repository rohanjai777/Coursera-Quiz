/*
Question 2.
Union-find with specific canonical element. Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing ii. The operations, union(), connected(), and find() should all take logarithmic time or better.

For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9}, then the find() method should return 99 for each of the four elements in the connected components.
*/
/*
Now to include find function, we have to first make an Array findarr[] whose size is n. Now we have to initialize it using the for loop. The modification will be done in the union method. 
        int i = root(p);
        int j = root(q);
        if(findarr[i]<findarr[j]){
            findarr[i]=findarr[j];
        }
        else{
            findarr[j]=findarr[i];
        }
Code will print the max element in the component.
My Complete Code is:
*/
class MyClas {
    private int[] a;
    private int[] size;
    private int[] findarr;
    int N=0;
    public MyClas(int n){
        N=n;
        a = new int[n];
        size = new int[n];
        findarr = new int[n];
        for(int i=0;i<n;i++){
            a[i]=i;
            findarr[i]=i;
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
    public void find(int f){
        System.out.print(findarr[f]);
    }
    public void union(int p,int q, String timestamp){
        int i = root(p);
        int j = root(q);
        if(findarr[i]<findarr[j]){
            findarr[i]=findarr[j];
        }
        else{
            findarr[j]=findarr[i];
        }
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
      obj.find(3);
      obj.union(5,2, "2019-08-14 18:00:03");
      obj.union(0,3,"2019-08-14 18:00:04");
      obj.union(2,1,"2019-08-14 18:00:05");
      
    }
}
