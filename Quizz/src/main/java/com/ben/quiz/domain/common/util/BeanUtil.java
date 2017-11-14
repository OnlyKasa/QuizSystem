package com.ben.quiz.domain.common.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.*;
import org.apache.log4j.Logger;

import java.util.Date;

public class BeanUtil {
    private static BeanUtilsBean buNative;

    static {
        buNative = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
//        buNative.getConvertUtils().register(new CustomDateConverter(), Date.class);
//        buNative.getConvertUtils().register(new CustomStringConverter(), String.class);
        buNative.getConvertUtils().register(new LongConverter(null), Long.class);
        buNative.getConvertUtils().register(new IntegerConverter(null), Integer.class);
        buNative.getConvertUtils().register(new ShortConverter(null), Short.class);
        buNative.getConvertUtils().register(new FloatConverter(null), Float.class);
        buNative.getConvertUtils().register(new DoubleConverter(null), Double.class);
    }

    private BeanUtil() {

    }

    public static void copyPropertiesNative(Object source, Object target) {
        try {
            buNative.copyProperties(target, source);
        } catch (Exception e) {
            Logger.getLogger(BeanUtil.class).error(e);
        }
    }

    @SuppressWarnings("rawtypes")
    public static Object createAndCopyPropertiesNative(Object source, Class c) {
        Object target = null;
        try {
            target = c.newInstance();
            buNative.copyProperties(target, source);
        } catch (Exception e) {
            Logger.getLogger(BeanUtil.class).error(e);
        }
        return target;
    }
}
