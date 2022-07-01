package algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

	static List<Integer> findAnagrams(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if (sLen < pLen) {
			return new ArrayList<>();
		}

		int[] sHash = new int[26];
		int[] pHash = new int[26];

		for (int i = 0; i < pLen; i++) {
			pHash[p.charAt(i) - 'a'] += 1;
			sHash[s.charAt(i) - 'a'] += 1;
		}

		List<Integer> result = new ArrayList<>();
		// taking sliding window of size equal to length of p string
		for (int i = pLen; i < sLen; i++) {
			// for the first sliding window
			if (Arrays.equals(sHash, pHash)) {
				result.add(i - pLen);
			}
			// slide window by adding into ith char and removing char out of window
			sHash[s.charAt(i) - 'a'] += 1;
			sHash[s.charAt(i - pLen) - 'a'] -= 1;
		}
		// For the last sliding window
		if (Arrays.equals(sHash, pHash)) {
			result.add(sLen - pLen);
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	}
}
