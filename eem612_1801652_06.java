import java.io.BufferedReader;

import java.io.FileInputStream;

import java.io.FileReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.util.Scanner;

import java.util.Arrays;

public class eem612_1801652_06
{
	public static void main(String args[]) throws Exception
	{
		String file = "C:"; 
	    Scanner sc =new Scanner(new FileReader(file));
        String[] line = sc.nextLine().trim().split(" ");
        line = sc.nextLine().trim().split(" ");
        int num=Integer.parseInt(line[0]);
        int[][] profit = new int[num+1][num+1];
        line = sc.nextLine().trim().split("\\s+");
        int kc=0;
        for(int i=1;i<=num;i++)
        {
			profit[i][i]=Integer.parseInt(line[kc]);
			kc++;
     	}
        
		int c=0;
		for(int i=1;i<=num;i++)
		{
			c=0;
			line = sc.nextLine().trim().split("\\s+");
			for(int j=i+1;j<=num;j++)
			{
				profit[i][j]=Integer.parseInt(line[c]);
        		c++;
			}
        }
        line = sc.nextLine().trim().split(" ");
        int capacity=Integer.parseInt((sc.nextLine().trim().split(" \\s+"))[0]);
        int[] weight = new int[num+1];
        line = sc.nextLine().trim().split("\\s+");
        c=0;
        for(int i=1;i<=num;i++)
        {
			weight[i]=Integer.parseInt(line[c]); 
        	c++;
        }
        
		int prof_best=0;
        int[] kp=new int[num+1];
        double[] d=new double[num+1];
        int w=0;
        int sum=0; 
        int[] kp_opt=new int[num+1];
        int prof_opt=0;
         
        for(int i=1;i<=num;i++)
        {
			prof_best=0;
			w=0;
			for(int l=1;l<=num;l++)
				kp[l]=0;
			kp[i]=1;
			prof_best=prof_best+profit[i][i];
			w=w+weight[i];
			
			while(w<=capacity)
			{
				for(int m=1;m<=num;m++)
					d[m]=0.0;
				
				for(int j=1;j<=num;j++) 
				{
					if(kp[j]==0)
					{
						sum=0;
						for(int k=1;k<j;k++)
							if(kp[k]==1)
							{
								sum=sum+profit[k][j];
							}
							for(int k=j;k<=num;k++)
								if(kp[k]==1)
								{
									sum=sum+profit[j][k];
								}
								d[j]=(double)(sum+profit[j][j])/weight[j];
							}
						}
						int max_m=0;
						double max=0;
						for(int m=1;m<=num;m++)
						{
							if((d[m]>max)) 
							{
								max=d[m];
								max_m=m;
							}
						}
						w=w+weight[max_m];
						if(w>capacity)
							break;
						
						kp[max_m]=1;
						prof_best=prof_best+(int)(max*weight[max_m]);
					}
					if(prof_best>=prof_opt)
					{
						prof_opt=prof_best;
						for(int s=1;s<=num;s++)
						{
							kp_opt[s]=kp[s];
						}
					}
				}
				sum=0;
				System.out.println("Max profit="+prof_opt);
				System.out.print("knapsack contains: ");
				for(int g=1;g<=num;g++)
				{
					sum=sum+kp[g]*weight[g];
					System.out.print(kp[g]+" ");
				}
				System.out.println();
				System.out.println("weight for max profit="+sum);
        	}
        }