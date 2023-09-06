package user_service_root.util;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;
import user_service_root.core.exception.GlobalError;
import user_service_root.core.exception.GlobalException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoRepositoryBean
public interface ExtendedRepository<T, ID> extends JpaRepositoryImplementation<T, ID> {
    default T getEntityById(ID id) {
        return this.findById(id).orElseThrow(
                () -> GlobalException.of(GlobalError.NOT_FOUND_ERROR)
        );
    }

    default List<T> getEntityByIds(Collection<ID> ids) {

        if (ids != null) {
            ids.remove(null);

            return this.findAllById(ids);
        }

        return new ArrayList<>();
    }

    default void deleteByIds(Collection<ID> ids) {
        if (ids != null) {
            ids.remove(null);

            this.deleteAllById(ids);
        }
    }
}
