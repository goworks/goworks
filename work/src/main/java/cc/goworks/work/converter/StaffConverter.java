package cc.goworks.work.converter;

import cc.goworks.work.entity.viewObjects.StaffVO;
import cc.goworks.work.tunnel.model.StaffDO;
import cc.goworks.work.utils.CommonUtils;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by ge on 12/05/2018.
 */
@Component
public class StaffConverter {
    public StaffDO convert(StaffVO staffVO) {
        if (Objects.isNull(staffVO)) {
            return null;
        }
        StaffDO staffDO = new StaffDO();
        staffDO.setStaffId(staffVO.getId());
        staffDO.setUsername(staffVO.getUsername());
        staffDO.setEmail(staffVO.getEmail());
        staffDO.setPassword(staffVO.getPassword());
        staffDO.setPhone(staffVO.getPhone());

        if (StringUtils.isEmpty(staffDO.getStaffId())) {
            staffDO.setStaffId(CommonUtils.uuid());
        }

        return staffDO;
    }

    public StaffVO convert(StaffDO staffDO) {
        if (Objects.isNull(staffDO)) {
            return null;
        }
        StaffVO staffVO = new StaffVO();
        staffVO.setId(staffDO.getStaffId());
        staffVO.setUsername(staffDO.getUsername());
        staffVO.setEmail(staffDO.getEmail());
        staffVO.setPassword(staffDO.getPassword());
        staffVO.setPhone(staffDO.getPhone());

        return staffVO;
    }
}
