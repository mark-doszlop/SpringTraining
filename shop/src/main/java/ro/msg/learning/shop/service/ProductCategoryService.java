package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.domain.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        ProductCategory foundProductCategory = productCategoryRepository.findByName(productCategory.getName());
        if (foundProductCategory == null) {
            productCategoryRepository.save(productCategory);
            return productCategory;
        } else
            return foundProductCategory;
    }
}
