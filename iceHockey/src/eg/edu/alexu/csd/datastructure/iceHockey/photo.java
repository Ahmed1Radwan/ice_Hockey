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
	
	public void posDirections(int i, int j, String[] photo, char team) {
		Point p = new Point(i, j);
		if (photo[i] == null) return;
		
		if (j >= photo[1].length() || j < 0) return;

		if (photo[i].charAt(j) != team) return;
		
		if (Points.contains(p)) return;
		
		max_X = Math.max(2 * (j - 1) + 2, max_X);
		max_Y = Math.max(2 * i, max_Y);
		min_X = Math.min(2 * (j - 1), min_X);
		min_Y = Math.min(2 * i - 2, min_Y);
		
		Points.add(p);
		area += 4;
		
		posDirections(i + 1, j, photo, team);
		posDirections(i - 1, j, photo, team);
		posDirections(i, j + 1, photo, team);
		posDirections(i, j - 1, photo, team);

	}
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		Point[] ans = new Point[1000];
		int count = 0;
		int i = 1;
		while (photo[i] != null) {
			for (int j = 0; j < photo[i].length(); j++) {
				area = 0;
				max_X = -1;
				min_X = 10000;
				max_Y = -1;
				min_Y = 10000;
				char t = photo[i].charAt(j);
				Point a = new Point(i, j);
				team = (char) (team + '0');
				if (t == team && !Points.contains(a)) {
					posDirections(i, j, photo, t);
					if (area >= threshold) {
						int x = (((max_X + min_X)/2)+2);
						int y = (max_Y + min_Y) / 2 ;
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
