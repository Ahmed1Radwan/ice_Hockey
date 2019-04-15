package eg.edu.alexu.csd.datastructure.iceHockey;

import java.util.Scanner;

public class Finder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = new String[10000];
		str[1] = sc.next();
		int teamNum;
		int threshold;
		int i = 1;
		while (str[i].charAt(str[i].length() - 1) != '.') {
			i++;
			str[i] = sc.next();
		}
		teamNum=sc.nextInt();
		threshold=sc.nextInt();
		IPlayersFinder finder=new photo();
		finder.findPlayers(str,teamNum, threshold);
	}

}
