
public class Model {
	private TheState currentState = TheState.MiddlePlane;
	private boolean hasDoorKeys = false;
	private boolean hasHatchet = false;
	private boolean hasGun = false; 
	public boolean getHasHatchet() {
		return hasHatchet;
	}

	public void setHasHatchet(boolean hasHatchet) {
		this.hasHatchet = hasHatchet;
	}

	public boolean getHasGun() {
		return hasGun;
	}

	public void setHasGun(boolean hasGun) {
		this.hasGun = hasGun;
	}

	public TheState getCurrentState() {
		return currentState;
	}

	public boolean getDoorKeys() {
		return hasDoorKeys;
	}
	public void setHasDoorKeys(boolean hasDoorKeys) {
		this.hasDoorKeys = hasDoorKeys; 
	}

}
