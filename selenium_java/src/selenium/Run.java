package selenium;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Run {
	public static void main(String[] args) {
		try {
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			// define the job and tie it to our HelloJob class
			JobDetail job = newJob(Selenium_Java.class).withIdentity("job1", "group1").build();

			// Trigger the job to run now, and then repeat every 40 seconds
			// 초 분 시 일 월 년
			// * * * * * ?
			// 10 * * * * ?
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
					.withSchedule(CronScheduleBuilder.cronSchedule("10,40 * * * * ?")).build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);

			// and start it off
			scheduler.start();

		} catch (SchedulerException se) {
			se.printStackTrace();
		}

	}
}