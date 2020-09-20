//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
   
    	
    	int[] wwcR =  new int[2];
    	int[] wwcL  = new int[2];
    	int[] wwcU = new  int[2];
    	int[] wwcD = new int[2];
    	
    	int upCow = 0;
    	int rightCow = 0;
    	int downCow = 0;
    	int leftCow =  0;
    	
    	char cowStart;
    	
        
    	for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[y].length-3; x++) {
				if(field[y][x]=='c' && field[y][x+1]=='o' && field[y][x+2]=='w') {
					rightCow++;
					wwcR[0] = x;
					wwcR[1] = y;
					
			}
		}
    }		
    		
		
    	for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[y].length-3; x++) {
				if(field[y][x]=='w' && field[y][x+1]=='o' && field[y][x+2]=='c') {
					leftCow++;
					wwcL[0] = x;
					wwcL[1] = y;
			}
		}
    }
    	
    	for (int y = 0; y < field.length-3; y++) {
			for (int x = 0; x < field[y].length; x++) {
				if(field[y][x]=='c' && field[y+1][x]=='o' && field[y+2][x]=='w') {
					downCow++;
					wwcD[0] = x;
					wwcD[1] = y;
			}
		}
    }
    	
    	for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[y].length-3; x++) {
				if(field[y][x]=='w' && field[y][x+1]=='o' && field[y][x+2]=='c') {
					upCow++;
					wwcU[0] = x;
					wwcU[1] = y;
			}
		}
    }
    	
    	if(rightCow==1) {
    		return wwcR;
    	}
    	else if(leftCow==1) {
    		return wwcL;
    	}
    	else if(upCow==1) {
    		return wwcU;
    	}
    	else if(downCow==1) {
    		return wwcD;
    	}
    	
    	else {
    		return null;
    	}
    	
    	
       
    }
}
