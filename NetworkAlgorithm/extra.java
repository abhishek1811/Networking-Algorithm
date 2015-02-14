package NetworkAlgorithm;

import org.apache.commons.lang3.ArrayUtils;

public class extra {
	public void delete(int []a,int pos){
		
        int []t=new int[a.length-1];
		t=ArrayUtils.removeElements(a,pos);
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a=new int[]{0,1,2,3,4};
		extra e=new extra();
		e.delete(a,1);
	}

}
