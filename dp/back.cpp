#include <iostream>
#include <algorithm>
#include <cstring>
#include <iomanip>
using namespace std;

string X, Y;           //input strings
int ans, dp[105][105]; // ans : answer

int LCS(int n, int m) //our function return value of (n,m) sate
{                     // so that we can use the result in (n+1,m+1) state
    if (n == 0 || m == 0)
        return 0; //in case of match in (n+1,m+1) state
    if (dp[n][m] != -1)
        return dp[n][m];

    LCS(n - 1, m); //to visit all n*m states          (try example:  X:ASDF
    LCS(n, m - 1); // we call these states first                     Y:ASDFF)

    if (X[n - 1] == Y[m - 1])
    {
        dp[n][m] = LCS(n - 1, m - 1) + 1;
        ans = max(ans, dp[n][m]);
        return dp[n][m];
    }

    return dp[n][m] = 0;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, m;
        cin >> n >> m; //length of strings
        cin >> X >> Y;
        memset(dp, -1, sizeof dp);
        ans = 0;
        LCS(n, m);
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                cout << setw(3) << dp[i][j];
            }
            cout << "\n";
        }

        cout << ans << '\n';
    }
    return 0;
}