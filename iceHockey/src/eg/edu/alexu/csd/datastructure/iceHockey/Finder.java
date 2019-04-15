package eg.edu.alexu.csd.datastructure.iceHockey;

import java.util.Scanner;

public class Finder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = new String[10000];
		System.out.println("Enter String Array space them by Enter last input of string element put . like (11111.) this is the last input");
		str[0] = sc.next();
		int teamNum;
		int threshold;
		int i = 0;
		while (str[i].charAt(str[i].length() - 1) != '.') {
			i++;
			str[i] = sc.next();
		}
		System.out.println("enter team and threshold");
		teamNum=sc.nextInt();
		threshold=sc.nextInt();
		IPlayersFinder finder=new photo();
		finder.findPlayers(str,teamNum, threshold);
	}

}
