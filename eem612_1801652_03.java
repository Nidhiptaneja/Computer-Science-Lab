import java.util.*; 
 
import java.io.*; 
  
class eem612_1801652_03
{ 
    
     static int ROW, COL; 
  
    
    boolean includeinDFS(int M[][], int row, int col, boolean visited[][]) 
    { 
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]); 
    } 
  
    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 8 neighbors as adjacent vertices 
    void DFS(int M[][], int row, int col, boolean visited[][]) 
    { 
        // These arrays are used to get row and column numbers 
        // of 8 neighbors of a given cell 
        int rowNumber[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
        int columnNumber[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
  
        visited[row][col] = true; 
  
         
        for (int k = 0; k < 8; ++k) 
            if (includeinDFS(M, row + rowNumber[k], col + columnNumber[k], visited))
            { 
                DFS(M, row + rowNumber[k], col + columnNumber[k], visited);
            } 
    } 
  
    
    int countFrumpies(int M[][]) 
    { 
        
        boolean visited[][] = new boolean[ROW][COL]; 
  
        int count = 0; 
        for (int i = 0; i < ROW; ++i) 
            for (int j = 0; j < COL; ++j) 
                if (M[i][j] == 1 && !visited[i][j]) 
                { 
                    DFS(M, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    } 
  
    
    public static void main(String[] args) throws java.lang.Exception 
    { 
        Scanner sc= new Scanner(System.in);
        
        ROW = sc.nextInt();
        COL = sc.nextInt();

        

        int M[][] = new int[ROW][COL]; 
        for (int i=0; i<M.length; i++) 
        {
            for (int j=0; j<M[0].length; j++) 
            {
                M[i][j] = sc.nextInt();
            }
        }
       
        eem612_1801652_03 I = new eem612_1801652_03(); 
        System.out.println(I.countFrumpies(M)); 
    } 
} 
  
