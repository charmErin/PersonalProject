package project;

import java.util.Scanner;

public class WaffleService {
	Scanner scan = new Scanner(System.in);
	WaffleStageService wss = new WaffleStageService();
	WaffleRepository wr = new WaffleRepository();
	static Long id = 0L;
	
	
	public String start(int choice) {
		String name = save();
		return name;
	}
	
	
	// 캐릭터 생성
	public String save() {
		WaffleDTO member = null;
		boolean run = true;
		
		while(run) {
			System.out.println("----------<캐릭터생성>----------");
			System.out.print("캐릭터 이름> ");
			String charName = scan.next();
			
			// 이름 중복 체크
			if (wr.checkId(charName)) {
				System.out.println("이미 사용중인 이름입니다. 다른 이름을 입력하세요.");
			} else {
				System.out.println(charName + "님 환영합니다.");
				member = new WaffleDTO(++id, charName);
				wr.save(member);
				System.out.println(member);
				
				run = false;
			}
		}
		weaponFirst(member);
		moveGo(member, member.getLocation());
		
		return member.getCharName();
	}
	
	
	// 캐릭터 생성시 무기 선택
	public void weaponFirst(WaffleDTO member) {
		System.out.println("------------------------");
		System.out.println("무기(weapon)을 선택해주세요.");
		System.out.println("무기 종류> 1.몽둥이 | 2.검");
		System.out.println("------------------------");
		System.out.print("무기 선택> ");
		int weapon1 = scan.nextInt();
		if (weapon1 == 1) {
			System.out.println(member.getCharName() + "님이 몽둥이를 장착했습니다.");
			System.out.println("-------------------------------");
		} else if (weapon1 == 2) {
			System.out.println(member.getCharName() + "님이 검을 장착했습니다.");
			System.out.println("-------------------------------");
		} else {
			System.out.println("1,2 중에 선택해주세요.");
		}
		locationNow(member.getLocation());
	}
	
	
	// 다음 스테이지 이동
	private void moveGo(WaffleDTO w, int location) {
		boolean run = true;
		int choice;
		while(run) {
			System.out.println("선택> 1.Next Stage 이동");
			System.out.print("선택> ");
			choice = scan.nextInt();
			if(choice == 1) {
				if(location == 1) {
					System.out.println("다음 스테이지로 이동합니다.");
					System.out.println("     ○");
					System.out.println("  ε=┌┤┘");
					System.out.println("<■__@@_□_____□_____□_____□>");
					System.out.println("---------------------------");
					location = wss.stage1(w);
				} else if(location == 2) {
					System.out.println("다음 스테이지로 이동합니다.");
					System.out.println("           ○");
					System.out.println("        ε=┌┤┘");
					System.out.println("<□_____■__@@_□_____□_____□>");
					System.out.println("---------------------------");
					location = wss.stage2(w);
				} else if(location == 3) {
					System.out.println("다음 스테이지로 이동합니다.");
					System.out.println("                 ○");
					System.out.println("              ε=┌┤┘");
					System.out.println("<□_____□_____■__@@_□_____□>");
					System.out.println("---------------------------");
					location = wss.stage3(w);
				} else if(location == 4) {
					System.out.println("다음 스테이지로 이동합니다.");
					System.out.println("                       ○");
					System.out.println("                    ε=┌┤┘");
					System.out.println("<□_____□_____□_____■__@@_□>");
					System.out.println("---------------------------");
					location = wss.stage4(w);
				} else if(location == 5) {
					run = false;
				}
			} else {
				System.out.println("1번만 선택 가능합니다.");
			}
		}
	}
	
	
	
	// 현재 위치 확인
	public void locationNow(int location) {
		if (location == 1) {
			System.out.println("<↓ 현재 위치>");
			System.out.println("<■_____□_____□_____□_____□>");
			System.out.println();
		} else if(location == 2) {
			System.out.println("      <↓ 현재 위치>");
			System.out.println("<□_____■_____□_____□_____□>");
			System.out.println();
		} else if(location == 3) {
			System.out.println("            <↓ 현재 위치>");
			System.out.println("<□_____□_____■_____□_____□>");
			System.out.println();
		} else if(location == 4) {
			System.out.println("                  <↓ 현재 위치>");
			System.out.println("<□_____□_____□_____■_____□>");
			System.out.println();
		} else if(location == 5) {
			System.out.println("                        <↓ 현재 위치>");
			System.out.println("<□_____□_____□_____□_____■>");
			System.out.println();
		}
		System.out.println("---------------------------");
	}
	
	// 전사
	public void fighter(String name) {
		System.out.println("---------------------");
		System.out.println("전사(파이터)로 전직합니다.");
		int fighter = 1;
		System.out.println(wr.changeJob(name, fighter));
		System.out.println("--------------");
		System.out.println("전직을 축하합니다.");
		System.out.println("무기 '하이랜더' 획득");
		System.out.println("--------------");
	}
	
	// 궁수
	public void hunter(String name) {
		System.out.println("-------------------");
		System.out.println("궁수(헌터)로 전직합니다.");
		int hunter = 2;
		System.out.println(wr.changeJob(name, hunter));
		System.out.println("--------------");
		System.out.println("전직을 축하합니다.");
		System.out.println("무기 '활' 획득");
		System.out.println("--------------");
		
	}

	// 마법사
	public void wizard(String name) {
		System.out.println("----------------------");
		System.out.println("마법사(위자드)로 전직합니다.");
		int wizard = 3;
		System.out.println(wr.changeJob(name, wizard));
		System.out.println("--------------");
		System.out.println("전직을 축하합니다.");
		System.out.println("무기 '스태프' 획득");
		System.out.println("--------------");
	}
	
	// 도적
	public void thief(String name) {
		System.out.println("---------------------");
		System.out.println("도적(시프)으로 전직합니다.");
		int thief = 4;
		System.out.println(wr.changeJob(name, thief));
		System.out.println("--------------");
		System.out.println("전직을 축하합니다.");
		System.out.println("무기 '표창' 획득");
		System.out.println("--------------");
	}
	
	// 보스잡기
	public void bossMop(String name, int job) {
		if(wr.bossAttack(name, job)) {
			System.out.println("보스 잡기 성공!!");
			System.out.println("고생하셨습니다. 미니게임 끝");
			System.out.println("----------------------");
		}
	}
	
	
}
