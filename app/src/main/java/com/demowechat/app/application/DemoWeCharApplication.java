// @Copyright

package com.demowechat.app.application;

import android.app.Application;
import com.demowechat.app.manager.WeChatManager;

public class DemoWeCharApplication extends Application {

    WeChatManager weChatManager;


    private static DemoWeCharApplication singleton;

    public static DemoWeCharApplication getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        singleton = this;

        /**
         * Create the wechat manager
         */
        weChatManager = new WeChatManager(this);

    }

    public WeChatManager getWeChatManager() {
        return weChatManager;
    }

    public void setWeChatManager(WeChatManager weChatManager) {
        this.weChatManager = weChatManager;
    }


}
