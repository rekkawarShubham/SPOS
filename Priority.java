
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

class PriorityProcess implements Comparable<PriorityProcess>{

	String p_name;
	int bt,ct,tat,wt,priority;
	public PriorityProcess(String name) {		
		bt=0;
		ct=0;
		tat=0;
		wt=0;
		priority=0;
		p_name=name;
	}
	public int compareTo(PriorityProcess o) {
		if(this.priority>o.priority)
			return 1;
		else if(this.priority<o.priority)
			 return -1;
		else
			return 0;
	}	
}
public class Priority {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int n;
		System.out.println("\n\tEnter the process no:");
		n=sc.nextInt();
		PriorityProcess obj[]=new PriorityProcess[n];
		ArrayList<PriorityProcess> pqueue=new ArrayList<PriorityProcess>();
		for(int i=0;i<n;i++){
			obj[i]=new PriorityProcess("P:"+i);
			System.out.println("Enter the Priority:P"+i);
			obj[i].priority=sc.nextInt();
			System.out.println("Enter the Burst Time:P"+i);
			obj[i].bt=sc.nextInt();
			pqueue.add(obj[i]);
			
		}
		Collections.sort(pqueue);
		Priority f1=new Priority();
		f1.calculate(pqueue);
		Iterator<PriorityProcess> it=pqueue.iterator();
		while(it.hasNext()){
			PriorityProcess o=it.next();
			System.out.println(o.p_name+"\t"+o.priority+"\t"+o.bt+"\t"+o.tat+"\t"+o.wt);
			
		}
			
	}
	
	private void calculate(ArrayList<PriorityProcess> pqueue) {

		Iterator<PriorityProcess>it=pqueue.iterator();
		int wt=0,bt=0;
		while(it.hasNext()){
			PriorityProcess p=it.next();
			p.wt=wt+bt;
			p.tat=p.wt+p.bt;
			wt=p.wt;
			bt=p.bt;
		}
	}
	

}
