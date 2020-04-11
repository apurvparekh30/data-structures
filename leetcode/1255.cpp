class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
      int letter_count[26];
      fill(letter_count, letter_count+26, 0);
      for(char c: letters) {
        letter_count[c-'a']++;
      }
      int n = words.size();
      int max_score = 0;
      for(int i = 0; i < (1 << n); i++) {
        int used_count[26];
        fill(used_count, used_count+26, 0);
        int score = 0;
        for(int j=0;j<n;j++) {
          if((i&(1<<j)) != 0) {
            int word_score = 0;
            string curr_word = words[j];
            for(char c: curr_word) {
              if(used_count[c-'a'] >= letter_count)  {
                word_score = -1;
                break;
              } else {
                word_score += score[c-'a'];
                used_count[c-'a']++;
              }
            }
            if(word_score != -1) {
              score = score + word_score;
            }
          } 
        }
        max_score = max(max_score, score);
      }
      return max_score;
    }
};
