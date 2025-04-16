package com.starbucks.starvive.cart.application;

import com.starbucks.starvive.cart.dto.in.AddCartItemRequestDto;
import com.starbucks.starvive.cart.dto.in.DeleteSelectedCartItemsRequestDto;
import com.starbucks.starvive.cart.dto.in.UpdateCartItemRequestDto;
import com.starbucks.starvive.cart.vo.CartItemResponseVo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface CartService {

    List<CartItemResponseVo> getCartList(UUID userId);
    void addItem(AddCartItemRequestDto addCartItemRequestDto, UUID userId);
    void updateItem(UpdateCartItemRequestDto updateCartItemRequestDto, UUID userId);
    void deleteSelectedItems(DeleteSelectedCartItemsRequestDto deleteSelectedCartItemsRequestDto, UUID userId);
}
