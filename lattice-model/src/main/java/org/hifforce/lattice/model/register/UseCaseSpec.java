package org.hifforce.lattice.model.register;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hifforce.lattice.exception.LatticeRuntimeException;
import org.hifforce.lattice.model.ability.IBusinessExt;
import org.hifforce.lattice.model.business.TemplateType;
import org.hifforce.lattice.model.business.UseCaseTemplate;

import java.util.Set;

/**
 * @author Rocky Yu
 * @since 2022/9/20
 */
@Slf4j
public class UseCaseSpec extends TemplateSpec<UseCaseTemplate> {

    @Getter
    @Setter
    private Class<?> useCaseClass;


    @Getter
    @Setter
    private Class<? extends IBusinessExt> sdk;

    @Getter
    public Set<ExtensionPointSpec> openExtensions = Sets.newHashSet();

    public UseCaseSpec() {
        this.setPriority(100);
        this.setType(TemplateType.USE_CASE);
    }

    public UseCaseTemplate newInstance() {
        if (null == useCaseClass) {
            return null;
        }
        try {
            return (UseCaseTemplate) useCaseClass.newInstance();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new LatticeRuntimeException("LATTICE-CORE-004", ex.getMessage());
        }
    }
}
