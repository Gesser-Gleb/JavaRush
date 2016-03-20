package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;


/**
 * Created by gesse_000 on 14.07.2015.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageTypes){
        ImageReader imageReader = null;
            if (imageTypes == ImageTypes.BMP) imageReader = new BmpReader();
            else if (imageTypes == ImageTypes.JPG) imageReader = new JpgReader();
            else if (imageTypes == ImageTypes.PNG) imageReader = new PngReader();
            else throw new IllegalArgumentException("Неизвестный тип картинки");

        return imageReader;
    }
}
