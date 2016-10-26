import java.util.*;

public class HashMapDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         LinkedHashMap m=new LinkedHashMap();
         m.put("chandra",101);
         m.put("Anil",302);
         m.put("venu",203);
         m.put("Dhana",402);
         System.out.println(m);
         /*System.out.println(m.put("venu",800));
         Set s=m.keySet();
         System.out.println(s);
         Collection c= m.values();
         System.out.println(c);
         Set s1=m.entrySet();
         System.out.println(s1);
         Iterator itr= s1.iterator();
         while(itr.hasNext()){
        	 Map.Entry m1=(Map.Entry)itr.next();
        	 System.out.println(m1.getKey()+"----"+m1.getValue());
        	 if(m1.getKey().equals("Dhana")){
        		 m1.setValue(2000);
        	 }
        	// System.out.println(m);
         }
         System.out.println(m);*/
         
	}

}
