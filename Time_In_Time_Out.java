import java.util.*;
class graph
{
    static int id = 0;
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
    public void dfs(int u , boolean visited[],int tt[][])      // to calculate time in and time out for graph
    {
        tt[u][0] = id;
        id++;
        visited[u] = true;
        for(int i = 0 ; i < v ; i++ )
        {
            if(a[u][i] == 1)
            {
                if(visited[i] == false )
                dfs(i,visited,tt);
            }
        }
        tt[u][1] = id;
        id++;
    }
}
class Time_In_Time_Out
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

        int tt[][] = new int[ver][2];
        boolean visited[] = new boolean[ver];
        for(int i = 0 ; i< ver ; i++)
        {
            if(visited[i] == false)
            {
                g.dfs(i,visited,tt);
            }
        }
        

        for(int i = 0 ; i < ver ; i++)
        System.out.println(tt[i][0]+"  "+tt[i][1]);
        sc.close();
    }
}