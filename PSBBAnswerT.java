package C7_BinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ��ϰ ѡ������ð�����򣬶��������򣬴���ϰ ����
public class PSBBAnswerT {
	
	// ͬһ���飬����������
	// ����������鷵��
	// �ж���������Ƿ���ͬ
	// Sort����ӿ� ���򷽷���������������鷽��
	// SelectionSortʵ�ֽӿ�Sort  ��Ա ���飻���� ���췽�������򷽷���������������鷽��
	// BubbleSortʵ�ֽӿ�Sort
	// TreeSortʵ�ֽӿ�Sort
	
	// ˽�к���performance(Sort algorithm, String type)
	
	// ������ϰȱ��
	// δ���Ǹ���Դ������в�ͬ�㷨����
	// ѡ���������ѭ��-1��ð�������ڲ�ѭ��length-���ѭ������-1
	
	
	public static void main(String[] args) {
		// ��ʼ������Ϊ40000����������飬����Ԫ�ط�ΧΪ0-40000
		int count = 4*1000*10;
		int[] randoms = new int[count];
		for(int i = 0; i < count; i++) {
			randoms[i] = (int) (Math.random()*count);
		}
		
		// ����
		int[] use4Sort;
		
		use4Sort = Arrays.copyOf(randoms, randoms.length);
		int[] selectSorted = performance(new SelectionSort(use4Sort), "ѡ��");
		
		use4Sort = Arrays.copyOf(randoms, randoms.length);
		int[] bubbleSorted = performance(new BubbleSort(use4Sort), "ð�ݷ�");
		
		use4Sort = Arrays.copyOf(randoms, randoms.length);
		int[] treeSorted = performance(new TreeSort(use4Sort), "������");
		// ������
		System.out.println(selectSorted);
		System.out.println(bubbleSorted);
		System.out.println(treeSorted);
		
		// ������������Ƿ���ͬ
		System.out.println(selectSorted.equals(bubbleSorted));
		System.out.println(bubbleSorted.equals(treeSorted));
		System.out.println(Arrays.equals(selectSorted, bubbleSorted));
		System.out.println(Arrays.equals(bubbleSorted, treeSorted));
		
	}
	
	interface Sort {
		void sort();
		int[] values();
	}
	
	static class TreeSort implements Sort {
		int[] numbers;
		TNode n;
		
		public TreeSort(int[] numbers) {
			n = new TNode();
			this.numbers = numbers;
		}
		
		@Override
		public void sort() {
			// TODO Auto-generated method stub
			for(int i : numbers) {
				n.add(i);
			}
		}

		@Override
		public int[] values() {
			// TODO Auto-generated method stub
			List<Object> values = n.values();
			int[] treeSorted = new int[values.size()];
			for(int i = 0; i < treeSorted.length; i++) {
				treeSorted[i] = Integer.parseInt(values.get(i).toString());
			}
			return treeSorted;
		}
		
	}
	
	static class BubbleSort implements Sort {
		int[] numbers;
		
		BubbleSort(int[] numbers) {
			this.numbers = numbers;
		}
		
		@Override
		public void sort() {
			for(int i = 0; i <numbers.length; i++) {
				for(int j = 0; j < numbers.length-i-1; j++) { 
					if(numbers[j] > numbers[j+1]) {
						int temp = numbers[j];
						numbers[j] = numbers[j+1];
						numbers[j+1] = temp;
					}
				}
			}
			
		}

		@Override
		public int[] values() {
			// TODO Auto-generated method stub
			return numbers;
		}
		
	}
	
	static class SelectionSort implements Sort {

		int[] numbers;
		
		public SelectionSort(int[] numbers) {
			this.numbers = numbers;
		}
		
		@Override
		public void sort() {
			
			for(int i = 0; i < numbers.length-1; i++) {
				for(int j = i+1; j < numbers.length; j++) {
					if(numbers[i] > numbers[j]) {
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
			
		}

		@Override
		public int[] values() {
			// TODO Auto-generated method stub
			return numbers;
		}
		
	}
	
	private static int[] performance(Sort algorithm, String type) {
		long start = System.currentTimeMillis();
		algorithm.sort();
		long end = System.currentTimeMillis();
		int[] sortedNumber = algorithm.values();
		System.out.printf("%s ���򣬺�ʱ %d ����%n", type, (end-start));
		return sortedNumber;
	}
	
	
	

}
