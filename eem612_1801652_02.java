import java.util.*;
public class eem612_1801652_02 
{

	public static int cheat(int num) 
	{
		int x=num;
		int count=0;
		while(x!=1) 
		{
			if(x%2==0) 
			{
				count++;
				x=x/2;
			}
			else 
			{
				count++;
				x=3*x+1;
			}
		}
		if(count<=num)
			return count;
		else
			return num;
	}
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int x= sc.nextInt();		
		System.out.println(cheat(x));
	}

}
