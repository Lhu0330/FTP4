package com.bitc.team5.dto;

import lombok.Data;

@Data
public class SheduleDto {
	
	private int sheduleCode;
	private String className;
	private String startDate;
	private String endDate;
	//private String allDay;
	
//	private String title;
//	private String start;
//	private String end;
//	private String allday;

	
	private int id; 
	private String groupId;
	private String title; 
	private String writer; 
	private String content;
	private String start; 
	private String end;
	private boolean allday; 
	private String textColor;
	private String backgroundColor;
	private String borderColor;

}
