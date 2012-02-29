/*
 * AOJ0038
 * Poker Hand
 *
 *  Created on: 2012/02/29
 *      Author: y42sora
 * 
 * スートは考えなくていいので，ストレート以外は何枚の同じカードの集合がいくつあるか，ということだけに気をつければいい．
 * なので同じ数字が何枚あるかを求めて，そこから何枚の集合はいくつあるかを求めれば簡単に判定できる．
 * ストレートだけは別処理．
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


bool is_straight(VI cards){
	if(cards[0]==cards[1]-1)
		if(cards[1]==cards[2]-1)
			if(cards[2]==cards[3]-1)
				if(cards[3]==cards[4]-1)
					return true;

	if(cards[0]==1 && cards[1]==10)
		if(cards[1]==cards[2]-1)
			if(cards[2]==cards[3]-1)
				if(cards[3]==cards[4]-1)
					return true;
	return false;
}

int main(void){
	int a[5];

	while(~scanf("%d,%d,%d,%d,%d",&a[0],&a[1],&a[2],&a[3],&a[4])){
		VI cards(5,0);
		REP(i,5) cards[i]=a[i];

		SORT(cards);
		VI nums(14,0);
		REP(i, cards.size())
			nums[cards[i]]++;

		VI card_set(5, 0);
		REP(i,nums.size())
			card_set[nums[i]]++;

		int ans = 0;
		if(card_set[4]==1) ans=6;
		else if(card_set[3]==1 && card_set[2]==1) ans=5;
		else if(is_straight(cards)) ans=4;
		else if(card_set[3]==1) ans=3;
		else if(card_set[2]==2) ans=2;
		else if(card_set[2]==1) ans=1;

		string output[] = {"null","one pair","two pair","three card","straight","full house","four card"};
		cout << output[ans] << endl;
	}
	return 0;
}
