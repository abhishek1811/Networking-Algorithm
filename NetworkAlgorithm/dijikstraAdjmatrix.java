
package NetworkAlgorithm;

import java.util.Scanner;
import java.io.IOException;

/**
 * @author Abhishek
 *
 */
public class dijikstraAdjmatrix {

	/**
	 * @param args
	 */
	int []q;
	int []ans;
	int []key;
	static int sp;
	private static Scanner s;
	public void dijikstra(int num){
		int counter=0;
		int u;
		network n=new network();
		key=new int[num];
		q=new int[num];
		ans=new int[num];
		n.initializeGraph(key, q, sp,num);
		//sp=0;
		System.out.println("\nInitially queue is ");n.print(q);
		System.out.println("\nInitially key matrix is:");n.print(key);
		System.out.println("Starting vertex is "+sp);
		
		while(counter<num){
			u=q[n.pick(key,ans)];
			ans[counter]=u;
			for(int i=0;i<network.adjmatrix[u].length;i++){
				if((network.adjmatrix[u][i]!=-1)&&(key[u]+network.adjmatrix[u][i]<key[i])){
					key[i]=key[u]+network.adjmatrix[u][i];
				}
			}
			n.print(key);
			counter++;
		}
		n.print(ans);
		
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		network n=new network();
		dijikstraAdjmatrix d= new dijikstraAdjmatrix();
		s = new Scanner(System.in);
		System.out.println("Enter the file name of input graph");
		String file=s.nextLine();
		int num =n.makeadjmatrix(file);
		System.out.println("Enter the source index [0-n]");
		sp=s.nextInt();
		d.dijikstra(num);
		
	}

}
