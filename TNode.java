package C7_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TNode {

	// 二叉树由结点组成
	// 每个结点都可以有左子结点，右子结点
	// 每个结点都有值

	TNode leftNode;
	TNode rightNode;
	Object value;

	public static void main(String[] args) {
		TNode tNode = new TNode();
		int values[] = new int[100000];
		
		for (int i = 0; i < values.length; i++) {
			values[i] = (int) (Math.random()*100);
			tNode.add(values[i]);
		}
		long start = System.currentTimeMillis();
		System.out.println(tNode.values());
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	// 插入
	public void add(Object v) {
		if(null == value) 
			value = v;
		else {
			if((Integer)v - (Integer)value <= 0) {
				if( null == leftNode)
					leftNode = new TNode();
				leftNode.add(v); // 递归
			} else {
				if( null == rightNode)
					rightNode = new TNode();
				rightNode.add(v); // 递归
			}
		}
	}
	
	// 中序遍历 
	public List<Object> values() {
		List<Object> list = new ArrayList<Object>();
		if(null != leftNode)
			list.addAll(leftNode.values());
		if(null != value)
			list.add(value);
		if(null != rightNode)
			list.addAll(rightNode.values()); // addAll 递归
		return list;
	}

}
