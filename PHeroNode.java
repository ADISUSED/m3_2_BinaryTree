package C7_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PHeroNode {
	PHeroNode leftNode;
	PHeroNode rightNode;
	Hero object;
	public static void main(String[] args) {
		// 长度为10的随机血量的英雄数组
		// 排倒序
		Hero heros[] = new Hero[10];
		for(int i = 0; i < heros.length; i++) {
			heros[i] = new Hero("hero " + i, (int)(Math.random()*1000+1));
		}
		
		PHeroNode phn = new PHeroNode();
		for(Hero hero : heros) {
			phn.add(hero);
		}
		
		List<Object> herosSort = phn.values();
		
		for(Object h : herosSort) {
			System.out.println(h);
		}	

	}

	private void add(Hero hero) {
		if(null == object)
			object = hero;
		else {
			if(hero.hp - object.hp >= 0) {
				if(null == leftNode)
					leftNode = new PHeroNode();
				leftNode.add(hero);
			} else {
				if(null == rightNode)
					rightNode = new PHeroNode();
				rightNode.add(hero);
			}
		}
	}
	private List<Object> values() {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<>();
		if(null != leftNode)
			list.addAll(leftNode.values());
		if(null != object)
			list.add(object);
		if(null != rightNode) {
			list.addAll(rightNode.values());
		}
		return list;
	}
}
