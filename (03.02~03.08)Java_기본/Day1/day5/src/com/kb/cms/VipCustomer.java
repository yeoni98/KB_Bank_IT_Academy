package com.kb.cms;

public class VipCustomer extends Customer { // 상속 받았으니, num, name, address 3개가 있는 상태
	String hobby;
	String carNumber;
	public VipCustomer() {
		super();
	}
	public VipCustomer(int num, String name, String address, String hobby, String carNumber) {
		super(num, name, address); // source -using field 에서 상속받은 3개도 받고 싶을때 설정할 때 Customer(int, String, String)선택해줌
		this.hobby = hobby;
		this.carNumber = carNumber;
	}
	public VipCustomer(int num, String name, String address,  String carNumber) {
		this(num, name, address,"", carNumber); //this()로 하면 vipCustomer가 불러지니, (num,name,..)으로 /this. = 나. this()= 나의 생성자
	                   // super()로 하면 안 됨. 
	}
	@Override // 컴파일러에게 Overriding 문법이 맞는지 체크 요청
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VipCustomer [");
		builder.append(super.toString()); //왜 굳이 super. ? 나에게도 toString이 있기 때문에 위에 builder 계속 불러올 것
		builder.append(", hobby=");
		builder.append(hobby);
		builder.append(", carNumber=");
		builder.append(carNumber);
		builder.append("]");
		return builder.toString();
	}
	

	

}
