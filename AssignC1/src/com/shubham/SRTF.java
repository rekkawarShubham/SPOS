package com.shubham;

import java.util.Scanner;

class Schedule3{
	int pno;
	Scanner sc = new Scanner(System.in);
	void input(){
		System.out.println("Enter No of process");
		pno = sc.nextInt();
		
		int at[]= new int[pno];
		int bt[]= new int[pno];
		int ct[]= new int[pno];
		int tat[]= new int[pno];
		int wt[]= new int[pno];

		for(int i=0;i<pno;i++){
			System.out.println("Enter the Arrival time for P"+i);
            at[i]=sc.nextInt();
		}
		
		for(int i=0;i<pno;i++){
			System.out.println("Enter the Burst time for P"+i);
            bt[i]=sc.nextInt();
		}
		int k[]=new int[pno];
		for(int i=0;i<pno;i++){
			k[i]=bt[i];
		}
		
		int complete=0;
		int st=0;
		int f[] = new int[pno];
		while(true){
			int min=999,pos=pno;
			if(complete==pno)
				break;
			for(int i=0;i<pno;i++)
			{
				if( (at[i]<=st) && (f[i]==0) && (bt[i]<min))
				{
					min = bt[i];
				    pos = i;   
				}
			}
			
			if(pos==pno)
				st++;
			
			else{
				bt[pos]--;
				st++;
				if(bt[pos]==0)
				{
					ct[pos]=st;
					complete++;
					f[pos]=1;
					
				}
				
			}
			
		}
		
		for(int i=0;i<pno;i++){
			tat[i]=ct[i]-at[i];
			wt[i]=tat[i]-k[i];
		}
		System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
		for(int i=0;i<pno;i++){
			System.out.println("P:"+i+"\t"+at[i]+"\t"+k[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
		}
		
	}
}

public class SRTF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Schedule3 s=new Schedule3();
		s.input();
	}

}
