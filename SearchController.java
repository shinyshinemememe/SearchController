package cn.edu.bjtu.weibo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.bjtu.weibo.service.serviceImpl.GeneralSearchServiceImpl;
import cn.edu.bjtu.weibo.service.serviceImpl.SearchContentServiceImpl;
import cn.edu.bjtu.weibo.service.serviceImpl.SearchUserServiceImpl;
import cn.edu.bjtu.weibo.model.UserSR;
import cn.edu.bjtu.weibo.model.GeneralSR;
import cn.edu.bjtu.weibo.model.BaseContentSR;

@RestController
@RequestMapping("/s")
public class SearchController {
	@RequestMapping(value="/search", method=RequestMethod.GET)
	
	public List<GeneralSR> getGeneralSR(String keyword, int pageIndex, int numberPerPage) 
	{
		GeneralSearchServiceImpl searchGeneralService = new GeneralSearchServiceImpl();
		List<GeneralSR> generalSRList = searchGeneralService.getGeneralSearchedResult(keyword, pageIndex, numberPerPage);
		return generalSRList;
	}
	
	public List<BaseContentSR> getWeiboSR(String keyword, int pageIndex, int numberPerPage) 
	{
		SearchContentServiceImpl searchWeiboService = new SearchContentServiceImpl();
		List<BaseContentSR> weiboSRList = searchWeiboService.getSearchedWeiboList(keyword, pageIndex, numberPerPage);
		return weiboSRList;
	}
	
	public List<UserSR> getUserSR(String username, int pageIndex, int numberPerPage) 
	{
		SearchUserServiceImpl searchUserService = new SearchUserServiceImpl();
		List<UserSR> userSRList = searchUserService.getSearchedUserList(username, pageIndex, numberPerPage);
		return userSRList;
	}
}
