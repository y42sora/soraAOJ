/*
 * AOJ0037
 * Path on a Grid
 *
 *  Created on: 2012/01/29
 *      Author: y42sora
 * 
 * 迷路を作って実際に右手法で進んでいくだけ
 * ての動きを追うので，袋小路に入ったときはちゃんと回転するのも出力しないとダメ
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


class block{
public:
	bool dir[4];
	bool up,right,down,left;

	block(bool up, bool right, bool down, bool left){
		dir[0] = up;
		dir[1] = right;
		dir[2] = down;
		dir[3] = left;
	}
};


vector<block> get_first( vector<vector<bool> > input){
	vector<block> line;
	REP(i, input[0].size())
		line.push_back(block(false, false, input[0][i], false));
	return line;
}

vector<block> get_line(int x, vector<vector<bool> > input){
	vector<block> line;
	line.push_back(block(input[x][0], input[x+1][0], input[x+2][0], false));

	FOR(i,1, input[x].size()-1)
		line.push_back(block(input[x][i], input[x+1][i], input[x+2][i], input[x+1][i-1]));

	line.push_back(block(input[x][input[x].size()-1], false, input[x+2][input[x+2].size()-1], input[x+1][input[x+1].size()-1]));
	return line;
}

vector<block> get_end( vector<vector<bool> > input){
	vector<block> line;
	REP(i, input[input.size()-1].size())
		line.push_back(block(input[input.size()-1][i], false, false, false));
	return line;
}


int main(void){
	vector<vector<bool> > input;
	string line;
	while( (cin >> line) ){
		vector<bool> wall;
		if(input.size() % 2 == 0)
			line = "0" + line + "0";
		REP(i, line.size())
			if(line[i] == '0')
				wall.push_back(false);
			else
				wall.push_back(true);
		input.push_back(wall);
	}

	vector<vector<block> > maze;
	maze.push_back(get_first(input));
	for(int i=1 ; i*2 < input.size(); i++)
		maze.push_back(get_line((i-1)*2,input));
	maze.push_back(get_end(input));
	
	int x = 1;
	int y = 0;
	int d = 1;
	int move[4][2] = {{0,-1}, {1,0}, {0,1}, {-1,0}};
	char o[4] = {'U', 'R', 'D', 'L'};

	cout << o[d];
	while(true){
		if(x==0 && y==1) break;
		if(x==1 && y==1 && !maze[1][1].dir[3] && d == 3) break;


		int front = d;
		int right = (front+1)%4;

		if(!maze[y][x].dir[front] && maze[y][x].dir[right]){
			int newx = x + move[d][0];
			int newy = y + move[d][1];
			if(!maze[newy][newx].dir[right]){
				front = right;
				right = (front+1)%4;
				newx = newx + move[front][0];
				newy = newy + move[front][1];
				if(!maze[newy][newx].dir[right]){
					front = right;
					newx = newx + move[front][0];
					newy = newy + move[front][1];
				}
				x = newx;
				y = newy;
				d = front;
			}else{
				x += move[d][0];
				y += move[d][1];
			}
			cout << o[d];
		}else if(!maze[y][x].dir[right]){
			d = right;	
			x += move[d][0];
			y += move[d][1];
			cout << o[d];
		}else{
			d = (d+3) % 4;
			cout << o[d];
		}
	}
	cout << endl;
	
	return 0;
}
