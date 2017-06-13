/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import java.io.IOException;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageUtils {

    /**
     * Decode string to image
     * @param imageString The string to decode
     * @return decoded image
     */
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Encode image to string
     * @param image The image to encode
     * @param type jpeg, bmp, ...
     * @return encoded string
     */
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

//    public static void main (String args[]) throws IOException {
//        /* Test image to string and string to image start */
//        BufferedImage img = ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/webquanlysach/web/img/book/cho_soi_can_cho_nha.jpg"));
//        BufferedImage newImg;
//        String imgstr;
//        imgstr = encodeToString(img, "jpg");
//        System.out.println(imgstr);
//        newImg = decodeToImage(imgstr);
//        ImageIO.write(newImg, "jpg", new File("C:/Users/dell/Documents/NetBeansProjects/webquanlysach/web/img/book/cho_soi_can_cho_nha.jpg"));
//        /* Test image to string and string to image finish */
//    }
}
