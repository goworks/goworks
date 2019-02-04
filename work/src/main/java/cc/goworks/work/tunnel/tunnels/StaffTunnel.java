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

    public int save(StaffDO staffDO) {
        Assert.notNull(staffDO, "staffDO cannot be null");
        String staffId = staffDO.getStaffId();

        StaffDO fetched = this.get(staffId);

        if (Objects.isNull(fetched)) {
            staffDO.setGmtCreate(new Date());
            staffDO.setGmtModify(new Date());
            staffDO.setActive(ACTIVE.getValue());
            staffDO.setVersion(1);

            return staffDOMapper.insert(staffDO);
        }
        Integer originVersion = fetched.getVersion();

        staffDO.setGmtModify(new Date());
        staffDO.setVersion(originVersion + 1);
        staffDO.setId(null);
        staffDO.setStaffId(null);

        StaffDOExample example = new StaffDOExample();
        example.createCriteria()
            .andStaffIdEqualTo(staffDO.getStaffId())
            .andActiveEqualTo(ACTIVE.getValue());
        return staffDOMapper.updateByExampleSelective(staffDO, example);
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
