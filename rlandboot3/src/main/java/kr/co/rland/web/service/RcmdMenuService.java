package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.RcmdMenuView;

public interface RcmdMenuService {

	List<RcmdMenuView> getViewListByMenuId(int menuId);
}
