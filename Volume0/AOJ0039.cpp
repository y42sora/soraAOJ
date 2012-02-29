/*
 * AOJ0039
 * Roman Figure
 *
 *  Created on: 2012/02/29
 *      Author: y42sora
 * 
 * 単純なローマ数字の問題．
 * 二個以上続かないらしいし，切り替わりの部分だけに注意すればいい
 * いまとその次を見て行って，同じならいまの部分を何も考えずに足して一個ずらす．
 * 違う場合は前より後ろが小さいなら，そのまま足す．
 * そうでないなら引いて一個ずらす．
 * 足してから引いても引いてから足しても変わらないので分けても大丈夫．
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
#include <fstream>
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
	string line;
	map<char,int> num;
	num['I'] = 1;
	num['V'] = 5;
	num['X'] = 10;
	num['L'] = 50;
	num['C'] = 100;
	num['D'] = 500;
	num['M'] = 1000;

	while((cin>>line)){
		int ans = 0;

		REP(i,line.size()-1)
			if( num[line[i]] < num[line[i+1]])
				ans -= num[line[i]];
			else
				ans += num[line[i]];
		ans += num[line[line.size()-1]];

		cout << ans << endl;
	}
	return 0;
}
