package C7_BinaryTree;

public class PSBB {

	// Practice2 Selected Bubble BinaryTree sort
	// 4万个随机数，比较三种排序方式的性能
	
	public static void main(String[] args) {
		// 4万个随机数
		int count = 4*1000*10;
		int[] randoms = new int[count];
		for(int i = 0; i < count; i++) {
			randoms[i] = (int) (Math.random()*900+100);
		}
		// 选择排序
		//show(randoms);
		long start = System.currentTimeMillis();
		selectedSort(randoms);
		//show(randoms);
		long end = System.currentTimeMillis();
		System.out.println("Selected Sort " + (end-start));
		
		for(int i = 0; i < count; i++) {
			randoms[i] = (int) (Math.random()*900+100);
		}
		// 冒泡排序
		//show(randoms);
		start = System.currentTimeMillis();
		bubbleSort(randoms);
		end = System.currentTimeMillis();
		System.out.println("Bubble Sort " + (end-start));
		//show(randoms);
		
		for(int i = 0; i < count; i++) {
			randoms[i] = (int) (Math.random()*900+100);
		}
		// 二叉树排序
		//show(randoms);
		start = System.currentTimeMillis();
		binaryTree(randoms);
		end = System.currentTimeMillis();
		System.out.println("Binary Sort " + (end-start));

	}

	private static void binaryTree(int[] randoms) {
		TNode node = new TNode();
		for(int h : randoms) {
			node.add(h);
		}
		node.values();
		//System.out.println();
	}

	private static void bubbleSort(int[] randoms) {
		int temp = 0;
		for(int i = 0; i <randoms.length; i++) {
			for(int j = 0; j < randoms.length-i-1; j++) { // randoms.length-i-1
				if(randoms[j] > randoms[j+1]) {
					temp = randoms[j];
					randoms[j] = randoms[j+1];
					randoms[j+1] = temp;
				}
			}
		}
		
	}

	private static void show(int[] randoms) {
		for(int i : randoms) {
			System.out.printf(i + " ");
		}
		System.out.println();
	}

	private static void selectedSort(int[] randoms) {
		
		for(int i = 0; i < randoms.length-1; i++) { // randoms.length-1
			for(int j = i+1; j < randoms.length; j++) {
				int temp = randoms[i];
				if(randoms[i] > randoms[j]) {
					randoms[i] = randoms[j];
					randoms[j] = temp;
				}
			}
		}
		
	}

}
