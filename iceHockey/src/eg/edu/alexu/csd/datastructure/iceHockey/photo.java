package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class photo implements IPlayersFinder{
	static HashSet<Point> Points = new HashSet<Point>();
	 static int area = 0;
	 static int max_X = -1;
	 static int min_X = 10000;
	 static int max_Y = -1;
	 static int min_Y = 10000;
	
	public void pos(int i,int j,String[] photo,char team) {
		 
		 	Point p = new Point(i, j);
		 	if(i < 0) return;
			if (photo[i] == null) return;
			
			if (j >= photo[1].length() || j < 0) return;

			if (photo[i].charAt(j) != team) return ;
			
			if (Points.contains(p)) return;
			
			Points.add(p);
			area += 4;
			
			pos(i + 1, j, photo, team);
			max_X = Math.max(max_X, i);
			pos(i - 1, j, photo, team);
			min_X = Math.min(min_X, i);
			pos(i, j + 1, photo, team);
			max_Y = Math.max(max_Y, j);
			pos(i, j - 1, photo, team);
			min_Y = Math.min(min_Y, j);
			return;
	 }
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		Point[] ans = new Point[1000];
		int count = 0;
		int i = 0;
		while (photo[i] != null) {
			for (int j = 0; j < photo[i].length(); j++) {

				char t = photo[i].charAt(j);
				Point a = new Point(i, j);
				char q = (char) (team+'0');
				if (t == q && !Points.contains(a)) {
					min_Y = j;
					min_X = i;
					max_X = -1;
					max_Y = -1;
					pos(i,j,photo,t);
					if (area >= threshold) {
						int y = (max_X + min_X +1);
						int x = (min_Y + max_Y +1);
						ans[count] = new Point(x,y);
						count++;
					}
				}
			}
			i++;
		}
		
		Arrays.sort(ans, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				if (a == null || b == null) {
					return 0;
				}
				int Comp_x = Integer.compare(a.x, b.x);
				if (Comp_x == 0)
					return Integer.compare(a.y, b.y);
				else
					return Comp_x;
			}
		});
		
		for (i = 0; i < count; i++) {
			System.out.println(ans[i]);
		}
		return ans;
	}

}
