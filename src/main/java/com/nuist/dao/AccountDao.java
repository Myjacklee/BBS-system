package com.nuist.dao;

import com.nuist.domain.Account;
import com.nuist.domain.Register;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
/*账户连接dao*/
@Repository
public interface AccountDao {
    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account(name,money) value(#{name},#{money})")
    public void saveAccount(Account account);

}
