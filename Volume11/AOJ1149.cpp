/*
 * AOJ1149
 * Cut the Cakes
 *
 *  Created on: 2011/12/24
 *      Author: y42sora
 *
 *  言われたとおりにカットするだけ
 *  カット位置がピースの長さより短いとは限らないので、MODしておくべき。
 *  番号の付け替えは生まれた順→大きさ順であるため、カットするピースを消して新しく出来た２つを末尾に付け足せば自然と順番になる。
 *  ただし、出力時は大きさ順なので最後にソートが必要
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

class Cake{
public:
	int w,h;
	void set(int w,int h){
		this->w = w;
		this->h = h;
	}
	int get_size(){
		return w*h;
	}

	int operator < (const Cake& c) const{
		return this->w*this->h < c.w*c.h;
	}
};

class Cakes{
public:
	vector<Cake> cake_list;
	void add_cake(int w,int d){
		Cake start;
		start.set(w,d);
		cake_list.push_back(start);
	}

	void cutting(int p, int s){
		int w = cake_list[p].w;
		int h = cake_list[p].h;
		vector<Cake>::iterator it = cake_list.begin();
		REP(i,p)
			it++;
		cake_list.erase(it);

		cat_cake(s,w,h);
	}

	void cat_cake(int s,int w,int h){
		Cake a,b;

		s = s % (w*2+h*2);
		if(s < w){
			a.set(s,h);
			b.set((w-s),h);
		}else if(s < w+h){
			a.set(w,h-(s-w));
			b.set(w,(s-w));
		}else if(s < w*2+h){
			a.set((s-(w+h)), h);
			b.set(w-(s-(w+h)),h);
		}else{
			a.set(w,(s-(w*2+h)));
			b.set(w,h-(s-(w*2+h)));
		}

		if(a.get_size() < b.get_size()){
			cake_list.push_back(a);
			cake_list.push_back(b);
		}else{
			cake_list.push_back(b);
			cake_list.push_back(a);
		}
	}

};


int main(void){
	while(true){
		int n,w,d;
		cin >> n;
		cin >> w;
		cin >> d;

		if((n | w | d) == 0) break;

		Cakes cut_cakes;
		cut_cakes.add_cake(w,d);

		REP(i,n){
			int p,s;
			cin >> p;
			cin >> s;
			cut_cakes.cutting(p-1,s);
		}

		SORT(cut_cakes.cake_list);
		
		REP(i,cut_cakes.cake_list.size()-1)
			cout << cut_cakes.cake_list[i].get_size() << " ";
		cout << cut_cakes.cake_list[cut_cakes.cake_list.size()-1].get_size() << endl;

	}
	return 0;
}
