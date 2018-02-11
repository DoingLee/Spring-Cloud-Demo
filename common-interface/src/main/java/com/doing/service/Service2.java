package com.doing.service;

import com.doing.vo.UserVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：ldy on 10/02/2018 14:52
 */
public interface Service2 {

    /**
     * GET RequestParam、PathVariable
     *
     * @param clientName
     * @param version
     * @return
     */
    @RequestMapping(path = "/hello/param/v{version}", method = RequestMethod.GET)
    String helloParam(@RequestParam(value = "clientName") String clientName, @PathVariable(value = "version") Integer version);

    /**
     * 失败：Null (该版本spring-cloud-feign不支持解释Spring mvc的@RequestBody，只支持@RequestParam、@PathVariable、@RequestHeader)
     *
     * POST application/json
     *
     * @param userVo
     * @return
     */
    @RequestMapping(path = "/hello/body", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    UserVo helloBody(@RequestBody UserVo userVo);

}
