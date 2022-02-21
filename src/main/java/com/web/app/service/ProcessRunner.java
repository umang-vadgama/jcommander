package com.web.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProcessRunner {

    private DownloadData downloadData;
    private LoadDataToDatabase loadDataToDatabase;

    public void run(String process){


        switch (process){

            case "download-data":

                downloadData.run();

                break;

            case "load-data-to-database":

                loadDataToDatabase.run();

                break;

            default:

                break;

        }

    }

}
