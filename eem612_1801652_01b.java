import java.util.*;

public class eem612_1801652_01b  
{
	static void multiply(int[][] A, int[][] B, int[][] R) 
    {
    	int N = A.length; 
    	for(int i = 0;i<N;i++)
    	{
    		for(int j=0;j<N;j++)
    		{
    			R[i][j] = 0;
    			for(int k=0;k<N;k++)
    			{
    				R[i][j] += A[i][k] * B[k][j];
    			}
    		}
        }
    }

    public static void fill(int[][] A, int N) 
    {
    	Random rand = new Random();
    	for(int i = 0;i<N;i++)
    	{
    		for(int j=0;j<N;j++)
    		{
    			A[i][j]=rand.nextInt(101); 
    		}
    	}
    }
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int N = sc.nextInt();
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        int[][] R = new int[N][N];
        fill(A,N); 
        fill(B,N);
        long t1 = System.nanoTime();    
        multiply(A,B,R);
        long t2 = System.nanoTime();
        System.out.println("time taken for multiplication "+(t2-t1)+"ns");
    }
}

 