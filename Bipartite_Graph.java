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
    public  boolean isBarpartite(int visited[],boolean c[],int v)
    {
        for(int i = 0 ; i < visited.length;i++)
        {
            if(a[v][i]==1)
            {
                if(visited[i]==0)
                {
                    visited[i] = 1;
                    c[i] = !c[v];
                    if(isBarpartite(visited,c,i) == false )
                    return false;
                }
                else
                {
                    if(c[v] == c[i])
                    return false;
                }
            }
        }
        return true;
    }
}
class Bipartite_Graph
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


        boolean color[] = new boolean[ver];
        int visited[] = new int[ver];


        for(int i = 0 ; i < ver ;i++)
        visited[i] = 0;
        visited[0] = 1;
        color[0] = true;
        
        
        if(g.isBarpartite(visited,color,0)==false)
        System.out.println("No graph is not Bipartite.");
        else
        System.out.println("Yes graph is Bipartite.");
        sc.close();
    }
}