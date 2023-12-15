class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int l=0; 
        
        int b = 0;
        int w=0;
        int result= Integer.MAX_VALUE;

        for(int r=0; r< n; r++){
            if(blocks.charAt(r)=='W'){
                w++;
            }
            else{
                b++;
            }

            if(r-l+1 >= k){
                result = Math.min(result,(r-l+1)-b);
                if(blocks.charAt(l)=='W'){
                    w--;
                }
                else{
                    b--;
                }
                l++;
                
            }
        }

        return result;
    }
}