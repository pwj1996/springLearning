package com.pwj.config;

import com.pwj.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author pwj
 *
 * Spring guides, upload file runner
 */
@Component
public class UploadFileTestRunner implements CommandLineRunner {

    @Autowired
    StorageService storageService;

    @Override
    public void run(String... args) {
        storageService.deleteAll();
        storageService.init();
    }
}
