package org.hiforce.lattice.annotation.processor;

import com.google.auto.service.AutoService;
import org.hiforce.lattice.spi.annotation.LatticeAnnotationProcessor;
import org.hiforce.lattice.model.demo.Abc;
import org.hiforce.lattice.model.demo.IAbc;

import javax.annotation.processing.Processor;
import javax.annotation.processing.SupportedOptions;
import java.lang.annotation.Annotation;

/**
 * Created by jianfeng.shen on 2025/4/18
 *
 */
@AutoService(Processor.class)
@SupportedOptions({"debug", "verify"})
public class TestAnnotationProcessor extends LatticeAnnotationProcessor {
    @Override
    public Class<?> getServiceInterfaceClass() {

        return IAbc.class;
    }

    @Override
    public Class<? extends Annotation> getProcessAnnotationClass() {
        return Abc.class;
    }
}
