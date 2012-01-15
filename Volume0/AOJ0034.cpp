/*
 * AOJ 0034
 * Railway Lines
 *
 *  Created on: 2011/12/31
 *      Author: y42sora
 * 
 * 速度と全体の距離からすれ違う時間を求め、その時電車がいる区間を求める
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
	int v1,v2;
	int len[10];
	while(scanf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d",
		&len[0],&len[1],&len[2],&len[3],&len[4],
		&len[5],&len[6],&len[7],&len[8],&len[9],&v1,&v2) != EOF){

		int sum = 0;
		REP(i,10)
			sum+=len[i];

		double t = (double)(sum) / (v1+v2);
		double cross = v1 * t;

		sum = 0;
		REP(i,10){
			sum += len[i];
			if(cross <= sum){
				cout << (i+1) << endl;
				break;
			}
		}
	}
	return 0;
}
