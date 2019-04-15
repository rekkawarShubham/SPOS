package com.shubham;

import java.util.ArrayList;
import java.util.Scanner;

class Process
{
	String p_name;
	int bt,wt,tat,remaining_time;
	public Process(String name) {
		// TODO Auto-generated constructor stub
		bt=0;
		wt=0;
		tat=0;
		remaining_time=0;
		p_name=name;
	}
	
}

public class RoundRobin {

	
	public static void main(String[] args) {
		int time_slice;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of process:");		
		int n=sc.nextInt();
		Process obj[]=new Process[n];
		
		
		System.out.println("Enter the time quantum");
		time_slice=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			obj[i]=new Process("P:"+i);
			System.out.println("Enter the burst time:");
			obj[i].bt=sc.nextInt();
			obj[i].remaining_time=obj[i].bt;
		}
		RoundRobin f1=new RoundRobin();
		f1.calculate(n,obj,time_slice);
		f1.print(n,obj);
		
	}

	private void print(int n, Process[] obj) {
		System.out.println("PId\tBT\tTAT\tWT");
		for(int i=0;i<n;i++)
		{
			System.out.println(obj[i].p_name+"\t"+obj[i].bt+"\t"+obj[i].tat+"\t"+obj[i].wt);
		}
	}

	private void calculate(int n, Process[] obj, int time_slice) {

		boolean done;
		int t=0;
		while(true){
			done=true;
			for(int i=0;i<n;i++){
					if(obj[i].remaining_time>0)
					{
						done=false;
						if(obj[i].remaining_time>time_slice)
						{
							t+=time_slice;
							obj[i].remaining_time-=time_slice;
						}
						else
						{
							t+=obj[i].remaining_time;
							obj[i].wt=t-obj[i].bt;
							obj[i].remaining_time=0;
						}
					}
				
			}
			
			if(done)
			{
				break;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			obj[i].tat=obj[i].wt+obj[i].bt;
		}
		
	}

}
