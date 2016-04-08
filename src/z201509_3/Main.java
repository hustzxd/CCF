package z201509_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner fin = new Scanner(System.in);
		int m,n;
		m = fin.nextInt();
		n = fin.nextInt();
		String str = "";
		List<String> lines=new ArrayList<String>();
		fin.nextLine();
		for(int i = 0; i< m+n;i++){
			str = fin.nextLine();
			lines.add(str);
		}
		Map<String , String > map = new HashMap<>() ;
		for(int i = 0 ;i<n;i++){
			 String str0 = lines.get(i+m);
			 int index = str0.indexOf(' ');
			 String str1 = str0.substring(0, index);
			 String str2 = str0.substring(index+2,str0.length()-1);
			 map.put(str1, str2);
		}
		Set<String> keys_set = map.keySet();
		List<String> keys_list = null;
		for(String set:keys_set){
			keys_list.add(set);
		}
		for(int i = 0 ;i<m;i++){
			String line_old = lines.get(i);
			String line_new=null;
			int index1 = 0;
			for(int index0 = 0;index0 < line_old.length();){
				index0 = line_old.indexOf("{{ ");
				index1 = line_old.indexOf(" }}");
				if(index0 < index1){
					
				}
			}
			System.out.println(line_new);
		}
		
	}

}
