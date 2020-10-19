import java.util.ArrayList;

// return current status as arrayList of strings
// return current menu as arrayList of strings

// do something based on choice (int)








public abstract class State {
private ArrayList<String> menu = new ArrayList<String>();
private ArrayList<String> message = new ArrayList<String>();
private int choice; 
private Model model; 
	public State(Model model) {
		this.model = model;
		setMenu(menu);
		setMessage(message);
	}
abstract TheState choice(int choice);

abstract void setMenu(ArrayList<String> menu);

public ArrayList<String> getMenu(){
		return menu;
	}
public ArrayList<String> getMessage() {
	return message;
}
	abstract void setMessage(ArrayList<String> message);

// logic to deal with answer
	
public Model getModel() {
	return model;

}	
	
	






}
