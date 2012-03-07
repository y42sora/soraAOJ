/*
 * AOJ0044
 * Prime Number II
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * ふるいを作ればいいんじゃない？
 * 最大はせいぜい5000だし
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
	vector<bool> prime(150000, true);
	
	prime[0] = false;
	prime[1] = false;

	for(int a=2; 2*a < prime.size(); a++)
		prime[2*a] = false;

	for(int i=3; i < prime.size(); i+=2)
		for(int a=2; i*a < prime.size(); a++)
			prime[i*a] = false;

	int x;
	while(cin >> x){
		int a=x;
		int b=x;
		while(!prime[++a]);
		while(!prime[--b]);

		cout << b << " " << a << endl;
	}
	return 0;
}