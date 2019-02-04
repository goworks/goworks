package cc.goworks.work.tunnel.tunnels;

import cc.goworks.work.tunnel.dao.StaffDOMapper;
import cc.goworks.work.tunnel.model.StaffDO;
import cc.goworks.work.tunnel.model.StaffDOExample;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import static cc.goworks.work.enums.Active.ACTIVE;

@Repository
public class StaffTunnel {
    private StaffDOMapper staffDOMapper;

    @Autowired
    public StaffTunnel(StaffDOMapper mapper) {
        staffDOMapper = mapper;
    }

    public StaffDO get(String id) {
        Assert.notNull(id, "staff id cannot be null");
        StaffDOExample example = new StaffDOExample();
        example.createCriteria()
            .andStaffIdEqualTo(id)
            .andActiveEqualTo(ACTIVE.getValue());
        List<StaffDO> staffDOS = staffDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(staffDOS)) {
            return null;
        }
        return staffDOS.get(0);
    }

    public void save(StaffDO staffDO) {
        Assert.notNull(staffDO, "staffDO cannot be null");
        String staffId = staffDO.getStaffId();

        StaffDO fetched = this.get(staffId);

        if (Objects.isNull(fetched)) {
            staffDO.setGmtCreate(new Date());
            staffDO.setGmtModify(new Date());
            staffDO.setActive(ACTIVE.getValue());
            staffDO.setVersion(1);

            staffDOMapper.insert(staffDO);
            return;
        }
        Integer originVersion = fetched.getVersion();
        Assert.isTrue(staffDO.getId().equals(fetched.getId()), "id should be equal");
        Assert.isTrue(staffDO.getStaffId().equals(fetched.getStaffId()), "staffId should be equal");

        staffDO.setGmtModify(new Date());
        staffDO.setVersion(originVersion + 1);

        StaffDOExample example = new StaffDOExample();
        example.createCriteria()
            .andStaffIdEqualTo(staffDO.getStaffId())
            .andIdEqualTo(staffDO.getId())
            .andActiveEqualTo(ACTIVE.getValue());
        staffDOMapper.updateByExampleSelective(staffDO, example);
    }

    public StaffDO getByUsername(String username) {
        StaffDOExample example = new StaffDOExample();
        example.createCriteria()
            .andUsernameEqualTo(username)
            .andActiveEqualTo(ACTIVE.getValue());
        List<StaffDO> staffDOS = staffDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(staffDOS)) {
            return null;
        }
        return staffDOS.get(0);
    }

    public StaffDO getUserByUsernameAndPassword(String username, String password) {
        StaffDOExample example = new StaffDOExample();
        example.createCriteria()
            .andUsernameEqualTo(username)
            .andPasswordEqualTo(password)
            .andActiveEqualTo(ACTIVE.getValue());

        List<StaffDO> staffDOS = staffDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(staffDOS)) {
            return null;
        }

        return staffDOS.get(0);
    }
}
