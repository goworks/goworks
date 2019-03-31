package cc.goworks.lifeditor.utils;

import cc.goworks.lifeditor.controller.wrapper.PageVO;
import cc.goworks.lifeditor.controller.wrapper.StatusVO;
import com.github.pagehelper.PageInfo;

/**
 * Created by ge on 12/05/2018.
 */
public class ResponseUtils {
    public static PageVO create(PageInfo pageInfo) {
        PageVO pageVO = new PageVO();
        pageVO.setCurrent(pageInfo.getPageNum());
        pageVO.setPageSize(pageInfo.getPageSize());
        pageVO.setTotal(pageInfo.getTotal());
        pageVO.setList(pageInfo.getList());

        return pageVO;
    }

    public static StatusVO ok() {
        StatusVO statusVO = new StatusVO();
        statusVO.setCode(1);
        statusVO.setMsg("ok");
        return statusVO;
    }

    public static StatusVO fail(String msg) {
        StatusVO statusVO = new StatusVO();
        statusVO.setCode(0);
        statusVO.setMsg(msg);
        return statusVO;
    }
}
