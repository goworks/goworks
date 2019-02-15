package cc.goworks.work.utils;

import cc.goworks.work.enums.Gender;
import cc.goworks.work.enums.StaffType;
import cc.goworks.work.enums.UserStatus;
import cc.goworks.work.tunnel.model.StaffDO;

import static java.time.LocalDateTime.parse;

/**
 * Created by ge on 12/05/2018.
 */
public class TestDataUtils {

    public static StaffDO generateStaffDO() {
        StaffDO staffDO = new StaffDO();
        staffDO.setStaffId(CommonUtils.uuid());
        staffDO.setPassword("password");
        staffDO.setEmail("email");
        staffDO.setPhone("phone");
        staffDO.setStatus(UserStatus.DISABLE.getValue());
        staffDO.setUsername("username");
        staffDO.setBirthday(CommonUtils.toDate(parse("2019-02-04T11:11:11")));
        staffDO.setCostingOrganizationId("costing organization id");
        staffDO.setHrOrganizationId("hr organization id");
        staffDO.setPostId("post id");
        staffDO.setWorkNo("work no");
        staffDO.setCreator("creator");
        staffDO.setModifier("modifier");
        staffDO.setType(StaffType.NORMAL.getValue());
        staffDO.setFirstEmployDate(CommonUtils.toDate(parse("2016-02-04T00:00:00")));
        staffDO.setPositiveDate(CommonUtils.toDate(parse("2016-05-04T00:00:00")));
        staffDO.setIdentityNumber("330181199111018119");
        staffDO.setGender(Gender.MALE.getValue());
        staffDO.setName("name");
        staffDO.setProbationSalary("800");
        staffDO.setSalary("1000");
        staffDO.setSalaryCard("8888888888888888888888");
        staffDO.setSalaryCard("Hangzhou Branch Bank");
        return staffDO;
    }
}
