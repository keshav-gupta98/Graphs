// Calculate Number of Islands formed by '1' in matrix of 0 & 1

class Result {
    public static void dfs(int v , boolean visited [], ArrayList<ArrayList<Integer>> arr)
    {
        visited[v] = true;
        for( int i = 0 ; i < arr.get(v).size() ; i++)
        {
            if(!visited[arr.get(v).get(i)])
            {
                dfs(arr.get(v).get(i),visited,arr);
            }
        }
    } 
    public static int countGroups(List<String> zombies) 
    {
        boolean visited[] = new boolean[zombies.size()];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int count = 0;
        for( int i = 0 ; i < zombies.size(); i++)
            arr.add( new ArrayList<Integer>());
        for(int i = 0 ; i < zombies.size();i++)
        {
            for(int j = 0 ; j < zombies.get(i).length();j++)
            {
                if(zombies.get(i).charAt(j)=='1')
                {
                    if(i!=j)
                    arr.get(i).add(j);
                }
            }
        }
        for(int i = 0 ; i  < zombies.size();i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,visited,arr);
            }
        }
        return count;
    }
}