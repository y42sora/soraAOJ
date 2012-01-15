/*
 * AOJ 1286
 * Expected Allowance 
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 *
 * サイコロを振った合計値-kの値の期待値はどれ位か？
 * 合計値がk以下なら全て１と処理する
 * 割る値は同じなので、最後に一回だけ割る
 * n面ダイスの時の確率がよく解らなかったので、全検索
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

int diceRoll(int num, int n, int m, int k){
	// 残りnの中から一個ダイスを振る
	if(n == 0)
		if(num-k <= 0)
			return 1;
		else
			return num-k;
	int ans = 0;
	REP(i,m)
		ans += diceRoll(num+(i+1), n-1, m,k);
	return ans;
}

int main(void){
	while(true){
		int n,m,k;

		cin >> n >> m >> k;
		if((n|m|k) == 0) break;

		printf("%.8f\n",diceRoll(0,n,m,k)/pow((double)m,(double)n));
	}
	return 0;
}
