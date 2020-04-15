import java.util.*;
class Graph
{
    int v;
    int e;
    int a[][];
    public Graph(int v)
    {
        this.v = v;
        a = new int[v][v];
        for( int i = 0 ; i < v ; i++ )
        {
            for( int j = 0 ;  j < v ; j++ )
            {
                a[i][j] = 0;
            }
        }
    }
    public void addEdge(int s , int d )
    {
        a[s][d] = 1;
        e++;
    }
    public int total_edge()
    {
        return e;
    }
    public int total_vertices()
    {
        return v;
    }
    public int isConnected(int s , int d )

    {
        return a[s][d];
    }
    public void dfs(int s , int visited[],int cc[],int id)
    {
        visited[s] = 1;
        cc[s] = id;
        for(int i = 0 ; i < v ; i++)
        {
            if(a[s][i]==1 && visited[i]==0)
            dfs(i,visited,cc,id);
        }
    }
}
class Connected_Components
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v = sc.nextInt();                   //scan vertices
        Graph g = new Graph(v);
        System.out.println("Enter number of edges");
        int e = sc.nextInt();
        for(int i = 0 ; i< e; i++)
        {
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.addEdge(s, d);
        }
        int visited[] = new int[v];
        int cc[] = new int[v];                  // coonected componenets
        int cg = 0;                             // number of connected groups
        for(int i = 0 ; i < v ; i++)
        {
            visited[i] = 0;
        }
        for(int i = 0 ; i< v ; i++ )
        {
            if(visited[i]==0)
           {
               g.dfs(i,visited,cc,cg);
               cg++;
           }
        }
        for(int i = 0 ; i < cg ; i++)
        {
            System.out.println("Component "+(i+1) +":");
            for(int j = 0 ; j < v ; j++)
            {
                if(cc[j] == i)
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
        sc.close();
    }
}