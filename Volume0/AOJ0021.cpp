/*
 * AOJ 0021
 * Parallelism
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 傾きを求めて一致すれば平行
 * 傾きが０の時を考えてないんだけど通った…
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


double getGradient(PDD p1, PDD p2){
	return (p1.second-p2.second) / (p1.first -p2.first);
}



int main(void){
	int n;
	cin >> n;
	REP(i,n){
		double x;
		PDD a,b,c,d;

		cin >> x;
		a.first = x;
		cin >> x;
		a.second = x;

		cin >> x;
		b.first = x;
		cin >> x;
		b.second = x;
		
		cin >> x;
		c.first = x;
		cin >> x;
		c.second = x;

		cin >> x;
		d.first = x;
		cin >> x;
		d.second = x;

		if( getGradient(a,b) == getGradient(c,d))
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}

	return 0;
}
