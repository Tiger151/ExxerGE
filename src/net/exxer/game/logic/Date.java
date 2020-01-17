package net.exxer.game.logic;

import org.json.JSONObject;

import net.exxer.game.Handler;
import net.exxer.game.utils.Utils;

public class Date{
	private Handler handler;
	private int day = 0;
	private long startTime = 0;
	private long elapsedTime = 0L;
	private JSONObject prop;
	
	public Date(Handler handler) {
		this.handler = handler;
		prop = new JSONObject(Utils.loadFileAsString("res/data/dates.json"));
	}
	public void update(){
		//here the events/news will appear via json file
		/*switch(day) {
		case 0: System.out.println("First date filler");
			
		}*/
		
//Trigger new date counter / resume from paused
		if(startTime == 0L) {
			startTime = System.currentTimeMillis();
			return;
		}
//Any tick in between desired time interval of 1 second
		if(elapsedTime < 1){
			elapsedTime += (System.currentTimeMillis() -  startTime) / 1000;
		}
//When desired time interval is reached, perform action, then reset counter		
		if(elapsedTime == 1){
			System.out.println(day);
			day++;
			elapsedTime = 0;
			startTime = 0L;
		}
//Used for resuming from a paused state
		if(elapsedTime >= 2) {
			elapsedTime = 0;
			startTime = 0L;
		}
		
		
		
		
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public String getDateName(int day) {
		return prop.getJSONObject(Integer.toString(day)).getString("date");
	}
	public String getDateEvent(int day) {
		return prop.getJSONObject(Integer.toString(day)).getString("event");
	}
	
	/*@Override
	public void run() {
		if(!handler.isPaused()) {
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0L;
			while(elapsedTime < 3) {
				elapsedTime += (System.currentTimeMillis() -  startTime) / 1000;
				if(elapsedTime == 2){
					update();
					elapsedTime = 0;
					return;
				}
			}
		}
	}*/
	
	
	
	
}
