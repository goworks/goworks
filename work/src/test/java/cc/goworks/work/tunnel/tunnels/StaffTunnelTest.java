package cc.goworks.work.tunnel.tunnels;

import cc.goworks.work.WorkApplicationTests;
import cc.goworks.work.tunnel.model.StaffDO;
import cc.goworks.work.utils.TestDataUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static cc.goworks.work.enums.Active.ACTIVE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WorkApplicationTests.class)
@Transactional
public class StaffTunnelTest {
    @Autowired
    private StaffTunnel staffTunnel;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void should_create_staff_successfully() {
        StaffDO staffDO = TestDataUtils.generateStaffDO();

        int id = staffTunnel.save(staffDO);

        StaffDO fetched = staffTunnel.get(staffDO.getStaffId());

        // basic
        assertThat(fetched.getName()).isEqualTo(staffDO.getName());
        assertThat(fetched.getUsername()).isEqualTo(staffDO.getUsername());
        assertThat(fetched.getEmail()).isEqualTo(staffDO.getEmail());
        assertThat(fetched.getPhone()).isEqualTo(staffDO.getPhone());
        assertThat(fetched.getPassword()).isEqualTo(staffDO.getPassword());
        assertThat(fetched.getBirthday()).isEqualTo(staffDO.getBirthday());
        assertThat(fetched.getGender()).isEqualTo(staffDO.getGender());
        assertThat(fetched.getIdentityNumber()).isEqualTo(staffDO.getIdentityNumber());

        // hr
        assertThat(fetched.getFirstEmployDate()).isEqualTo(staffDO.getFirstEmployDate());
        assertThat(fetched.getPositiveDate()).isEqualTo(staffDO.getPositiveDate());
        assertThat(fetched.getCostingOrganizationId()).isEqualTo(staffDO.getCostingOrganizationId());
        assertThat(fetched.getHrOrganizationId()).isEqualTo(staffDO.getHrOrganizationId());
        assertThat(fetched.getProbationSalary()).isEqualTo(staffDO.getProbationSalary());
        assertThat(fetched.getSalary()).isEqualTo(staffDO.getSalary());
        assertThat(fetched.getSalaryCard()).isEqualTo(staffDO.getSalaryCard());
        assertThat(fetched.getWorkNo()).isEqualTo(staffDO.getWorkNo());

        // work
        assertThat(fetched.getPostId()).isEqualTo(staffDO.getPostId());

        // system
        assertThat(fetched.getId()).isEqualTo(id);
        assertThat(fetched.getStaffId()).isEqualTo(staffDO.getStaffId());
        assertThat(fetched.getStatus()).isEqualTo(staffDO.getStatus());
        assertThat(fetched.getType()).isEqualTo(staffDO.getType());
        assertThat(fetched.getGmtCreate()).isNotNull();
        assertThat(fetched.getGmtModify()).isNotNull();
        assertThat(fetched.getCreator()).isEqualTo(staffDO.getCreator());
        assertThat(fetched.getModifier()).isEqualTo(staffDO.getModifier());
        assertThat(fetched.getVersion()).isEqualTo(1);
        assertThat(fetched.getActive()).isEqualTo(ACTIVE.getValue());
    }

}