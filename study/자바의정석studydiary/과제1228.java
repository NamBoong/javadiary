package �ڹ�������studydiary;

public class ����1228 {

	public static void main(String[] args) {

		int[] arr = {4,7,1,1,3,7,6,2,4,4,2,8,3,9,2};

		// arr�迭 �� ���� ������ŭ bucket �迭�� �ȿ� ���� ��.	
		int[] bucket = new int[arr.length];
		
		
		// ��Ŷ������ �̿��Ͽ� �� index�� �ȿ� ������� ���� ��.
		for(int i=0; i<arr.length; i++) {
			bucket[arr[i]]++;
		}
		
		System.out.print("1. �ߺ����� = ");
		
		// bucket�� index ���� �ƴ϶� index�� ��½�Ų��.
		for(int i=0; i<bucket.length; i++) {
			if(bucket[i]!=0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		
		System.out.print("2. ���� = ");
		
		// bucket�� index ���� 0�� �ƴϸ� ��½�Ű��, i�� �������� ���ϵ��� i�� �̸� ���ش�. �׷� if�� �ڿ� i++ ��.
		for(int i=0; i<bucket.length; i++) {
			if(bucket[i]!=0) {
				System.out.print(i + " ");
				bucket[i]--;
				i--;
			}
		}
		
	}

}
