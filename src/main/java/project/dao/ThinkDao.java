package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Think;
import project.model.User;

import java.util.List;

public interface ThinkDao extends JpaRepository<Think, Long> {
    List<Think> findAllByAuthor(User author);
}
