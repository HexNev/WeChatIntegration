// @Copyright

package com.demowechat.app.manager;

import android.content.Context;
import com.tencent.mm.sdk.openapi.*;

/**
 * Wee Chat manager
 */
public class WeChatManager{

    /**
     * WeChat APP_ID
     */
    private static final String APP_ID = "wx7c5c5ce9109d5c03";
    /**
     * WeChat API
     */
    private IWXAPI iwxapi;


    public WeChatManager(Context context) {

        //Get IWXAPI through WXAPIFactory
        iwxapi = WXAPIFactory.createWXAPI(context, APP_ID, true);

        // Register appID to WeChat

        iwxapi.registerApp(APP_ID);

    }

    public void sendAuth(){

        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "post_timeline";
        req.state = "none";

        iwxapi.sendReq(req);
    }

    public void sendMessage(){

        String message = "Test Message";

        //Init a WXTextObject object
        WXTextObject textObject = new WXTextObject();
        textObject.text = message;

        //Init a WXMediaMessage object with MXTextObject();
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObject;
        msg.description = message;

        //Construct a req

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = msg;

        req.scene = SendMessageToWX.Req.WXSceneTimeline;

        //Using API to send data to WeChat

        iwxapi.sendReq(req);







        iwxapi.sendReq(req);
    }
}
