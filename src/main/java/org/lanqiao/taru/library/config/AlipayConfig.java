package org.lanqiao.taru.library.config;



import java.io.FileWriter;
import java.io.IOException;


public class AlipayConfig  {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    public static String app_id = "2016100200646259";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSaNcg9bbQ1ZhGco/Tzuh6GfcdoSQj7OlfWxsLsgGKNXkaDsBPmshuuKY9yaM7zpOS3R7DBdQQJKInjjmQHV/FNFR2Sx6+VHU4twQH+p7/ychDvsbUGNbD1Ma1qe4quqltXtS3NiMG4GhjLHek/uw0JAvfLGF0pRADgoj6GX8Hg0mMxowCqdoM5qeySgGyBdeXU2zvZV75yUCSLDADEBJ+0630AljIHWqYLZUAmro+BMgDJmCcoXLQs9VSZ30Rgn7JZVOxjBWpwU/hb0dhI6+CUrF5oTYIAR3Sh5ydtJ0j536POVcriaWrPet5lgDP+Eh15KEvGQW2UPMV9GMCMscTAgMBAAECggEACJZlp+VBp9YfbGJj1USZli/XssE04XaP6avqVjFGrdidFc4vsXuerf/eoFknXear+T1HBKFe4uODL1bEQZO3flWnbpjRYNCLX5w8fEtS8CXhvTd/agla73mXfihNc+wm6+dYCrb+LvUSql59VgwtxpEmsRxlSvYzjkElz6WXMdWGnxibZZCval3CPCBnMHcsgrfG3GQYYk3sxUCirG7ATS1VjskmKuPoX2dEtfbu1RRj6vrfVmVn5zndFkwr2S1z7tfNpBcSWMFJDpjE7paMjaW3rD7Xrqzy6i3+Ftzm363Cn9N1tRJkUCgKHkInUus0bZJ1O7i0PDXSSsSBGCKxQQKBgQDcofm7pG1H7HbD1Q2jFbuB91QL0gsed5+ycSUtVkyKlBaNi18csI250lAOZMsTtaUTGkSf/McmtZ33zFJzcfjQuo0PFa6S+7lWUfZFC8MVdNy/zG8FRKY40wJoROvueYxYIkczEfJzo8osAWt0hIwZ0ApPwltwLx2YL6ATb6n3ewKBgQCp4P66pVtoGbL66hz7MIMCpueQyYJs1evQg8OecP9raweIjxVzw8bh1Zsv8zXkEVmDZzsa2ItK/4eXuBRcpZP+wROj+7fJjQX9TDiTBo+LHyhWPa2IkgfxCy5X/Gn/m+3G893LFy++g0y0IMW/XrNaBH7CfrnbhxBKnFpybUEPSQKBgDI+3Q3Do3OGwYFVqtZiI6K0fbp3ajrVCVRs+gd6KNJCaWRwwgdZmd0grUSp5amma2KPT+OTgJMrNz9wk7Jg2UZHxcoSqQAmPY4P+mK9C/997qvrVblAag50146Ba62SlsiXfdl+k9WMDoW5CQyvBuz1+PMzEvnYcQfwiKcEfhOzAoGBAKV2QYXYM4zUozCjwPCkkqaNnLS4oTGStyoUfP+g/hdJW0AWZYWpJdinbo0orc/jWjWT4czHJ/03oIEVSbfnipuywYeSULOeiTvq9pu14zBVe7tsPc7stZGBG3WVpETUQqfqtZfvkJBWYOp9lT5NZhGCmViliC+bgTG60pnrclgJAoGAJKiNIyl9tghh5hJVbjwc3jhdff3GTw13oH09pnT2WSMhgAJjQ2a3V4BV7u/PU+G5PXhEy3tMtebJwapF6rqbd7mWFRuLMakKzyvpHFXZhfw/xu5RT1rPYpFcNvjqqkcxLV0UmhMD72x6Tp+ra9+k4CXvx/wRCFw9q9uZarLMSWc=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzm2SzEH6o+oGSSJ2Y75gEItnv6u9ejifcRgFASZDmMjfk2MdiaTT2MsFKhg3REXtv8qQVH9IMKHajPlKIe3b/Cn/ckL1QX7HHKhFDDjUKuHaOSD7KKQ8JIZmB0IZ/6IbCPQDXb50e8tj5YWwP0ka7DNwarHmw62Y6NZfvbjBdtKp1vWLJzPwSpDaSjrM5AgQt7ZoIWKNtCFHiMsyc5L64fBmm6z9LaBDHeOWJhclReROjOhxfx9xApFBehEieKoL2QoJyXkbKn+ZaJv6jqrRj7+lF+YnqlEGz5iB31HaP3EdMB3+08K0pt5kO6SQdIlELq7+pgiPGYjJu2yz4d/FwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
