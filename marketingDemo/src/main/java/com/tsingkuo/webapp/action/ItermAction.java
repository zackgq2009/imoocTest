package com.tsingkuo.webapp.action;

import com.tsingkuo.webapp.entity.Iterm;
import com.tsingkuo.webapp.model.ItermModel;

import java.util.ArrayList;
import java.util.Collection;

public class ItermAction {
    private static ItermModel itermModel = null;

    static {
        itermModel = new ItermModel();
    }

    public void create(Iterm iterm) {
        itermModel.createIterm(iterm);
    }

    public void delete(Iterm iterm) {
        itermModel.delIterm(iterm);
    }

    public void update(Iterm iterm) {
        itermModel.updateIterm(iterm);
    }

    public Collection<Iterm> queryAll() {
        Collection<Iterm> itermCollection = itermModel.queryIterm();
        return itermCollection;
    }

    public Iterm queryOne(int itermId) {
        Iterm iterm = itermModel.queryIterm(itermId);
        return iterm;
    }

    public Iterm search(String itermName) {
        Iterm iterm = itermModel.searchIterm(itermName);
        return iterm;
    }

    public Collection<Iterm> queryFifth(String viewList) {
        String[] viewIds = viewList.split("-");
        Collection<Iterm> itermCollection = new ArrayList<Iterm>();
        ItermAction itermAction = new ItermAction();
        if (viewIds != null && viewIds.length > 0) {
            if (viewIds.length > 5) {
                for (int i = viewIds.length - 1; i >= viewIds.length - 5; i--) {
                    itermCollection.add(itermAction.queryOne(Integer.parseInt(viewIds[i])));
                }
            } else {
                for (int i = viewIds.length -1; i> 0; i--) {
                    itermCollection.add(itermAction.queryOne(Integer.parseInt(viewIds[i])));
                }
                itermCollection.add(itermAction.queryOne(Integer.parseInt(viewIds[0])));
            }
            return itermCollection;
        }
        return null;
    }
}
