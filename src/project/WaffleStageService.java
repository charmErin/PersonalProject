package project;

import java.util.Scanner;

public class WaffleStageService {
	Scanner scan = new Scanner(System.in);
	WaffleRepository wr = new WaffleRepository();

	public int stage1(WaffleDTO man) {
		wr.stage1(man);

		WaffleService ws = new WaffleService();
		ws.locationNow(man.getLocation());

		System.out.println("<!신규 퀘스트!> 달팽이 3마리를 잡으세요.");
		System.out.println(" ____@_____@_____@___");

		WaffleDTO newMan = null;
		for (int count = 0; count < 3 && man.getLocation() == 2;) {
			MonsterDTO monster = new MonsterDTO("달팽이", 5, 5, 20);
			System.out.println("---------------------------------");
			System.out.println("!" + monster.getName() + " 등장!");
			System.out.println(monster);

			while (monster.getHp() > 0 && man.getHp() > 0) {

				System.out.println("-----------------------");
				System.out.println("선택> 1. 공격 | 2. 지나가기");
				System.out.println("-----------------------");
				System.out.print("선택> ");
				int attackOrAvoid = scan.nextInt();

				if (attackOrAvoid == 1) {
					System.out.println("몽둥이(검) 휘두르기!!");
					newMan = wr.attack(attackOrAvoid, monster, man);
					System.out.println();
				} else if (attackOrAvoid == 2) {
					System.out.println(monster.getName() + "의 공격을 받았습니다.");
					newMan = wr.avoid(attackOrAvoid, man, monster);
					System.out.println();
				} else {
					System.out.println("1~2번 중에 선택해주세요.");
				}
			}
			if (man.getLocation() == 2) {
				System.out.println("---------------------------------");
				System.out.println("Q. 달팽이 3마리 잡기: " + ++count + "/3 완료");
				System.out.println();
				if (count == 3) {

					newMan = wr.levelUp(man);
					System.out.println("축! 퀘스트 완료 exp+150");
					newMan.setExp(newMan.getExp() + 150);
					newMan = wr.levelUp(newMan);

				}
			} else {
				newMan.setHp(50);
				System.out.println("현재 " + newMan.getCharName() + "님의 hp: " + newMan.getHp());
			}

		}

		System.out.println("---------------------------------");

		return newMan.getLocation();
	}

	public int stage2(WaffleDTO man) {
		wr.stage2(man);
		WaffleService ws = new WaffleService();
		ws.locationNow(man.getLocation());

		System.out.println("<!신규 퀘스트!> 파란달팽이 3마리를 잡으세요.");
		System.out.println(" ____@_____@_____@___");

		WaffleDTO newMan = null;
		for (int count = 0; count < 3 && man.getLocation() == 3;) {
			MonsterDTO monster = new MonsterDTO("파란달팽이", 10, 10, 30);
			System.out.println("---------------------------------");
			System.out.println("!" + monster.getName() + " 등장!");
			System.out.println(monster);

			while (monster.getHp() > 0 && man.getHp() > 0) {

				System.out.println("--------------------------");
				System.out.println("선택목록> 1. 공격 | 2. 지나가기");
				System.out.println("--------------------------");
				System.out.print("선택> ");
				int attackOrAvoid = scan.nextInt();

				if (attackOrAvoid == 1) {
					System.out.println("몽둥이(검) 휘두르기!!");
					newMan = wr.attack(attackOrAvoid, monster, man);
				} else if (attackOrAvoid == 2) {
					System.out.println(monster.getName() + "의 공격을 받았습니다.");
					newMan = wr.avoid(attackOrAvoid, man, monster);
				} else {
					System.out.println("1~2번 중에 선택해주세요.");
				}
			}
			if (man.getLocation() == 3) {
				System.out.println("---------------------------------");
				System.out.println("Q. 파란달팽이 3마리 잡기: " + ++count + "/3 완료");
				if (count == 3) {
					System.out.println("축! 퀘스트 완료 exp+300");
					newMan.setExp(newMan.getExp() + 300);
					newMan = wr.levelUp(newMan);
				}
			} else {
				newMan.setHp(100);
				System.out.println("현재 " + newMan.getCharName() + "님의 hp: " + newMan.getHp());
			}

		}

		System.out.println("---------------------------------");

		return newMan.getLocation();
	}

