// Find the Missing Number in a sorted array

class ques4{
    public static int missingNumber(int num[]){
        int n = num.length;

        if(num[0] != 1){
            return 1;
        }

        if(num[n-1] != n+1){
            return n+1;
        }

        int low = 0;
        int high = n-1;

        while((high-low)>1){
            int mid = (low+high)/2;

            if(num[low] - low != num[mid]-mid){
                high = mid;
            }else if(num[high]-high != num[mid]-mid){
                low = mid;
            }
        }
        return num[low]+1;
    }
    public static void main(String[] args) {
        int num[] = {1,2,3,4,6,7,8};

        System.out.println(missingNumber(num));
    }
}