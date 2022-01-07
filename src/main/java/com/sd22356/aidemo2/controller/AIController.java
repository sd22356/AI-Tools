package com.sd22356.aidemo2.controller;

import com.sd22356.aidemo2.utils.AIUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AIController {

    @RequestMapping(value = "/pic",method = RequestMethod.POST)
    public String PicToWords(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AIUtils.PicToWords(file);
        System.out.println(res);
        return res;
    }
}
