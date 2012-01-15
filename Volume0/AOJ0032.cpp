/*
 * AOJ 0032
 * Plastic Board
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 長方形の場合直角三角形が含まれるので、ピタゴラスの定理が成り立てば長方形
 * 菱形の場合はa=bが成り立つとき
 * 長方形は？と思ったけど、全て整数の場合長方形はあり得ない
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
	int a,b,c;
	char com;
	int square = 0;
	int lozenge = 0;
	while(cin >>a>>can>>b>>can>>c)
		if( (a*a+b*b) == c*c)
			square++;
		else if(a==b)
			lozenge++;

	cout << square << endl;
	cout << lozenge << endl;

	return 0;
}
