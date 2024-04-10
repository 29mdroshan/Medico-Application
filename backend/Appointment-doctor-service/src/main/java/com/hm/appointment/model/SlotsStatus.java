package com.hm.appointment.model;

public enum SlotsStatus {
	SLOTBOOKED(0),
	SLOTNOTBOOKED(1);
	
	int value;
	
	private SlotsStatus(int value) {
		this.value=value;
	}


}
