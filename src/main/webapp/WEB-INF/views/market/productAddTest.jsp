<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


   <html>
        <head>
        <meta charset="UTF-8">
            <title>상품 등록</title>
            <script language="javascript">
            function addProduct(){
                document.productForm.submit();
            }
            </script>
        </head>
        <body>
        <!-- 상품 등록 -->
        <form action="./ProductAdd" method="post" enctype="multipart/form-data" name="productForm">
            <table cellpadding="0" cellspacing="0">
                <tr align="center" valign="middle">
                    <td colspan="2">상품 등록</td>
                </tr>
                <tr>
                    <td>상품구분</td>
                    <td><input name="productType" type="text" size="10" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>상품번호</td>
                    <td><input name="productId" type="text" size="10" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td><input name="name" type="text" size="50" maxlength="100" /></td>
                </tr>
                <tr>
                    <td>상품가격</td>
                    <td><input name="price" type="text" size="10" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>상품설명</td>
                    <td><textarea name="productDes" cols="67" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td>키워드</td>
                    <td><input name="productKeyword" type="text" size="50" maxlength="100" /></td>
                </tr>
                <tr>
                    <td>추천고객</td>
                    <td><input name="productToWho" type="text" size="50" maxlength="100" /></td>
                </tr>
                <tr>
                    <td>향</td>
                    <td><input name="productSmell" type="text" size="50" maxlength="100" /></td>
                </tr>
                <tr>
                    <td>주요성분</td>
                    <td><textarea name="productIngr" cols="67" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td>썸넬1</td>
                    <td><input name="productImg1" type="file" /></td>
                </tr>
                <tr>
                    <td>썸넬2</td>
                    <td><input name="productImg2" type="file" /></td>
                </tr>
                <tr>
                    <td>상세이미지</td>
                    <td><input name="productDetailImg" type="file" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="javascript:addProduct()">[등록]</a>&nbsp;&nbsp;
                        <a href="javascript:history.go(-1)">[뒤로]</a>
                    </td>
                </tr>
            </table>
        </form>
        <!-- 상품 등록 -->
        </body>
        </html>