package com.jarvis.focus.dao;

import com.jarvis.focus.dto.ProductDTO;

/**
 * Created by Jarvis on 2016/5/28.
 */
public interface ProductDao {

    public ProductDTO getProduct(String productCode);

    public void saveProductMember(Long productId, Long memberId, Long memberApplyInfoId);
}
