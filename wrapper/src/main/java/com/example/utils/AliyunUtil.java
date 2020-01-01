package com.example.utils;

import javax.swing.text.html.FormSubmitEvent;

/**
 * @author wuchengxing
 * @version 1.0
 * @date 2019/12/24 10:58
 */
public final class AliyunUtil {

    /*private static final String regionId = "cn-hangzhou";
    private static final String accessKeyId = "LTAI4FgzdaM9btYq6Tu8Vob4";
    private static final String secret = "JxJnWAQexPmNZ9jPVxHnsU9huyDnrL";

    public static CommonResponse sendSms(String phone, SmsBean smsBean) throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(FormSubmitEvent.MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "阿基皕科技");
        request.putQueryParameter("TemplateCode", "SMS_166868380");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(smsBean));
        return client.getCommonResponse(request);
    }

    public static void main(String[] args) {
        try {
            System.out.println(AliyunUtil.sendSms("18607097289", new SmsBean("项目1", "客户1", "告警内容")).getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }*/

}
