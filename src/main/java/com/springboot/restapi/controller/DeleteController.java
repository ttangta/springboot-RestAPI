package com.springboot.restapi.controller;

import com.springboot.restapi.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/implement/delete-api")
public class DeleteController {
    ProductDto product1 = new ProductDto(1,"p1",1000);
    ProductDto product2 = new ProductDto(2,"p2",2000);
    ProductDto product3 = new ProductDto(3,"p3",3000);

    @GetMapping("/{variable}")
    public ResponseEntity<Object> getProduct(@PathVariable("variable") int number){
        ProductDto result = null;
        switch(number){
            case 1 :
                result = product1;
                break;
            case 2 :
                result = product2;
                break;
            case 3 :
                result = product3;
                break;
        }
        if(result == null)return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("해당 번호를 가진 데이터는 서버에 존재하지 않습니다");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/del/{variable}")
    public String deleteProduct(@PathVariable("variable") int number){
        switch(number){
            case 1 :
                product1 = null;
                break;
            case 2 :
                product2 = null;
                break;
            case 3 :
                product3 = null;
                break;
            default :
                return "[" + number + "]번 상품은 존재하지 않습니다";
        }
        return "[" + number + "]번 상품 삭제 성공";
    }
}
