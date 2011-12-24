/*
 * AOJ0014
 * Integral
 *
 *  Created on: 2011/11/18
 *      Author: y42sora
 *
 *  書いてある計算方法を行うだけ
 */

#include <iostream>
using namespace std;

int main(){
	int d;
	while(cin >> d){
		int ans = 0;
		for(int i=1; i*d < 600; i++)
			ans += (d*i * d*i) *d;
		cout << ans << endl;
	}
	return 0;
}
