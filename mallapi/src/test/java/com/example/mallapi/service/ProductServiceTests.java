package com.example.mallapi.service;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mallapi.domain.Product;
import com.example.mallapi.dto.PageRequestDTO;
import com.example.mallapi.dto.PageResponseDTO;
import com.example.mallapi.dto.ProductDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);

        result.getDtoList().forEach(dto -> log.info(dto));
    }

    @Test
    public void testRegister() {
        ProductDTO productDTO = ProductDTO.builder()
                .pname("새로운 상품")
                .pdesc("신규 추가 상품입니다.")
                .price(1000)
                .build();

        // uuid가 있어야함
        productDTO.setUploadFileNames(
                java.util.List.of(
                        UUID.randomUUID() + "_" + "Test1.jpg",
                        UUID.randomUUID() + "_" + "Test2.jpg"));
        productService.register(productDTO);
    }

    @Test
    public void testRead() {
        Long pno = 12L;

        ProductDTO productDTO = productService.get(pno);
        log.info(productDTO);
        log.info(productDTO.getUploadFileNames());
    }
}
