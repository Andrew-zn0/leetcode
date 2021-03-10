package algorithms.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description
 * @date Created in 2020/7/19 7:41 下午
 */
public class Test {


    @org.junit.Test
    public void test9() throws ObjectAccessException {
        Layer1 layer1 = new Layer1();
        layer1.layer2 = new Layer2();
        layer1.layer2.layer3 = new ArrayList<>();
        Layer3 l3 = new Layer3();
        l3.val = 1;
        layer1.layer2.layer3.add(l3);

        l3.layer1 = new ArrayList<>();
        l3.layer1.add(new Layer1());

        Layer2 layer2 = (Layer2) getPath(layer1, "layer2");
        Layer3 layer3 = (Layer3) getPath(layer1, "layer2.layer3[0]");

        Integer layer3_0_val = (Integer) getPath(layer1, "layer2.layer3[0].val");

    }

    public Object getPath(Object root, String path) throws ObjectAccessException {
        Object o = null;
        if (path == null) {
            return o;
        }
        int i = path.indexOf(".");
        try {
            if (i == -1) {
                return getObject(root, path);
            } else {
                String substring = path.substring(i + 1);
                o = getObject(root, path.substring(0, i));
                if (o == null) {
                    return o;
                }
                return getPath(o, substring);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Object getObject(Object root, String path) throws Exception {
        Class<?> aClass = root.getClass();
        String substring = path;
        String index = null;
        if (path.contains("[")) {
            index = path.substring(path.indexOf("[") + 1, path.indexOf("]"));
            substring = path.substring(0, path.indexOf("["));
        }
        Field field = null;
        if (List.class.isAssignableFrom(aClass)) {

            Class<?> clazz = aClass.getClass();
            Method getM = clazz.getDeclaredMethod("get", int.class);
            getM.setAccessible(true);
            // 取出列表中对应的元素
            int i = Integer.valueOf(index);
            root = getM.invoke(field.get(root), i);

        } else {
            Field[] declaredFields = aClass.getDeclaredFields();

            for (int i = 0; i < declaredFields.length; i++) {

                if (declaredFields[i].getName().equals(substring)) {
                    field = declaredFields[i];
                }
            }
            if (field == null) {
                return null;
            }
            // 判断是否为列表对象，并且路径参数正常
            if (List.class.isAssignableFrom(field.getType())) {
                // 获取下标
                Type t = field.getGenericType();
                if (t instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) t;
                    Class<?> clazz = field.get(root).getClass();
                    Method getM = clazz.getDeclaredMethod("get", int.class);
                    getM.setAccessible(true);
                    // 取出列表中对应的元素
                    int i = Integer.valueOf(index);
                    root = getM.invoke(field.get(root), i);
                }

            } else {
                root = field.get(root);
            }


        }
        if (path.contains("]")) {
            // 循环列表递归处理
            path = substring + path.substring(path.indexOf("]") + 1);
            if (path.contains("[")) {
                root = getObject(root, path);
            }
        }

        return root;

    }
}
