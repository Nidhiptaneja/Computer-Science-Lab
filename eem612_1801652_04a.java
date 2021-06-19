import java.io.FileNotFoundException;
import java.util.Scanner;

public class eem612_1801652_04a 
{
    static int count = 0;
    static int nov;
    static float mstdistance = 0;
        
    public static void main(String s[]) throws FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
       
        runPrim(build_graph(sc));
         System.out.printf("%.4f",mstdistance);
    }
    
    public static float[][] build_graph(Scanner sc) throws FileNotFoundException 
    {
    	 sc.useDelimiter("[ , : ; \n]");
         String tmp = sc.next().trim();
         nov = Integer.parseInt(tmp);
         
         float [][] distances = new float[nov+1][nov+1];
         float [][] nodes = new float[nov+1][2];
         
         input(sc,distances,nodes);
        return distances;
        
         
    }
    
    public static void input(Scanner sc,float [][]distances, float [][]nodes)throws FileNotFoundException
    {
        String tmp;
        int k = 0;
                
        while(sc.hasNext())
        {
            tmp = sc.next().trim();
            if( tmp.equals("") || tmp.equals("\r") || tmp.equals(".") || tmp.equals(",")) {}
                else
                {
                    Float value = Float.parseFloat(tmp);
                    if(k==0)
                    {
                        nodes[count][0] = value;
                        k=1;
                    }    
                    else
                    {                    
                        nodes[count][1]=value;
                        k=0;
                        count++;
                    }
                }
        }
        finddistances(sc,nodes,distances);
    }
    
    public static void finddistances(Scanner sc, float[][]nodes, float[][]distances)
    {
        float dist;
        for(int i=0;i<nov-1;i++)
		{
			for(int j=i+1;j<nov;j++)
			{
				dist = (float)Math.sqrt((Math.pow((nodes[i][0]-nodes[j][0]),2) + Math.pow((nodes[i][1]-nodes[j][1]),2)));
				distances[i][j] = distances[j][i] =  dist;
			}
		}
    }
    
    public static void runPrim(float distances[][])
    {
        int parent[] = new int[nov];
        float key[] = new float [nov];
        Boolean includedvertices[] = new Boolean[nov];
   
        for (int i = 0; i < nov; i++)
        {
			{
				key[i] = Float.MAX_VALUE;
				includedvertices[i] = false;
            }
            
        }
 
        key[0] = 0;
        parent[0] = -1; 
 
        for (int i = 0; i < nov-1; i++)
        {
            int m = minKey(key,includedvertices);
            includedvertices[m] = true;

            for (int j = 0; j < nov; j++)
                if (distances[m][j]!=0 && includedvertices[j] == false && distances[m][j] <  key[j])
                {
                    parent[j]  = m;
                    key[j] = distances[m][j];
                }
        }
        printMST(parent,distances);
    }
    
    public static int minKey(float key[], Boolean includedvertex[])
    {
        float min = Float.MAX_VALUE;
        int min_index=-1;
 
        for (int i = 0; i < nov; i++)
            if (includedvertex[i] == false && key[i] <= min)
            {
                min = key[i];
                min_index = i;
            }
 
        return min_index;
    }
    
    public static void printMST(int parent[],float distances[][])
    {
        for (int i = 1; i < nov; i++)
        {
            mstdistance += distances[i][parent[i]];
           
        }
    }
}
