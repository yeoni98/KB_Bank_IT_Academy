package com.kb.cms;

public interface ICustMgr {

	// 저장
	void save(Customer c);

	// 검색
	void search();
	public void sortedSearch();
	// 상세검색
	Customer search(int num);
/**
 * 주어진 고객번호를 검색하여 주소를 수정한다.
 * @param num : 고객번호
 * @param address : 수정된 주소
 */
	// 수정 : 고객 주소 수정
	// 고객 정보 검색 - 주소 수정
	void update(int num, String address);

	// 삭제
	void delete(int num);

}