package project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.ThinkDao;
import project.model.Think;
import project.model.User;
import project.service.ThinkService;

import java.util.List;

@Service
public class ThinkServiceImpl implements ThinkService {

    @Autowired
    private ThinkDao thinkDao;

    @Override
    public List<Think> findAllByAuthor(User author) {
        return thinkDao.findAllByAuthor(author);
    }

    @Override
    public void save(Think think) {
        thinkDao.save(think);
    }
}
