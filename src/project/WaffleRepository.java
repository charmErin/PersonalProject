package project;

import java.util.ArrayList;
import java.util.List;

public class WaffleRepository {
	static List<WaffleDTO> charList = new ArrayList<>();
	
	public boolean checkId(String charName) {
		boolean result = false;
		for(int i=0; i<charList.size(); i++) {
			if(charName.equals(charList.get(i).getCharName())) {
				result = true;
			}
		}
		return result;
	}
	
	// 캐릭터 저장
	public void save(WaffleDTO member) {
		charList.add(member);
	}
	
	public void stage1(WaffleDTO man) {
		man.setLocation(2);
	}
	
	public void stage2(WaffleDTO man) {
		man.setLocation(3);
	}
	
	public void stage3(WaffleDTO man) {
		man.setLocation(4);
	}
	
	public void stage4(WaffleDTO man) {
		man.setLocation(5);
	}
	
	// 기본 공격
	public WaffleDTO attack(int attack, MonsterDTO monster, WaffleDTO man) {
			int randomAttack = (int)(Math.random() * monster.getHp()) +1;
			System.out.println(monster.getName() + "hp-" + randomAttack);
			monster.setHp(monster.getHp() - randomAttack);
			if (monster.getHp() > 0) {
				System.out.println("현재 " + monster.getName() + " hp: " + monster.getHp());
			} else {
				System.out.println(monster.getName() + "잡기 성공!");
				System.out.println("exp+" + monster.getGiveExp());
				man.setExp(man.getExp() + monster.getGiveExp());
				System.out.println("현재 " + man.getCharName() + "님 exp: " + man.getExp());
			}
			
			return man;
	}
		
	
	// 기본 지나가기
	public WaffleDTO avoid(int avoid, WaffleDTO man, MonsterDTO monster) {
		man.setHp(man.getHp() - monster.getAttack());
		if(man.getHp() > 0) {
			System.out.println("현재" + man.getCharName() + "님 hp: " + man.getHp());
		} else {
			System.out.println(man.getCharName() + "님이 사망하셨습니다.");
			int randomMinusExp = (int)(Math.random() * 70) +1;
			if (man.getExp() > randomMinusExp) {
				System.out.println(man.getCharName() + "님의 exp -" + randomMinusExp);
				man.setExp(man.getExp() - randomMinusExp);
				System.out.println("현재 exp: " + man.getExp());
			}
			man.setLocation(1);
			man.setHp(30);
			System.out.println("마을로 돌아갑니다.");
		}
		return man;
	}
	
	// 레벨업
	public WaffleDTO levelUp(WaffleDTO newMan) {
		System.out.println();
		System.out.println("    /\\     /\\        ");
		System.out.println("   /  \\   /  \\     ");
		System.out.println("    ┃┃     ┃┃         ");
		System.out.println("    ┃┃     ┃┃         ");
		System.out.println("  !! LEVEL UP !!");
		System.out.println();
		
		if(newMan.getLevel()==1 && newMan.getExp()>=50) {
			newMan.setLevel(2);
			newMan.setHp(70);
			newMan.setMp(70);
			newMan.setExp(newMan.getExp()-50);
			System.out.println(newMan);
		} else if(newMan.getLevel()==2  && newMan.getExp()>=100) {
			newMan.setLevel(3);
			newMan.setHp(100);
			newMan.setMp(100);
			newMan.setExp(newMan.getExp()-150);
			System.out.println(newMan);
		} else if(newMan.getLevel()==3  && newMan.getExp()>=250) {
			newMan.setLevel(4);
			newMan.setHp(150);
			newMan.setMp(150);
			newMan.setExp(newMan.getExp()-250);
			System.out.println(newMan);
		} else if(newMan.getLevel()==4 && newMan.getExp()>=300) {
			newMan.setLevel(5);
			newMan.setHp(200);
			newMan.setMp(200);
			newMan.setExp(newMan.getExp()-300);
			System.out.println(newMan);
		} else if(newMan.getLevel()==5 && newMan.getExp()>=350) {
			newMan.setLevel(6);
			newMan.setHp(250);
			newMan.setMp(250);
			newMan.setExp(newMan.getExp()-350);
			System.out.println(newMan);
		} else if(newMan.getLevel()==6 && newMan.getExp()>=400) {
			newMan.setLevel(7);
			newMan.setHp(300);
			newMan.setMp(300);
			newMan.setExp(newMan.getExp()-400);
			System.out.println(newMan);
		} else if(newMan.getLevel()==7 && newMan.getExp()>=450) {
			newMan.setLevel(8);
			newMan.setHp(350);
			newMan.setMp(350);
			newMan.setExp(newMan.getExp()-450);
			System.out.println(newMan);
		}
		return newMan;
		
	}
	
	public WaffleDTO changeJob(String name, int job) {
		WaffleDTO member = null;
		for(int i=0; i<charList.size(); i++) {
			if(name.equals(charList.get(i).getCharName())) {
				member = charList.get(i);
				if(job == 1)
					member.setJob("파이터");
				else if(job == 2)
					member.setJob("헌터");
				else if(job == 3)
					member.setJob("위자드");
				else if(job == 4)
					member.setJob("시프");
			}
		}
		return member;
	}
	
	public boolean bossAttack(String name, int job) {
		boolean result = false;

		System.out.println("완전 큰 달팽이 마노 등장!!");
		System.out.println("맹공격을 시작합니다.");
		
		for(int i=0; i<charList.size(); i++) {
			if(name.equals(charList.get(i).getCharName())) {
				if(job == 1)
					System.out.println("파워 검 휘두르기!");
				else if(job == 2)
					System.out.println("연속 활 쏘기!");
				else if(job == 3)
					System.out.println("썬콜 번개 치기!");
				else if(job == 4)
					System.out.println("표창 연속 던지기!");
				
				result = true;
			}
		}
		
		return result;
	}
	
}
