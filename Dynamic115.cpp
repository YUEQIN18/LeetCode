#include <stddef.h>
#include <iostream>
#include <vector>
#include <list>
#include <unordered_set>
#include <map>
using namespace std;

class Solution
{
public:
  int numDistinct(string s, string t)
  {
    vector<vector<uint64_t>> dp(s.size() + 1, vector<uint64_t>(t.size() + 1, 0));
    for (int i = 0; i < s.size() + 1; i++)
      dp[i][0] = 1;
    for (int j = 1; j < t.size() + 1; j++)
      dp[0][j] = 0;
    for (int i = 1; i < s.size() + 1; i++)
    {
      for (int j = 1; j < t.size() + 1; j++)
      {
        if (s[i - 1] == t[j - 1])
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    // for (int i = 1; i < s.size() + 1; i++){
    //   for (int j = 1; j < t.size() + 1; j++){
    //     cout << dp[i][j];
    //   }
    //   cout << endl;
    // }
      return dp[s.size()][t.size()];
  }

};

int main()
{
  string s = "baegg";
  string t = "bag";
  Solution a;
  cout << a.numDistinct(s, t);
}