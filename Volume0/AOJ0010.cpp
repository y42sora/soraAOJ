/*
 * AOJ0010
 * Circumscribed Circle of a Triangle
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * 公式に入れるだけ
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
	int n;
	cin >> n;
	REP(i,n){
		double x1, y1, x2, y2, x3, y3;
		scanf("%lf %lf %lf %lf %lf %lf", &x1, &y1, &x2, &y2, &x3, &y3);

		double a1 = 2.0 * (x2-x1);
		double b1 = 2.0 * (y2-y1);
		double c1 = x1*x1 - x2*x2 + y1*y1 - y2*y2;
		double a2 = 2.0 * (x3-x1);
		double b2 = 2.0 * (y3-y1);
		double c2 = x1*x1 - x3*x3 + y1*y1 - y3*y3;

		double x = (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
		double y = (c1*a2 - c2*a1) / (a1*b2 - a2*b1);
		double r = sqrt( (x1-x)*(x1-x) + (y1-y)*(y1-y));
		
		printf("%.3f %.3f %.3f\n", x,y,r);
	}
	return 0;
}