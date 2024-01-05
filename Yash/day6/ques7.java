import java.util.*;
import java.lang.*;

class Main
{
	
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k =0;
		while(t-->0){
			int n =sc.nextInt();
			int minChicks = sc.nextInt();
			int barn = sc.nextInt();
			int time = sc.nextInt();
			int chicks[]= new int[n];
			int speed[] = new int[n];
			
			for(int i=0; i<n; i++){
				chicks[i] = sc.nextInt();
			}
			
			for(int i=0; i<n; i++){
				speed[i] = sc.nextInt();
			}
			
			int swaps = 0;
			int cant_reach =0;
			int count=0;
		
		
		
			for(int i=chicks.length-1; i>=0;i--){
				int dst =  barn - chicks[i];
				int canCover = speed[i]*time;
			
				if( dst <= canCover){
					count+=1;
					if(cant_reach > 0){
						swaps+=cant_reach;
					}
				}
				else{
				  cant_reach+=1;
				}

				if(count== minChicks){
					break;
				}
			}
			k++;

			
		
			if(count >= minChicks){
			System.out.println("Case #"+k+" : "+swaps);
			}
			else{
			System.out.println("Case #"+k+" : IMPOSSIBLE");
			}
			
			
			
		}
	}
}