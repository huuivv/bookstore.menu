package bookstore.domain;

public interface CODE {
	int SHOP_LOGIN = 999;              //로그인 
	String SHOP_LOGIN_HOST = "host";   //주인 로그인정보
	String SHOP_LOGIN_GUEST = "guest"; //손님 로그인정보

	
	// 주인
	int HOST = 1;
	int HOST_BOOK = 110;        //재고관리
	int HOST_BOOK_LIST = 111;   //책 목록
	int HOST_BOOK_ADD = 112;    //책 추가
	int HOST_BOOK_UPDATE = 113; //책 수정
	int HOST_BOOK_DEL = 114;    //책 삭제

	int HOST_ORDER = 120;       //주문관리
	int HOST_ORDER_LIST = 121;  //주문 목록
	int HOST_ORDER_ADD = 122;   //주문 추가
	int HOST_ORDER_DEL = 123;   //주문 삭제

	
	// 손님
	int GUEST = 2;
	int GUEST_ORDER = 210;       //쇼핑
	int GUEST_ORDER_ADD = 211;   //구매
	int GUEST_ORDER_DEL = 212;   //환불		
}
