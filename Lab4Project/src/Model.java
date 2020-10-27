
public class Model {
	private TheState currentState = TheState.MiddlePlane;
	private boolean hasDoorKeys = false;
	private boolean hasHatchet = false;
	private boolean hasGun = false; 
	private boolean hasSnowmobileKey = false;
	private boolean lockedCabin = true;
	private boolean hasMap = false;
	private boolean hasGas = false;
	private boolean seenPicture = false;
	private boolean doorBroken = false;
	private boolean planeOpen = false; 
	public void save () {
		String status = "";
		
		
		
	}
	
	
	
	
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

	public boolean getHasSnowmobileKey() {
		return hasSnowmobileKey;
	}

	public void setHasSnowmobileKey(boolean hasSnowmobileKey) {
		this.hasSnowmobileKey = hasSnowmobileKey;
	}

	public boolean getLockedCabin() {
		return lockedCabin;
	}

	public void setLockedCabin(boolean lockedCabin) {
		this.lockedCabin = lockedCabin;
	}

	public boolean getHasMap() {
		return hasMap;
	}

	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
	}

	public boolean getHasGas() {
		return hasGas;
	}

	public void setHasGas(boolean hasGas) {
		this.hasGas = hasGas;
	}

	public boolean getSeenPicture() {
		return seenPicture;
	}

	public void setSeenPicture(boolean seenPicture) {
		this.seenPicture = seenPicture;
	}

	public boolean getDoorBroken() {
		return doorBroken;
	}

	public void setDoorBroken(boolean doorBroken) {
		this.doorBroken = doorBroken;
	}

	public boolean getPlaneOpen() {
		return planeOpen;
	}

	public void setPlaneOpen(boolean planeOpen) {
		this.planeOpen = planeOpen;
	}

}
