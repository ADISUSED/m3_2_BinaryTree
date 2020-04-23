package C7_BinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 练习 选择排序，冒泡排序，二叉树排序，答案练习 分析
public class PSBBAnswerT {
	
	// 同一数组，拷贝再排序
	// 排序后以数组返回
	// 判断排序后结果是否相同
	// Sort排序接口 排序方法，返回排序后数组方法
	// SelectionSort实现接口Sort  成员 数组；方法 构造方法，排序方法，返回排序后数组方法
	// BubbleSort实现接口Sort
	// TreeSort实现接口Sort
	
	// 私有函数performance(Sort algorithm, String type)
	
	// 自我练习缺陷
	// 未考虑复制源数组进行不同算法排序
	// 选择排序外层循环-1，冒泡排序内层循环length-外层循环变量-1
	
	
	public static void main(String[] args) {
		// 初始化长度为40000的随机数数组，数组元素范围为0-40000
		int count = 4*1000*10;
		int[] randoms = new int[count];
		for(int i = 0; i < count; i++) {
			randoms[i] = (int) (Math.random()*count);
		}
		
		// 排序
		int[] use4Sort;
		
		use4Sort = Arrays.copyOf(randoms, randoms.length);
		int[] selectSorted = performance(new SelectionSort(use4Sort), "选择法");
		
		use4Sort = Arrays.copyOf(randoms, randoms.length);
		int[] bubbleSorted = performance(new BubbleSort(use4Sort), "冒泡法");
		
		use4Sort = Arrays.copyOf(randoms, randoms.length);
		int[] treeSorted = performance(new TreeSort(use4Sort), "二叉树");
		// 判数组
		System.out.println(selectSorted);
		System.out.println(bubbleSorted);
		System.out.println(treeSorted);
		
		// 判排序后内容是否相同
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
		System.out.printf("%s 排序，耗时 %d 毫秒%n", type, (end-start));
		return sortedNumber;
	}
	
	
	

}
