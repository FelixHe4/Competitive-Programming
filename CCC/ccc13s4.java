package Unit1;
import java.io.*;
import java.util.*;

public class ccc13s4 {
	static class Node {
		ArrayList<Node> taller = new ArrayList<Node>();
		ArrayList<Node> shorter = new ArrayList<Node>();
		int visited = 0;
		int i = 0;

		public Node(int i) {
			this.i = i;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int peopleClass = Integer.parseInt(st.nextToken());
		Node[] arr = new Node[peopleClass + 1];
		int comparison = Integer.parseInt(st.nextToken());
		for (int i = 0; i < comparison; i++) {
			st = new StringTokenizer(in.readLine());
			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());
			if (arr[person2] == null) {
				arr[person2] = new Node(person2);
			}
			if (arr[person1] == null) {
				arr[person1] = new Node(person1);
			}
			arr[person1].taller.add(arr[person2]);
			arr[person2].shorter.add(arr[person1]);
		}
		st = new StringTokenizer(in.readLine());
		int taller = Integer.parseInt(st.nextToken());
		int shorter = Integer.parseInt(st.nextToken());

		ArrayDeque<Node> Q = new ArrayDeque<Node>();
		Q.addLast(arr[shorter]);
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				Node temp = Q.removeFirst();
				if (temp.i == taller) {
					System.out.println("yes");
					return;
				}
				for (int j = 0; j < temp.shorter.size(); j++) {
					temp.shorter.get(j).visited++;
					Q.addLast(temp.shorter.get(j));
				}
			}
		}

		Q = new ArrayDeque<Node>();
		Q.addLast(arr[shorter]);
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				Node temp = Q.removeFirst();
				if (temp.i == taller) {
					System.out.println("no");
					return;
				}
				for (int j = 0; j < temp.taller.size(); j++) {
					temp.taller.get(j).visited++;
					Q.addLast(temp.taller.get(j));
				}
			}
		}
		System.out.println("unknown");
	}
}