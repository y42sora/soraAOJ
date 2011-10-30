import java.util.Scanner;


public class AOJ1289 {
	public static void main(String[] args) {
		new AOJ1289().start();
	}
	
	private void start(){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int num = sc.nextInt();
			if(num == 0) break;
			
			Point3D dir = null;
			Point3D nowPoint = new Point3D(0, 0, 0);
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				dir = new Point3D(x, y, z);
			}
			
			Circle3D circleArray[] = new Circle3D[num];
			for(int i=0; i<num;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				int r = sc.nextInt();
				circleArray[i] = new Circle3D(x, y, z, r);
			}

			while(true){
				Circle3D nextSCircle = null;
				double min = Double.MAX_VALUE;
				
				for(int i=0;i<num;i++){
					Circle3D check = circleArray[i];
					Point3D vect = new Point3D(nowPoint.x - check.p.x, nowPoint.y-check.p.y, nowPoint.z-check.p.z);
					
					double a = dot(dir,dir);
					double b = 2*dot(dir,vect);
					double c = dot(vect, vect)- check.r*check.r;
					
					//”»•ÊŽ®
					double d = discriminant(a, b, c);
					if(d < 0) continue;
					
					double t = (-b-Math.sqrt(d)) / (2*a);
					if(t <= 0)continue;
					
					if(t < min){
						nextSCircle = check;
						min = t;
					}
				}
				
				if(nextSCircle == null) break;
				
				Point3D a = dir.getUnitVector();
				a.reverse();
				
				dir.times(min);
				nowPoint.plus(dir);
				
				Point3D nPoint3d = nowPoint.copy();
				nPoint3d.minus(nextSCircle.p);
				Point3D n = nPoint3d.getUnitVector();
				
				double an = dot(a, n);
				
				n.times(an*2.0);
				n.minus(a);
				dir = n;
			}
			System.out.printf("%.4f %.4f %.4f\n", nowPoint.x, nowPoint.y , nowPoint.z);
		}
	}
	
	double discriminant(double a,double b,double c){
		return b*b-4*a*c;
	}
	
	double dot(Point3D p1,Point3D p2){
		return p1.x * p2.x + p1.y*p2.y + p1.z*p2.z;
	}
	
	class Point3D{
		double x;
		double y;
		double z;
		public Point3D(int x,int y,int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public Point3D(double x,double y,double z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public Point3D copy() {
			return new Point3D(x, y, z);
		}
		
		public void plus(double x,double y,double z){
			this.x += x;
			this.y += y;
			this.z += z;
		}
		
		public void plus(Point3D p) {
			plus(p.x,p.y,p.z);
		}
		
		public void minus(Point3D p) {
			minus(p.x,p.y,p.z);
		}
		
		public void minus(double x,double y,double z){
			this.x -= x;
			this.y -= y;
			this.z -= z;
		}
		
		public double getNorm() {
			return Math.sqrt(this.x * this.x + this.y*this.y + this.z*this.z);
		}
		
		public Point3D getUnitVector(){
			double n = getNorm();
			return new Point3D(this.x/n, this.y/n, this.z/n);
		}
		
		public void times(double x,double y,double z) {
			this.x *= x;
			this.y *= y;
			this.z *= z;
		}
		
		public void times(Point3D p) {
			times(p.x,p.y,p.z);
		}
		
		public void times(double t) {
			times(t,t,t);
		}
		
		public void reverse(){
			this.x = -x;
			this.y = -y;
			this.z = -z;
		}
	}
	
	class Circle3D{
		Point3D p;
		double r;
		
		public Circle3D(int x,int y,int z,int r) {
			this.p = new Point3D(x, y, z);
			this.r = r;
		}
	}
}