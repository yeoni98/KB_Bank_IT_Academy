package com.itskb.ws03.dto;
// 같은 패키지 쓰기 때문에 따로 import 안 해도 됨
public class BankService {

		final int ACCOUNT_SIZE = 5;
		final int USER_SIZE = 10;
		int aIndex = 0;
		int uIndex = 0;
		AccountDto[] accountList;
		UserDto[] userList;
		
		public BankService() { // 기본 생성자 안에 배열을 생성하라
			accountList = new AccountDto[ACCOUNT_SIZE];
			userList = new UserDto[USER_SIZE];
			//공통 이름 바꾸기 refactor - rename
			userList[uIndex++] = new UserDto(1001,"kim","222@22.co.kr","010-222-3333", false);
			userList[uIndex++] = new UserDto(1002,"lee","322@22.co.kr","010-111-3333", true);
			userList[uIndex++] = new UserDto(1003,"kang","422@22.co.kr","010-212-3333", false);
			accountList[aIndex++]=new AccountDto(1, "11-111",500000, 1001);
			accountList[aIndex++]=new AccountDto(2, "21-111",500000, 1003);
			accountList[aIndex++]=new AccountDto(3, "31-111",500000, 1001);
		}
		public AccountDto[] getAccountList(int userSeq) {
			//(1001)인 사용자 번호인 user 2개 정보를 꺼내야 한다
			//배열 생성을 위한 결과 데이터 개수를 체크
			int count = 0;
			for(int i=0; i<aIndex; i++) {
				if (accountList[i].userSeq==userSeq) {
					count++; // 참일 때마다 1씩 증가함
//					System.out.println(accountList[i]);
				}

		
		}
		//배열 생성
		AccountDto[] result = new AccountDto[count];
		// 결과 데이터 담기
		int ix = 0;
		for(int i=0; i<aIndex; i++) {
			if (accountList[i].userSeq==userSeq) {
				result[ix++] = accountList[i];
			}
			
		}
		return result;
		
		
		
		

	}
		public UserDto getUserDetail(int userSeq) {
			UserDto result = null;
			for(int i=0; i<uIndex; i++) {
				if (userList[i].userSeq==userSeq) {
					result = userList[i];
					break;
				}
				
			}
			return result;
		}

}
