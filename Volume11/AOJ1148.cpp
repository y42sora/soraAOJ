/*
 * AOJ1148
 * Analyzing Login/Logout Records
 *
 *  Created on: 2011/12/24
 *      Author: y42sora
 *
 *  数が少ないので、ログイン・ログアウトデータを保存しておき、それをいわれたときに各時間事に計算するだけでいける。
 *  PCは一台でもログインしていれば良いため、個別認識せずにその時何台ログインしているか？だけを記録し
 *  全ての端末からログアウトしたときに、一番初めのログアウトからの時間を使用時間と計算する
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




class Student{
public:
	int pcnum;
	int login_time;
	vector<bool> login_log;
	Student(void){
		login_time = 0;
		pcnum = 0;
		int time = 1300;
		REP(i,time)
			login_log.push_back(false);
	}
	void login(int time){
		pcnum++;
		if(pcnum==1)
			login_time = time;
	}

	void logout(int time){
		pcnum--;
		if(pcnum == 0)
			FOR(i,login_time, time)
				login_log[i] = true;
	}

	int get_login_time(int start, int end){
		int sum = 0;
		FOR(i,start,end)
			if(login_log[i])
				sum++;
		return sum;
	}
};


int main(void){
	while(true){
		int n,m;
		cin >> n;
		cin >> m;

		if((n | m) == 0) break;


		vector<Student> student_list(m);

		int r,q;
		cin >> r;
		REP(i,r){
			int t,n,m,s;
			cin >> t;
			cin >> n;
			cin >> m;
			cin >> s;
			m--;

			if(s == 1)
				student_list[m].login(t);
			else
				student_list[m].logout(t);
		}

		cin >> q;
		REP(i,q){
			int start,end,m;
			cin >> start;
			cin >> end;
			cin >> m;
			m--;
			cout << student_list[m].get_login_time(start,end) << endl;
		}

	}
}
