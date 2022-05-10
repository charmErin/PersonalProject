package project;

import java.util.Scanner;

public class WaffleMain {

	public static void main(String[] args) {
		// 와플 스토리
		
		Scanner scan = new Scanner(System.in);
		
		WaffleService ws = new WaffleService();
		boolean run = true;
		String name = "";
		
		
		end:
		while(run) {
			int choice = 0;
			while(run) {
				System.out.println("새로운 게임시작을 원하시면 1(YES)을 선택해주세요.");
				System.out.println("---------------------");
				System.out.println("1.YES | 2.NO | 3.END");
				System.out.println("---------------------");
				System.out.print("선택> ");
				choice = scan.nextInt();
			
				if(choice == 1) {
					System.out.println("게임을 시작해볼까요?");			
					name = ws.start(choice);
					break;
				} else if(choice == 2) {
					System.out.println("왜요ㅠㅠㅠ 해봐요ㅠㅠㅠ 다시 실행해줘요.");
					System.out.println();
				} else if(choice == 3){
					break end;
				} else { 
					System.out.println("다른 선택권은 없어요. 보기 중에 선택해주세요.");
					System.out.println();
				}
			}
			
			if(choice == 1) {
				if(name != null) {
					System.out.println("레벨 8 달성으로 전직 가능");
					System.out.println("-------------------------------");
					System.out.println("1.전사 | 2.궁수 | 3.마법사 | 4.도적");
					System.out.println("-------------------------------");
					System.out.print("선택> ");
					choice = scan.nextInt();
					
					System.out.println("보스를 잡아볼게요.");
					
					if(choice == 1) {
						ws.fighter(name);
						ws.bossMop(name, choice);
					} else if(choice == 2) {
						ws.hunter(name);
						ws.bossMop(name, choice);
					} else if(choice == 3) {
						ws.wizard(name);
						ws.bossMop(name, choice);
					} else if(choice == 4) {
						ws.thief(name);
						ws.bossMop(name, choice);
					} else {
						System.out.println("1~4중에 선택해주세요.");
					}
				}
			}
		
		}


	}

}
