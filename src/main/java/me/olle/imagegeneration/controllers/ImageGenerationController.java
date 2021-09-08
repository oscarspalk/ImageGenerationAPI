package me.olle.imagegeneration.controllers;


import me.olle.imagegeneration.ImageGeneration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/")
public class ImageGenerationController {


    @GetMapping
    @RequestMapping(value = "/drawS",
    produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] drawStringOnImage(
            @RequestParam(value = "string", required = true) String string,
            @RequestParam(value = "backgroundColor", defaultValue = "000000") String backgroundColor,
            @RequestParam(value = "fontColor", defaultValue = "ffffff") String fontColor,
            @RequestParam(value = "fontSize", defaultValue = "16") int fontSize,
            @RequestParam(value = "xPosition", defaultValue = "0") int xPosition,
            @RequestParam(value = "yPosition", defaultValue = "0") int yPosition,
            @RequestParam(value = "xSize", defaultValue = "100") int xSize,
            @RequestParam(value = "ySize", defaultValue = "100") int ySize,
            @RequestParam(value = "centered", defaultValue = "false") Boolean centered
    )
    {
        Color fColor = Color.decode("0x" + fontColor);
        Color bColor = Color.decode("0x" + backgroundColor);
        ImageGeneration img = new ImageGeneration(xSize, ySize);
        img.drawFilledRect(0,0,xSize, ySize,bColor);
        if(centered){
            img.drawCenteredString(string, fontSize, fColor);
            return img.buildImage("jpg");
        }
        img.drawString(string, xPosition, yPosition, fColor, fontSize);
        return  img.buildImage("jpg");
    }



}
