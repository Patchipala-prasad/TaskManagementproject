package com.ust.UstProject.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskErrorResponse {

	
   private int status;
	
	private String message;
	 
	private long timeStamp;
}
