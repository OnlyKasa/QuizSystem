package com.ben.quiz.domain.common.bean.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletRequest;

/**
 * Get the bean managed by Hospital Bean Factory DispatcherServlet.
 *
 * @author QuangNV
 *
 */
public class QWebBeanFactory {

	private static ApplicationContext ac = null;

	private QWebBeanFactory() {

	}

	@SuppressWarnings("deprecation")
	public static void init(ServletRequest request) {

		ac = RequestContextUtils.getWebApplicationContext(request);

	}

	/**
	 * Get the object with the specified name from the DI container.
	 *
	 * @param type
	 * @param beanId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> type, String beanId) {

		Object bean = ac.getBean(beanId);

		return (T) bean;
	}

	/**
	 * Retrieve an instance of the specified class from the DI container. BeanID is
	 * the first lowercase letter of the class name.
	 *
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> type) {
		return (T) ac.getBean(getBeanId(type));
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> type, Object... args) {
		return (T) ac.getBean(getBeanId(type), args);
	}

	private static <T> String getBeanId(Class<T> type) {
		String name = type.getSimpleName();
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		return name;
	}

	public static ApplicationContext getAc() {
		return ac;
	}

}
