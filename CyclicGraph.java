import java.util.*;
class graph
{
    int a[][];
    int v;
    int e;
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
    public boolean cyclic(boolean visited[],int u , int parent)
    {
        visited[u] = true;
        for(int i = 0 ; i< v ; i++)
        {
            if(a[u][i] == 1)
            {
                if(visited[i] == false)
                {
                    if(cyclic(visited,i,u))
                    return true;
                }
                else
                {
                    if(i!=parent)
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCyclic()
    {
        boolean visited[] = new boolean[v];
        for(int i = 0 ; i < v ; i++)
        {
            if(visited[i] == false)
            {
                if(cyclic(visited,i,-1) == true )
                return true;
            }
        }
        return false;
    }
}
class CyclicGraph
{
    public static void main(String[] args)
    {
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
        
        if(g.isCyclic() == true)
        System.out.println("Yes the graph is Cyclic");
        else
        System.out.println("No the graph is not Cyclic");
        sc.close();
    }
}