package web.controller;

public class RegisterController implements Controller{

	@Override
	public String handle() {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 폼 값 받아서
		 * 2. vo 생성
		 * 3. DAO리턴받고... register()호출
		 * 4. 네비게이션
		 */
		System.out.println("RegisterController.. member register..");
		
		return "register_result.jsp";
	}

}
