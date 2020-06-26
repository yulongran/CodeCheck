package com.yulongran.CodeCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
class CodeCheckController {

  private final String CACHE_FOLDER = "/Users/yulongran/CodeCheck/src/cache";

  CodeCheckController() {
  }

  @PostMapping("/codecheck")
  public String greetingSubmit(@RequestBody MultipartFile file) {
    try {
      // Save file into cahce folder
      byte[] bytes = file.getBytes();
      Path path = Paths.get(CACHE_FOLDER + "/" + file.getOriginalFilename());
      System.out.println(path);
      Files.write(path, bytes);

      // Execute file and send back output
      Runtime rt = Runtime.getRuntime();
      Process process = rt.exec("java /Users/yulongran/CodeCheck/src/cache/isUnique.java");
      BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      return lineReader.readLine();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return "Some thing goes wrong";
  }
}