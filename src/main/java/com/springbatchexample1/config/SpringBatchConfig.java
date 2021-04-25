package com.springbatchexample1.config;

import com.springbatchexample1.model.Employee;
import com.springbatchexample1.model.EmployeeMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    DataSource dataSource;

    private Resource outputResource = new FileSystemResource("output/outputData.txt");

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemStreamReader<Employee> itemReader,
                   FlatFileItemWriter<Employee> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<Employee, Employee>chunk(100)
                .reader(itemReader)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public ItemStreamReader<Employee> itemReader() {
        JdbcCursorItemReader<Employee> reader = new JdbcCursorItemReader<Employee>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT id,name ,dept ,salary, joiningdate FROM employee");
        reader.setRowMapper(new EmployeeMapper());
        return reader;
    }

    @Bean
    public FlatFileItemWriter<Employee> itemWriter() {
        //Create writer instance
        FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<>();

        //Set output file location
        writer.setResource(outputResource);

        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(false);

        //Name field values sequence based on object properties
        writer.setLineAggregator(new DelimitedLineAggregator<Employee>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<Employee>() {
                    {
                        setNames(new String[]{"id", "name", "dept", "salary", "joiningdate"});
                    }
                });
            }
        });
        return writer;
    }

}
