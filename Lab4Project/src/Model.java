import java.util.Scanner;

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
	private boolean doorKnock = false;
	private boolean openDoor = false;
	public String save() {
		String status = "";
		status += saveState();
		status += " " + saveBoolean(hasDoorKeys);
		status += " " + saveBoolean(hasHatchet);
		status += " " + saveBoolean(hasGun);
		status += " " + saveBoolean(hasSnowmobileKey);
		status += " " + saveBoolean(lockedCabin);
		status += " " + saveBoolean(hasMap);
		status += " " + saveBoolean(hasGas);
		status += " " + saveBoolean(seenPicture);
		status += " " + saveBoolean(doorBroken);
		status += " " + saveBoolean(doorKnock);
		status += " " + saveBoolean(openDoor);
		return status;

	}

	public void load(String status) {
		Scanner input = new Scanner(status);
		loadCurrentState(input.nextInt());
		hasDoorKeys = loadBoolean(input.next());
		hasHatchet = loadBoolean(input.next());
		hasGun = loadBoolean(input.next());
		hasSnowmobileKey = loadBoolean(input.next());
		lockedCabin = loadBoolean(input.next());
		hasMap = loadBoolean(input.next());
		hasGas = loadBoolean(input.next());
		seenPicture = loadBoolean(input.next());
		doorBroken = loadBoolean(input.next());
		doorKnock = loadBoolean(input.next());
		openDoor = loadBoolean(input.next());
		input.close();
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

	public void setCurrentState(TheState currentState) {
		this.currentState = currentState;
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

	public boolean getDoorKnock() {
		return doorKnock;
	}

	public void setDoorKnock(boolean doorKnock) {
		this.doorKnock = doorKnock;
	}

	public String saveState() {
		switch (currentState) {
		case MiddlePlane:
			return "1";
		case CockPit:
			return "2";
		case OutsidePlane:
			return "3";
		case CabinPorch:
			return "4";
		case CabinLivingRoom:
			return "5";
		case Kitchen:
			return "6";
		case Bedroom:
			return "7";
		case SnowMobile:
			return "8";
		case MainRoad:
			return "9";
		case OffRoad:
			return "10";
		case WoodPile:
			return "11";
		case Solved:
			return "12";
		default:
			return "-1";
		}
	}

	public void loadCurrentState(int state) {
		switch (state) {
		case 1:
			currentState = TheState.MiddlePlane;
			break;
		case 2:
			currentState = TheState.CockPit;
			break;
		case 3:
			currentState = TheState.OutsidePlane;
			break;
		case 4:
			currentState = TheState.CabinPorch;
			break;
		case 5:
			currentState = TheState.CabinLivingRoom;
			break;
		case 6:
			currentState = TheState.Kitchen;
			break;
		case 7:
			currentState = TheState.Bedroom;
			break;
		case 8:
			currentState = TheState.SnowMobile;
			break;
		case 9:
			currentState = TheState.MainRoad;
			break;
		case 10:
			currentState = TheState.OffRoad;
			break;
		case 11:
			currentState = TheState.WoodPile;
			break;
		case 12:
			currentState = TheState.Solved;
			break;

		}

	}

	public String saveBoolean(Boolean bool) {
		if (bool) {
			return "T";
		}
		return "F";
	}

	public boolean loadBoolean(String value) {
		return value.equals("T");
	}

	public boolean getOpenDoor() {
		return openDoor;
	}

	public void setOpenDoor(boolean openDoor) {
		this.openDoor = openDoor;
	}

}
