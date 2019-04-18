import java.io.*;
import java.util.ArrayList;

class Assembler1{
	
	void input() throws Exception{
	BufferedReader br=new BufferedReader(new FileReader("passone.txt"));
	BufferedReader sbr=new BufferedReader(new FileReader("symtab.txt"));
	BufferedReader lbr=new BufferedReader(new FileReader("littab.txt"));
	BufferedWriter wr=new BufferedWriter(new FileWriter("passtwo.txt"));
	ArrayList<String> symtab=new ArrayList<String>();
	ArrayList<String> symaddr=new ArrayList<String>();
	ArrayList<String> littab=new ArrayList<String>();
	ArrayList<String> litaddr=new ArrayList<String>();
	
	String line;
	while((line=sbr.readLine())!=null){
		String arr[]=line.split("\\s+");
		symtab.add(arr[0]);
		symaddr.add(arr[1]);
	}
	while((line=lbr.readLine())!=null){
		String arr[]=line.split("\\s+");
		littab.add(arr[0]);
		litaddr.add(arr[1]);
	}
	while((line=br.readLine())!=null){
		String arr[]=line.split("\\s+");
		if(arr.length>1)
		{
			if(arr[1].contains("IS"))
			{
				String res[]=arr[1].split(",");
				wr.write("\n"+arr[0]+ " + (" +res[1]);
				
				if(arr.length>3 && arr[3] !=null)
				{
					wr.write(arr[2]);
					if(arr[3].contains("S"))
					{
						String f[]=arr[3].split(",");
						String str=f[1].replace(")","");
						int index=Integer.parseInt(str);
						wr.write("  "+symaddr.get(index));
						
					}
					else{

						String f[]=arr[3].split(",");
						String str=f[1].replace(")","");
						int index=Integer.parseInt(str);
						wr.write("  "+litaddr.get(index));
						
					}
				}
				else
				{
					wr.write("(0)");
					if(arr[2].contains("S"))
					{
				
						String f[]=arr[2].split(",");
						String str=f[1].replace(")","");
				
						int index=Integer.parseInt(str);
						wr.write("  "+symaddr.get(index));
						
					}
					else{

						String f[]=arr[2].split(",");
						String str=f[1].replace(")","");
						int index=Integer.parseInt(str);
						wr.write("  "+litaddr.get(index));
						
					}

				}
			}
			else{
				//it is DL
				String f[]=arr[1].split(",");
				if(f[1].contains("01"))
				{
					//DC
					String d[]=arr[2].split(",");
					wr.write("\n"+arr[0]+" + 00  0 ("+d[1]);
				}
				else{
					//DS
					String m[]=arr[2].split(",");
					String m1=m[1].replace(")","");
					
					int n=Integer.parseInt(m1);
					int a=Integer.parseInt(arr[0]);
					
					for(int i=0;i<n;i++){
						wr.write("\n"+String.valueOf(a));
						a=a+1;
					}
				}
				
			}
		}
	}
	wr.close();
	
	}
}
public class PassTwo {
 public static void main(String[] args) throws Exception {
	Assembler1 a=new Assembler1();
	a.input();
	
}
}
