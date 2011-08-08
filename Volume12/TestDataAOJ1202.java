import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.Test;

public class TestDataAOJ1202 {
	@Test
	public void testRectangleIsOver1(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(0,0,3.0,3.0);
		assertTrue(r1.isOver(r2));
	}

	@Test
	public void testRectangleIsOver2(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(2.0,2.0,3.0,3.0);
		assertTrue(r1.isOver(r2));
	}
	
	@Test
	public void testRectangleIsOver3(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(2,2,1.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(1,3,3.0,1.0);
		assertTrue(r1.isOver(r2));
	}
	
	@Test
	public void testRectangleIsOver4(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,4.0,4.0);
		Main.Rectangle r2 = main.makeRectangle(2,2,3.0,1.0);
		assertTrue(r1.isOver(r2));
	}
	
	@Test
	public void testRectangleIsOver5(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(1,1,1.0,1.0);
		assertTrue(r1.isOver(r2));
	}
	
	@Test
	public void testRectangleIsOver6(){

		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(3,3,1.0,1.0);
		assertFalse(r1.isOver(r2));
	}

	@Test
	public void testRectangleIsOverMini1(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(2,2,1.0,1.0);
		assertTrue(r1.isOver(r2));
	}

	@Test
	public void testRectangleIsOverMini2(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(0,0,1.0,1.0);
		assertTrue(r1.isOver(r2));
	}

	@Test
	public void testRectangleIsOverMini3(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(2,0,1.0,1.0);
		assertTrue(r1.isOver(r2));
	}

	@Test
	public void testRectangleIsOverMini4(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(0,2,1.0,1.0);
		assertTrue(r1.isOver(r2));
	}

	@Test
	public void testRectangleIsPoint1(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(0,0,3.0,3.0);
		assertEquals(4, r1.isInPointNum(r2));
	}

	@Test
	public void testRectangleIsPoint2(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(2.0,2.0,3.0,3.0);
		assertEquals(1, r1.isInPointNum(r2));
	}
	
	@Test
	public void testRectangleIsPoint3(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(2,2,1.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(1,3,3.0,1.0);
		assertEquals(0, r1.isInPointNum(r2));
	}
	
	@Test
	public void testRectangleIsPoint4(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,4.0,4.0);
		Main.Rectangle r2 = main.makeRectangle(2,2,3.0,1.0);
		assertEquals(2, r1.isInPointNum(r2));
	}
	
	@Test
	public void testRectangleIsPoint5(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(1,1,1.0,1.0);
		assertEquals(4, r1.isInPointNum(r2));
	}
	
	@Test
	public void testRectangleIsPointMini(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(2,2,1.0,1.0);

		assertEquals(4, r1.isInPointNum(r2));
	}
	
