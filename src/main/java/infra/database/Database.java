package infra.database;

import java.util.List;

public interface Database<T> {

    List<T> readAll();
}
