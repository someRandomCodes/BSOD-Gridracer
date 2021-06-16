package settingMenue;

public class SoundSettings {
	private int volume =-80;
	private int musik = 1;
	
	public int getVolume() {
		volume = Panel_Sounds.volume();
		return volume;
	}
	public int getMusik() {
		musik =Panel_Sounds.music();
		return musik;
	}
}
