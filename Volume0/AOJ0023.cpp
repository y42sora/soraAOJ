/*
 * AOJ 0023
 * Circles Intersection
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 全ての場合を計算するだけ
 * 0の場合は中心間の距離が2つの半径の和よりも長い場合
 * 2,-2の場合は、中心間の距離＋小さい方の半径<大きい方の半径の場合。
 * それ以外の場合1
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

double point_to_point_length(PDD a, PDD b){
	return sqrt((a.first-b.first)*(a.first-b.first) +
		(a.second-b.second)*(a.second-b.second));
}

int main(void){
	int n;
	cin >> n;
	REP(i,n){
		PDD a;
		PDD b;
		double ar,br;
		
		cin >> a.first >> a.second >> ar;
		cin >> b.first >> b.second >> br;

		int ans = 1;
		double length = point_to_point_length(a,b);
		if( ar+br < length)
			ans = 0;
		else
			if( length + br < ar)
				ans = 2;
			else if(length + ar < br)
				ans = -2;
		cout << ans << endl;
	}
	return 0;
}
