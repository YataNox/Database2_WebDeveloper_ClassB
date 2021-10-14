package JDBC01;

import java.util.ArrayList;
import java.util.Scanner;

public class Member_Driver
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		// 기능 실행 무한 반복
		while(true) {
			System.out.println("\n*** 메뉴 선택 ***");
			System.out.printf("1. 데이터추가. ");
			System.out.printf("2. 데이터열람. ");
			System.out.printf("3. 데이터수정. ");
			System.out.printf("4. 데이터삭제. ");
			System.out.println("5. 프로그램 종료. ");
			System.out.print(">> 메뉴선택 : ");
			String choice = sc.nextLine();
			
			// 5 입력시 프로그램 종료
			if(choice.equals("5"))
				break;
			
			// Rent_Dao를 공유해서 쓰는 방법 #1
			// Driver Class에서 객체를 생성하고 각 메소드에 전달인수로 전달
			// 공통적으로 사용할 멤버 접속 객체
			//Rent_Dao Rdao = Rent_Dao.getInstance();
			
			// 입력한 번호에 따른 기능 실행
			switch(choice) {
				case "1": 
					insert(sc); // 158 Line
					break;
				case "2":
					select(); // 140 Line
					break;
				case "3":
					update(sc); // 60 Line
					break;
				case "4":
					delete(sc); // 47 Line
					break;
				default:
					System.out.println("잘못 입력된 값입니다.");
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}

	private static void delete(Scanner sc) {
		
		
	}

	private static void update(Scanner sc) {
		
		
	}

	private static void select() {
		Member_Dao mdao = Member_Dao.getInstance();
		ArrayList<Member_Dto> list = mdao.selectAll();
		
		System.out.println("회원번호 \t  회원이름 \t\t 핸드폰번호 \t\t 성별\t 나이\t 생일 \t\t\t 가입날짜\t\t 포인트");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		for(Member_Dto mto : list)
		{ // list에 있는 값이 하나씩 dto에 저장
			System.out.printf("%s \t\t %-12s \t %13s\t %s\t %-2d\t %-10s\t %-10s\t %-6s\n",
					mto.getMembernum(), mto.getName(), mto.getPhone(), mto.getGender(), 
					mto.getAge(), mto.getBirth(), mto.getJoindate(), mto.getBpoint());
		}
		
	}

	private static void insert(Scanner sc) {
		
		
	}
}
