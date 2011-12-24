import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

public class AOJ0012 {
	
	public static void main(String[] args) {
		new AOJ0012().start();
	}
	
	/*
	 * 線分の左右どちらかにあるか調べる
	 * 外戚を求めてる
	 *  1 左
	 *  0 上
	 * -1 右
	 */
	public int isRL(Point2D.Double p,Line2D.Double line){
		Point2D p1 = line.getP1();
		Point2D p2 = line.getP2();
		
		double ans = p.x * (p1.getY() - p2.getY()) + p1.getX() * (p2.getY() - p.y) + p2.getX() * (p.y - p1.getY());
		
		if(ans < 0)return -1;
		else if(0 < ans)return 1;
		else return 0;
	}

	/*
	 * 与えられた点が、三角形の内部にあるか調べる
	 * 時計回りに見て行ったときと反時計回りに見て行く
	 * 周り型が同じ時に違う方向にあればダメ
	 * 時計回りと反時計回りで左右が違わないとダメ
	 */
	public boolean isPointInTriangle(
			Point2D.Double point, 
			Point2D.Double p1,
			Point2D.Double p2,
			Point2D.Double p3){
		
		int ans1 = isRL(point, new Line2D.Double(p1,p2));
		int ans2 = isRL(point, new Line2D.Double(p2,p1));
		if(ans1 == isRL(point, new Line2D.Double(p2,p3)))
			if(ans1 == isRL(point, new Line2D.Double(p3,p1)))
				if(ans2 == isRL(point, new Line2D.Double(p1,p3)))
					if(ans2 == isRL(point, new Line2D.Double(p3,p2)))
						if(ans1 != ans2)
							return true;
		return false;
	}
	
	private void start() {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			double y3 = sc.nextDouble();
			
			double xp = sc.nextDouble();
			double yp = sc.nextDouble();
			
			if(isPointInTriangle(
					new Point2D.Double(xp, yp), 
					new Point2D.Double(x1, y1), 
					new Point2D.Double(x2, y2), 
					new Point2D.Double(x3, y3)
					)
				)
				System.out.println("YES");
			else
				System.out.println("NO");
				
		}
	
	
	}

}