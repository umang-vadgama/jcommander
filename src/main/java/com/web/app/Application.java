package com.web.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.web.app.cli.DateParamConverter;
import com.web.app.cli.DateParamValidator;
import com.web.app.cli.ProcessCommandValidator;
import com.web.app.service.ProcessRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
@Parameters(separators = "=")
public class Application implements CommandLineRunner {


    @Autowired
    private ProcessRunner processRunner;

    @Autowired
    private ApplicationContext applicationContext;

    @Parameter(names = {"--spring.config.location"}, required = false)
    private String location;

    @Parameter(names = {"--process", "-p"}, required = true, validateWith = ProcessCommandValidator.class)
    private String process;

    @Parameter(names = {"--from"}, required = false, validateWith = DateParamValidator.class, converter = DateParamConverter.class)
    private LocalDate from;

    @Parameter(names = {"--to"}, required = false, validateWith = DateParamValidator.class, converter = DateParamConverter.class)
    private LocalDate to;


    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);

    }


    @Override
    public void run(String... args) throws Exception {

        try {

            JCommander.newBuilder()
                    .addObject(this)
                    .build()
                    .parse(args);

            log.info("Process Started...");
            log.info("Process : "+process);
            if(this.help){

                this.help();

            }else{

                processRunner.run(process);

            }


            log.info("Process completed...");

            SpringApplication.exit(applicationContext);

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    private void help(){

        System.out.println("Available process :");
        System.out.println("OPTIONS");
        System.out.println("	--p PROCESS, --process PROCESS");
        System.out.println("           Run the specified PROCESS, where PROCESS valid values are:  ");
        System.out.println("               * download-data");
        System.out.println("               * load-data-to-database");

    }
}
