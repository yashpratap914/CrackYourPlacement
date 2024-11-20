class Solution {
    public int takeCharacters(String s, int k) {
        if(k == 0) return 0;
	else if(s.length() < k*3) return -1;

	int ct[] = new int[3];
	int res = -1, i = 0, n = s.length();
	for(; i<n; i++) {
		ct[s.charAt(i)-'a']++;
		if(ct[0]>=k && ct[1]>=k && ct[2]>=k) {
			res = i+1;
			break;
		}
	}

	if(res == -1) return res;

	for(int j=n-1; i>=0 && j>=0; j--) {
		ct[s.charAt(j)-'a']++;

		while(i>=0 && ct[s.charAt(i)-'a'] > k) {
			ct[s.charAt(i--)-'a']--;
		}

		if(ct[0]>=k && ct[1]>=k && ct[2]>=k) {
			res = Math.min(res, (i+1)+(n-j));
		}
	}

	return res;
    }
}