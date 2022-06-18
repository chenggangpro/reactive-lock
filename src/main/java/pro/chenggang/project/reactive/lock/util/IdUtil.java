package pro.chenggang.project.reactive.lock.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;

/**
 * Id util
 *
 * @author Gang Cheng
 * @version 1.0.0
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdUtil {

    private final IdGenerator idGenerator = new AlternativeJdkIdGenerator();

    /**
     * get instance
     * @return the IdUtil
     */
    public static IdUtil getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * generate id
     *
     * @return the UUID in String type
     */
    public String generateId() {
        return idGenerator.generateId().toString();
    }

    private static class InstanceHolder {

        private final static IdUtil INSTANCE;

        static {
            INSTANCE = new IdUtil();
        }
    }
}
