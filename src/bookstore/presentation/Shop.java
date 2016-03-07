package bookstore.presentation;


//서점
public class Shop {	
	private Menu menu;  //메뉴	
	
	public Shop(){		
		menu = new MenuImpl();
	}
	
	//가게문을 열다
	public void open(){
		menu.play();
	}
}
