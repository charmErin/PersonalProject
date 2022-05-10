package project;

public class WaffleDTO {
	private Long id;
	private String charName;
	private String job;
	private int level;
	private int location;
	private int hp;
	private int mp;
	private int exp;

	public WaffleDTO() {
		
	}
	
	public WaffleDTO(Long id, String charName) {
		this.id = id;
		this.charName = charName;
		level = 1;
		job = "모험가";
		location = 1;
		hp = 50;
		mp = 50;
		exp = 0;
	}
	

	public WaffleDTO(Long id, String charName, int level, String job, int location, int hp, int mp, int exp) {
		this.id = id;
		this.charName = charName;
		this.level = level;
		this.job = job;
		this.location = location;
		this.hp = hp;
		this.mp = mp;
		this.exp = exp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "[" + charName + ", Lv." + level + ", " + job + ", Stage=" + location + ", HP="
				+ hp + ", MP=" + mp + ", EXP=" + exp + "]";
	}


	
	
	
	
}
