

public class View {
	private State state;
	public View(State state) {
		 this.state = state;
	}
	
	
	
	public void printCurrentMessage() {
		for(int j = 0; j < state.getMessage().size(); j++) {
			System.out.println(state.getMessage().get(j));
			
		}
		
	}

	public void printMenu() {
		for(int i = 0; i < state.getMenu().size(); i++) {
		System.out.println((i+1) + state.getMenu().get(i));
		
		}
		
	}





}
