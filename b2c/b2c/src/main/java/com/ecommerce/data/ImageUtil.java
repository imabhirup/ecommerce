package com.ecommerce.data;


import org.apache.tomcat.util.codec.binary.Base64;

public class ImageUtil {
    public String getImgData(byte[] byteData) {
        return Base64.encodeBase64String(byteData);
    }
}
