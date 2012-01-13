/*
 * AOJ 0018
 * Sorting Five Numbers
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * ソートするだけ
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
#define SORT(c) sort((c).begin(),(c).end())

#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;


int main(void){
	int x;
	VI ans;
	while(cin >> x)
		ans.push_back(x);

	SORT(ans);
	reverse(ans.begin(), ans.end());
	REP(i,ans.size()-1)
		cout << ans[i] << " ";
	cout << ans[ans.size()-1] << endl;
	return 0;
}
