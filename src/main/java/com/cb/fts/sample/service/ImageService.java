package com.cb.fts.sample.service;

import com.cb.fts.sample.entities.vo.CoverVo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Install chrome driver with:
 * brew cask install chromedriver
 */
@Component
public class ImageService {

    private static final String prefix = "https://www.google.com/imgres?imgurl=";
    private static final String chromeDriverPath = "/usr/local/bin/chromedriver";

    public CoverVo getImg(String words) throws Exception {
        CoverVo coverVo = null;
        words = Arrays.asList(words.split(" ")).stream().collect(Collectors.joining(","));
        ChromeOptions options = new ChromeOptions();
        // setting headless mode to true.. so there isn't any ui
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        try {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            // Create a new instance of the Chrome driver
            String searchUrl = "https://www.google.com/search?hl=en&tbm=isch&q=" + words + "+movie";
            //System.out.println("search: "+searchUrl);
            driver.get(searchUrl);
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

            List<WebElement> elements = driver.findElements(By.tagName("img"));
            //List<WebElement> elements = driver.findElements(By.tagName("a"));

            for (WebElement element : elements) {
                String src = element.getAttribute("src");

                String httpPrefix="https://encrypted-tbn0.gstatic.com/images?q=";
                if ( src != null && ( src.startsWith(httpPrefix) ||  src.startsWith("data:image"))) {
                    String url =  element.getAttribute("src"); // URLDecoder.decode(element.getAttribute("src"), "UTF-8");

                    if (url.indexOf("&imgrefurl") != -1) {
                        url = url.substring(0, url.indexOf("&imgrefurl"));
                    }
                    //if(coverVo != null) System.out.println(url.length()+" "+coverVo.toString().length());
                    if(coverVo == null || url.length() > coverVo.toString().length() ) {
                        coverVo = new CoverVo(url);
                    }
                    if(url.length() > 8192) { // big enough to use
                        return coverVo;
                    }
                }
            }

            return coverVo != null ?  coverVo : new CoverVo("default.jpg");
        } catch (Exception e) {
            e.printStackTrace();
            return new CoverVo("default.jpg");
        } finally {
            driver.close();
        }
    }

}
