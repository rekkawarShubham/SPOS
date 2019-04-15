package com.shubham;
import java.util.*;

class Schedule{
	
	int pno;
	Scanner sc=new Scanner(System.in);
	void input(){
		System.out.println("Enter the number of process");
		pno=sc.nextInt();
		int at[]=new int[pno];
		int wt[]=new int[pno];
		int bt[]=new int[pno];
		int tat[]=new int[pno];
		int ct[]=new int[pno];
		for(int i=0;i<pno;i++){
			System.out.println("\n\tEnter the arrival time: P "+i);
			at[i]=sc.nextInt();
			
		}
		for(int i=0;i<pno;i++){
			System.out.println("\n\tEnter the burst time: P "+i);
			bt[i]=sc.nextInt();
			
		}
		ct[0]=bt[0];
		for(int i=1;i<pno;i++){
			
			ct[i]=ct[i-1]+bt[i];
		}
		int sumt=0,sumw=0;
		for(int i=0;i<pno;i++){
			tat[i]=ct[i]-at[i];
			sumt+=tat[i];
		}
		for(int i=0;i<pno;i++){
			wt[i]=tat[i]-bt[i];
			sumw+=wt[i];
		}
		System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
		for(int i=0;i<pno;i++){
			System.out.println("P:"+i+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
		}
		float tavg=sumt/pno;
		float wavg=sumw/pno;
		System.out.println("AVERAGE TURN AROUND TIME"+tavg);;
		System.out.println("AVERAGE WT"+wavg);;
		
	}
	
	
}
public class FCFS {
public static void main(String[] args) {
	Schedule s=new Schedule();
	s.input();
	
	
}
	
}

