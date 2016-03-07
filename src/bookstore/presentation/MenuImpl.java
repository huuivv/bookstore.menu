package bookstore.presentation;

import java.util.HashMap;
import java.util.Map;

import bookstore.domain.CODE;

public class MenuImpl implements Menu {	
	private Map<Integer, String[]> menu; //메뉴	
	private StringBuffer buffer;	     //메뉴생성버퍼
	
	public MenuImpl() {	
		menu = new HashMap<Integer, String[]>();
		buffer = new StringBuffer();		
		setUp();
	}

	//메뉴를 준비한다.
	private void setUp() {
		menu.clear();
		menu.put(CODE.SHOP_LOGIN, item("주인", "손님"));
		menu.put(CODE.HOST, item("재고관리", "주문목록"));
		menu.put(CODE.HOST_BOOK, item("책목록", "책추가", "책수정", "책삭제"));		
		menu.put(CODE.GUEST, item("구매","환불"));		
	}

	//각 메뉴별 항목들을 준비한다.
	//param: item 메뉴 항목들
	private String[] item(String... item) {
		return item;
	}

	//메뉴 번호를 선택한다.
	//param: 기능코드번호
	private int choose(int code) {
		//메뉴 한줄 구성
		buffer.delete(0, buffer.capacity());
		String[] line = menu.get(code);
		for (int i = 0; i < line.length; i++) {
			buffer.append(i + 1);
			buffer.append(":");
			buffer.append(line[i]);
			buffer.append(", ");
		}
		buffer.append("0:종료");
		
		//메뉴 번호 입력
		boolean isOK = false;
		int choice = 0;
		do {
			Console.in(buffer.toString());
			choice = Console.nextInt();
			if (choice < 0 || choice > line.length)
				Console.err("존재하는 메뉴 번호를 입력하세요.");
			else isOK = true;
		} while (!isOK);
		return choice;
	}

	// 메뉴를 콘솔에 출력한다.
	public void play() {		
		int choice = 0; //메뉴선택번호
		while ((choice = choose(CODE.SHOP_LOGIN)) != 0) {			
			switch (choice) {
			case CODE.HOST: //1 주인
				while ((choice = choose(CODE.HOST)) != 0) {
					switch (CODE.HOST * 100 + choice * 10) {
					case CODE.HOST_BOOK: //110 재고관리
						while ((choice = choose(CODE.HOST_BOOK)) != 0) {
							switch (CODE.HOST_BOOK + choice) {
							case CODE.HOST_BOOK_LIST:   //111 책목록							
								Console.println("책목록 출력합니다."); break;							
							case CODE.HOST_BOOK_ADD:    //112 책추가								
								Console.println("책추가 합니다."); break;
							case CODE.HOST_BOOK_UPDATE: //113 책수정								
								Console.println("책수정 합니다."); break;	
							case CODE.HOST_BOOK_DEL:    //114 책삭제								
								Console.println("책삭제 합니다."); 
							}
						}
						break;
					case CODE.HOST_ORDER: //120 주문관리
						Console.println("주문목록 출력합니다.");//121 주문목록						
					}
				}
				break;
			case CODE.GUEST: // 2 손님
				while ((choice = choose(CODE.GUEST)) != 0) {					
					switch (CODE.GUEST_ORDER + choice) {
					case CODE.GUEST_ORDER_ADD:    //211 구매								
						Console.println("구매 합니다."); break;
					case CODE.GUEST_ORDER_DEL:    //212 환불								
						Console.println("환불 합니다."); 
					}
				}				
			}
		}
	}
}