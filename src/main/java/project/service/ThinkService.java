package project.service;

import project.model.Think;
import project.model.User;

import java.util.List;

public interface ThinkService {
    List<Think> findAllByAuthor(User author);
    void save(Think think);
}
