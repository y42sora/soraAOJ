/*
 * AOJ0043
 * Puzzle
 *
 *  Created on: 2012/03/07
 *      Author: y42sora
 * 
 * 全ての場合で試すだけ
 * 
 * 判定は
 * 数字を辞書に入れる
 * 2個のものだけを取り出して，全てのにこの場合で再起
 * 再起先では，三個の組みをとった場合，もしくは連続している数字を一個ずつとった場合で再起
 * 全部ゼロになったら終了して，その時点ですべて終了する
 * なければFalseを返す
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


bool check_ok(int x, VI num){
	if (x == 0)
		return true;


	REP(i,num.size()){
		if(3 <= num[i]){
			num[i] -= 3;
			if(check_ok(x-3, num))
				return true;
			num[i] += 3;
		}
	}

	REP(i,num.size()-2){
		if(1 <= num[i] && 1 <= num[i+1] && 1 <= num[i+2]){
			num[i]--;
			num[i+1]--;
			num[i+2]--;
			if(check_ok(x-3, num))
				return true;
			num[i]--;
			num[i+1]--;
			num[i+2]--;
		}
	}
	return false;	
}

bool check_start(int x, VI num){
	num[x]++;

	REP(i,num.size())
		if(4 < num[i])
			return false;

	REP(i,num.size()){
		if(2 <= num[i]){
			num[i] -= 2;
			if(check_ok(12, num))
				return true;
			num[i] += 2;
		}
	}
	return false;
}

int main(void){

	string line;
	while( cin>>line){
		VI num(10, 0);
		REP(i,line.size())
			num[line[i]-'0']++;

		VI ans;
		FOR(i,1,10)
			if(check_start(i,num))
				ans.push_back(i);

		if(ans.size() == 0)
			cout << 0 << endl;
		else{
			REP(i,ans.size()-1)
				cout << ans[i] << " ";
			cout << ans[ans.size()-1] << endl;
		}
	}
	return 0;
}