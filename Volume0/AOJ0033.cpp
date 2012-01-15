/*
 * AOJ 0033
 * Ball
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 2^10なので全検索でいける
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

bool get_ans(int now,int b,int c,VI balls){
	if(balls.size() == now)
		return true;					
	int x = balls[now];

	if(b < x)
		if(get_ans(now+1, x, c, balls))
			return true;

	if(c < x)
		if(get_ans(now+1, b, x, balls))
			return true;
	return false;
}

int main(void){
	int n;
	cin >> n;
	REP(i,n){
		VI balls;
		REP(j,10){
			int x;
			cin >> x;
			balls.push_back(x);
		}

		if(get_ans(0,0,0,balls))
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
	return 0;
}
