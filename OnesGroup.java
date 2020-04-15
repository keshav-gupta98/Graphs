//In a given matrix find the number of islands found by '1' and tell the size of those islands.
//zombies is the matrix in the form of List<List<Integer>> 
// queries contain the sizes of islands
// return 0 if no island of that size exist in matrix else return the number of islands of that size that exist in matrix
class Result {
    static int count = 0;
    static int start = 0;
    public static boolean check(ArrayList<ArrayList<Boolean>> visited, int row ,
    int col,List<List<Integer>> zombies)
    {
        return row>=0&&row<visited.size()&&col>=0&&col<visited.size()&&zombies.get(row).get(col)==1&&visited.get(row).get(col)==false;
    }
    public static void dfs(ArrayList<ArrayList<Boolean>> visited,
    List<List<Integer>> zombies , int i , int j)
    {
        visited.get(i).set(j,true);
        int row[] = {-1,0,0,1};
        int col[] = {0,-1,1,0};
        for( int x = 0 ; x < 4 ; x++ )
        {
            if(check(visited,i + row[x],j + col[x],zombies)==true)
            {
                dfs(visited,zombies, i+row[x],j + col[x]);
                count++;
            }
        }
    }
    public static List<Integer> onesGroups(List<List<Integer>> zombies, List<Integer> queries)    {
        ArrayList<ArrayList<Boolean>> visited = new ArrayList();
        for(int i = 0 ; i  < zombies.size();i++)     // initializing visited with false
        {
            ArrayList<Boolean> a = new ArrayList<Boolean>();
            for( int j = 0 ; j < zombies.size() ; j++)
            {
                a.add(false);
            }
            visited.add(a);
        }
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();   // will contain number of islands of each size
        for(int i = 0 ; i < zombies.size() ; i++)
        {
            for( int j = 0 ; j < zombies.size() ; j++ )
            {
                if(zombies.get(i).get(j) ==1 && visited.get(i).get(j) == false)
                {
                    dfs(visited,zombies,i,j);
                    count = count + 1;
                    int key = count - start;
                    System.out.println(key);
                    int val;
                    if(m.get(key)==null)                                    // if size is not present
                    {
                        val = 1;
                    }
                    else                                                    // if size is present
                    {
                        val = m.get(key)+1;
                    }
                    m.put(key,val);
                    start = count;
                }
            }
        }
        List<Integer> res = new LinkedList<Integer>();
        for(int i = 0 ; i < queries.size() ; i++)
        {
            if(m.get(queries.get(i))==null)                 // if no island with given size exists                                
            {
                res.add(0);
            }
            else
            {
                res.add(m.get(queries.get(i)));
            }
        }
        return res;   
    }
}