package com.edu.test;
/*
 Singletone Pattern (- static과의 연관?)
   1. 클래스 안에서 하나의 인스턴스는 일단 생성
   private static으로..
   2. 다른 클래스에서는 생성 못 하도록 막아둔다.
   private 생성자(){
   3. 하나 만들어놓은 객체를 여기 저기서 갖다 쓰도록 
   public static 객체명 getInstance(){
   
 */
class Service{
	//1. 
	private static Service service = new Service();
	//2.
	private Service() { //객체 생성 막는다
		System.out.println("Singletone...");
	}
	//3.
	public static Service getInstance() { //얘를 쓰려면 메모리에 올려야 되는데 -> 객체 생성해야 되는데 private으로 객체 생성 막아서 얘도 못 씀
		//그래서 static으로 바꿔줌
		return service;
	}
}
public class StaticExamTest3 {

	public static void main(String[] args) {
		Service s1 = Service.getInstance();
		Service s2 = Service.getInstance();
		Service s3 = Service.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

}
