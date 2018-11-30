package Unit2;
import java.io.*;
public class ecoo15r1p1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			String input = br.readLine();
			double orange = 0;
			double blue = 0;
			double green = 0;
			double yellow = 0;
			double pink = 0;
			double violet = 0;
			double brown = 0;
			double red = 0;
			while (!input.equals("end of box")) {
				if (input.equals("orange")) {
					orange++;
				}
				else if (input.equals("blue")) {
					blue++;
				}
				else if (input.equals("green")) {
					green++;
				}
				else if (input.equals("yellow")) {
					yellow++;
				}
				else if (input.equals("pink")) {
					pink++;
				}
				else if (input.equals("violet")) {
					violet++;
				}
				else if (input.equals("brown")) {
					brown++;
				}
				else if (input.equals("red")) {
					red++;
				}
				input = br.readLine();
			}
			double time = 0;
			int total = 0;
			total += Math.ceil(orange / 7.0);
			total += Math.ceil(blue / 7.0);
			total += Math.ceil(green / 7.0);
			total += Math.ceil(yellow / 7.0);
			total += Math.ceil(pink / 7.0);
			total += Math.ceil(violet / 7.0);
			total += Math.ceil(brown / 7.0);
			time += red * 16;
			time += total * 13;
			System.out.println((int) time);

		}
	}

}
