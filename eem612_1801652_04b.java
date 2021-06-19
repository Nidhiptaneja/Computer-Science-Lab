import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class eem612_1801652_04b 
{
    static int INF = Integer.MAX_VALUE; 
    
    static double distance(double x1, double y1,double x2,double y2) 
    { 
       double distance =Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) * 1.0);
       return  distance;
    }
  
    static int find(int i,int[] parent) 
    { 
        while (parent[i] != i)
        { 
            i = parent[i];
        } 
        return i; 
    } 
      
    static void union1(int i, int j, int[] parent) 
    { 
        int a = find(i,parent); 
        int b = find(j,parent); 
        parent[a] = b; 
    } 
      
    static void kruskalMST(double cost[][],int V,int[] parent) 
    { 
        double mincost = 0; 
       
        for (int i = 0; i < V; i++)
        { 
            parent[i] = i; 
        }
      
        int edge_count = 0; 
        while (edge_count < V - 1) 
        { 
            double min = INF;int a = -1, b = -1; 
            for (int i = 0; i < V; i++) 
            { 
                for (int j = 0; j < V; j++)  
                { 
                    if (find(i,parent) != find(j,parent) && cost[i][j] < min)  
                    { 
                        min = cost[i][j]; 
                        a = i; 
                        b = j; 
                    } 
                } 
            } 
      
            union1(a, b,parent); 
            edge_count++;
            mincost += min; 
            
        } 
        System.out.printf("%4f", mincost); 
    } 

    public static double[][] build_graph( Scanner sc,int vertices)
    {
    
        
        
        double co_ordinates[][]= new double[vertices][2];
        double distances[][]= new double[vertices][vertices];
        
        for(int i=0;i<vertices;i++) 
        {
            for(int j=0;j<2;j++)
            { 
                co_ordinates[i][j]=sc.nextDouble();
            }
        }
        
        for(int i=0;i<vertices;i++) 
        {
            for(int j=0;j<vertices;j++) 
            {
                if(i==j)
                distances[i][j]=0;
                else
                distances[i][j]=distance(co_ordinates[i][0],
                                        co_ordinates[i][1],
                                        co_ordinates[j][0],
                                        co_ordinates[j][1]);    
                                        
            }
        }
        return distances;
    
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        Scanner sc= new Scanner(System.in);
        int vertices = sc.nextInt();
        
        int[] parent = new int[vertices];
        
        kruskalMST(build_graph(sc,vertices),vertices,parent);
    
    }
    

}
