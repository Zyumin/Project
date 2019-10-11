import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-03-22 19:03
 */
public class JPA implements CrudRepository {
    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable iterable) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Iterable findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void deleteAll(Iterable iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
