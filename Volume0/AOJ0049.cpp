/*
 * AOJ0049
 * Blood Groups
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * 計算するだけ
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
	string line;
	VI num(4,0);
	while(cin >> line){
		VS s = split(line,",");

		if(s[1]=="AB")
			num[2]++;
		else if(s[1]=="A")
			num[0]++;
		else if(s[1]=="B")
			num[1]++;
		else if(s[1]=="O")
			num[3]++;
	}
	REP(i,num.size())
		cout << num[i] << endl;

	return 0;
}

