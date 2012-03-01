/*
 * AOJ0040
 * Affine Cipher
 *
 *  Created on: 2012/03/01
 *      Author: y42sora
 * 
 * 文字列sの各文字にたいして
 * (α*s[i]+β)%26というアフィン変換をした文から元の文を求めよ．
 * ただし必ずthatかthisが含まれ，αと26は互いに素とする．
 * とう問題
 * βは0-25までしかあり得ないので，αを１ずつ増やしていって確認していけばOK
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


string trans(int a, int b, string text){
	   string ans = text;
	   REP(i,ans.size())
		ans[i] = (((ans[i]-'a')*a + b)%26) + 'a';
	   return ans;
}

bool is_text(int a, int b, VS text){
	REP(i,text.size())
		if(trans(a,b,text[i])=="that" || trans(a,b,text[i])=="this")
			return true;
	return false;
}

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

int gcd(int m, int n){
	if ((0==m) || (0==n))
		return 0;
	while(m != n)
		if(m > n)
			m = m-n;
		else
			n = n-m;
	return m;
}

int main(void){
	int n;
	
	string line;
	getline(cin, line);
	n = atoi(line.c_str());

	REP(i,n){
		getline(cin, line);
		VS text = split(line, " ");

		int a=-1;
		int b=-1;
		bool flag = true;

		while(flag){
			b=-1;
			if(gcd(++a,26) == 1){
				while(b <= 26){
					if(is_text(a,++b,text)){
						flag = false;
						break;
					}
				}
			}
		}

		cout << trans(a,b,text[0]);
		FOR(i,1,text.size())
			cout << " " << trans(a,b,text[i]);
		cout << endl;
	}

	return 0;
}
