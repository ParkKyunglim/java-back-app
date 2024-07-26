package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	
	private static Scanner scanner = new Scanner(System.in); 
	private static List<Account> accounts = new ArrayList<>(); 
		
	public static void main(String[] args) {
	
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			 if (selectNo == 1) {
	                createAccount();
	            } else if (selectNo == 2) {
	                accountList();
	            } else if (selectNo == 3) {
	                deposit();
	            } else if (selectNo == 4) {
	                withdraw();
	            } else if (selectNo == 5) {
	                run = false;
	            } 
	        }
		System.out.println("프로그램 종료");
	 }
	
	
		
	  private static void createAccount() {
	        System.out.println("---------");
	        System.out.println("계좌생성");
	        System.out.println("---------");
	        
	        
	        System.out.print("계좌번호: ");
	        String ano = scanner.next();
	        System.out.print("계좌주: ");
	        String owner = scanner.next();
	        System.out.print("초기입금액: ");
	        int balance = scanner.nextInt();
	        
	        System.out.println("계좌가 생성되었습니다.");
	        
	        Account ac = new Account(ano, owner, balance);
	        accounts.add(ac);  // 리스트에 계좌 추가
	        scanner.nextLine();
	  }
	        
	    
	   

	    private static void accountList() {
	        System.out.println("----------");
	        System.out.println("계좌목록");
	        System.out.println("----------");
	        for (Account account : accounts) {
	            System.out.println("계좌번호: " + account.getAno() + ", 계좌주: " + account.getOwner() + ", 잔고: " + account.getBalance());
	        }
	    }

	    private static void deposit() {
			System.out.println("--------");
			System.out.println("예금");
			System.out.println("--------");
			System.out.print("계좌번호: ");
			String ano = scanner.next();
			System.out.print("예금액: ");
			int deposit = scanner.nextInt();

			if (findAccount(ano) == null) {
				System.out.println("입력한 계좌번호를 찾지 못했습니다.");
			} else {
				findAccount(ano).setBalance(findAccount(ano).getBalance() + deposit);
				System.out.println("결과: 입금이 성공되었습니다.");
			}
			scanner.nextLine();
			
	    }

	    private static void withdraw() {
			System.out.println("--------");
			System.out.println("출금");
			System.out.println("--------");
			System.out.print("계좌번호: ");
			String ano = scanner.next();
			System.out.print("출금액: ");
			int withd = scanner.nextInt();

			if (findAccount(ano) == null) {
				System.out.println("입력한 계좌번호를 찾지 못했습니다.");
			} else {
				if (withd > findAccount(ano).getBalance()) {
					System.out.println("잔액보다 큰 액수를 입력하셨습니다.");
				} else {
					findAccount(ano).setBalance(findAccount(ano).getBalance() - withd);
					System.out.println("결과: 출금이 성공되었습니다.");
				}
			} 
			scanner.nextLine();
		}

	    private static Account findAccount(String ano) {
	        for (Account account : accounts) {
	            if (account.getAno().equals(ano)) {
	                return account;
	            }
	        }
	        return null;
	    }
	}
