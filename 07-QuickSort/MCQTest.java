import java.util.*;
public class MCQTest {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		for (int i = 1; i <= 8; i++) {
			a.add(new Integer(i));
		}
		for (int j = 1; j < 4; j++) {
			a.remove(j);
		}
		System.out.println(a.toString());
	}
}