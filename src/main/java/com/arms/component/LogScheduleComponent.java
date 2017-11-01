package com.arms.component;

import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.stereotype.Component;

@Component
public class LogScheduleComponent implements Job, InterruptableJob {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("\n\n"
				+ "\n-------------------------------------"
				+ "\nThis is a Message from LogScheduleComponent (Job Class) "
				+ "\n-------------------------------------\n\n\n");
	}

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		this.interrupt();
	}
	
	
}
