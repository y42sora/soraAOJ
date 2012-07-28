/*
 * AOJ0013
 * Switching Railroad Cars
 *
 *  Created on: 2011/11/16
 *      Author: y42sora
 *
 *  スタックに積むだけ
 */

#include <iostream>
#include <stack>
using namespace std;

int main(){
	stack<int> st;
	int num;

	while(cin >> num){
		if(num == 0){
			cout << st.top() << endl;
			st.pop();
		}else{
			st.push(num);
		}
	}
	return 0;
}
