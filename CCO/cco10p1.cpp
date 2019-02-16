
#include <iostream>
#include <climits>
#define long long ll;
using namespace std;

const int MAXN = 1e3+5;
vector<int> adj[MAXN]:
int main() {
    int d;
    cin >> d;
    int dog[d];
    int time[d];
    for(int i = 0; i<d; i++){
        cin >> dog[d];
    }
    int f;
    cin >> f;
    for(int i = 0; i < i++){
        int dogA, dogB;
        cin >> dogA >> dogB;
        adj[dogA].push_back(dogB);
        adj[dogB].push_back(dogA);
    }
    int t;
    cin >> t;
    Queue<int> q;
    int barks[d];
    barks[0]++;
    int d[d];
    bool s[d];
    for(int i = 0; i<t; i++){
        s.fill(false);
        if(d[i] > 0  && !s[i]){
            d[i] -= 1;
            if(d[i] == 0){
                s[i] = true;
                barks[i]++;
                for(int j = 0; j<adj[dogA].size(); j++){
                    if(d[k] > 0 && !switcher[k]){
                        switcher[k] = true;
                        d[k] = time[k];
                    }
                }
            }
        }
    }
    for(int i = 0; i<d; i++){
        cout << barks[i] << endl;
    }
}
