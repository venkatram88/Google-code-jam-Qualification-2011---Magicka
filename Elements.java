
public class Elements {

	public int C,D,N;
	String[] combine=null;
	String[] oppose =null;
	String[] input =null;
	
	String outputString ="";
	
	public Elements(String inputString){

		
		String[] patternSplit = inputString.split(" ");
		
		
		int pos=0;
		
		C = Integer.parseInt(patternSplit[0]);
		pos++;
		
		if(C>0){
			combine = new String[C];
			
			for(int i=0;i<C;i++){
				combine[i]=patternSplit[pos];
				pos++;
			}
				
		}
		
		D = Integer.parseInt(patternSplit[pos]);
		pos++;
		
		if(D>0){
			oppose = new String[D];
			
			for(int i=0;i<D;i++){
				oppose[i]=patternSplit[pos];
				pos++;
			}
				
		}
		

		N = Integer.parseInt(patternSplit[pos]);
		
		pos++;
		
		
		if(N>0){
			input = new String[N];
			
			int posInsideString =1;
			for(int i=0;i<N;i++){
				input[i]=patternSplit[pos].split("")[posInsideString];
				posInsideString++;
				
			}
				
		}
			
	}
	

	public String invoke(){
		for (int i = 0; i < input.length; i++) {
			outputString+=input[i];
		//	System.out.println(i + ":" + outputString);
			this.check();
			
		}
		return(outputString);
		
	
	}
	
private void check(){
		
		
		//check for combinations
		String s1 = null;
		String s2 = null;
		
		if(combine!=null){
				for (int i = 0; i < combine.length; i++) {
					
					s1=combine[i].split("")[1]+combine[i].split("")[2];
					s2=combine[i].split("")[2]+combine[i].split("")[1];
					if(outputString.endsWith(s1)||outputString.endsWith(s2)){
						//System.out.println("input:" + outputString);
						int len = outputString.length();
						outputString = outputString.substring(0,len-2)+combine[i].split("")[3];
					//	System.out.println("output:" + outputString);
						return;
					}
				}
		}
		//check opposed strings
		if(oppose!=null){
			for (int i = 0; i < oppose.length; i++) {
				s1 = oppose[i].split("")[1];
				s2 = oppose[i].split("")[2];
				if(outputString.contains(s1)&&outputString.contains(s2)){
					outputString="";
				}
			}
		}
	}
		

}

