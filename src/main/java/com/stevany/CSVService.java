package com.stevany;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Validated
@Service
public class CSVService {
  private static Validator validator;
  public List<User> readCsv() throws CsvException, IOException {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
    List<User> userList = new ArrayList<User>();

    try {
      File fileName = new ClassPathResource("data.csv").getFile();
      System.out.println(fileName);
      List<UserDTO> beans = new CsvToBeanBuilder(new FileReader(fileName))
        .withType(UserDTO.class)
        .build()
        .parse();

      beans.forEach(System.out::println);
      for(UserDTO userDTO: beans){
        Boolean isInsertDate = true;
        String dateString = userDTO.getDob();
        if(dateString.equals("")){
          isInsertDate = false;
          dateString = new Date().toString();
          System.out.println("date of birth required");
        }

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        User user = new User();
        user.setMsisdn(userDTO.getMsisdn());
        user.setSimType(userDTO.getSimType().toUpperCase());
        user.setAddress(userDTO.getAddress());
        user.setName(userDTO.getName());
        user.setGender(userDTO.getGender());
        user.setDob(date);
        user.setIdNumber(userDTO.getIdNumber());
        if(isInsertDate) {
          userList.add(this.validate(user));
        }

      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    this.writeText(userList);
    return userList;
  }

  public void writeText(List<User> userList) throws IOException {
    FileWriter writer = new FileWriter("MSISD.txt", true);
    for(User user: userList){
      writer.write(String.valueOf(user));
      writer.write("\r\n");
    }
    writer.close();
  }

  public User validate(@Valid User user){
    Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
    String messageError = constraintViolations.size() > 0 ? user.getName() + " " : " ";

    for(ConstraintViolation constrain : constraintViolations){
      messageError += constrain.getMessage() + "; ";
    }
    System.out.println(messageError);
    return user;
  }
}
