package cc.goworks.lifeditor.tunnel.tunnels;

import cc.goworks.lifeditor.tunnel.dao.TaskDOMapper;
import cc.goworks.lifeditor.tunnel.model.TaskDO;
import cc.goworks.lifeditor.tunnel.model.TaskDOExample;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import static cc.goworks.lifeditor.enums.Active.ACTIVE;

@Repository
public class TaskTunnel implements Tunnel<TaskDO> {
    private TaskDOMapper taskDOMapper;

    @Autowired
    public TaskTunnel(TaskDOMapper taskDOMapper) {
        this.taskDOMapper = taskDOMapper;
    }

    @Override
    public TaskDO get(String id) {
        Assert.notNull(id, "task id cannot be null");
        TaskDOExample example = new TaskDOExample();
        example.createCriteria()
            .andLogicIdEqualTo(id)
            .andActiveEqualTo(ACTIVE.getValue());
        List<TaskDO> taskDOS = taskDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(taskDOS)) {
            return null;
        }
        return taskDOS.get(0);
    }

    @Override
    public void save(TaskDO taskDO) {

        Assert.notNull(taskDO, "taskDO cannot be null");
        String taskId = taskDO.getLogicId();

        TaskDO fetched = this.get(taskId);

        if (Objects.isNull(fetched)) {
            taskDO.setGmtCreate(new Date());
            taskDO.setGmtModify(new Date());
            taskDO.setActive(ACTIVE.getValue());
            taskDO.setVersion(1);

            taskDOMapper.insert(taskDO);
            return;
        }
        Integer originVersion = fetched.getVersion();
        Assert.isTrue(taskDO.getId().equals(fetched.getId()), "id should be equal");
        Assert.isTrue(taskDO.getLogicId().equals(fetched.getLogicId()), "taskId should be equal");

        taskDO.setGmtModify(new Date());
        taskDO.setVersion(originVersion + 1);

        TaskDOExample example = new TaskDOExample();
        example.createCriteria()
            .andLogicIdEqualTo(taskDO.getLogicId())
            .andIdEqualTo(taskDO.getId())
            .andActiveEqualTo(ACTIVE.getValue());
        taskDOMapper.updateByExampleSelective(taskDO, example);
    }
}
