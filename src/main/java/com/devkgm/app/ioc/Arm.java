package com.devkgm.app.ioc;

public abstract class Arm {
	private String direction;
	public abstract void act();
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
