package com.shubham;

import java.util.Scanner;
class Schedule1{
	int pno;
	Scanner sc = new Scanner(System.in);
	void input()
	{
		   System.out.println("Enter Number of process");
		   pno = sc.nextInt();
	   
	   int at[]= new int[pno];
	   int bt[]= new int[pno];
	   int wt[]= new int[pno];
	   int tat[]=new int[pno];
	   int ct[]=new int[pno];

	   for(int i=0;i<pno;i++)
	   {
		   System.out.println("Enter Arrival of P"+i+"Process");
		   at[i]= sc.nextInt();
	   }
	   for(int i=0;i<pno;i++)
	   {
		   System.out.println("Enter Burst of P"+i+"Process");
		   bt[i]= sc.nextInt();
	   }
	   int complete=0;
	   int st=0;
	   int f[]=new int[pno];
	   while(true){
		   int pos=pno,min=999;
		   if(complete==pno)
			   	break;
		   for(int i=0;i<pno;i++){
			   if((at[i]<=st) && (f[i]==0) && (bt[i]<min)){
				   min=bt[i];
				   pos=i;
			   }
		   }
		   if(pos==pno)
			   st++;
		   else{
			   ct[pos]=st+bt[pos];
			   st+=bt[pos];
			   tat[pos]=ct[pos]-at[pos];
			   wt[pos]=tat[pos]-bt[pos];
			   complete++;
			   f[pos]=1;
			   
		   }
			   
		   
		   
	   }
	   System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
		for(int i=0;i<pno;i++){
			System.out.println("P:"+i+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
		}
		//float tavg=sumt/pno;
		//float wavg=sumw/pno;
	//	System.out.println("AVERAGE TURN AROUND TIME"+tavg);;
		//System.out.println("AVERAGE WT"+wavg);;
		
	   
	   
	   
	   
    }
	
	
}
public class SJF {
public static void main(String[] args) {
	
	Schedule1 s=new Schedule1();
	s.input();
}		
}
