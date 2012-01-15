/*
 * AOJ 0030
 * Sum of Integers
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 蟻本に似たような問題があった気がするけど手元にないので解らない
 * 高々10!なので全検索でいける
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
#include <time.h>
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

int get_ans(int n, int s, int x){
	// xより大きい値をn個使ってsと一致する値が作れる数
	if(n == 0)
		if(s == 0)
			return 1;
		else
			return 0;

	int ans = 0;
	x+=1;
	FOR(i,x,10)
		if(0 <= s-i)
			ans += get_ans(n-1, s-i, i);

	return ans;
}

int main(void){
	while(true){
		int n,s;
		cin >> n >> s;
		if((n|s) == 0) break;

		cout << get_ans(n,s,-1) << endl;
	}
	return 0;
}
