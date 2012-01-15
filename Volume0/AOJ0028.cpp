/*
 * AOJ 0028
 * Mode Value
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 100個の配列を用意して、データの個数を数えていく
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



int main(void){
	VI num;
	REP(i,110)
		num.push_back(0);

	int x;
	int big = -1;
	while(cin >> x)
		big = max(big, ++num[x]);

	REP(i,num.size())
		if(num[i] == big)
			cout << i << endl;

	return 0;
}
