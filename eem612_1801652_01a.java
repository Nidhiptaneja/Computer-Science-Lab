import java.util.*;

public class eem612_1801652_01a  
{ 
    public static int linearsearch(int arr[], int x) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; i++)  
        { 
            if (arr[i] == x) 
                return i; 
        } 
        return -1; 
    } 
  
    public static int binarySearch(int arr[], int x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) 
        { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) 
                return m; 
            if (arr[m] < x) 
                l = m + 1; 
            else
                r = m - 1; 
        } 
        return -1; 
    } 
  
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        Random rand = new Random();
        for(int i = 0; i<arr.length; i++)
        {
            arr[i]= rand.nextInt(1000);
        }
        Arrays.sort(arr);
        
        int x = arr[n-1]; 
        long t1 = System.nanoTime();
        int result = linearsearch(arr, x);
        long t2 = System.nanoTime();
        System.out.println("linear search time"+(t2-t1)+"ms");
        
        long t3 = System.nanoTime();
        int result2 = binarySearch(arr, x);
        long t4 = System.nanoTime();
        System.out.println("Binary search time"+(t4-t3)+"ms");
        
        

        
    } 
}
