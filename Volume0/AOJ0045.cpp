/*
 * AOJ0045
 * Sum and Average
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * 計算するだけ
 * 四捨五入に気を付けつけましょう
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
	int gold = 0;
	int num = 0;
	int sum = 0;

	int n,u;
	while(scanf("%d,%d", &u, &n) != EOF){
		gold += u*n;
		num++;
		sum += n;
	}

	cout << gold << endl;
	cout << (int)(((double)sum / (double)num)+0.5) << endl;
	return 0;
}

