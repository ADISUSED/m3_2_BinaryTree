package C7_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TNode {

	// �������ɽ�����
	// ÿ����㶼���������ӽ�㣬���ӽ��
	// ÿ����㶼��ֵ

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
	
	// ����
	public void add(Object v) {
		if(null == value) 
			value = v;
		else {
			if((Integer)v - (Integer)value <= 0) {
				if( null == leftNode)
					leftNode = new TNode();
				leftNode.add(v); // �ݹ�
			} else {
				if( null == rightNode)
					rightNode = new TNode();
				rightNode.add(v); // �ݹ�
			}
		}
	}
	
	// ������� 
	public List<Object> values() {
		List<Object> list = new ArrayList<Object>();
		if(null != leftNode)
			list.addAll(leftNode.values());
		if(null != value)
			list.add(value);
		if(null != rightNode)
			list.addAll(rightNode.values()); // addAll �ݹ�
		return list;
	}

}
