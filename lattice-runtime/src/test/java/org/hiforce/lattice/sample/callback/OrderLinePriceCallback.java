package org.hiforce.lattice.sample.callback;

import lombok.RequiredArgsConstructor;
import org.hiforce.lattice.model.ability.execute.ExtensionCallback;
import org.hiforce.lattice.sample.ability.ext.OrderLinePriceExt;
import org.hiforce.lattice.sample.model.OrderLine;

/**
 * Created by jianfeng.shen on 2025/4/14
 *
 */
@RequiredArgsConstructor
public class OrderLinePriceCallback implements ExtensionCallback<OrderLinePriceExt, Long> {
    private final OrderLine orderLine;
    @Override
    public Long apply(OrderLinePriceExt extension) {
        return extension.getCustomUnitPrice(orderLine);
    }
}
