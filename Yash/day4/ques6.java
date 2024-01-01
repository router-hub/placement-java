import java.util.*;
import java.lang.*;
 
 
class main
{
	
	public static boolean canWePlace(int arr[], int mid, int cows){
		int cowsCount = 1;
		int last = arr[0];
		
		for(int i=0; i< arr.length; i++){
			if((arr[i] - last) >= mid ){
				cowsCount++;
				last= arr[i];
			}
			if(cowsCount >= cows){
				return true;
			}
		}
		
		return false;
	}
	
	public static int aggressiveCows(int arr[], int cows){
		int low = 1;
		int high = arr[arr.length-1]- arr[0];
		while(low<= high ){
			int mid = low +(high-low)/2;
			if(canWePlace(arr, mid, cows)){
				low = mid+1;
			}
			else{
				high = mid-1;
			}
		}
		
		return high;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
			int stalls = sc.nextInt();
			int cows = sc.nextInt();
			int arr[] = new int[stalls];
			
			for(int i=0; i<arr.length; i++){
				arr[i]= sc.nextInt();
			}
			Arrays.sort(arr);
            System.out.println(aggressiveCows(arr,cows));
			
			
			
		}
	}
}
