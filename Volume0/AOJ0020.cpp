/*
 * AOJ 0020
 * Capitalize
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * そのまま
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
	string s;
	while(getline(cin, s)){
		REP(i,s.size())
			if('a' <= s[i] && s[i] <= 'z')
				cout << (char)(s[i]-'a' + 'A');
			else
				cout << s[i];
		cout << endl;
	}
	return 0;
}
