package com.mirac.main.ypassport.dao;

import com.mirac.main.ypassport.pojo.Jiezhongren;
import com.mirac.main.ypassport.pojo.Point;
import com.mirac.main.ypassport.pojo.User;
import com.mirac.main.ypassport.pojo.Wuliu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DBMapper {
    List<Point> findById(String id);
    List<Jiezhongren> findJiezhongrenById(int id);

    List<Wuliu> findAllWuliu();
    List<Jiezhongren> findAllJiezhongren();
    List<Point> findAllPoint();

    User findUserByUsernameAndPassword(User user);
}
