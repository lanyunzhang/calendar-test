/*
 * 
 * 
 * Problem Statement
    
Crow Keith is looking at the goose cage in the zoo. The bottom of the cage is divided into a grid of square cells. 
There are some birds sitting on those cells (with at most one bird per cell). Some of them are geese and all the others are ducks.
 Keith wants to know which birds are geese. He knows the following facts about them:
There is at least one goose in the cage.


You are given a String[] field and the int dist. The array field describes the bottom of the cage. 
Each character of each element of field describes one of the cells. The meaning of individual characters follows.
The character 'v' represents a cell that contains a bird.
The character '.' represents an empty cell.
Return the number of possible sets of geese in the cage, modulo 1,000,000,007. 
Note that for some of the test cases there can be no possible sets of geese.
Definition
    
Class:
GooseInZooDivTwo
Method:
count
Parameters:
String[], int
Returns:
int   zhanglanyun               zhanglanyun
Method signature:
int count(String[] field, int dist)
(be sure your method is public)
    

Notes
-
The Manhattan distance between cells (a,b) and (c,d) is |a-c| + |b-d|, where || denotes absolute value.
 In words, the Manhattan distance is the smallest number of steps needed to get from one cell to the other, 
 given that in each step you can move to a cell that shares a side with your current cell.
Constraints
-
field will contain between 1 and 50 elements, inclusive.
-
Each element of field will contain between 1 and 50 characters, inclusive.
-
Each element of field will contain the same number of characters.
-
Each character of each element of field will be 'v' or '.'.
-
dist will be between 0 and 100, inclusive.
Examples
0)

    
{"vvv"}
0
Returns: 7
There are seven possible sets of positions of geese: "ddg", "dgd", "dgg", "gdd", "gdg", "ggd", "ggg" ('g' are geese and 'd' are ducks).
1)

    
{"."}
100
Returns: 0
The number of geese must be positive, but there are no birds in the cage.
2)

    
{"vvv"}
1
Returns: 1

3)
{"v.v..................v............................"
,".v......v..................v.....................v"
,"..v.....v....v.........v...............v......v..."
,".........vvv...vv.v.........v.v..................v"
,".....v..........v......v..v...v.......v..........."
,"...................vv...............v.v..v.v..v..."
,".v.vv.................v..............v............"
,"..vv.......v...vv.v............vv.....v.....v....."
,"....v..........v....v........v.......v.v.v........"
,".v.......v.............v.v..........vv......v....."
,"....v.v.......v........v.....v.................v.."
,"....v..v..v.v..............v.v.v....v..........v.."
,"..........v...v...................v..............v"
,"..v........v..........................v....v..v..."
,"....................v..v.........vv........v......"
,"..v......v...............................v.v......"
,"..v.v..............v........v...............vv.vv."
,"...vv......v...............v.v..............v....."
,"............................v..v.................v"
,".v.............v.......v.........................."
,"......v...v........................v.............."
,".........v.....v..............vv.................."
,"................v..v..v.........v....v.......v...."
,"........v.....v.............v......v.v............"
,"...........v....................v.v....v.v.v...v.."
,"...........v......................v...v..........."
,"..........vv...........v.v.....................v.."
,".....................v......v............v...v...."
,".....vv..........................vv.v.....v.v....."
,".vv.......v...............v.......v..v.....v......"
,"............v................v..........v....v...."
,"................vv...v............................"
,"................v...........v........v...v....v..."
,"..v...v...v.............v...v........v....v..v...."
,"......v..v.......v........v..v....vv.............."
,"...........v..........v........v.v................"
,"v.v......v................v....................v.."
,".v........v................................v......"
,"............................v...v.......v........."
,"........................vv.v..............v...vv.."
,".......................vv........v.............v.."
,"...v.............v.........................v......"
,"....v......vv...........................v........."
,"....vv....v................v...vv..............v.."
,".................................................."
,"vv........v...v..v.....v..v..................v...."
,".........v..............v.vv.v.............v......"
,".......v.....v......v...............v............."
,"..v..................v................v....v......"
,".....v.....v.....................v.v......v......."}
3
Returns: 797922654

 * Class:
GooseInZooDivTwo
Method:
count
Parameters:
String[], int
Returns:
int
Method signature:
int count(String[] field, int dist)
(be sure your method is public)
 */
public class GooseInZooDivTwo {
	
	private position [] po= new position[50];
	
	int k = 0;
	int max = 0;
	int re = 0;
	public int count(String[] field ,int dist){
		int length = field.length;
		
		for(int i=0;i<length ;i++){
			String  s = field[i];
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)=='v')
					po[k++] = new position(i,j);		
			}
		}
		
		for(int i=0;i<k;i++){
			re=doWork(po[i],i,dist);
			max += (int)Math.pow(2,re);
		}

		return max;
	}
	
	public int doWork(position p,int i,int dist){
		
		int resu = 0;
		for(int m=i;m<k;m++){
			
			if(Math.abs(po[m].x - po[i].x) + Math.abs(po[m].y-po[i].y) > dist){
				resu += 1;
			}
		}
		
		return resu;
	}
	
	class position{
		int x;
		int y;
		
		position(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	
	public static void main(String[] args){
		GooseInZooDivTwo ginz = new GooseInZooDivTwo();
		int re = ginz.count(new String[]{"vvv"}, 1);
		System.out.println(re);
		
	}

}

//{ ...V...V...V}
