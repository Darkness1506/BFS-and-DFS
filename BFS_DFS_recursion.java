import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Scanner;

public class BFS_DFS_recursion
{
    static class Edge
    {
        int dest;
        Edge(int d)
        {
            dest=d;
        }
    }

    public static void dfs(int u, ArrayList<Edge>[] graph, boolean []vis)
    {
        vis[u]=true;
        System.out.print(u +" ");
        for(Edge e: graph[u])
        {
            if(!vis[e.dest])
            {
                dfs(e.dest, graph, vis);
            }
        }
    }

    public static void bfs(int start, ArrayList<Edge>[] graph, boolean  [] vis)
    {
        Queue<Integer> q= new LinkedList<>();
        vis[start]=true;
        q.add(start);
        bfsHelper(q, graph, vis);
    }

    public static void bfsHelper(Queue<Integer> q, ArrayList<Edge> [] graph, boolean [] vis)
    {
        if(q.isEmpty())
        {
            return;
        }
        int u=q.poll();
        System.out.print(u + " ");
        for(Edge e: graph[u])
        {
            if(!vis[e.dest])
            {
                vis[e.dest]=true;
                q.add(e.dest);
            }
        }
        bfsHelper(q, graph, vis);
    }

    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of vertices(V)=");
        int V=sc.nextInt();
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph= new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            graph[i]=new ArrayList<>();
        }
        System.out.println("Enter each edge(u,v)=");
        for(int i=0;i<E;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            graph[u].add(new Edge(v));
            graph[v].add(new Edge(u));
        }
        System.out.println("Enter the choice for bfs and dfs");
        System.out.print("1 for BFS and 2 for DFS: ");
        int ch=sc.nextInt();
        boolean [] vis= new boolean[V];
        switch(ch)
        {
            case 1:
                System.out.println("The BFS Traversal is ");
                for(int i=0;i<V;i++)
                {
                    if(!vis[i])
                    {
                        bfs(i, graph, vis);
                    }
                }
                break;

            case 2:
                System.out.println("The DFS Traversal is ");
                for(int i=0;i<V;i++)
                {
                    if(!vis[i])
                    {
                        dfs(i, graph, vis);
                    }
                }
                break;

            default:
                System.out.println("Invalid Choice Please Enter 1 or 2");
        }
        System.out.println();
        System.out.println("Thank You For Using Me");
        sc.close();
    }
}