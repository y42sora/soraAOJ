/*
 * AOJ 0024
 * Physical Experiments
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * vからtを求めて、tからyを求める
 * 後は与えられた条件からn = (y+5.0)/5をやり、切り上げるだけ。
 * ぴったりの場合も切り上げているが、予想通りテストケースにそんなコーナーケースはなかった。
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
	double speed;
	while(cin >> speed){
		double time = speed / 9.8;
		double height = 4.9*time*time;
		double n = (height+5.0) / 5.0;
		int ans =  (int)n+ 1;
		cout << ans << endl;
	}
	return 0;
}
