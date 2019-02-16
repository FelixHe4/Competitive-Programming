//
//  main.cpp
//  dmopc15c6p6
//
//  Created by Felix He on 2019-02-16.
//  Copyright © 2019 Felix He. All rights reserved.
//
#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1505;
int n, m, k;
vector<int> a[MAXN];
int dp[MAXN][MAXN];
bool vis[MAXN];
int main() {
    cin.tie(0);
    cin.sync_with_stdio(false);
    cout.tie(0);
    cin >> n >> m >> k;
    if(m == (n * (n-1)) / 2) {
        for(int i = 0; i < n; i++) {
            cout << n << '\n';
        }
        return 0;
    }
    for(int i = 0; i < m; i++) {
        int c1, c2;
        cin >> c1 >> c2;
        a[c1].push_back(c2);
        a[c2].push_back(c1);
    }
    memset(dp, 0x3f, sizeof dp);
    for(int i = 1; i <= n; i++) {
        queue<int> q;
        q.push(i);
        memset(vis, false, sizeof vis);
        vis[i] = true;
        dp[i][i] = 0;
        while(!q.empty()) {
            int cur = q.front();
            q.pop();
            bool sus = false;
            for(int z : a[cur]) {
                if(!vis[z]) {
                    vis[z] = true;
                    dp[i][z] = dp[i][cur] + 1;
                    dp[z][i] = dp[cur][i] + 1;
                    q.push(z);
                    if(dp[i][z] > k) {
                        sus = true;
                        break;
                    }
                }
            }
//            if(sus) {
//                break;
//            }
        }
        int count = 0;
        for(int j = 1; j <= n; j++) {
            if(dp[i][j] <= k) {
                count++;
            }
        }
        cout << count << endl;
//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=n; j++) {
//                cout << dp[i][j] << " \n"[j==n];
//            }
//        }
    }
}
