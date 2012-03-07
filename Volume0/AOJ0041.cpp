/*
 * AOJ0041
 * Expression
 *
 *  Created on: 2012/03/02
 *      Author: y42sora
 * 
 * 組み合わせはともかく，カッコの付け方面倒だなー→カッコは決め打ちするか！
 * というわけで以下の方法五種類にたいして全ての演算子を試すだけ
 * (a b) (c d)
 * ((a b) c ) d
 * (a (b c)) d
 * a ((b c) d
 * a (b (c d))
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

int eval(int x, int y, char a){
	switch(a){
	case '+':
		return x+y;
	case '-':
		return x-y;
	case '*':
		return x*y;
	}
	return 1000;
}

bool calc(VI num, char a, char b, char c){

	//(a b) (c d)
	if(eval(eval(num[0],num[1], a), eval(num[2],num[3], c), b) == 10){
		printf("(%d %c %d) %c (%d %c %d)\n", num[0],a,num[1],b,num[2],c,num[3]);
		return true;
	}

	//((a b) c ) d
	if(eval(eval(eval(num[0],num[1], a),num[2], b),num[3], c) == 10){
		printf("((%d %c %d) %c %d) %c %d\n", num[0],a,num[1],b,num[2],c,num[3]);
		return true;
	}

	//(a (b c)) d
	if(eval(eval(num[0], eval(num[1],num[2], b), a),num[3], c) == 10){
		printf("(%d %c (%d %c %d)) %c %d\n", num[0],a,num[1],b,num[2],c,num[3]);
		return true;
	}

	//a ((b c) d) 
	if(eval(num[0], eval(eval(num[1],num[2],b),num[3], c),a) == 10){
		printf("%d %c ((%d %c %d) %c %d)\n", num[0],a,num[1],b,num[2],c,num[3]);
		return true;
	}

	//a (b (c d))
	if(eval(num[0], eval(num[1],eval(num[2],num[3], c),b),a) == 10){
		printf("%d %c (%d %c (%d %c %d))\n", num[0],a,num[1],b,num[2],c,num[3]);
		return true;
	}

	return false;
}

bool get_ans(VI pos){
	string op = "+-*";
	do{
		REP(i,3)
			REP(j,3)
				REP(k,3)
					if(calc(pos,op[i],op[j],op[k]))
						return true;
	}while(next_permutation(pos.begin(), pos.end()));
	return false;
}

int main(void){
	while(true){
		VI pos(4,0);
		REP(i,4)
			cin>>pos[i];
		SORT(pos);

		if((pos[0]|pos[1]|pos[2]|pos[3]) == 0)
			break;

		if(!get_ans(pos))
			cout << "0" << endl;
	}
	return 0;
}