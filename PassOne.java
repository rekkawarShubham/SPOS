import java.io.*;
import java.util.*;
class Assembler
{
	BufferedReader br;
	BufferedWriter swr,wr,lwr,pwr;
	HashMap<String, String> is=new HashMap<String, String>();
	ArrayList<String> symtab=new ArrayList<String>();
	ArrayList<Integer> symaddr=new ArrayList<Integer>();
	ArrayList<String> littab=new ArrayList<String>();
	ArrayList<Integer> litaddr=new ArrayList<Integer>();
	ArrayList<Integer> pooltab=new ArrayList<Integer>();
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
	void input() throws IOException
	{
		
		
		wr=new BufferedWriter(new FileWriter("output.txt"));
		swr=new BufferedWriter(new FileWriter("symtab.txt"));
		lwr=new BufferedWriter(new FileWriter("littab.txt"));
		pwr=new BufferedWriter(new FileWriter("pooltab.txt"));
		br=new BufferedReader(new FileReader("input.txt"));
		String line;
		int lc=0;
		pooltab.add(0);
		while((line=br.readLine())!=null){
			String arr[]=line.split("\\s+");
			if(arr[0].length()>0){
				
				if(!symtab.contains(arr[0])){
					symtab.add(arr[0]);
					symaddr.add(lc);
				}
				else{
					int index=symtab.indexOf(arr[0]);
					symaddr.remove(index);
					symaddr.add(index,lc);
					
				}
			}
			if(arr[1].equals("START")){
				lc=Integer.parseInt(arr[2]);
				wr.write("\n(AD,01)(C,"+arr[2]+")");
			}
			if(arr[1].equals("ORIGIN")){
				if(arr[2].contains("+") || arr[2].contains("-")){
					lc=getAddress(arr[2]);
					
				}
				else
				{
					lc=symaddr.get(symtab.indexOf(arr[2]));
				}
				
			}
			if(arr[1].equals("EQU")){
				int addr=symaddr.get(symtab.indexOf(arr[2]));
				if(!symtab.contains(arr[0])){
					symtab.add(arr[0]);
					symaddr.add(addr);
				}
				else{
					int index=symtab.indexOf(arr[0]);
					symaddr.remove(index);
					symaddr.add(index,addr);
					
				}
				wr.write("\n(AD,04)(S,"+symtab.indexOf(arr[2])+")");
			}
			if(arr[1].equals("LTORG") || arr[1].equals("END"))
			{
				String code = null;
				if(litaddr.contains(0)){
					for(int i=pooltab.get(pooltab.size()-1);i<littab.size();i++){
						if(litaddr.get(i)==0){
							litaddr.remove(i);
							litaddr.add(lc);
							code=littab.get(i);
							lc++;
						}
					}
				}
				if(!arr[1].equals("END")){
					pooltab.add(littab.size());
					wr.write("\n(AD,05)(DL,01)(C,"+code+")");
				}
				else{
					wr.write("\n(AD,02)");
				}
				
				
			}
			if(arr[1].equals("DS")){
				wr.write("\n"+lc+"\t(DL,02) (C,"+arr[2]+")");
				lc+=Integer.parseInt(arr[2]);
				
			}
			if(arr[1].equals("DC")){
				wr.write("\n"+lc+"\t(DL,01) (C,"+arr[2]+")");
				lc++;
			}
			if(is.containsKey(arr[1]))
			{
				wr.write("\n"+lc+"\t(IS,"+is.get(arr[1])+") ");
			
				if(arr.length>2 && arr[2]!=null){
					
					String str=arr[2].replace(",","");
					
					if(str.contains("AREG"))
						wr.write(" (1) ");
					else if(str.contains("BREG"))
						wr.write(" (2) ");
					else if(str.contains("CREG"))
						wr.write(" (3) ");
					else if(str.contains("DREG"))
						wr.write(" (4) ");
					else{
						if(!symtab.contains(str)){
							symtab.add(str);
							symaddr.add(0);
						}
						wr.write(" (S,"+symtab.indexOf(str)+")");
						
					}
				}
				if(arr.length>3 && arr[3]!=null){
					if(arr[3].contains("="))
					{
						if(!littab.contains(arr[3])){
							littab.add(arr[3]);
							litaddr.add(0);
						}
						wr.write(" (L,"+littab.indexOf(arr[3])+")");
						
					}
					else{
						if(!symtab.contains(arr[3])){
							symtab.add(arr[3]);
							symaddr.add(0);
						}
						wr.write(" (S,"+symtab.indexOf(arr[3])+")");
						
					}
				}
				
				lc++;
			}
			
			
			
		}
		System.out.println(symtab);
		for(int i=0;i<symtab.size();i++){
			swr.write("\n"+symtab.get(i)+"  "+symaddr.get(i));
		}
		System.out.println(symaddr);
		
		System.out.println(littab);
		System.out.println(litaddr);
		System.out.println(pooltab);
		wr.close();
		swr.close();
		
	}
	private int getAddress(String str) throws IOException {
		String res[]=str.split("\\+");
		int addr=symaddr.get(symtab.indexOf(res[0]));
		int val=addr+Integer.parseInt(res[1]);
		wr.write("\n(AD,03)(S,"+symtab.indexOf(res[0])+")+"+res[1]);
		return val;
	}
	
}
public class PassOne {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Assembler a=new Assembler();
		a.data();
		a.input();
	}

}
