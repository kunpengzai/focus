package com.jarvis.focus.dao.impl;

import com.jarvis.focus.dao.ProductDao;
import com.jarvis.focus.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jarvis on 2016/5/28.
 */
public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

    private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

    public ProductDTO getProduct(String productCode) {
        try {
            return this.getSqlSession().selectOne("product.getProduct", productCode);
        } catch(RuntimeException e) {
            log.error("productDao.getProduct", e);
            throw e;
        }
    }

    public void saveProductMember(Long productId, Long memberId, Long memberApplyInfoId) {
        try {
            Map map = new HashMap();
            map.put("productId", productId);
            map.put("memberId", memberId);
            map.put("memberApplyInfoId", memberApplyInfoId);
            this.getSqlSession().insert("product.saveProductMember", map);
        } catch(RuntimeException e) {
            log.error("productDao.saveProductMember", e);
            throw e;
        }
    }
}
