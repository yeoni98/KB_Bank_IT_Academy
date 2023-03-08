package com.kb.cms;

public class Test {

	public static void main(String[] args) {
		ICustMgr mgr = new CustManager();
		mgr.save(new Customer(1001, "kim", "seoul"));
		mgr.save(new Customer(1002, "lim", "incheon"));
		mgr.save(new Customer(1003, "choi", "busan"));
		mgr.save(new VipCustomer(2001, "kim", "busan", "11가1234"));
		mgr.save(new VipCustomer(2002, "lee", "suwon","violin", "21가1234"));
		
		System.out.println("=== 전체 검색 ===");
		mgr.sortedSearch();

		System.out.println("=== 1003 검색 ===");
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 1003 수정 ===");
		mgr.update(1003, "seoul");
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 1003 삭제 ===");
		mgr.delete(1003);
		System.out.println(mgr.search(1003));
		
		System.out.println("=== 전체 검색 ===");
		mgr.search();
	}

}
