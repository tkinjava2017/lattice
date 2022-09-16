package org.hiforce.lattice.runtime.cache;

import com.google.auto.service.AutoService;
import org.apache.commons.lang3.StringUtils;
import org.hifforce.lattice.annotation.model.AbilityAnnotation;
import org.hifforce.lattice.cache.ILatticeRuntimeCache;
import org.hifforce.lattice.model.ability.cache.IBusinessExtCache;
import org.hifforce.lattice.model.register.AbilitySpec;
import org.hiforce.lattice.runtime.ability.cache.BusinessExtCache;

import java.util.Collection;

/**
 * @author Rocky Yu
 * @since 2022/9/16
 */
@SuppressWarnings("unused")
@AutoService(ILatticeRuntimeCache.class)
public class LatticeRuntimeCache extends SimpleCache implements ILatticeRuntimeCache {
    @Override
    public IBusinessExtCache getBusinessExtCache() {
        return BusinessExtCache.getInstance();
    }


    public AbilitySpec doCacheAbilitySpec(AbilityAnnotation ability, Class<?> targetClass) {
        String abilityCode = StringUtils.isEmpty(ability.getCode()) ? targetClass.getName() : ability.getCode();
        AbilitySpec abilitySpec = getAbilitySpecEntry(abilityCode);
        if (null == abilitySpec) {
            abilitySpec = AbilitySpec.of(abilityCode, ability.getName(), ability.getDesc());
            abilitySpec.setAbilityClass(targetClass);
            if (StringUtils.isNotEmpty(ability.getParent())) {
                abilitySpec.setParentCode(ability.getParent());
            }
            return doCacheObjectAbilitySpec(abilityCode, abilitySpec);
        }
        return abilitySpec;
    }

    public Collection<AbilitySpec> getAllCachedAbilities() {
        return getAllCacheAbilitySpec();
    }
}
