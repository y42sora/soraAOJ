/*
 * AOJ 1153
 * Equal Totaol Score
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 *
 *  SUM(taro) -t +h == SUM(hanako) -h +t
 *  が一致するものを求める、全通り
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
		int n,m;
		VI taro;
		int sumTaro=0;
		VI hanako;
		int sumHanako=0;

		cin >> n;
		cin >> m;
		if(n == 0 && m == 0) break;
		REP(i,n){
			int x;
			cin >> x;
			taro.push_back(x);
			sumTaro+=x;
		}
		REP(i,m){
			int x;
			cin >> x;
			hanako.push_back(x);
			sumHanako+=x;
		}

		int taroCard = 1000;
		int hanakoCard = 1000;
		REP(i,taro.size()){
			REP(j,hanako.size()){
				int tx = taro[i];
				int hx = hanako[j];
				if(sumTaro - tx + hx == sumHanako -hx +tx){
					if(tx+hx < taroCard+hanakoCard){
						taroCard = tx;
						hanakoCard = hx;
					}
				}
			}
		}

		if(taroCard == 1000)
			cout << -1 << endl;
		else
			cout << taroCard << " " << hanakoCard << endl;
	}
	return 0;
}
