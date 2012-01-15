/*
 * AOJ 0026
 * Dropping Ink
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 実際にやってみるだけ。
 * 配列外参照回避のために大きさを20*20にしている。
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
	string s;

	VVI map;
	REP(i,20){
		VI line;
		REP(j,20)
			line.push_back(0);
		map.push_back(line);
	}
	
	vector<PII> small;
	vector<PII> mid;
	vector<PII> big;
	PII p;
	p.first = 0;
	p.second = 0;
	small.push_back(p);

	p.first = 1;
	p.second = 0;
	small.push_back(p);
	p.first = 0;
	p.second = 1;
	small.push_back(p);
	p.first = -1;
	p.second = 0;
	small.push_back(p);
	p.first = 0;
	p.second = -1;
	small.push_back(p);

	REP(i,small.size())
		mid.push_back(small[i]);
	p.first = -1;
	p.second = -1;
	mid.push_back(p);
	p.first = 1;
	p.second = -1;
	mid.push_back(p);
	p.first = -1;
	p.second = 1;
	mid.push_back(p);
	p.first = 1;
	p.second = 1;
	mid.push_back(p);

	REP(i,mid.size())
		big.push_back(mid[i]);
	p.first = -2;
	p.second = 0;
	big.push_back(p);
	p.first = 0;
	p.second = -2;
	big.push_back(p);
	p.first = 0;
	p.second = 2;
	big.push_back(p);
	p.first = 2;
	p.second = 0;
	big.push_back(p);

	while(getline(cin,s)){
		int x = s[0] - '0' + 5;
		int y = s[2] - '0' + 5;
		int size = s[4] - '0';

		switch(size){
		case 1:
			REP(i,small.size())
				map[y+small[i].second][x+small[i].first]++;
			break;
		case 2:
			REP(i,mid.size())
				map[y+mid[i].second][x+mid[i].first]++;
			break;
		case 3:
			REP(i,big.size())
				map[y+big[i].second][x+big[i].first]++;
			break;
		}
	}

	int count = 0;
	int maxInk = -1;
	FOR(i,5,15)
		FOR(j,5,15)
			if(map[i][j] == 0)
				count++;
			else
				maxInk = max(maxInk, map[i][j]);

	cout << count << endl << maxInk << endl;
	return 0;
}
