/*
 * AOJ 1285
 * Grey Area
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 *
 * 英語ゲー
 * 最も大きいものを黒く塗ったときのインクの量を１ユニットとして、どれだけインクがかかるか？
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


using namespace std;

#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n)  FOR(i,0,n)
typedef vector<int> VI;
typedef vector<VI> VVI;
typedef vector<string> VS;
typedef pair<int, int> PII;
typedef long long LL;
const double EPS = 1e-10;
#define SORT(c) sort(k(c).begin(),(c).end())

#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;


int main(void){

	while(true){
		int n,w;
		cin >> n;
		cin >> w;
		if((n|w) == 0) break;

		VI num;
		int big = -1;
		REP(i,n){
			int x;
			cin >> x;
			num.push_back(x);
			big = max(big, x);
		}

		big = big / w + 1;
		VI data;
		REP(i, big)
			data.push_back(0);

		REP(i,num.size())
			data[num[i]/w]++;

		int maxSize = -1;
		REP(i,data.size())
			maxSize = max(maxSize, data[i]);

		double ans = 0.0;
		REP(i,data.size())
			ans += (1.0 * data[i]) / maxSize * (double)(data.size()-(i+1)) / (data.size()-1);
		ans += 0.01;
		printf("%.6f\n", ans);
	}
	return 0;
}
