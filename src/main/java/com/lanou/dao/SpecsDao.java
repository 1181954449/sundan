package com.lanou.dao;

import com.lanou.entity.Specs;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/10.
 */
@Repository
public interface SpecsDao {
    public abstract List<Specs> findSpecsByContent(Map<String, Object> paramMap);
}
