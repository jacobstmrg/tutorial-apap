package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.RoleModel;
import apap.tutorial.haidokter.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDb roleDb;

    @Override
    public List<RoleModel> findAll(){
        return roleDb.findAll();
    }
}
