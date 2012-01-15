/*
 * AOJ 0031
 * Weight
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 大きい方から順に載っけていくだけ
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
	VI weight;
	weight.push_back(1);
	FOR(i,1,10)
		weight.push_back(weight[i-1] * 2);
	reverse(weight.begin(), weight.end());

	int w;
	while(cin >> w){
		VI ans;
		REP(i,weight.size()){
			if(0 <= w - weight[i]){
				w -= weight[i];
				ans.push_back(weight[i]);
			}
		}
		SORT(ans);
		REP(i,ans.size()-1)
			cout << ans[i] << " ";
		cout << ans[ans.size()-1] << endl;
	}

	return 0;
}
