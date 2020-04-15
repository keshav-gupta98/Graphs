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
        e++;
    }
    public  void dfs(int v, int visited[])
    {
        visited[v] = 1;
        for(int i = 0 ; i < visited.length;i++)
        {
            if(a[v][i]==1 && visited[i]==0)
            dfs(i,visited);
        }
    }
    public void reverse()
    {
        boolean visited[][] = new boolean[v][v];
        for(int i = 0; i< v ; i++)
        {
            for(int j = 0 ; j < v ; j++ )
            {
                if(visited[i][j] == false && visited[j][i] == false)
                {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                    visited[i][j] = visited[j][i] = true;
                }
            }
        }
    }
    public void dfs(int u , Stack<Integer>s,boolean visited[])
    {
        visited[u] = true;
        for(int i = 0 ; i < v; i++)
        {
            if(a[u][i] == 1 && visited[i] == false)
            {
                dfs(i,s,visited);
            }
        }
        s.push(u);
    }
    public void components(int u , boolean visited[] , int scc[] , int id)
    {
        visited[u] = true;
        scc[u] = id;
        for(int i = 0 ; i < v ; i++)
        {
            if(visited[i] == false && a[u][i] == 1)
            {
                components(i, visited, scc, id);
            }
        }
    }
}
class Strongly_Connected_Components
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
        int scc[] = new int[ver];
        int id = 0;
        boolean visited[] = new boolean[ver];
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0 ; i< ver ; i++)
        {
            if(visited[i] == false)
            g.dfs(i,s,visited);
        }
        g.reverse();
        for(int i= 0 ; i < ver ; i++)
        visited[i] = false;
        while(!s.isEmpty())
        {
            int u = s.peek();
            if(visited[u]== false)
            {
                g.components(u,visited,scc,id);
                id++;
            }
            s.pop();
        }
        for(int i = 0 ; i < id ; i++)
        {
            System.out.print("Strongly Connected Component "+(i+1)+": ");
            for(int j = 0 ; j < ver ; j++)
            {
                if(scc[j]==i)
                {
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
        sc.close();   
    }
}