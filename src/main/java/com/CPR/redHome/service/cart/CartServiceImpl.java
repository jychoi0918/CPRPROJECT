package com.CPR.redHome.service.cart;

import com.CPR.redHome.dto.cart.CartDto;
import com.CPR.redHome.dto.cart.OrderDto;
import com.CPR.redHome.mapper.cart.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    @Override
    public List<CartDto> getCartList(Long memberId) {

        log.info("회원 번호 "+ memberId+"님의 장바구니를 조회 합니다. " );

        return cartMapper.getCartList(memberId);
    }

    @Override
    public int cartDelete(Long id) {

        log.info("삭제되는cart id = " + id);
        return cartMapper.cartDelete(id);
    }

    @Override
    public List<OrderDto> getPayment(List<String> ids) {

        log.info("회원번호 1 의 제품번호 : " + ids + "결제 창 요청 중...");

        return cartMapper.getPayment(ids);
    }

    @Override
    public int findMemberId(Long memberId) {
        return 0;
    }
}

