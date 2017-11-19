package com.tsingkuo.jdbc.control;

import com.tsingkuo.jdbc.base.Goddess;
import com.tsingkuo.jdbc.model.GoddessModel;

import java.util.List;
import java.util.Map;

/**
 * Created by johnnykuo on 2017/11/7.
 */
public class GoddessControl {

    public Boolean create(Goddess goddess) {
        GoddessModel goddessModel = new GoddessModel();
        return goddessModel.createGoddess(goddess);
    }

    public Boolean del(String goddessId) {
        GoddessModel goddessModel = new GoddessModel();
        return goddessModel.delGoddess(goddessId);
    }

    public Boolean update(Goddess goddess) {
        GoddessModel goddessModel = new GoddessModel();
        return goddessModel.updateGoddess(goddess);
    }

    public List<Goddess> query() {
        GoddessModel goddessModel = new GoddessModel();
        return goddessModel.queryGoddess();
    }

    public Goddess query(String goddessId) {
        GoddessModel goddessModel = new GoddessModel();
        return goddessModel.queryGoddess(goddessId);
    }

    public List<Goddess> query(List<Map<String, Object>> params) {
        GoddessModel goddessModel = new GoddessModel();
        return goddessModel.queryGoddess(params);
    }
}
