package com.example.shiro;

import jdk.internal.dynalink.beans.StaticClass;

public class YanXinyu {
        private YanXinyu(){}
        private static YanXinyu stu=new YanXinyu();
        public static YanXinyu getInstance(){
            return stu;
    }
}
