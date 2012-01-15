/*
 * AOJ 0036
 * A Figure on Surface
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 実際に調べるだけ
 * 配列外参照に注意
 * 今回は余計に上下左右に6列作り、20*20にする事で回避している
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

char sarchFigure(int x, int y, VVI map){
	if(map[x][y+1] == 1){
		// 横に伸びてる
		if(map[x+1][y] == 1)
			if(map[x+1][y+1] == 1)
				return 'A';
		if(map[x][y+2]==1)
			if(map[x][y+3])
				return 'C';
		if(map[x+1][y+1] == 1)
			if(map[x+1][y+2] == 1)
				return 'E';
		if(map[x-1][y+1] == 1)
			if(map[x-1][y+2] == 1)
				return 'G';
	}else if(map[x+1][y] == 1){
		// 縦に伸びている
		if(map[x+2][y] == 1)
			if(map[x+3][y] == 1)
				return 'B';
		if(map[x+1][y-1] == 1)
			if(map[x+2][y-1] == 1)
				return 'D';
		if(map[x+1][y+1] == 1)
			if(map[x+2][y+1] == 1)
				return 'F';
	}
	return 0;
}

char searchMap(VVI map){
	REP(i,map.size())
		REP(j,map[i].size())
			if(map[i][j] == 1)
				if((int)sarchFigure(i,j,map) != 0)
					return sarchFigure(i,j,map);
}

int main(void){
	string s;
	while(getline(cin, s)){
		if(s.size() == 0) continue;

		VVI map;

		REP(i,6){
			VI line;
			REP(j,20)
				line.push_back(0);
			map.push_back(line);
		}

		{
			VI line;
			REP(j,6)
				line.push_back(0);
			REP(j,s.size())
				line.push_back(s[j]-'0');
			REP(j,6)
				line.push_back(0);
			map.push_back(line);
		}
		REP(i,7){
			VI line;
			getline(cin,s);
			REP(j,6)
				line.push_back(0);
			REP(j,s.size())
				line.push_back(s[j]-'0');
			REP(j,6)
				line.push_back(0);
			map.push_back(line);
		}
		
		REP(i,6){
			VI line;
			REP(j,20)
				line.push_back(0);
			map.push_back(line);
		}
		
		cout << searchMap(map) << endl;
	}
	return 0;
}
