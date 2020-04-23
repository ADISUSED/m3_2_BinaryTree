package C7_BinaryTree;

public class Hero{
	public String name;
	public float hp;
	
	public Hero(String name) {
		this.name = name;
	}
	
	Hero(String name, float hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public String toString() {
		return name + ":" + hp;
	}
}
