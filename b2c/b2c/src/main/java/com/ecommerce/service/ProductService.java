package com.ecommerce.service;

import com.ecommerce.dao.entity.Media;
import com.ecommerce.dao.entity.MediaRepository;
import com.ecommerce.dao.entity.Product;
import com.ecommerce.dao.entity.ProductRepository;
import com.ecommerce.data.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MediaRepository mediaRepository;

    public ProductData getProduct(String code) {
        Product product = productRepository.findById(code).get();
        ProductData productData = new ProductData();
        productData.setName(product.getName());
        productData.setId(product.getId());
        productData.setColor(product.getColor());
        productData.setPrice(new BigDecimal(product.getPrice()));
        productData.setCurrency("₹");
        productData.setSize(Arrays.asList(product.getSize().split(",")));
        productData.setDimension(product.getDimension());
        productData.setWeight(product.getWeight());
        productData.setDescription(product.getDescription());
        productData.setDisplayPrice(productData.getCurrency() + product.getPrice());
        List<Blob> pictures = product.getMediaList().stream().map(Media::getPicture).collect(Collectors.toList());
        List<byte[]> picBytes = new ArrayList<>();
        pictures.forEach(ph -> {
            try {
                byte[] bytes = ph.getBytes(1, (int) ph.length());
                picBytes.add(bytes);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        productData.setMedias(picBytes);
        return productData;
    }

    public Blob getMedia(String code) {
        return mediaRepository.findById(code).get().getPicture();
    }
}
