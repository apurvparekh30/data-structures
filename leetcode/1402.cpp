#include <bits/stdc++.h>

using namespace std;


class Solution {
public:
    int maxSatisfaction(vector<int>& arr) {
    
      sort(arr.begin(), arr.end());

      //for(int i:arr) cout << i << " "; cout << "\n";

      int pos_sum = 0;
      int neg_sum = 0;
      int m = 1;
      for(int i:arr) {
        if(i >= 0) {
          pos_sum += i;
        } else {
          neg_sum += i; 
          m++;
        }
      }


      int sum = 0;

      m = 1;

      int not_selected_sum = 0;

      for(int i=0;i<arr.size();i++) {
        if(arr[i] >= 0)  {
          sum = sum + (arr[i] * m);
          m++;
          continue;
        }
        int tmp = (neg_sum - not_selected_sum) * -1;
        if(tmp < pos_sum){
            //cout << i << " " << tmp << " " << pos_sum << " " << arr[i] << "\n";
            sum = sum + ( arr[i] * m);
            m++;
            continue;
        }
        not_selected_sum = not_selected_sum + arr[i];
      }
      return sum;
    }
};

void trimLeftTrailingSpaces(string &input) {
    input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
        return !isspace(ch);
    }));
}

void trimRightTrailingSpaces(string &input) {
    input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
        return !isspace(ch);
    }).base(), input.end());
}

vector<int> stringToIntegerVector(string input) {
    vector<int> output;
    trimLeftTrailingSpaces(input);
    trimRightTrailingSpaces(input);
    input = input.substr(1, input.length() - 2);
    stringstream ss;
    ss.str(input);
    string item;
    char delim = ',';
    while (getline(ss, item, delim)) {
        output.push_back(stoi(item));
    }
    return output;
}

int main() {
    string line;
    while (getline(cin, line)) {
        vector<int> satisfaction = stringToIntegerVector(line);
        
        int ret = Solution().maxSatisfaction(satisfaction);

        string out = to_string(ret);
        cout << out << endl;
    }
    return 0;
}
