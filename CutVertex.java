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
        int low[] = new int[v];
        boolean al[] = new boolean[v];
        for(int i = 0 ;i  < v ; i++)
        {
            if(visited[i] == false)
            {
                check_CutVertex(i,visited,tt,low, -1,al);
            }
        }
        for(int i = 0 ; i< v ; i++)
        if(al[i] == true)
        System.out.print( i + " ");
    }
    public int min(int a , int b)
    {
        if(a>b)
        return b;
        return a;
    }
    public void check_CutVertex(int u ,  boolean visited[] , int tt[] , int low[],int parent ,boolean al[])
    {
        visited[u] = true;
        tt[u] = low[u] =  id;
        id++;
        int children = 0;
        for(int i = 0 ; i < v ; i++)
        {
            if(a[u][i] == 1)
            {
                if(visited[i] == false)
                {
                    children++;
                    check_CutVertex(i, visited, tt, low, u, al);

                    low[u] = min(low[u],low[i]);

                    if(parent == -1 && children >1)
                    al[u] = true;

                    if(parent!= -1 && low[i] >= tt[u])
                    al[u] = true;
                }
                else if(i!=parent)
                {   
                    low[u] = min(low[u],tt[i]);
                }
            }
        }
    }
}
class CutVertex
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