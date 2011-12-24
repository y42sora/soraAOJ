/*
 * AOJ0015
 * National Budget
 *
 * Created on: 2011/11/18
 *     Author: y42sora
 *
 * 80桁なのでどうあがいてもC++だと無理
 * 素直にBigIntegerのようなものを作るか配列に入れて計算する
 *
 * しかしRE…
 * 問題文をよく読むと
 * そこで、80 桁までの 0 以上の整数を２つ入力し、その数の和を出力して終了するプログラムを作成して下さい。
 * "与えられた数"やその和が 10 進数の正の整数で 80 桁を超える場合は、overflow と表示して下さい。
 *
 * 解りにくい！(ﾉ・∀・)ﾉ　＝＝＝＝＝┻━┻))ﾟДﾟ)･∵.
 */

#include <iostream>
#include <algorithm>
using namespace std;

void calc(string one, string two, int num[]){
	int now = 0;
	int next = 0;

	while(true){
		if(one.length() <= now && two.length() <= now){
			num[now] = next;
			return;
		}

		int plus = 0;
		if(one.length() <= now)
			plus = next + (two[now] -'0');
		else if(two.length() <= now)
			plus = next + (one[now] -'0');
		else
			plus = next + (one[now] -'0') + (two[now]-'0');

		num[now] = plus%10;
		now++;
		next = plus/10;
	}
}

int main(){
	int n;
	cin >> n;

	for(int i=0; i<n; i++){
		string one, two;
		int num[100];
		for(int i=0; i<100; i++)
			num[i] = -1;

		cin >> one;
		cin >> two;

		if(80 < one.length() || 80 < two.length()){
			cout << "overflow" << endl;
			continue;
		}

		reverse(one.begin(), one.end());
		reverse(two.begin(), two.end());

		calc(one,two,num);

		int start = 99;
		while(num[start] == -1 || num[start] == 0) start--;

		if(80 <= start)
			cout << "overflow";
		else if(start == -1)
			cout << 0;
		else
			while(0<= start)
				cout << num[start--];

		cout << endl;
	}
	return 0;
}
