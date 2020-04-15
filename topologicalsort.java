import java.util.*;
public class topologicalsort{
    static Stack<Integer> st=new Stack<>();
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<LinkedList<Integer>> arr=new LinkedList<>();
		boolean mark[]=new boolean[n];

		for(int i = 0 ; i< n ; i++)
		{
		    int n1=sc.nextInt();
		    LinkedList<Integer> ls=new LinkedList<>();
			for(int j=0;j<n1;j++)
			{
		        int n2=sc.nextInt();
		        ls.add(n2);
		    }
		    arr.add(ls);
		}
		for(int i = 0 ; i< arr.size() ; i++)
		System.out.println(arr.get(i));
		for(int i=0;i<n;i++)
		{
			if(!mark[i])
			{
		        dfs(i,arr,mark);
		    }
		}
		while(!st.isEmpty())
		{
		    System.out.print(st.pop()+" ");
		}
		sc.close();
	}
	public static void dfs(int i,LinkedList<LinkedList<Integer>> arr,boolean[] mark)
	{
	    mark[i]=true;
		for(int k:arr.get(i))
		{
			if(!mark[k])
			{
	            dfs(k,arr,mark);
	        }
	    }
	    st.push(i);
	}
}