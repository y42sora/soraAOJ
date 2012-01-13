/*
 * AOJ 0029
 * English Sentence
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * mapに値を入れていくだけ
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
	string s;
	map<string,int> freqlist;
	int freq_count = -1;
	string freq_string;

	string max_string = "";		
	while(cin >> s){
		if(max_string.size() < s.size())
			max_string = s;
		freqlist[s] += 1;
		if(freq_count < freqlist[s]){
			freq_string = s;
			freq_count  = freqlist[s];
		}
	}

	cout << freq_string << " " << max_string << endl;
	return 0;
}
