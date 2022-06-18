package pro.chenggang.project.reactive.lock.configuration;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.type.AnnotationMetadata;
import pro.chenggang.project.reactive.lock.option.ReactiveLockType;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static pro.chenggang.project.reactive.lock.properties.ReactiveLockProperties.LOCK_PROPERTIES_PREFIX;

/**
 * Reactive lock auto configuration import selector
 *
 * @author Gang Cheng
 * @version 1.0.0
 * @since 1.0.0
 */
public class ReactiveLockAutoConfigurationImportSelector implements ImportSelector, EnvironmentAware {

    private ConfigurableEnvironment configurableEnvironment;

    @SuppressWarnings("unchecked")
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
        return propertySources.stream()
                .map(propertySource -> (Object) propertySource.getSource())
                .filter(value -> Map.class.isAssignableFrom(value.getClass()))
                .map(Map.class::cast)
                .flatMap(map -> (Stream<Map.Entry<String, Object>>) map.entrySet().stream())
                .filter(entry -> entry.getKey().startsWith(LOCK_PROPERTIES_PREFIX + ".type"))
                .map(Map.Entry::getKey)
                .map(configurableEnvironment::getProperty)
                .map(String.class::cast)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .map(value -> {
                    try {
                        return ReactiveLockType.valueOf(value);
                    } catch (Exception e) {
                        //ignore
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .filter(reactiveLockType -> !ReactiveLockType.REDIS.equals(reactiveLockType))
                .map(ReactiveLockType::getRegistryAutoConfigurationClass)
                .map(Class::getName)
                .toArray(String[]::new);
    }

    @Override
    public void setEnvironment(Environment environment) {
        if (environment instanceof ConfigurableEnvironment) {
            this.configurableEnvironment = (ConfigurableEnvironment) environment;
        } else {
            throw new UnsupportedOperationException("Unsupported Environment type : " + environment.getClass().getName());
        }
    }
}
