package com.good.juno.command.product;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.good.juno.dao.ProductDao;
import com.good.juno.dto.ProductDto;

public class ProductAddTest implements BCommand {
    
    private ProductDao productDao;

    public ProductAddTest(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    @Override
    public void execute(Model model) {
        
        Map<String, Object> map = model.asMap();
        MultipartHttpServletRequest request = (MultipartHttpServletRequest) map.get("request");
        
        MultipartFile productImg1 = request.getFile("productImg1");
        MultipartFile productImg2 = request.getFile("productImg2");
        MultipartFile productDetailImg = request.getFile("productDetailImg");

        ProductDto pDto = new ProductDto();
        
        String realFolder = "";
        String saveFolder = "resources/productupload";
        
        realFolder = request.getSession().getServletContext().getRealPath(saveFolder);

        // 디렉토리가 존재하지 않으면 생성
        java.io.File uploadDir = new java.io.File(realFolder);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        boolean result = false;
        
        try {
            request.setCharacterEncoding("UTF-8");
            
            // 파일 처리
            String filename1 = null;
            String filename2 = null;
            String filenameDetail = null;
            
            if (productImg1 != null && !productImg1.isEmpty()) {
                filename1 = productImg1.getOriginalFilename();
                productImg1.transferTo(new java.io.File(realFolder + "/" + filename1));
            }
            
            if (productImg2 != null && !productImg2.isEmpty()) {
                filename2 = productImg2.getOriginalFilename();
                productImg2.transferTo(new java.io.File(realFolder + "/" + filename2));
            }
            
            if (productDetailImg != null && !productDetailImg.isEmpty()) {
                filenameDetail = productDetailImg.getOriginalFilename();
                productDetailImg.transferTo(new java.io.File(realFolder + "/" + filenameDetail));
            }

            // 상품 데이터 설정
            String productTypeParam = request.getParameter("productType");
            String productIdParam = request.getParameter("productId");
            String priceParam = request.getParameter("price");

            pDto.setProductType((productTypeParam != null && !productTypeParam.isEmpty()) ? Integer.parseInt(productTypeParam) : 0);
            pDto.setProductId((productIdParam != null && !productIdParam.isEmpty()) ? Integer.parseInt(productIdParam) : 0);
            pDto.setName(request.getParameter("name"));
            pDto.setPrice((priceParam != null && !priceParam.isEmpty()) ? Integer.parseInt(priceParam) : 0);
            pDto.setProductDes(request.getParameter("productDes"));
            pDto.setProductKeyword(request.getParameter("productKeyword"));
            pDto.setProductToWho(request.getParameter("productToWho"));
            pDto.setProductSmell(request.getParameter("productSmell"));
            pDto.setProductIngr(request.getParameter("productIngr"));
            pDto.setProductImg1(filename1);
            pDto.setProductImg2(filename2);
            pDto.setProductDetailImg(filenameDetail);
            
            // 데이터베이스에 상품 추가
            result = productDao.productInsert(pDto);
            
            if (!result) {
                System.out.println("상품 등록에 실패했습니다.");
            } else {
                System.out.println("상품이 등록되었습니다.");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
