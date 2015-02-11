/**
 * 
 */
package NetworkAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;



/**
 * @author Abhishek
 *
 */
public class network {
	public static int [][]adjmatrix;
	public  Scanner s;
	public void print(int[]a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public void initializeGraph(int[]key,int[]queue,int startingvertex,int sizematrix){
		for(int i=0;i<sizematrix;i++){
			key[i]=Integer.MAX_VALUE;
		}
		key[startingvertex]=0;
		for(int i=0;i<sizematrix;i++){
			queue[i]=i;
		}
	}
	public  int makeadjmatrix(String file) throws FileNotFoundException{
		String type="Directed";
		s = new Scanner(new File(file));
		//System.out.println("Enter the the no of vertices in graph");
		if(s.nextInt()==0){
			type="UnDirected";
		}
		int num=s.nextInt();
		//System.out.println("Enter the no of edges in the graph");
		int e=s.nextInt();
		adjmatrix=new int[num][num];
		for(int i =0 ;i<num;i++){
			for(int j=0;j<num;j++){
				adjmatrix[i][j]=-1;
			}
		}	
		for(int i=0;i<e;i++){
			
			int u=s.nextInt();
			int v=s.nextInt();
			adjmatrix[u][v]=s.nextInt();
			if(type=="UnDirected")
				adjmatrix[v][u]=adjmatrix[u][v];
			System.out.print(i+".  Wt of edge ("+u+","+v+") is "+adjmatrix[u][v]);
			System.out.println();
		}
		System.out.println("\nThe adjacency matrix is :");
		for(int i =0 ;i<num;i++){
			for(int j=0;j<num;j++){
				System.out.print(adjmatrix[i][j]+" ");
			}
			System.out.println("");
		}
		return num;
	}
	public int[] delete(int []a,int pos){
		int []t=new int[a.length];
		a[pos]=-2;
		t=a;
		return t;
	}
	public int []delShrink(int[]a,int pos){
		int []t=new int[a.length-1];
		t=ArrayUtils.removeElements(a,pos);
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}
		return t;
	}
	public int extractmin(int[]a){
		int pos=0;		
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){
			if(a[i]!=-2){
				if(temp>a[i]){
					temp=a[i];
					pos=i;
				}
			}
			
		}
		return pos;
	}
	public int pick(int[]key,int[]ans){
		int pos=0;
		int []t=new int[key.length];
		for(int i=0;i<key.length;i++){
			t[i]=key[i];
		}
		for(int i=0;i<ans.length;i++){
			t[ans[i]]=-2;
		}
		
		int temp=Integer.MAX_VALUE;
		for(int i=0;i<t.length;i++){
			if(t[i]!=-2){
				if(temp>t[i]){
					temp=t[i];
					pos=i;
				}
			}
			
		}
		return pos;
	}
	public  boolean belongsTo(int temp,int []a){
		for(int i=0;i<a.length;i++){
			if(a[i]==temp)
				return true;
		}
		return false;
	}
}
