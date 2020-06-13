package com.ecommerce.b2c;

import com.ecommerce.dao.entity.Product;
import com.ecommerce.dao.entity.ProductRepository;
import com.ecommerce.data.ImageUtil;
import com.ecommerce.service.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

@Controller
public class ProductPageController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{code}")
    public String getProduct(@PathVariable("code") String code, Model model){
        model.addAttribute("product", productService.getProduct(code));
        model.addAttribute("imgUtil", new ImageUtil());
        return "productpage";
    }

    @RequestMapping(value = "/getProductImage/{id}")
    public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") String id) throws Exception {
        response.setContentType("image/jpeg");

        Blob ph = productService.getMedia(id);

        byte[] bytes = ph.getBytes(1, (int) ph.length());
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

}
