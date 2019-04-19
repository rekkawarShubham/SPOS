import java.util.Scanner;

class Bank
{
	void input()
	{
		int n,r;
		Scanner sc=new Scanner(System.in);
		System.out.println("\n\t Enter number of process:");
		n=sc.nextInt();
		System.out.println("\n\tEnter the no of resources");
		r=sc.nextInt();
		int allocation[][]=new int[n][r];
		int max[][]=new int[n][r];
		int need[][]=new int[n][r];
		int available[]=new int[r];
		int i,j;
		
		for(i=0;i<n;i++)
		{
			System.out.println("Enter allocation: P"+i);
			for(j=0;j<r;j++)
			{
				allocation[i][j]=sc.nextInt();
			}
		}
		for(i=0;i<n;i++)
		{
			System.out.println("Enter max: P"+i);
			for(j=0;j<r;j++)
			{
				max[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter available: P"+i);
		for(j=0;j<r;j++)
		{
				available[j]=sc.nextInt();
		}
		
		for(i=0;i<n;i++)
		{
		
			for(j=0;j<r;j++)
			{
				need[i][j]=max[i][j]-allocation[i][j];
			}
		}
		
		System.out.println("Need matrix:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<r;j++)
			{
				System.out.print("\t"+need[i][j]);
			}
			System.out.println();
		}
		
		boolean finish[]=new boolean[r];
		
		for(int k=0;k<n;k++)
		{
			for(i=0;i<n;i++)
			{
				
				if(finish[i]==false)
				{
					int flag=0;
					for(j=0;j<r;j++)
					{
						if(need[i][j]>available[j])
						
							flag=1;
							break;							
							
						
					}					
				
				if(flag==0){
					System.out.println("P:"+i);
					
					for(int y=0;y<r;y++)
						available[y]+=allocation[i][y];
					finish[i]=true;
				}
		
			}
			}
			
		}
		
		System.out.println("Enter process id:");
		int p=sc.nextInt();
		System.out.println("Enter the request");
		int request[]=new int[r];
		for(i=0;i<r;i++)
		{
			request[i]=sc.nextInt();
		}
		int flag=0;
		for(i=0;i<r;i++)
		{
			if(request[i]>need[p][i])
			{
				flag=1;
				break;
			}
			if(request[i]>available[i]){
				flag=1;
				break;
			}
			
		}
		if(flag==0)
		{
			for(i=0;i<r;i++)
			{
				available[i]-=request[i];
				allocation[p][i]+=request[i];
				need[p][i]-=request[i];
			}
			
			
		}
		else
		{
			System.out.println("Request not granted");
		}
		
		System.out.println("Allocation:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<r;j++)
			{
				System.out.print("\t"+allocation[i][j]);
			}
			System.out.println();
		}
		System.out.println("Need:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<r;j++)
			{
				System.out.print("\t"+need[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
}

public class Bankers {

	public static void main(String[] args) {
		Bank b=new Bank();
		b.input();
		
	}
	
	
}
