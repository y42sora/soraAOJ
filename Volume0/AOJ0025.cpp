/*
 * AOJ 0025
 * Hit and Blow
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * まず初めにブローしたものを調べる。
 * 次にヒットしたものを数える。
 * ここでヒットしたものは必ずブローに含まれるため、その分を引いたものがブローだけしているものの値。
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
	int a1,a2,a3,a4;
	int b1,b2,b3,b4;
	while(cin >> a1){
		cin >> a2 >> a3 >>a4;
		cin >> b1 >> b2 >> b3 >> b4;

		int h = 0;
		int b = 0;

		int z;
		z = a1;
		if(z==b1 || z==b2 || z==b3 || z==b4)b++;
		z = a2;
		if(z==b1 || z==b2 || z==b3 || z==b4)b++;
		z = a3;
		if(z==b1 || z==b2 || z==b3 || z==b4)b++;
		z = a4;
		if(z==b1 || z==b2 || z==b3 || z==b4)b++;

		if(a1 == b1)h++;
		if(a2 == b2)h++;
		if(a3 == b3)h++;
		if(a4 == b4)h++;
		
		b-=h;

		cout << h << " " << b << endl;
	}
	return 0;
}
