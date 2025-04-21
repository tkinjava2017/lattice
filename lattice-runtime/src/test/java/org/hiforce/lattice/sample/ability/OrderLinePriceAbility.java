package org.hiforce.lattice.sample.ability;

import org.hiforce.lattice.annotation.Ability;
import org.hiforce.lattice.runtime.ability.BaseLatticeAbility;
import org.hiforce.lattice.runtime.ability.reduce.Reducers;
import org.hiforce.lattice.sample.ability.ext.BlankOrderLinePriceExt;
import org.hiforce.lattice.sample.ability.ext.OrderLinePriceExt;
import org.hiforce.lattice.sample.callback.OrderLinePriceCallback;
import org.hiforce.lattice.sample.model.OrderLine;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Rocky Yu
 * @since 2022/9/22
 * 能力是对扩展的包装
 */
@Ability(name = "OrderLine's Price Ability")
public class OrderLinePriceAbility extends BaseLatticeAbility<OrderLinePriceExt> {

    public OrderLinePriceAbility(OrderLine bizObject) {
        super(bizObject);
    }

    public Long getCustomUnitPrice(OrderLine orderLine) {
        OrderLinePriceCallback callback = new OrderLinePriceCallback(orderLine);
        return Optional.ofNullable(reduceExecute(callback, Reducers.firstOf(Objects::nonNull)))
                .orElseThrow(()->new RuntimeException("无法匹配到扩展点"));
    }

    @Override
    public BlankOrderLinePriceExt getDefaultRealization() {
        return new BlankOrderLinePriceExt();
    }
}