	@Test
	public void testRectangleEquals(){
		Main main = new Main();
		
		Main.Rectangle r1 = main.makeRectangle(0,0,3.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(0,0,3.0,3.0);
		assertEquals(r1,r2);
	}

	@Test
	public void testLinkedList(){
		Main main = new Main();
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		addRects.add(main.makeRectangle(1, 1, 1, 1));
		LinkedList<Main.Rectangle> addRects2 = new LinkedList<Main.Rectangle>();
		addRects2.add(main.makeRectangle(1, 1, 1, 1));
		
		assertTrue(checkLiknedList(addRects,addRects2));
	}

	private boolean checkLiknedList(LinkedList<Main.Rectangle> addRects,
			LinkedList<Main.Rectangle> ansRects) {
		if(addRects.size() != ansRects.size()){
			System.out.println(addRects.size() + " != " + ansRects.size());
			return false;
		}
		
		for(int i=0; i<addRects.size();i++){
			if(!(addRects.contains(ansRects.get(i)))){
				System.out.println(addRects.get(i));
				return false;
			}
		}
		return true;
	}
	
	private void printAll(LinkedList<Main.Rectangle> ar){
		for (Main.Rectangle rectangle : ar)
			System.out.println(rectangle);
	}

	@Test
	public void testRectangleIsOneOver1(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(0,0,2,2);
		Main.Rectangle r2 = main.makeRectangle(1,1,2,2);
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addOnePoint(r1, r2, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r1);
		ansRects.add(main.makeRectangle(2,1,1,2));
		ansRects.add(main.makeRectangle(1,2,1,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsOneOver2(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(1,0,2,2);
		Main.Rectangle r2 = main.makeRectangle(0,1,2,2);
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addOnePoint(r1, r2, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r1);
		ansRects.add(main.makeRectangle(0,1,1,2));
		ansRects.add(main.makeRectangle(1,2,1,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsOneOver3(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(0,0,2,2);
		Main.Rectangle r2 = main.makeRectangle(1,1,2,2);
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addOnePoint(r2, r1, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r1);
		ansRects.add(main.makeRectangle(2,1,1,2));
		ansRects.add(main.makeRectangle(1,2,1,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsOneOver4(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(1,0,2,2);
		Main.Rectangle r2 = main.makeRectangle(0,1,2,2);
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addOnePoint(r2, r1, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r1);
		ansRects.add(main.makeRectangle(0,1,1,2));
		ansRects.add(main.makeRectangle(1,2,1,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}
	
	@Test
	public void testRectangleIsTwoOver1(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(5,5,4,2);
		Main.Rectangle r2 = main.makeRectangle(4,4,4,4);
		
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addTwoPoint(r2, r1, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r2);
		ansRects.add(main.makeRectangle(8,5,1,2));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsTwoOver2(){
		Main main = new Main();

		Main.Rectangle small = main.makeRectangle(5,5,2,4);
		Main.Rectangle big = main.makeRectangle(4,4,4,4);
		
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addTwoPoint(big, small, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(big);
		ansRects.add(main.makeRectangle(5,8,2,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsTwoOver3(){
		Main main = new Main();

		Main.Rectangle small = main.makeRectangle(0,5,7,2);
		Main.Rectangle big = main.makeRectangle(4,4,4,4);
		
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addTwoPoint(big, small, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(big);
		ansRects.add(main.makeRectangle(0,5,4,2));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsTwoOver4(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(5,3,2,2);
		Main.Rectangle r2 = main.makeRectangle(4,4,4,4);
		
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addTwoPoint(r2, r1, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r2);
		ansRects.add(main.makeRectangle(5,3,2,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testRectangleIsZeroPoint1(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(2,2,1.0,3.0);
		Main.Rectangle r2 = main.makeRectangle(1,3,3.0,1.0);
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addZeroPoint(r1, r2, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r2);
		ansRects.add(main.makeRectangle(2,2,1,1));
		ansRects.add(main.makeRectangle(2,4,1,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}

	@Test
	public void testGetAns1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1, 1, 6, 6));
		rects.add(main.makeRectangle(2, 3, 6, 6));
		rects.add(main.makeRectangle(4.5, 3.5, 2, 2));
		
		assertEquals(52, (int)main.getAns(rects));
	}

	@Test
	public void testGetAns2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,6,6));
		rects.add(main.makeRectangle(0.5,0.5,2,2));
		
		assertEquals(36, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,6,6));
		rects.add(main.makeRectangle(6,6,6,6));
		
		assertEquals(72, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,4,4));
		rects.add(main.makeRectangle(0,2,5,3));
		
		assertEquals(23, (int)main.getAns(rects));
	}
	
	@Test
	public void testRectangleIsOnePoint(){
		Main main = new Main();

		Main.Rectangle r1 = main.makeRectangle(0,0,4,4);
		Main.Rectangle r2 = main.makeRectangle(0,2,5,3);
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addOnePoint(r1, r2, addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(r1);
		ansRects.add(main.makeRectangle(4,2,1,3));
		ansRects.add(main.makeRectangle(0,4,4,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}
	
	@Test
	public void testGetAns5_1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,4,4));
		rects.add(main.makeRectangle(0,2,5,1));
		
		assertEquals(17, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns5_2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,4,4));
		rects.add(main.makeRectangle(0,6,8,3));
		
		assertEquals(32, (int)main.getAns(rects));
	}
	
	@Test
	public void testOnePointSplit5_2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> addRects = new LinkedList<Main.Rectangle>();
		main.addOnePoint(main.makeRectangle(4,4,4,4), main.makeRectangle(0,6,8,3), addRects);
		
		LinkedList<Main.Rectangle> ansRects = new LinkedList<Main.Rectangle>();
		ansRects.add(main.makeRectangle(4,4,4,4));
		ansRects.add(main.makeRectangle(0,6,4,3));
		ansRects.add(main.makeRectangle(4,8,4,1));
		
		assertTrue(checkLiknedList(addRects, ansRects));
	}
	
	@Test
	public void testGetAns5_3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,3,2));
		rects.add(main.makeRectangle(1,1,2,2));
		
		assertEquals(8, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns5_4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,3,2));
		rects.add(main.makeRectangle(1,0,2,2));
		
		assertEquals(6, (int)main.getAns(rects));
	}
	
	
	@Test
	public void testGetAns6_1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,2,2));
		rects.add(main.makeRectangle(1,0,2,2));
		
		assertEquals(6, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns6_2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,2,2,2));
		
		assertEquals(6, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns6_3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,1,2,2));
		
		assertEquals(6, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns6_4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,0,2,2));
		
		assertEquals(6, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns7_1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,0,2,2));
		rects.add(main.makeRectangle(0,0,3,3));
		
		
		assertEquals(9, (int)main.getAns(rects));
	}
	@Test
	public void testGetAns7_2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,2,2));
		rects.add(main.makeRectangle(0,0,3,3));
		
		
		assertEquals(9, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns7_3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,0,3,3));
		
		
		assertEquals(9, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAns7_4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,1,2,2));
		rects.add(main.makeRectangle(0,0,3,3));
		
		assertEquals(9, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPoint_Ans6_1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,0,2,2));
		
		assertEquals(6, (int)main.getAns(rects));		
	}
	
	@Test
	public void testGetAnsTwoPoint_Ans6_2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,1,2,2));
		
		assertEquals(6, (int)main.getAns(rects));	
	}
	
	@Test
	public void testGetAnsTwoPoint_Ans6_3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(2,1,2,2));
		
		assertEquals(6, (int)main.getAns(rects));	
	}
	
	@Test
	public void testGetAnsTwoPoint_Ans6_4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,2,2,2));
		rects.add(main.makeRectangle(1,1,2,2));
		
		assertEquals(6, (int)main.getAns(rects));	
	}
	
	@Test
	public void testGetAnsNoOver_1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(0,0,3,3));
		rects.add(main.makeRectangle(3,2,2,2));
		
		assertEquals(13, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,1,3,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,2,3,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,1,1,3));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(2,1,1,3));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver5(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,1,3,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver6(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,2,3,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver7(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,0,1,3));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointTwoOver8(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(2,0,1,3));
		rects.add(main.makeRectangle(1,1,2,2));

		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,1,2,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(0,2,2,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(2,1,2,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(2,2,2,1));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver5(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,0,1,2));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver6(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(2,0,1,2));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver7(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(1,2,1,2));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoPointOneOver8(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(1,1,2,2));
		rects.add(main.makeRectangle(2,2,1,2));
		
		assertEquals(5, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo1(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(5,4,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo2(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(4,5,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo3(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(2,4,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo4(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(3,5,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo5(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(3,2,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo6(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(2,3,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo7(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(5,3,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
	
	@Test
	public void testGetAnsTwoMendo8(){
		Main main = new Main();
		
		LinkedList<Main.Rectangle> rects = new LinkedList<Main.Rectangle>();
		rects.add(main.makeRectangle(4,4,2,2));
		rects.add(main.makeRectangle(4,2,3,3));
		
		assertEquals(11, (int)main.getAns(rects));
	}
}
