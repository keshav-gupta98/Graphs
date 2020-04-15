import java.util.*;
class graph
{
    int a[][];
    int v;
    int e;
    static int id = 0;
    public graph(int v)
    {
        this.v = v;
        a = new int[v][v];
        for(int i = 0; i < v ; i++)
        for(int j = 0; j < v ; j++)
        a[i][j]=0;
    }
    public void addEdge(int s, int d)
    {
        a[s][d] = 1;
        a[d][s] = 1;
        e++;
    }
    public void check()
    {
        boolean visited[] = new boolean[v];
        int tt[] = new int[v];
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        dfs(0,visited,-1,tt,al);
        if(al.size() == 0)
        System.out.println("There are no bridges present in graph");
        else
        System.out.println("The bridges present in graph are");
        for(int i = 0 ; i < al.size() ; i++ )
        System.out.println((i+1) + ". " + al.get(i));
    }
    public void dfs(int u , boolean visited[], int parent,int tt[],ArrayList<ArrayList<Integer>> al)
    {
        visited[u] = true;
        tt[u] = id;
        id++;
        for(int i = 0 ; i< v ; i++)
        {
            if(a[u][i] == 1 && visited[i] == false)
            dfs(i,visited,u,tt,al);
        }
        int min = 99999;
        for(int i = 0 ; i < v ; i++)
        {
            if(i!=parent && a[u][i] == 1)
            {
                if(tt[i]<min)
                {
                    tt[u] = tt[i];
                    min = tt[u];
                }
            }
        }
        if(parent!=-1)
        if(tt[parent]<tt[u])
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(parent);
            temp.add(u);
            al.add(temp);
        }
        id++;
    }
}
public class bridge
{
	public static void main(String[] args) {
	 System.out.println("Enter the no. of vertices");
    Scanner sc = new Scanner(System.in);
    int ver = sc.nextInt();
    graph g = new graph(ver);
    System.out.println("Enter the no. of edges");
    int edges = sc.nextInt();
    for( int i = 0 ; i < edges ; i++ )
    {
        int s = sc.nextInt();
        int d = sc.nextInt();
        g.addEdge(s, d);
    }
    g.check();
    sc.close();
	}
}
