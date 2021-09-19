package me.olle.imagegeneration.controllers;


import me.olle.imagegeneration.ImageGeneration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class ImageGenerationController {

    @RequestMapping(value = "/drawS")
    public @ResponseBody
    ResponseEntity<byte[]> drawStringOnImage(
            @RequestParam(value = "string", required = true) String string,
            @RequestParam(value = "backgroundColor", defaultValue = "000000") String backgroundColor,
            @RequestParam(value = "fontColor", defaultValue = "ffffff") String fontColor,
            @RequestParam(value = "fontSize", defaultValue = "16") int fontSize,
            @RequestParam(value = "xPosition", defaultValue = "0") int xPosition,
            @RequestParam(value = "yPosition", defaultValue = "0") int yPosition,
            @RequestParam(value = "xSize", defaultValue = "100") int xSize,
            @RequestParam(value = "ySize", defaultValue = "100") int ySize,
            @RequestParam(value = "centered", defaultValue = "false") Boolean centered,
            @RequestParam(value = "format", defaultValue = "jpg") String format
    )
    {
       String MediaFormat = format.equals("jpg") ? MediaType.IMAGE_JPEG_VALUE : MediaType.IMAGE_PNG_VALUE;
        Color fColor = Color.decode("0x" + fontColor);
        Color bColor = Color.decode("0x" + backgroundColor);
        ImageGeneration img = new ImageGeneration(xSize, ySize);
        img.drawFilledRect(0,0,xSize, ySize,bColor);
        if(centered){
            img.drawCenteredString(string, fontSize, fColor);
            return ResponseEntity.ok().contentType(MediaType.valueOf(MediaFormat)).body(img.buildImage(MediaFormat));
        }
        img.drawString(string, xPosition, yPosition, fColor, fontSize);
        return ResponseEntity.ok().contentType(MediaType.valueOf(MediaFormat)).body(img.buildImage(MediaFormat));
    }



}
