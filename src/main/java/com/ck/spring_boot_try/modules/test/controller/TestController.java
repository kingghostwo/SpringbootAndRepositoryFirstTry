package com.ck.spring_boot_try.modules.test.controller;

import com.ck.spring_boot_try.modules.test.entity.City;
import com.ck.spring_boot_try.modules.test.entity.Country;
import com.ck.spring_boot_try.modules.test.service.CityService;
import com.ck.spring_boot_try.modules.test.service.CountryService;
import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import com.ck.spring_boot_try.modules.test.entity.ApplicationTest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${com.hqyj.name}")
    private String name;
    @Autowired
    private ApplicationTest applicationTest;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    /**
     * 127.0.0.1:8080/test/helloWorld ---- get
     */
    @GetMapping(value = "/helloWorld")
    @ResponseBody
    String helloWorld() {
        return "Hello world";
    }

    @GetMapping(value = "/config")
    @ResponseBody
    String config() {
        return String.format("%s", name, applicationTest.getName());
    }

    @GetMapping(value = "/log")
    @ResponseBody
    public String logback() {
        LOGGER.trace("trace");
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
        return "log test";
    }

    @RequestMapping("/index")
    public String testIndex(ModelMap modelMap) {
        int countryId = 522;
        Country country = countryService.getCountryByCountryId(countryId);
        List<City> cities = cityService.getCitiesByCountryId(countryId);
        cities = cities.stream().limit(10).collect(Collectors.toList());

        modelMap.addAttribute("checked", true);
        modelMap.addAttribute("currentNumber", 99);
        modelMap.addAttribute("changeType", "checkbox");
        modelMap.addAttribute("baiduUrl", "/test/config");
//      modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
        modelMap.addAttribute("country", country);
        modelMap.addAttribute("cities", cities);
        modelMap.addAttribute("updateCityUri", "/api/city");
        modelMap.addAttribute("city", cities.get(0));
        modelMap.addAttribute("thymeleafTitle", "This is thymeleaf page.");
        modelMap.addAttribute("template", "test/index");
//        ????????????
        return "index";
    }

    @RequestMapping("/desc")
    @ResponseBody
    public String testDesc(HttpServletRequest request, @RequestParam String key) {
        String key2 = request.getParameter("key");
        return "this is test desc." + key + "---" + key2;
    }

    @PostMapping(value = "/file", consumes = "multipart/form-data")
    public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
//            addAttribute?????????
            redirectAttributes.addFlashAttribute("message", "Please select file.");
//            ??????????????????????????????????????????
            return "redirect:/test/index";
        }
        try {
            String fileName = file.getOriginalFilename();
            File destFile = new File(
                    "D:\\project\\Java\\CKHOMEWORK\\SpringbootAndRepositoryFirstTry\\target\\classes\\static\\upload/"
                            + fileName);
            file.transferTo(destFile);


            redirectAttributes.addFlashAttribute("message", "Upload file success");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Upload file failed");
            e.printStackTrace();
        }
        return "redirect:/test/index";
    }

    @RequestMapping("/download")
    public ResponseEntity<Resource> downLoadFile(@RequestParam String fileName) {
        try {
            Resource resource = new UrlResource(Paths.get("D:\\project\\Java\\CKHOMEWORK\\SpringbootAndRepositoryFirstTry\\target\\classes\\static\\upload/"
                    + fileName).toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            String.format("attachment; filename=\"%s\"", resource.getFilename()))
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
