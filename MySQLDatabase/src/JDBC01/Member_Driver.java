package JDBC01;

import java.util.ArrayList;
import java.util.Calendar;
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
		//alter table 테이블명 auto_increment = 정수값;

		
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
		Member_Dao mdao = Member_Dao.getInstance();
		Member_Dto mdto = new Member_Dto();
		
		System.out.print("회원 이름을 입력하세요 : ");
		mdto.setName(sc.nextLine());
		
		System.out.print("핸드폰 번호를 입력하세요 : ");
		mdto.setPhone(sc.nextLine());
		
		System.out.print("생일을 입력하세요 : ");
		mdto.setBirth(sc.nextLine());

		Calendar today = Calendar.getInstance();
		int year = Integer.parseInt(String.valueOf(today.get(Calendar.YEAR)));
		int age = Integer.parseInt(mdto.getBirth().substring(0,4));
		year = year - age + 1;
		mdto.setAge(year );
		
		System.out.print("보유 포인트를 입력하세요 : ");
		mdto.setBpoint(Integer.parseInt(sc.nextLine()));
		
		while(true)
		{
			System.out.print("성별을 입력하세요 : ");
			String gender = sc.nextLine();
			if(gender.equals("M") || gender.equals("F"))
			{
				mdto.setGender(gender);
				break;
			}
			else {
				System.out.println("M(남성) 혹은 F(여성)만 입력 가능합니다.");
			}
		}
		
		int result = mdao.insert(mdto);
		
		if(result == 1)
			System.out.println("삽입 성공");
		else
			System.out.println("삽입 실패");
	}
}
