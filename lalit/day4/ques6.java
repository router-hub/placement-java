import java.util.*;

class ques6{

	public static int largestMinimumDistance(int stalls[],int cows){
		Arrays.sort(stalls);
		
		int low = 0;
		int high = stalls[stalls.length - 1] - stalls[0];
		int minDistance = -1;
		
		while(low<=high){
			int mid = low +(high-low)/2;
			
			if(isPossible(stalls,cows,mid)){
				minDistance = mid;
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return minDistance;
	}
	
	public static boolean isPossible(int stalls[],int cows,int val){
		int placed = 1;
		int lastPlaced = stalls[0];
		
		for(int i = 1;i<stalls.length;i++){
			if (stalls[i] - lastPlaced >= val) {
                placed++;
                lastPlaced = stalls[i];
            }
        }

        return placed >= cows;
		}
	
	public static void main (String[] args) throws java.lang.Exception
    {
		Scanner sc = new Scanner(System.in);
		
        int diff = sc.nextInt();

		for(int i = 0;i<diff;i++){
            int n = sc.nextInt();
            int stalls[] = new int[n];
            int cows = sc.nextInt();
            
            for (int j = 0; j < n; j++) {
                stalls[j] = sc.nextInt();
            }
            
            int result = largestMinimumDistance(stalls, cows);
            System.out.println(result);
		}
        sc.close();
	}
}