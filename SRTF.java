import java.util.Scanner;



class Schedule2{

	void input(){
		int pno;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter1 no of processess");
		
		pno = sc.nextInt();	
		int at[] = new int[pno];
		int bt[] = new int[pno];
		int ct[] = new int[pno];
		int tat[] = new int[pno];
		int wt[] = new int[pno];
		int k[] = new int[pno];
		
		for(int i=0;i<pno;i++){
			System.out.println("Enter Arrival time for P:"+i);
			at[i]= sc.nextInt();
		}

		for(int i=0;i<pno;i++){
			System.out.println("Enter bursst time for P:"+i);
			bt[i]= sc.nextInt();
		}
		
		for(int i=0;i<pno;i++){
			k[i] = bt[i];
		}
		
		
		int complete = 0;
		int st=0;
		int f[] = new int[pno];
		while(true){
			int pos=pno,min=999;
			if(complete == pno)
				break;
			for(int i=0;i<pno;i++){
			     if((at[i]<=st) && (f[i]==0) && (bt[i]<min)){
			    	    min =bt[i];
			    	    pos =i;
			     }
			}
			if(pos==pno)
				st++;
			else{
				bt[pos]--;
				st++;
				if(bt[pos]==0)
				{
					ct[pos] = st;
					f[pos] =1;
					complete++;
				}
			}
		}
		
		for(int i=0;i<pno;i++){
			tat[i] = ct[i] - at[i];	
		}
		for(int i=0;i<pno;i++){
			wt[i] = tat[i] - k[i];	
		}
		
      System.out.println("\tPID\tAT\tBT\tCT\tTAT\tWT");
		
		for(int i=0;i<pno;i++)
		{
			System.out.println("\tP"+i+"\t"+at[i]+"\t"+k[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
		}
		
		
	}
}


public class SRTF {

	public static void main(String[] args) {
		Schedule2 s = new Schedule2();
		s.input();
	}
}
