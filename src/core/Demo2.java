package core;

import netease.Api;
import netease.UrlParamPair;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import secret.JSSecret;

/**
 * Created by MiChong on 2017/11/22 0022.
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
            String music_id = "516392300";
            UrlParamPair upp = Api.getDetailOfPlaylist(music_id);
            String req_str = upp.getParas().toJSONString();
            System.out.println("req_str:"+req_str);
            //某个歌的评论json地址
            //http://music.163.com/weapi/v1/resource/comments/R_SO_4_516392300?csrf_token=1ac15bcb947b3900d9e8e6039d121a81
            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/v1/resource/comments/R_SO_4_"+music_id+"?csrf_token=")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
