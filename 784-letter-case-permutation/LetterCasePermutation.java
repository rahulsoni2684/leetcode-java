package algorithm1;

import java.util.ArrayList;
import java.util.List;
/**
 * 784-letter-case-permutation
 */
public class LetterCasePermutation {

	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		backtrack(S.toLowerCase().toCharArray(), result, 0, S.length());
		return result;
	}

	public void backtrack(char[] chArr, List<String> result, int i, int len) {
		if (i < len) {
			backtrack(chArr, result, i + 1, len);
			if (Character.isLetter(chArr[i])) {
				chArr[i] = Character.toUpperCase(chArr[i]);
				backtrack(chArr, result, i + 1, len);
				chArr[i] = Character.toLowerCase(chArr[i]);
			}
		} else
			result.add(new String(chArr));
	}

	public static void main(String[] args) {
		LetterCasePermutation obj = new LetterCasePermutation();
		System.out.println(obj.letterCasePermutation("a2d4"));
	}
}
