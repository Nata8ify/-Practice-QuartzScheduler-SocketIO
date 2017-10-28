package com.arms.quartz.controller;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobBuilder;import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arms.component.LogScheduleComponent;

@Controller
@RequestMapping("/qaurtz")
public class QuartzController {
	
	@Autowired
	@Qualifier("trigger5Sec")
	Trigger trigger5Sec;
	
	@Autowired
	@Qualifier("trigger5Sec")
	Trigger trigger10Sec;
	
	@Autowired
	@Qualifier("triggerSch")
	Trigger triggerSchedule;
	
	
	@Autowired
	Job logScheduleJob;
	
	@RequestMapping("/5sec")
	public String log5Second() throws SchedulerException, IOException{
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(JobBuilder.newJob().ofType(LogScheduleComponent.class).withIdentity("log").build(), trigger5Sec);
		return "redirect:/";
	}
	
	@RequestMapping("/10sec")
	public String log10Second() throws SchedulerException{
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(JobBuilder.newJob().ofType(LogScheduleComponent.class).build(), trigger10Sec);
		return "redirect:/";
	}
	
	@RequestMapping("/sch")
	public String log1650() throws SchedulerException{
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(JobBuilder.newJob().ofType(LogScheduleComponent.class).build(), triggerSchedule);
		return "redirect:/";
	}
}
