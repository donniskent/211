import java.util.ArrayList;

public abstract class State {
	private ArrayList<String> menu = new ArrayList<String>();
	private ArrayList<String> message = new ArrayList<String>();
	private Model model;

	public State(Model model) {
		this.model = model;
	}

	abstract TheState choice(int choice);

	abstract void setMenu(ArrayList<String> menu);

	public ArrayList<String> getMenu() {
		return menu;
	}

	public ArrayList<String> getMessage() {
		return message;
	}

	abstract void setMessage(ArrayList<String> message);

	public Model getModel() {
		return model;

	}

}
