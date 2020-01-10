package com.troy.trade.service;

/**
 * 动态feign调用
 *
 * @author dp
 */
public interface IDynamicFeignService {

    /**
     * 通过url创建feign客户端实例
     *
     * @param apiType feign接口类
     * @param url     动态url，包含协议、ip、端口、根目录，如:"http://192.168.1.91:8894/xxxxx"
     * @return
     */
    <T> T newInstanceByUrl(Class<T> apiType, String url);

    /**
     * 通过服务名创建url
     *
     * @param apiType feign接口类
     * @param name    动态名称，包含协议、名称、根目录，如:"http://troy-trade-exchange/xxxxx"
     * @return
     */
    <T> T newInstanceByName(Class<T> apiType, String name);
}
