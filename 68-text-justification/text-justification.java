class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int count = words[i].length(), j = i + 1;
            while (j < words.length && count + words[j].length() + (j - i) <= maxWidth) {
                count += words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            if (j == words.length || j - i == 1) {
                line.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    line.append(" ").append(words[k]);
                }
                while (line.length() < maxWidth) line.append(" ");
            } else {
                int spaces = (maxWidth - count) / (j - i - 1);
                int extra = (maxWidth - count) % (j - i - 1);
                line.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    for (int s = 0; s < spaces + (k - i <= extra ? 1 : 0); s++) line.append(" ");
                    line.append(words[k]);
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }
}