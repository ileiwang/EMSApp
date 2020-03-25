package cc.ileiwang.emsapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.emsapp.util.common.*;

/**
 * �ж��û�Ȩ�޵�Spring MVC��������
 */
public class AuthorizedInterceptor implements HandlerInterceptor {

	/** ���岻��Ҫ���ص����� */
//	private static final String[] IGNORE_URI = { "/loginForm", "/login", "/404.html" };

	private static final String[] IGNORE_URI = { "/loginForm", "/login", "/404.html" ,"/findpasswd","/forgetpasswd","/register"};
	/**
	 * �÷�����ҪpreHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С� �÷������������������֮��ִ�У���Ҫ����������������Դ��
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}

	/**
	 * ���������preHandle��������ֵΪtrue��ʱ��Ż�ִ�С� ִ��ʱ�����ڴ��������д���֮ ��Ҳ������Controller�ķ�������֮��ִ�С�
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {

	}

	/**
	 * preHandle�����ǽ��д����������õģ��÷�������Controller����֮ǰ���е��ã�
	 * ��preHandle�ķ���ֵΪfalse��ʱ����������ͽ����ˡ�
	 * ���preHandle�ķ���ֵΪtrue��������ִ��postHandle��afterCompletion��
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/** Ĭ���û�û�е�¼ */
		boolean flag = false;
		/** ��������ServletPath */
		String servletPath = request.getServletPath();
		/** �ж������Ƿ���Ҫ���� */
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				flag = true;
				break;
			}
		}
		/** �������� */
		if (!flag) {
			/** 1.��ȡsession�е��û� */
			Object obj = (Object) request.getSession().getAttribute(EMSAppConstants.USER_SESSION);
			/** 2.�ж��û��Ƿ��Ѿ���¼ */
			if (obj == null) {
				/** ����û�û�е�¼����ת����¼ҳ�� */
				request.setAttribute("message", "���ȵ�¼�ٷ�����վ!");
				request.getRequestDispatcher(EMSAppConstants.LOGIN).forward(request, response);
				return flag;
			} else {
				flag = true;
			}
		}
		return flag;
	}
}
