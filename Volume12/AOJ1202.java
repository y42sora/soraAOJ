import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AOJ1202 {
	public static void main(String[] args) {
		AOJ1202 m = new AOJ1202();
		m.start();
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		DecimalFormat nf = new DecimalFormat("########.00"); 
		
		int num = 1;
		while(true){
			int n = sc.nextInt();
			if(n == 0) return;
			

			LinkedList<Rectangle> addRects = new LinkedList<AOJ1202.Rectangle>();
			for(int i=0; i<n; i++){
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				double w = sc.nextDouble();
				addRects.add(new Rectangle(x-w,y-w,w*2,w*2));
			}
			System.out.println(num++ + " " + nf.format(getAns(addRects)));
		}
	}

	public double getAns(LinkedList<Rectangle> addRects) {
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		
		while(!addRects.isEmpty()){
			Rectangle r = addRects.pop();
			
			if(checkRects(r,rects,addRects))
				continue;
			rects.add(r);
		}
		
		double ans = 0;
		for (Rectangle rectangle : rects)
			ans += rectangle.getArea();

		return ans;
	}
	
	private boolean checkRects(Rectangle r, ArrayList<Rectangle> rects, LinkedList<Rectangle> addRects) {
		for(int i=0; i<rects.size();i++)
			if(rects.get(i).isOver(r))
				if(spRectangle(i,r,rects,addRects))
					return true;
		return false;
	}

	private boolean spRectangle(int i, Rectangle r, ArrayList<Rectangle> rects,
			LinkedList<Rectangle> addRects) {
		Rectangle r1 = rects.get(i);
		rects.remove(i);
		
		splitRectangle(r1,r,addRects);
		return true;
	}

	public void splitRectangle(Rectangle r1, Rectangle r2,
			LinkedList<Rectangle> addRects) {
		int num1 = r1.isInPointNum(r2);
		int num2 = r2.isInPointNum(r1);
		
		if(num1 == 4)
			addRects.add(r1);
		else if(num2 == 4)
			addRects.add(r2);
		else if(num1 == 0 && num2 == 0)
			addZeroPoint(r1,r2,addRects);
		else if(num1 == 2)
			addTwoPoint(r1,r2,addRects);
		else if(num2 == 2)
			addTwoPoint(r2, r1, addRects);
		else 
			addOnePoint(r1,r2,addRects);
	}

	public void addZeroPoint(Rectangle r1, Rectangle r2,
			LinkedList<Rectangle> addRects) {
		
		if(r2.x < r1.x){
			addZeroPoint(r2, r1, addRects);
			return;
		}
		
		addRects.add(r1);
		addRects.add(new Rectangle(r2.x, r2.y, r2.w, r1.y-r2.y));
		addRects.add(new Rectangle(r2.x, r1.y+r1.h, r2.w, (r2.y+r2.h)-(r1.y+r1.h)));
	}

	public void addTwoPoint(Rectangle big, Rectangle small,
			LinkedList<Rectangle> addRects) {
		if(big.isInPoint(small.x,small.y)){
			if(big.isInPoint(small.x,small.y2)){
				addRects.add(big);
				addRects.add(new Rectangle(big.x2,small.y,small.x2-big.x2,small.h));
				return;
			}else{
				addRects.add(big);
				addRects.add(new Rectangle(small.x,big.y2,small.w,small.y2-big.y2));
				return;
			}
		}
		if(big.isInPoint(small.x2,small.y)){
			addRects.add(big);
			addRects.add(new Rectangle(small.x,small.y,big.x-small.x,small.h));
			return;
		}else{
			addRects.add(big);
			addRects.add(new Rectangle(small.x,small.y,small.w,big.y-small.y));
			return;
		}
	}

	public void addOnePoint(Rectangle r1, Rectangle r2,
			LinkedList<Rectangle> addRects) {
		
		if(r1.isInPoint(r2.x, r2.y)){
			addRects.add(r1);
			addRects.add(new Rectangle(r1.x + r1.w, r2.y, r2.x + r2.w -(r1.x+r1.w),r2.h));
			addRects.add(new Rectangle(r2.x, r1.y+r1.h ,r1.x+r1.w - r2.x, r2.y+r2.h - (r1.y + r1.h)));
			return;
		}

		if(r1.isInPoint(r2.x+r2.w, r2.y)){
			addRects.add(r1);
			addRects.add(new Rectangle(r2.x,r2.y, r1.x-r2.x, r2.h));
			addRects.add(new Rectangle(r1.x,r1.y2,r2.x2-r1.x,r2.y2-r1.y2));
			return;
		}
		addOnePoint(r2, r1, addRects);
	}

	// test 
	Rectangle makeRectangle(double x,double y,double w,double h){
		return new Rectangle(x,y,w,h);
	}
	
	class Rectangle{
		double x,y,w,h,x2,y2;
		Rectangle(double x,double y,double w,double h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.x2 = x+w;
			this.y2 = y+h;
		}
		
		public double getArea(){
			return w*h;
		}
		
		boolean isOver(Rectangle r){
			if(x < r.x+r.w && y < r.y+r.h)
				if(r.x < x+w && r.y < y+h)
					return true;
			return false;
		}
		
		int isInPointNum(Rectangle r){
			int num = 0;
			if(isInPoint(r.x, r.y))num++;
			if(isInPoint(r.x+r.w, r.y))num++;
			if(isInPoint(r.x, r.y+r.h))num++;
			if(isInPoint(r.x+r.w, r.y+r.h))num++;
			
			return num;
		}
		
		boolean isInPoint(double px,double py){
			if(x <= px && px <= x+w)
				if(y <= py && py <= y+h)
					return true;
			return false;
		}
		
		public boolean equals(Object other){
	        if(other == null)
	            return false;
	        if(!(other instanceof Rectangle))
	            return false;
	        
			Rectangle rectangle = (Rectangle)other;
			if(x==rectangle.x && y==rectangle.y && w==rectangle.w && h==rectangle.h)
				return true;
			return false;
		}
		
		public String toString(){
			return x+" " + y+" "+h+" "+h;
		}
	}
	

}