package Unit2;
import java.io.*;
import java.util.*;
import java.util.Map.*;
public class ecoo14r3p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, ArrayList<String>> fam = new HashMap<>();
		int names = Integer.valueOf(br.readLine());
		String temp = "";
		for (int x = 0; x < names; x++) {
			temp = br.readLine();
			String mom = temp.split(" ")[0];
			String d = temp.split(" ")[1];
			if (!fam.containsKey(mom)) {
				fam.put(mom, new ArrayList<String>());
			}
			fam.get(mom).add(d);
		}
		for (int i = 0; i < 10; i++) {
			String name = br.readLine();
			String mom = null;
			String momMom = null;
			int sisters = 0, cousins = 0;
			for (Entry<String, ArrayList<String>> entry : fam.entrySet()) {
				if (entry.getValue().contains(name)) {
					mom = entry.getKey();
					sisters = entry.getValue().size() - 1;
					break;
				}
			}
			for (Entry<String, ArrayList<String>> entry : fam.entrySet()) {
				if (entry.getValue().contains(mom)) {
					momMom = entry.getKey();
					break;
				}
			}
			for (String s : fam.get(momMom)) {
				if (s.equals(mom))
					continue;
				if (!fam.containsKey(s))
					continue;
				cousins += fam.get(s).size();
			}
			System.out.println("Cousins: " + cousins + ", Sisters: " + sisters);
		}
	}
}