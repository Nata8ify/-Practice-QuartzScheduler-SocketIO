package com.arms.component;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class LogScheduleComponent implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("\n\n"
				+ "\n-------------------------------------"
				+ "\nThis is a Message from LogScheduleComponent (Job Class) "
				+ "\n-------------------------------------\n\n\n");
	}
	
	
}
