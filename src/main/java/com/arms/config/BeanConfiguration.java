package com.arms.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arms.component.LogScheduleComponent;

@Configuration
public class BeanConfiguration {
	

	@Bean(name = "trigger5Sec")
	public Trigger trigger5Second(){
		return TriggerBuilder
				.newTrigger()
				.withIdentity("log_trigger_5sec", "1")
				.withDescription("For trigger a jobDetail")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
				.build();
	}
	

	@Bean(name = "trigger10Sec")
	public Trigger trigger10Second(){
		return TriggerBuilder
				.newTrigger()
				.withIdentity("log_trigger_10sec", "1")
				.withDescription("For trigger a jobDetail")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(10))
				.build();
	}
	
	@Bean(name = "triggerSch")
	public Trigger triggerSchedule(){
		return TriggerBuilder
				.newTrigger()
				.withIdentity("log_trigger_sch", "1")
				.withDescription("For trigger a jobDetail")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 00 17 * * ?")) // everyday at 17:00:00.
				.build();
	}
}