	public int stage3(WaffleDTO man) {
		wr.stage3(man);
		WaffleService ws = new WaffleService();
		ws.locationNow(man.getLocation());

		System.out.println("<!신규 퀘스트!> 빨간달팽이 3마리를 잡으세요.");
		System.out.println(" ____@_____@_____@___");

		WaffleDTO newMan = null;
		for (int count = 0; count < 3 && man.getLocation() == 4;) {
			MonsterDTO monster = new MonsterDTO("빨간달팽이", 15, 15, 50);
			System.out.println("---------------------------------");
			System.out.println("!" + monster.getName() + " 등장!");
			System.out.println(monster);

			while (monster.getHp() > 0 && man.getHp() > 0) {

				System.out.println("--------------------------");
				System.out.println("선택목록> 1. 공격 | 2. 지나가기");
				System.out.println("--------------------------");
				System.out.print("선택> ");
				int attackOrAvoid = scan.nextInt();

				if (attackOrAvoid == 1) {
					System.out.println("몽둥이(검) 휘두르기!!");
					newMan = wr.attack(attackOrAvoid, monster, man);
					if (man.getExp() >= 300) {
						man = wr.levelUp(man);

					}
				} else if (attackOrAvoid == 2) {
					System.out.println(monster.getName() + "의 공격을 받았습니다.");
					newMan = wr.avoid(attackOrAvoid, man, monster);
				} else {
					System.out.println("1~2번 중에 선택해주세요.");
				}
			}
			if (man.getLocation() == 4) {
				System.out.println("---------------------------------");
				System.out.println("Q. 빨간달팽이 3마리 잡기: " + ++count + "/3 완료");
				if (count == 3) {
					System.out.println("축! 퀘스트 완료 exp+450");
					newMan.setExp(newMan.getExp() + 450);
					newMan = wr.levelUp(newMan);
				}
			} else {
				newMan.setHp(100);
				System.out.println("현재 " + newMan.getCharName() + "님의 hp: " + newMan.getHp());
			}

		}

		System.out.println("---------------------------------");

		return newMan.getLocation();
	}

	public int stage4(WaffleDTO man) {
		wr.stage4(man);
		WaffleService ws = new WaffleService();
		ws.locationNow(man.getLocation());

		System.out.println("<!신규 퀘스트!> 빨간달팽이 5마리를 잡으세요.");
		System.out.println(" ____@_____@_____@___");

		WaffleDTO newMan = null;
		for (int count = 0; count < 5 && man.getLocation() == 5;) {
			MonsterDTO monster = new MonsterDTO("빨간달팽이", 15, 10, 50);
			System.out.println("---------------------------------");
			System.out.println("!" + monster.getName() + " 등장!");
			System.out.println(monster);

			while (monster.getHp() > 0 && man.getHp() > 0) {

				System.out.println("--------------------------");
				System.out.println("선택목록> 1. 공격 | 2. 지나가기");
				System.out.println("--------------------------");
				System.out.print("선택> ");
				int attackOrAvoid = scan.nextInt();

				if (attackOrAvoid == 1) {
					System.out.println("몽둥이(검) 휘두르기!!");
					newMan = wr.attack(attackOrAvoid, monster, man);
				} else if (attackOrAvoid == 2) {
					System.out.println(monster.getName() + "의 공격을 받았습니다.");
					newMan = wr.avoid(attackOrAvoid, man, monster);
				} else {
					System.out.println("1~2번 중에 선택해주세요.");
				}
			}
			if (man.getLocation() == 5) {
				System.out.println("---------------------------------");
				System.out.println("Q. 빨간달팽이 5마리 잡기: " + ++count + "/5 완료");
				if (count == 5) {
					System.out.println("축! 퀘스트 완료 exp+750");
					newMan.setExp(newMan.getExp() + 750);
					newMan = wr.levelUp(newMan);
					newMan = wr.levelUp(newMan);
				}
			} else {
				newMan.setHp(100);
				System.out.println("현재 " + newMan.getCharName() + "님의 hp: " + newMan.getHp());
			}

		}

		System.out.println("---------------------------------");

		return newMan.getLocation();
	}
}
