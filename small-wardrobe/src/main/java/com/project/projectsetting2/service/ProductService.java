package com.project.projectsetting2.service;

import com.project.projectsetting2.dto.AddProductRequest;
import com.project.projectsetting2.entity.*;
import com.project.projectsetting2.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final MemberRepository memberRepository;

    private final TagRepository tagRepository;

    private final ProductRepository productRepository;

    private final ProductSSRepository productSSRepository;

    private final ProductTagRepository productTagRepository;

    private final ImageService imageService;

    @Transactional
    public void addProduct(AddProductRequest request, MultipartFile[] multipartFiles, Principal principal) throws IOException {
        Member seller = memberRepository.findByUsername(principal.getName()).get();
        String[] tags = request.getTag().split(" ");
        String[] productSSs = request.getInventory().split(", ");
        List<Image> images = multipartFiles.length > 0 ? imageService.saveImages(multipartFiles) : new ArrayList<>();
        Product product = Product.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .seller(seller)
                .name(request.getName())
                .content(request.getContent())
                .type(request.getType())
                .cost(request.getCost())
                .images(images)
                .productSSs(new ArrayList<>())
                .tags(new ArrayList<>())
                .images(images)
                .build();

        productRepository.save(product);

        for (String tagName : tags) {
            Optional<Tag> tagOpt = tagRepository.findById(tagName);
            Tag tag;

            if (tagOpt.isEmpty()) {
                 tag = new Tag(tagName, new ArrayList<>());

                tagRepository.save(tag);
            } else {
                tag = tagOpt.get();
            }

            ProductTag productTag = new ProductTag(product, tag);

            productTagRepository.save(productTag);
            product.getTags().add(productTag);
            tag.getProducts().add(productTag);
        }

        for (String inventory : productSSs) {
            ProductSS productSS;

            if (!request.getType().equals(ProductType.CLOTHES.getKey())) {
                productSS = new ProductSS("", Integer.parseInt(inventory));
            } else {
                String size = inventory.split("/")[0];
                int stock = Integer.parseInt(inventory.split("/")[1]);
                productSS = new ProductSS(size, stock);
            }

            productSSRepository.save(productSS);
            product.getProductSSs().add(productSS);
            productRepository.save(product);
        }

        log.info("product: {}", product);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProducts(String search) {
        if (search != null && search.startsWith("#")) {
            Optional<Tag> tag = tagRepository.findById(search);

            if (tag.isPresent()) {
                List<Product> products = new ArrayList<>();
                List<ProductTag> productTags = productTagRepository.findAllByTag(tag.get());

                for (ProductTag productTag : productTags) {
                    products.add(productTag.getProduct());
                }

                return products;
            }
        }

        return search == null ? productRepository.findAll() : productRepository.findAllByNameContaining(search);
    }

    public List<Product> getClothes(String search) {
        if (search != null && search.startsWith("#")) {
            Optional<Tag> tag = tagRepository.findById(search);

            if (tag.isPresent()) {
                List<Product> products = new ArrayList<>();
                List<ProductTag> productTags = productTagRepository.findAllByTag(tag.get());

                for (ProductTag productTag : productTags) {
                    products.add(productTag.getProduct());
                }

                return products;
            }
        }

        return search == null ? productRepository.findAllByType(ProductType.CLOTHES.getKey()) : productRepository.findAllByTypeAndNameContaining(ProductType.CLOTHES.getKey(), search);
    }

    public List<Product> getAccessory(String search) {
        if (search != null && search.startsWith("#")) {
            Optional<Tag> tag = tagRepository.findById(search);

            if (tag.isPresent()) {
                List<Product> products = new ArrayList<>();
                List<ProductTag> productTags = productTagRepository.findAllByTag(tag.get());

                for (ProductTag productTag : productTags) {
                    products.add(productTag.getProduct());
                }

                return products;
            }
        }

        return search == null ? productRepository.findAllByType(ProductType.ACCESSORY.getKey()) : productRepository.findAllByTypeAndNameContaining(ProductType.ACCESSORY.getKey(), search);
    }

    public List<Product> getEtc(String search) {
        if (search != null && search.startsWith("#")) {
            Optional<Tag> tag = tagRepository.findById(search);

            if (tag.isPresent()) {
                List<Product> products = new ArrayList<>();
                List<ProductTag> productTags = productTagRepository.findAllByTag(tag.get());

                for (ProductTag productTag : productTags) {
                    products.add(productTag.getProduct());
                }

                return products;
            }
        }

        return search == null ? productRepository.findAllByType(ProductType.ETC.getKey()) : productRepository.findAllByTypeAndNameContaining(ProductType.ETC.getKey(), search);
    }

    public void addCart(String id, Principal principal) {
        Member member = memberRepository.findByUsername(principal.getName()).get();
        Product product = productRepository.findById(id).get();

        if (!member.getCart().contains(product)) {
            member.getCart().add(product);
            memberRepository.save(member);
        }
    }

    public void deleteCart(String id, Principal principal) {
        Member member = memberRepository.findByUsername(principal.getName()).get();
        Product product = productRepository.findById(id).get();

        member.getCart().remove(product);

        memberRepository.save(member);
    }

    public List<Product> getCart(Principal principal) {
        Member member = memberRepository.findByUsername(principal.getName()).get();

        return member.getCart();
    }

    public int getCartTotalCost(Principal principal) {
        Member member = memberRepository.findByUsername(principal.getName()).get();
        int totalCost = 0;

        for (Product product : member.getCart()) {
            totalCost += product.getCost();
        }

        return totalCost;
    }

    @Transactional
    public void deleteProduct(String id) {
        Product product = productRepository.findById(id).orElse(null);


        product.setImages(null);
        product.setProductSSs(null);
        product.setTags(null);

        productTagRepository.deleteAllByProduct(product);
        productRepository.delete(product);
    }

}
