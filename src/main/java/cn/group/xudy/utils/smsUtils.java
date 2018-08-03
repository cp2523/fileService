package cn.group.xudy.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

public class smsUtils {
    /**
     * 腾讯云短信工具
     */
    private static int appid = 13;
    private static String appkey = "";

    //发送验证码
    public static void sendVerificationCode(String mobile,String verificationCode){

        String msg = "你的验证码为:"+verificationCode+",请妥善保管.";
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", mobile,
                    msg, "", "");
            System.out.print(result);
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        smsUtils.sendVerificationCode("15874152065","123456");
       /* string strMobile = "13788888888"; //tel 的 mobile 字段的内容
        string strAppKey = "5f03a35d00ee52a21327ab048186a2c4"; //sdkappid 对应的 appkey，需要业务方高度保密
        string strRand = "7226249334"; //url 中的 random 字段的值
        string strTime = "1457336869"; //unix 时间戳
        string sig = sha256(appkey=5f03a35d00ee52a21327ab048186a2c4&random=7226249334&time=1457336869&mobile=13788888888)
                = ecab4881ee80ad3d76bb1da68387428ca752eb885e52621a3129dcf4d9bc4fd4;*/
    }



}
