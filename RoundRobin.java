import java.util.Scanner;



class Process {
	int wt,bt,tat,remain;
	String name;
	
	public Process(String name){
		wt=0;
		bt=0;
		tat=0;
		remain=0;
		this.name =name;
	}
	
}
public class RoundRobin{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int pno,time_slice;
		System.out.println("Enter no. of processes");
		pno = sc.nextInt();
		
		System.out.println("Enter time quantum");
		time_slice = sc.nextInt();
		
		Process obj[] = new Process[pno];
		for(int i=0;i<pno;i++)
		{
			obj[i] = new Process("P"+i);
			System.out.println("Enter burst for P:"+i);
			obj[i].bt = sc.nextInt();
			obj[i].remain = obj[i].bt;
		}
		
		RoundRobin r = new RoundRobin();
		r.calc(pno,obj,time_slice);
		r.print(pno,obj);
		
	}

	private void print(int pno, Process[] obj) {
		
		System.out.println("PID\tBT\tTAT\tWT\t");
		for(int i=0;i<pno;i++)
		{
			System.out.println(obj[i].name+"\t"+obj[i].bt+"\t"+obj[i].tat+"\t"+obj[i].wt);
		}
	}

	private void calc(int pno, Process[] obj, int time_slice) {

		boolean done;
		int t=0;
		while(true){
			done=true;
			
			for(int i=0;i<pno;i++)
			{
				if(obj[i].remain > 0)
				{
					done=false;
					if(obj[i].remain>time_slice){ 
						t+= time_slice;
						obj[i].remain-=time_slice;
					}
					else{
						t+=obj[i].remain;
						obj[i].wt = t - obj[i].bt;
						obj[i].remain = 0;
					}
				}
			}
			
			if(done)
				break;
		}

		for(int i=0;i<pno;i++)
		{
			obj[i].tat = obj[i].wt + obj[i].bt;
		}
	}

}
