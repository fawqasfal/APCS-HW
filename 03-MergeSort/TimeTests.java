//see if i could just use functions as parameters like any language worth a shit allows you to this wouldnt be so ugly
import java.util.*;
public class TimeTests {
	static int[] stopNums = {50000,100000,100000,200000,200000};
	public static void main(String[] args) {
		System.out.println("Bubble");
		System.out.println(timeTestBubble());
		System.out.println("Insert");
		System.out.println(timeTestInsert());
		System.out.println("Radix");
		System.out.println(timeTestRadix());
		System.out.println("Merge");
		System.out.println(timeTestMerge());
		System.out.println("Tweaked Quicksort");
		System.out.println(timeTestGod());
	}
	public static String timeTestBubble() {
		String answer = "";
		for (int i = 0; i <= stopNums[0]; i+= 2500) {
			double[] array = SortDriver.genDouble(i);
			long time = System.currentTimeMillis();
			Sort.bubble(array);
			long elapsedTime = System.currentTimeMillis() - time;
			double finalTime = elapsedTime / 1000.0;
			answer += i + " " + finalTime + "\n";		
		}
		return answer;
	}
	public static String timeTestInsert() {
		String answer = "";
		for (int i = 0; i <= stopNums[1]; i+= 2500) {
			double[] array = SortDriver.genDouble(i);
			long time = System.currentTimeMillis();
			Sort.insert(array);
			long elapsedTime = System.currentTimeMillis() - time;
			double finalTime = elapsedTime / 1000.0;
			answer += i + " " + finalTime + "\n";		
		}
		return answer;
	}
	public static String timeTestRadix() {
		String answer = "";
		for (int i = 0; i <= stopNums[2]; i+= 2500) {
			double[] array = SortDriver.genDouble(i);
			long time = System.currentTimeMillis();
			Sort.radix(array);
			long elapsedTime = System.currentTimeMillis() - time;
			double finalTime = elapsedTime / 1000.0;
			answer += i + " " + finalTime + "\n";		
		}
		return answer;
	}
	public static String timeTestMerge() {
		String answer = "";
		for (int i = 0; i <= stopNums[3]; i+= 2500) {
			double[] array = SortDriver.genDouble(i);
			long time = System.currentTimeMillis();
			Sort.radix(array);
			long elapsedTime = System.currentTimeMillis() - time;
			double finalTime = elapsedTime / 1000.0;
			answer += i + " " + finalTime + "\n";		
		}
		return answer;
	}
	public static String timeTestGod() {
		String answer = "";
		for (int i = 0; i <= stopNums[4]; i+= 2500) {
			double[] array = SortDriver.genDouble(i);
			long time = System.currentTimeMillis();
			Arrays.sort(array);
			long elapsedTime = System.currentTimeMillis() - time;
			double finalTime = elapsedTime / 1000.0;
			answer += i + " " + finalTime + "\n";		
		}
		return answer;
	}
}