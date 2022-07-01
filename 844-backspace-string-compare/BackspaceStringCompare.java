package algorithm2;

public class BackspaceStringCompare {
	static boolean backspaceCompare(String s, String t) {

		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '#') {
				sb1.append(s.charAt(i));
			} else {
				if (sb1.length() > 0)
					sb1.deleteCharAt(sb1.length() - 1);
			}
		}
		System.out.println(sb1.toString());
		
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) != '#') {
				sb2.append(t.charAt(i));
			} else {
				if (sb2.length() > 0)
					sb2.deleteCharAt(sb2.length() - 1);
			}
		}
		System.out.println(sb2.toString());
		
		return sb1.toString().equals(sb2.toString());
	}

	public static void main(String[] args) {
		String s = "#ac#ey##";
		String t = "ac#fy##";
		System.out.println(backspaceCompare(s, t));
	}
}
