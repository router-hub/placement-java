//Maximize the Confusion of an Exam

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k, char targetChar) {
        int left = 0;
        int right = 0;
        int n = answerKey.length();
        int count = 0;
        int ans = 0;

        while (right < n) {
            if (answerKey.charAt(right) == targetChar) {
                count++;
            }

            while (count > k) {
                if (answerKey.charAt(left) == targetChar) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxConsecutiveT = maxConsecutiveAnswers(answerKey, k, 'T');
        int maxConsecutiveF = maxConsecutiveAnswers(answerKey, k, 'F');

        return Math.max(maxConsecutiveT, maxConsecutiveF);
    }
}
