package com.stevany;

import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class CSVApplication {
  @Autowired
  private CSVService csvService;

  @PostConstruct
  private void postConstruct() {
    try {
      csvService.readCsv();
    } catch (CsvException | IOException e) {
      e.printStackTrace();
    }
  }
}
