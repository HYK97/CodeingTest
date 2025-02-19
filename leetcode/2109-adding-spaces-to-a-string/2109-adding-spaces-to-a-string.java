class Solution {
    public String addSpaces(String s, int[] spaces) {
        Set<Integer> set = Arrays.stream(spaces)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        StringBuilder sb = new StringBuilder();
        if (set.contains(0)) {
            sb.append(" ");
        }
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (set.contains(i+1)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}