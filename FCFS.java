import java.util.Scanner;


class Schedule{
	void input(){
	int pno;
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter no. of process");
	pno = sc.nextInt();
	
	int at[] = new int[pno];
	int bt[] = new int[pno];
	int ct[] = new int[pno];
	int tat[] = new int[pno];
	int wt[] = new int[pno];
		
	for(int i=0;i<pno;i++)
	{
		System.out.println("Enter Arrival time for P:"+i);
		at[i] = sc.nextInt();
	}
	
	for(int i=0;i<pno;i++)
	{
		System.out.println("Enter burst time for P:"+i);
		bt[i] = sc.nextInt();
	}
	ct[0] = bt[0];
	
	for(int i=1;i<pno;i++){
		ct[i] = ct[i-1]+bt[i]; 
	}
	int sumw=0;
	int sumt=0;
	
	for(int i=0;i<pno;i++){
		tat[i] = ct[i]-at[i];
		sumt+=tat[i];
	}
	
	for(int i=0;i<pno;i++){
		wt[i] =tat[i]-bt[i];
		sumw+=wt[i];
	}
	
	float avgt = sumt/pno;
	float avgw = sumw/pno;
	
	System.out.println("\tPID\tAT\tBT\tCT\tTAT\tWT");
	
	for(int i=0;i<pno;i++)
	{
		System.out.println("\tP"+i+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
	}
	
	System.out.println("Avergae Waiting time:"+avgw);
	System.out.println("Avergae turn around time :"+avgt);
	}
}

public class FCFS {
public static void main(String[] args) {
	Schedule s = new Schedule();
	s.input();
}
}
