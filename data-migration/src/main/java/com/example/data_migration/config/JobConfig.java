package com.example.data_migration.config;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private Step step1ReadCustomers; // Assuming reader, processor, writer beans are defined

    @Autowired (required = false) // Optional processor step
    private Step step2ProcessCustomers;

    @Autowired
    private Step step3WriteCustomers;

    @Bean
    public Job migrationJob() {
        return jobs.get("migrationJob")
                .flow(step1ReadCustomers)
                .next(step2ProcessCustomers) // Include if processing is needed
                .from(step2ProcessCustomers) // Restart from processing step in case of failure (optional)
                .next(step3WriteCustomers)
                .end()
                .build()
                .listeners(new JobExecutionListenerSupport() { // Add Job Listener for notifications (optional)
                    @Override
                    public void beforeJob(JobExecution jobExecution) {
                        log.info("Migration Job started.");
                    }

                    @Override
                    public void afterJob(JobExecution jobExecution) {
                        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                            log.info("Migration Job completed successfully.");
                        } else {
                            log.error("Migration Job failed with status: {}", jobExecution.getStatus());
                        }
                    }
                });
    }
}
