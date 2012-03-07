/*
 * AOJ0047
 * Cup Game
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * シミュレートするだけ
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

vector<string> split(string str, string sp){
	vector<string> s;
	int start = 0;

	while(str.find_first_of(sp,start) != str.npos){
		int end = str.find_first_of(sp,start);
		s.push_back(str.substr(start,end-start));
		start = end + sp.size();
	}
	s.push_back(str.substr(start,str.size()-start));

	return s;
}

int main(void){
	vector<double> cups(3,false);
	cups[0] = true;

	string line;
	while(cin >> line){
		VS s = split(line, ",");
		char b = s[0][0];
		char a = s[1][0];

		if(cups[b - 'A']){
			cups[b - 'A'] = false;
			cups[a - 'A'] = true;
		}else if(cups[a - 'A']){
			cups[b - 'A'] = true;
			cups[a - 'A'] = false;
		}
	}
	REP(i,3)
		if(cups[i])
			cout << char('A'+i) << endl;
	return 0;
}

