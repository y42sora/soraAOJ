/*
 * AOJ0048
 * Class
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * 計算するだけ
 * 書くのが面倒
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

string get_class(double x){
	if(x <= 48.00)
		return "light fly";
	if(x <= 51.00)
		return "fly";
	if(x <= 54.00)
		return "bantam";
	if(x <= 57.00)
		return "feather";
	if(x <= 60.00)
		return "light";
	if(x <= 64.00)
		return "light welter";
	if(x <= 69.00)
		return "welter";
	if(x <= 75.00)
		return "light middle";
	if(x <= 81.00)
		return "middle";
	if(x <= 91.00)
		return "light heavy";
	return "heavy";
}

int main(void){
	double x;
	while(cin >> x)
		cout << get_class(x) << endl;
	return 0;
}

