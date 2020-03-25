package cc.ileiwang.emsapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.emsapp.domain.Admin;
import cc.ileiwang.emsapp.domain.Notice;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��4��1�� ����10:51:53
*/
@Controller
public class NoticeController {
	
	// �Զ�ע��eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;
	
	// ��ӹ���
	@RequestMapping(value = "/notice/addNotice")
	public ModelAndView addNotice(String flag,Integer admin_id,@ModelAttribute Notice notice, ModelAndView mv) {
		if (flag.equals("1")) {
			List<Admin> admins = eMSAppService.findAllAdmin();
			mv.addObject("admins", admins);
			mv.setViewName("notice/showAddNotice");
		} else {
			
			Admin admin  = new Admin();
			admin.setId(admin_id);
			notice.setAdmin(admin);
			eMSAppService.addNotice(notice);
			mv.setViewName("redirect:/notice/showAllNotice");
		}
		return mv;
	}
	
	
	// �鿴���й���
	@RequestMapping(value = "/notice/showAllNotice")
	public ModelAndView showAllNotice(ModelAndView mv, HttpSession session) {
		List<Notice> notices = eMSAppService.findAllNotice();

		if (session.getAttribute("admin") != null) {
			mv.addObject("notices", notices);

			mv.setViewName("notice/allNotice");

		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}
	
	// ɾ������
	@RequestMapping(value = "/notice/deleteNotice")
	public ModelAndView deleteNotice(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			eMSAppService.deleteNoticeById(id);
			mv.setViewName("redirect:/notice/showAllNotice");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// ���¹���
	@RequestMapping(value = "/notice/updateNotice")
	public ModelAndView updateNotice(String flag, @ModelAttribute Notice notice,Integer admin_id, ModelAndView mv) {
		if (flag.equals("1")) {
			Notice target = eMSAppService.selectNoticeById(notice.getId());
			List<Admin> admins = eMSAppService.findAllAdmin();
			mv.addObject("notice", target);
			mv.addObject("admins", admins);
			mv.setViewName("notice/showUpdateNotice");
		} else {
			Admin admin  = new Admin();
			admin.setId(admin_id);
			notice.setAdmin(admin);
			eMSAppService.modifyNotice(notice);
			mv.setViewName("redirect:/notice/showAllNotice");
		}
		return mv;
	}
	
	
	
	// ѡ�񹫸�
	@RequestMapping(value = "/notice/selectNotice")
	public String selectNotice(String flag, Integer admin_id,@ModelAttribute Notice notice,Model model) {
		if (flag.equals("1")) {

			List<Admin> admins = eMSAppService.findAllAdmin();
			model.addAttribute("admins", admins);
			return "notice/showSelectNotice";
		} 
		else 
		{
			Admin admin = new Admin();
			admin.setId(admin_id);
			notice.setAdmin(admin);
			List<Notice> notices = eMSAppService.findNotice(notice);
			model.addAttribute("notices", notices);
			return "notice/allNotice";
		}
	}


}
