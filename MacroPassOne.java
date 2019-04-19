import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

class MacroPass{
	HashMap<String, String> is=new HashMap<String, String>();
	ArrayList<String> pntab=new ArrayList<String>();
	void data()
	{
		is.put("STOP","00");
		is.put("ADD","01");
		is.put("SUB","02");
		is.put("MULT","03");
		is.put("MOVER","04");
		is.put("MOVEM","05");
		is.put("COM","06");
		is.put("DIV","07");
		is.put("BC","08");
		is.put("READ","09");
		is.put("PRINT","10");
	}
	void input() throws Exception{
		
		BufferedReader br = new  BufferedReader(new FileReader("input.txt"));
		BufferedWriter pnt = new BufferedWriter(new FileWriter("pntab.txt"));
		BufferedWriter mdt = new BufferedWriter(new FileWriter("mdt.txt"));
		BufferedWriter mnt = new BufferedWriter(new FileWriter("mnt.txt"));
		BufferedWriter kpt = new BufferedWriter(new FileWriter("kptab.txt"));
		BufferedWriter im = new BufferedWriter(new FileWriter("immediate.txt"));
		String line;
		String mname;
		int kpdtp=101,mdtp=1,startkp=101;
		while((line=br.readLine())!=null)
		{
			String arr[]=line.split("\\s+");
			if(arr[0].equals("MACRO"))
			{
				pntab.clear();
				int pp=0,kp=0;
				line=br.readLine();
				String res[]=line.split("\\s+");
				mname=res[0];
				String r[]=res[1].split(",");
				for(int i=0;i<r.length;i++)
				{
					if(r[i].contains("=")){
						kp++;
						kpt.write("\n"+kpdtp+"  "+r[i]);
						kpdtp++;
						String f[]=r[i].split("=");
						pnt.write("\n"+f[0]);
						pntab.add(f[0]);
						
					}
					else{
						pp++;
						pntab.add(r[i]);
						pnt.write("\n"+r[i]);
					}
				}
				mnt.write("\n"+mname+"\t"+pp+"\t"+kp+"\t"+startkp+"\t"+mdtp);
				startkp=kpdtp;
				
			}
			else if(arr[0].equals("MEND"))
			{
				mdt.write("\n"+mdtp+"MEND");
				mdtp++;
			}
			else if(is.containsKey(arr[0])){
				mdt.write("\n"+mdtp+"  "+arr[0]);
				String str=arr[1].replace(",","");
				mdt.write("(P,"+pntab.indexOf(str)+")");
				String str2=arr[2].replace(",","");
				mdt.write("(P,"+pntab.indexOf(str2)+")");
				mdtp++;
			}
			else{
				im.write("\n"+line);
			}
		}
		System.out.println(pntab);
		pnt.close();
		mdt.close();
		mnt.close();
		kpt.close();
		im.close();
	}
}
public class MacroPassOne {
	public static void main(String[] args) throws Exception {
	    	MacroPass m=  new MacroPass();
    	   m.data();
	    	m.input();
	}
}
