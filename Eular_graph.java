import java.util.*;
class Graph
{
    int v;
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
    public void removeEdege(int s, int d)
    {
        a[s][d] = 0;
        a[d][s] = 0;
    }
    public void addEdge(int s , int d )
    {
        a[s][d] = 1;
        a[d][s] = 1;
    }
    public void Print_Path()
    {
        int u = 0;
        int count = 0;
        for(int i = 0 ; i < v; i++)
        {
            for(int j = 0 ; j < v ; j++)
            {
                if(a[i][j]==1)
                count++;
            }
            if(count%2==1)
            {
                u = i;
                break;
            }
        }
        Eularpath(u);
    }
    public void Eularpath(int u)
    {
        for(int i = 0 ; i< v ; i++)
        {
            if(a[u][i]==1 && isValidNextEdge(u,i))
            {
                System.out.print(u+"-"+i+" ");
                removeEdege(u, i);
                Eularpath(i);
            }
        }
    }
    public boolean isValidNextEdge(int u , int b )
    {
        int count = 0;
        for(int i = 0 ; i  < v ; i++)
        if(a[u][i]==1)
        count++;
        if(count==1)
        return true;
        boolean visited[] = new boolean[v];
        for(int i = 0 ; i < v ; i++)
        visited[i] = false;
        int count1 = DFSCount(u,visited);
        removeEdege(u, b);
        for(int i = 0 ; i < v ; i++)
        visited[i] = false;
        int count2 = DFSCount(u,visited);
        addEdge(u, b);
        if(count1>count2)
        return false;
        else return true;
    }
    public int DFSCount(int u , boolean visited[])
    {
        visited[u] = true;
        int count = 1;
        for( int i = 0 ; i< v; i++)
        {
            if(a[u][i]==1&&visited[i]==false)
            {
                count+=DFSCount(i, visited);
            }
        }
        return count;
    }
}
class Eular_graph
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(v);
        for(int i = 0 ; i < e ; i++ )
        {
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.addEdge(s, d);
        }
        g.Print_Path();
        sc.close();
    }
}