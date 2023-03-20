/**
 * 
 * @author venkateswarlu
 *
 */
public class Fan {

	private static int STOPPED=0;
	private static int SLOW=1;
	private static int MEDIUM=2;
	private static int FAST=3;
	
	private int fanSpeed=STOPPED;
	private boolean isFanOn;
	private double fanRadius=6;
	private String fanColor;
	
	public Fan() {
		
	}
	
	public Fan(int fanSpeed, boolean isFanOn, double fanRadius, String fanColor) {
		
		this.fanSpeed = fanSpeed;
		this.isFanOn = isFanOn;
		this.fanRadius = fanRadius;
		this.fanColor = fanColor;
	}


	 
	 
	public int getFanSpeed() {
		return fanSpeed;
	}

	
	
	public void setFanSpeed(int fanSpeed) {
		this.fanSpeed = fanSpeed;
	}


	
	public boolean isFanOn() {
		return isFanOn;
	}

	
	 
	public void setFanOn(boolean isFanOn) {
		this.isFanOn = isFanOn;
	}


	public double getFanRadius() {
		return fanRadius;
	}


	public void setFanRadius(double fanRadius) {
		this.fanRadius = fanRadius;
	}



	
	public String getFanColor() {
		return fanColor;
	}


	
	public void setFanColor(String fanColor) {
		this.fanColor = fanColor;
	}

	
	@Override
	public String toString() {
		if(isFanOn) {
			return "The Fan speed is set to " +fanSpeed +" with a color of "+ fanColor +" and radius is of "  + fanRadius;
		}else {
			return "The Fan is white with a radious of " + fanRadius + " and the fan is off";
		}
		
	}

	
	
	
}