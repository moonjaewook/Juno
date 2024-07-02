package com.good.juno.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.good.juno.dto.ProductDto;

@Repository
public class ProductDao {
    
    private SqlSessionFactory sqlSessionFactory;
    
    @Autowired
    public ProductDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public boolean productInsert(ProductDto pDto) {
        SqlSession session = null;
        
        try {
            session = sqlSessionFactory.openSession();
            ProductIDao mapper = session.getMapper(ProductIDao.class);
            mapper.insertProduct(pDto);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
