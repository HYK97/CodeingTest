class Solution {
    public String clearDigits(String s) {
        	Stack<Character> stack = new Stack<>();
	for (char c : s.toCharArray()) {
		if (Character.isDigit(c)) {
			// 숫자가 나왔을 때, 스택이 비어있지 않다면 가장 가까운 문자 제거
			if (!stack.isEmpty() && Character.isLetter(stack.peek())) {
				stack.pop(); // 가장 가까운 문자 제거
			}
		} else {
			stack.push(c); // 문자는 스택에 추가
		}
	}
	// 스택에 남은 문자들을 합쳐 결과 반환
	StringBuilder result = new StringBuilder();
	for (char c : stack) {
		result.append(c);
	}
	return result.toString();
    }
}