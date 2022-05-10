package project;

public class MonsterDTO {
	public String name;
	public int hp;
	public int attack;
	public int giveExp;
	
	public MonsterDTO() {
		
	}
	
	public MonsterDTO(String name, int hp, int attack, int giveExp) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.giveExp = giveExp;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getGiveExp() {
		return giveExp;
	}

	public void setGiveExp(int giveExp) {
		this.giveExp = giveExp;
	}

	@Override
	public String toString() {
		return "[" + name + ", hp=" + hp + ", 공격력=" + attack + "]";
	}
	
	
	
	
}
