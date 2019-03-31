package cc.goworks.lifeditor.tunnel.tunnels;

import cc.goworks.lifeditor.tunnel.dao.UserDOMapper;
import cc.goworks.lifeditor.tunnel.model.UserDO;
import cc.goworks.lifeditor.tunnel.model.UserDOExample;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import static cc.goworks.lifeditor.enums.Active.ACTIVE;

@Repository
public class UserTunnel implements Tunnel<UserDO> {
    private UserDOMapper userDOMapper;

    @Autowired
    public UserTunnel(UserDOMapper mapper) {
        userDOMapper = mapper;
    }

    @Override
    public UserDO get(String id) {
        Assert.notNull(id, "user id cannot be null");
        UserDOExample example = new UserDOExample();
        example.createCriteria()
            .andLogicIdEqualTo(id)
            .andActiveEqualTo(ACTIVE.getValue());
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }
        return userDOS.get(0);
    }

    @Override
    public void save(UserDO userDO) {
        Assert.notNull(userDO, "userDO cannot be null");
        String userId = userDO.getLogicId();

        UserDO fetched = this.get(userId);

        if (Objects.isNull(fetched)) {
            userDO.setGmtCreate(new Date());
            userDO.setGmtModify(new Date());
            userDO.setActive(ACTIVE.getValue());
            userDO.setVersion(1);

            userDOMapper.insert(userDO);
            return;
        }
        Integer originVersion = fetched.getVersion();
        Assert.isTrue(userDO.getId().equals(fetched.getId()), "id should be equal");
        Assert.isTrue(userDO.getLogicId().equals(fetched.getLogicId()), "userId should be equal");

        userDO.setGmtModify(new Date());
        userDO.setVersion(originVersion + 1);

        UserDOExample example = new UserDOExample();
        example.createCriteria()
            .andLogicIdEqualTo(userDO.getLogicId())
            .andIdEqualTo(userDO.getId())
            .andActiveEqualTo(ACTIVE.getValue());
        userDOMapper.updateByExampleSelective(userDO, example);
    }

    public UserDO getByUsername(String username) {
        UserDOExample example = new UserDOExample();
        example.createCriteria()
            .andUsernameEqualTo(username)
            .andActiveEqualTo(ACTIVE.getValue());
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }
        return userDOS.get(0);
    }

    public UserDO getUserByUsernameAndPassword(String username, String password) {
        UserDOExample example = new UserDOExample();
        example.createCriteria()
            .andUsernameEqualTo(username)
            .andPasswordEqualTo(password)
            .andActiveEqualTo(ACTIVE.getValue());

        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }

        return userDOS.get(0);
    }
}
