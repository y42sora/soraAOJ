/*
 * AOJ1147
 * ICPC Score Totalizer Software
 *
 *  Created on: 2011/12/24
 *      Author: y42sora
 *
 *  いわれたとおりにやるだけ
 *  その都度最大と最小を持つ方法の方が早いかも
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
	while(true){
		int n;
		cin >> n;
		if(n == 0) break;

		VI data;
		int sum = 0;
		REP(i,n){
			int x;
			cin >> x;
			data.push_back(x);
			sum += x;
		}
		SORT(data);
		sum -= data[0];
		sum -= data[data.size()-1];
		cout << (int)(sum/(data.size()-2)) << endl;
	}
}
