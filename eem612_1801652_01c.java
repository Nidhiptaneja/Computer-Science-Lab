import java.util.*;

public class eem612_1801652_01c  
{
	public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] arr)
    {  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++)
            {  
                if (arr[j] < arr[index])
                {  
                    index = j;  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }
    public static void insertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) 
        { 
            int key = arr[i]; 
            int j = i - 1; 
  
            
            while (j >= 0 && arr[j] > key) 
            { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }

    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 

    public static void quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            
            int pi = partition(arr, low, high); 
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    } 


    public static void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    }
    public static void heapify(int arr[], int n, int i) 
    { 
        int largest = i;   
        int l = 2*i + 1;  
        int r = 2*i + 2;  
  
        
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
         
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
         
            heapify(arr, n, largest); 
        } 
    } 

    public static void merge(int arr[], int l, int m, int r)
    {
        
        int n1 = m - l + 1;
        int n2 = r - m;
 
       
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
       
        int i = 0, j = 0;
 
       
        int k = l;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            }
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) 
        {
            
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
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
        long t1 = System.nanoTime();
        bubbleSort(arr);
        long t2 = System.nanoTime();
        System.out.println("bubble sort time "+(t2-t1)+"ns");

        long t3 = System.nanoTime();
        selectionSort(arr);
        long t4 = System.nanoTime();
        System.out.println("Selection sort time "+(t4-t3)+"ns");

        long t5 = System.nanoTime();
        insertionSort(arr);
        long t6 = System.nanoTime();
        System.out.println("Insertion sort time "+(t6-t5)+"ns");

        long t7 = System.nanoTime();
        quickSort(arr,0,n-1);
        long t8 = System.nanoTime();
        System.out.println("Quick sort time "+(t8-t7)+"ns");


        long t9 = System.nanoTime();
        heapSort(arr);
        long t10 = System.nanoTime();
        System.out.println("Heap sort time "+(t10-t9)+"ns");

        long t11 = System.nanoTime();
        mergeSort(arr,0,n-1);
        long t12 = System.nanoTime();
        System.out.println("Merge sort time "+(t12-t11)+"ns");
    }
}
  
     
 