/*
 * AOJ0042
 * A Thief
 *
 *  Created on: 2012/03/02
 *      Author: y42sora
 * 
 * ナップサック問題なのでDP
 * 教科書に載っている練習問題かと見間違うほどの典型的なDP
 */
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <fstream>
using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)
typedef vector<int> VI;
typedef vector<VI> VVI;
typedef vector<string> VS;
typedef pair<int, int> PII;
typedef pair<double, double> PDD;
typedef long long LL;
const double EPS = 1e-10;
#define SORT(c) sort((c).begin(),(c).end())

#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;


int main(void){
	int data_set = 0;
	while(true){
		int w;
		cin >> w;

		if(w==0)
			break;

		data_set++;

		int n;
		cin >> n;

		VVI dp;
		VI gold;
		VI weight;
		REP(i,n+1){
			VI line(w+1,0);
			dp.push_back(line);
		}
		REP(i, n){
			int g,we;
			char c;

			cin >> g >> c >> we;
			gold.push_back(g);
			weight.push_back(we);
		}

		FOR(i, 1,  n+1)
			FOR(j, 1,  w+1)
				if(0 <= j-weight[i-1])
					dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i-1]] + gold[i-1]);
				else
					dp[i][j] = dp[i-1][j];

		cout << "Case " << data_set << ":" << endl;
		cout << dp[n][w] << endl;

		int x = n, y=w;
		while(true){
			if(dp[x][y] != dp[x][y-1])
				break;
			y--;
		}
		cout << y << endl;
	}
	return 0;
}