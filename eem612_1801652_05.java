import java.util.*;
import java.io.File;
import java.io.FileNotFoundException; 
class eem612_1801652_05 
{ 
  static int max(int a, int b)  
  { 
    return (a > b) ? a : b; 
  } 

  static void printknapSack(int W, Integer[] wt, int val[], int n) 
  { 
    int i, w; 
    int result[] = new int[n+1];
    int K[][] = new int[n + 1][W + 1];  
    for (i = 0; i <= n; i++) 
    { 
      for (w = 0; w <= W; w++) 
      { 
        if (i == 0 || w == 0) 
          K[i][w] = 0; 
        else if (wt[i - 1] <= w) 
          K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]); 
        else
          K[i][w] = K[i - 1][w]; 
      } 
    } 
    int res = K[n][W]; 
    w = W; 
    for (i = n; i > 0 && res > 0; i--) 
    { 
      if (res == K[i - 1][w]) 
      {
        result[i]=0;
        continue;
      } 
      else 
      { 
        result[i]=1;
        res = res - val[i - 1]; 
        w = w - wt[i - 1]; 
      } 
    }
    for(i=1;i<result.length;i++)
    {
      System.out.println(result[i]);
    }
  } 
  public static void main(String args[]) throws FileNotFoundException 
  { 
    Scanner sc = new Scanner(System.in);
    int i=0,j=0;
    
    ArrayList<Integer> weight = new ArrayList<Integer>();
    System.out.println("Enter the name of the capacity file");
    String s_c = sc.next();
    File file_c = new File(s_c); 
    Scanner sc_c = new Scanner(file_c); 
    int capacity = sc_c.nextInt();

    System.out.println("Enter the name of the weights file");
    String s_w = sc.next();
    File file_w = new File(s_w); 
    Scanner sc_w = new Scanner(file_w);
    while(sc_w.hasNext())
    {
      weight.add(sc_w.nextInt());
    }
    Integer [] wt = new Integer[weight.size()];
    wt = weight.toArray(wt);

    
    int[] profit = new int[weight.size()];
    System.out.println("Enter the name of the profits file");
    String s_p = sc.next();
    File file_p = new File(s_p); 
    Scanner sc_p = new Scanner(file_p);
    while(sc_p.hasNext())
    {
      profit[j]=sc_p.nextInt();
      j++;
    }
    int n = profit.length; 
    printknapSack(capacity, wt, profit, n);
  } 
} 