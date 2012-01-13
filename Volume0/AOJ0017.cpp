/*
 * AOJ 0017
 * Caesar Cipher
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 答え書いてあるwww
 * と思ったら、問題文がひどくてWA連発…
 * 暗号文に改行が入っていることから、入力がaaa \n bb \n ccのような複数行にわたる事があり得るため
 * 入力全てが1つの暗号文だと思い、ずらす値を一定にしてたらダメだった。
 * どうやら暗号文は一行ずつ別々らしい。
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
#define SORT(c) sort(k(c).begin(),(c).end())

#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;


int main(void){
	string read;

	while(getline(cin, read)){
		string s = read;
		while(s.find("the") == -1 && s.find("this") == -1 && s.find("that")==-1)
			REP(i,s.size())
				if(s[i] != ' ' && s[i] != '.')
					s[i] = ((s[i]-'a'+1)%26) +'a';
		cout << s << endl;
	}
	return 0;
}
