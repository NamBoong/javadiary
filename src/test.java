import java.util.Arrays;

class test {
	public static void main(String[] args) {
		System.out.println("�Ű������� ����" + args.length);
		for(int i=0; i<args.length; i++) {
			System.out.println("args[" + i + "] = \"" + args[i] + "\"");
		}
		
		System.out.printf("��� �׽�Ʈ %n123%n");
		
		String a = "abcde";
		System.out.println(a.toCharArray());
		
		int[] arr = {3,2,0,1};
		Arrays.sort(arr);
		System.out.print(Arrays.toString(arr));
	}
}
