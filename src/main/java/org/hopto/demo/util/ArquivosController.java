package org.hopto.demo.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("api/arquivos")
public class ArquivosController {

    private static final String DIR_UPLOAD ="uploads/";

    @GetMapping
    public String getMethodName() {
        return "Este é o controlador de arquivos";
    }
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile file){
        if (file.isEmpty())
            return new ResponseEntity<>("Selecione um arquivo para fazer upload", HttpStatus.BAD_REQUEST);

        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(DIR_UPLOAD+file.getOriginalFilename());
            Files.write(path,bytes);

            return new ResponseEntity<>("Arquivo carregado com sucesso",HttpStatus.OK);
        } catch(IOException e){
            e.printStackTrace();
            return new ResponseEntity<>("Falha ao fazer o upload",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
