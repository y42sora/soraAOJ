/*
 * AOJ 0027
 * What day is today?
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 解法１：実際にやる
 * 解法２：モジュロ演算する
 * 解法３：標準ライブラリtime.hを使う　←これ
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
	while(true){
		int month,day;
		cin >> month >> day;
		if( (month|day) == 0) break;

		struct tm daytime;
		daytime.tm_year = 2004-1900;
		daytime.tm_mon = month-1;
		daytime.tm_mday = day;
		daytime.tm_hour = 0;
		daytime.tm_min = 0;
		daytime.tm_sec = 0;
		daytime.tm_isdst = -1;
		mktime(&daytime);

		char s[50];
		strftime(s, 50, "%A", &daytime);
		printf("%s\n",s);
	}

	return 0;
}
