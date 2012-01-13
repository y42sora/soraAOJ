/*
 * AOJ 0022
 * Maximum Sum Sequence
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 *	一つ一つ取っていき、最大値を求める
 * ただし合計値がマイナスになった場合は0に戻す(そこから再スタート)
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
typedef pair<double, double> PDD;
typedef long long LL;
const double EPS = 1e-10;
#define SORT(c) sort((c).begin(),(c).end())

#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;


int main(void){
	while(true){
		int n;
		cin >> n;

		if(n == 0) break;

		LL big = -900000;
		LL all = 0;
		REP(i,n){
			int x;
			cin >> x;

			big = max(big, all+x);
			all+=x;
			if(all < 0)
				all = 0;
		}
		cout << big << endl;
	}
	return 0;
}
