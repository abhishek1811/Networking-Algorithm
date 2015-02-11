/**
 * 
 */
package NetworkAlgorithm;
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;


/**
 * @author Abhishek
 *
 */

public class primsAdjmatrix{
	/**
	 * Returns the  number of vertices in graph
	 *
	 */
	//public static int [][]adjmatrix;
	public  Scanner s;
	private static Scanner s2;

	public static void main (String[]args) throws IOException{
		int u;
		int sp;
		int []q;
		int []ans;
		int []key;
		int counter=0;
		int [] parent;
		s2 = new Scanner(System.in);
		Random r= new Random();
		network p= new network();
		System.out.println("Enter the file name of input graph ");
		String file = s2.nextLine();
		int num=p.makeadjmatrix(file);
		q=new int[num];
		ans=new int[num];
		key=new int[num];
		parent=new int[num];
		
		sp=r.nextInt((num-1));
		p.initializeGraph(key,q,sp,num);
		System.out.println("\nInitial Queue is ");p.print(q);
		System.out.println("Initial value of Key is ");p.print(key);
		System.out.println("\nStarting point is: "+sp);
		while(counter<num){
			u=q[p.extractmin(key)];
			System.out.println("\nExtracting "+u+" from Queue");
			System.out.print("Q: ");
			q=p.delete(q,p.extractmin(key));
			p.print(q);
			key=p.delete(key,p.extractmin(key));
			ans[counter]=u;
			for(int i=0;i<network.adjmatrix[u].length;i++){
				if((network.adjmatrix[u][i]!=-1)&&(network.adjmatrix[u][i]<key[i])&&(p.belongsTo(i,q))){
					key[i]=network.adjmatrix[u][i];
					parent[i]=u;
				}
			}
			System.out.print("K: ");
			p.print(key);	
			counter++;	
		}
		System.out.println("\nThe MST is :");p.print(ans);
		System.out.println("\nParents :");p.print(parent);
	}
}
