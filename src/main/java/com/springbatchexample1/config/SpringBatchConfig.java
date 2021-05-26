package com.springbatchexample1.config;

import com.springbatchexample1.model.MockData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Writer;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    private Resource outputResource = new FileSystemResource("output/outputData.txt");

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<MockData> itemReader,
                 //  ItemWriter<MockData> itemWriter
                   FlatFileItemWriter<MockData> itemWriters
    ) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<MockData, MockData>chunk(100)
                .reader(itemReader)
           //     .writer(itemWriter)
                .writer(itemWriters)
                .build();


        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

/*   @Bean
    public ItemWriter<MockData> itemWriter() {
        return new LoggingItemWriter();
    }*/


    @Bean
    public ItemReader<MockData> itemReader(Environment environment,
                                             RestTemplate restTemplate) {

        return new MockDataReader(environment.getRequiredProperty("rest.api.url"),
                restTemplate
        );
    }


   /* @Bean
    public ItemStreamReader<Employee> itemReader() {
        JdbcCursorItemReader<Employee> reader = new JdbcCursorItemReader<Employee>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT id,name ,dept ,salary, joiningdate FROM employee");
        reader.setRowMapper(new EmployeeMapper());
        return reader;
    }*/

/*    public class ExampleWriter implements ItemWriter<SoccerJsonEntry>{
        private static Logger logger = LoggerFactory.getLogger(ExampleWriter.class);

        public void write(List<? extends SoccerJsonEntry> items) throws Exception {
            for (SoccerJsonEntry item : items) {
                logger.info("Writing " + item);
            }
        }

    }*/

    @Bean
    public FlatFileItemWriter<MockData> itemWriters() {
        //Create writer instance
        FlatFileItemWriter<MockData> writer = new FlatFileItemWriter<>();

        //Set output file location
        writer.setResource(outputResource);

        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(false);

        //Name field values sequence based on object properties
        writer.setHeaderCallback(new FlatFileHeaderCallback() {

            public void writeHeader(Writer writer) throws IOException {
                writer.write("id,firstName,lastName,email,gender,ipAddress");

            }
        });
        writer.setLineAggregator(new DelimitedLineAggregator<MockData>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<MockData>() {
                    {
                        setNames(new String[]{"id", "firstName", "lastName", "email", "gender","ipAddress"});
                    }
                });
            }
        });
        return writer;
    }

}
