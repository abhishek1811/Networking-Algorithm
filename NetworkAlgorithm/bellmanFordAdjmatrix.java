/**
 * 
 */
package NetworkAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author Abhishek
 *
 */

public class bellmanFordAdjmatrix {

	/**
	 * @param args
	 */
	int []q;
	int []ans;
	int []key;
	static int sp;
	public static int [][]adjmatrix;
	public static Scanner s=new Scanner(System.in);
	public  int makeadjmatrix(String file) throws FileNotFoundException{
		
		bellmanFordAdjmatrix B=new bellmanFordAdjmatrix();
		String type="Directed";
		s = new Scanner(new File(file));
		if(s.nextInt()==0){
			type="UnDirected";
		}
		int num=s.nextInt();
		int e=s.nextInt();
		edges[] E=new edges[e];
		for(int i=0;i<E.length;i++){
			E[i]=new edges();
		}
		adjmatrix=new int[num][num];
		for(int i =0 ;i<num;i++){
			for(int j=0;j<num;j++){
				adjmatrix[i][j]=0;
			}
		}	
		for(int i=0;i<e;i++){
			int a=E[i].u=s.nextInt();
			int b=E[i].v=s.nextInt();
			int wt=E[i].w=s.nextInt();
			adjmatrix[a][b]=wt;
			if(type=="UnDirected")
				adjmatrix[b][a]=adjmatrix[a][b];
			System.out.print(i+".  Wt of edge ("+a+","+b+") is "+adjmatrix[a][b]);
			System.out.println();
		}
		System.out.println("\nThe adjacency matrix is :");
		for(int i =0 ;i<num;i++){
			for(int j=0;j<num;j++){
				System.out.print(adjmatrix[i][j]+" ");
			}
			System.out.println("");
		}
		B.bellmanFord(num,e,E);
		return num;
	}
	public void bellmanFord(int num,int e,edges[]E){
		
		int counter=0;
		network n=new network();
		key=new int[num];
		q=new int[num];
		ans=new int[num];
		n.initializeGraph(key, q, sp,num);
		System.out.println("Key Initially:");n.print(key);
		while(counter<num-1){
			for(int i=0;i<E.length;i++){
				//System.out.print(adjmatrix[E[i].u][E[i].v]+"+"+key[E[i].u]+" < "+key[E[i].v]+"  ");
				//System.out.println(adjmatrix[E[i].u][E[i].v]+key[E[i].u]< key[E[i].v]);
				if((key[E[i].u]!=Integer.MAX_VALUE)&&(adjmatrix[E[i].u][E[i].v]!=0)&&(adjmatrix[E[i].u][E[i].v]+key[E[i].u] < key[E[i].v])){
					key[E[i].v] = key[E[i].u] +adjmatrix[E[i].u][E[i].v] ;
					//System.out.println("****key[E[i].v] is "+key[E[i].v]);
				}
				
			}
			System.out.println("K->Pass no:"+counter+" ");n.print(key);
			counter++;
			
		}
		for(int i=0;i<E.length;i++){
			if((key[E[i].u]!=Integer.MAX_VALUE)&&(adjmatrix[E[i].u][E[i].v]!=0)&&(adjmatrix[E[i].u][E[i].v]+key[E[i].u] < key[E[i].v])){
				System.out.println("Negative cycle in the graph");
				System.exit(0);
			}
		}
		System.out.println();
		n.print(key);
		
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		bellmanFordAdjmatrix b=new bellmanFordAdjmatrix();
		System.out.println("Enter the file name of input graph");
		String file=s.nextLine();
		System.out.println("Enter the source vertex");
		sp=s.nextInt();
		b.makeadjmatrix(file);
		
	}
	public class edges{
		int u,v,w;
		edges(){
			u=0;
			v=0;
			w=0;
		}
	}


}
